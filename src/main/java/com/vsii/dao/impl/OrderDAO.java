package com.vsii.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vsii.dao.IOrderDAO;
import com.vsii.entity.DetailOrder;
import com.vsii.entity.Order;
import com.vsii.entity.Status;
import com.vsii.entity.Supplier;
import com.vsii.entity.User;
import com.vsii.entity.json.DOrderRequest;

@Transactional
@Repository
public class OrderDAO implements IOrderDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private final String FETCH_ORDER = ""
			+ "SELECT orders.order_id, order_date, orders.quantity as order_quantity, description, orders.updated_at as order_updated_at, user_id, orders.status_id, supplier_id, status_name "
			+ "FROM orders, status "
			+ "WHERE orders.status_id = status.status_id";
	private final String FETCH_ORDER_BY_ID = ""
			+ "SELECT orders.order_id, order_date, orders.quantity as order_quantity, description, orders.updated_at as order_updated_at, user_id, orders.status_id, supplier_id, status_name "
			+ "FROM orders, status "
			+ "WHERE orders.status_id = status.status_id "
			+ "AND order_id = ?";
	private final String FETCH_ORDER_BY_USER = ""
			+ "SELECT "
			+ "FROM user, orders, "
			+ "WHERE "
			+ "AND";
	private final String INSERT_ORDER = ""
			+ "INSERT INTO orders(order_date, quantity, description, updated_at, user_id, status_id, supplier_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String INSERT_DETAIL_ORDER = ""
			+ "INSERT INTO detailorder(order_id, food_id) VALUES (?, ?)";
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = jdbcTemplate.query(FETCH_ORDER, new ResultSetExtractor<List<Order>>()
        {
            @Override
            public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Order> list = new ArrayList<Order>();
                while (rs.next())
                {
                    Order order = new Order();
                    order.setOrderId(rs.getInt(1));
                    order.setOrderDate(rs.getDate(2));
                    order.setQuantity(rs.getInt(3));
                    order.setDescription(rs.getString(4));
                    order.setUpdatedAt(rs.getDate(5));
                    User user = new User();
                    user.setUserId(rs.getInt(6));
                    order.setUser(user);
                    Status status = new Status();
                    status.setStatusId(rs.getInt(7));
                    status.setStatusName(rs.getString(9));
                    order.setStatus(status);
                    Supplier supplier = new Supplier();
                    supplier.setSupplierId(rs.getInt(8));
                    order.setSupplier(supplier);
                    list.add(order);
                }
                return list;
            }

        });
		return orders;
	}

	@Override
	public Order getOrderById(int orderId) {
		return jdbcTemplate.queryForObject(FETCH_ORDER_BY_ID, new Object[] {orderId}, new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order order = new Order();
                order.setOrderId(rs.getInt(1));
                order.setOrderDate(rs.getDate(2));
                order.setQuantity(rs.getInt(3));
                order.setDescription(rs.getString(4));
                order.setUpdatedAt(rs.getDate(5));
                User user = new User();
                user.setUserId(rs.getInt(6));
                order.setUser(user);
                Status status = new Status();
                status.setStatusId(rs.getInt(7));
                status.setStatusName(rs.getString(9));
                order.setStatus(status);
                Supplier supplier = new Supplier();
                supplier.setSupplierId(rs.getInt(8));
                order.setSupplier(supplier);
				
				return order;
			}
			
		});
	}

	@Override
	public List<Order> getOrderByUser(int userId) {
		
		return null;
	}
//
//	@Override
//	public List<Order> findOrderByDate(Date startDate, Date endDate) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
	@Override
	public boolean order(Order order) {
		// TODO Auto-generated method stub
		return false;
	}
//
//	@Override
//	public void updateOrder(Order order) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteOrder(int orderId) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	@Transactional
	public int createOrder(DOrderRequest order) {
		try {
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
					ps.setDate(1,  new java.sql.Date(System.currentTimeMillis()));
					ps.setInt(2, 0);
					ps.setString(3, order.description);
					ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
					ps.setInt(5, order.userId);
					ps.setInt(6, order.status);
					ps.setInt(7, order.supplierId);
					System.out.println(ps);
					return ps;
				}
			}, holder);
			
			int newOrderId = holder.getKey().intValue();
			order.orderId = newOrderId;
			
			jdbcTemplate.batchUpdate(INSERT_DETAIL_ORDER, new BatchPreparedStatementSetter() {
	
				@Override
				public int getBatchSize() {
					return order.detailOrder.size();
				}
	
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					int detail = order.detailOrder.get(i);
					ps.setInt(1, newOrderId);
					ps.setInt(2, detail);
				}
				
			});
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}
	
}
