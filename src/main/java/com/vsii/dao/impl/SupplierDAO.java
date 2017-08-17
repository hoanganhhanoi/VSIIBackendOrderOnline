package com.vsii.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vsii.dao.ISupplierDAO;
import com.vsii.entity.Supplier;
import com.vsii.mapper.SupplierMapper;

@Transactional
@Repository
public class SupplierDAO implements ISupplierDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private final String FETCH_SUPPLIER = "SELECT * FROM supplier";
	private final String FETCH_SUPPLIER_BY_ID = "SELECT * FROM supplier WHERE supplier_id = ?";
	private final String FETCH_SUPPLIER_BY_NAME = "SELECT * FROM supplier WHERE supplier_name = ?";
	private final String INSERT_SUPPLIER = "INSERT INTO supplier(supplier_name, address, created_at, updated_at) VALUES (?, ?, ?, ?)";
	private final String UPDATE_SUPPLIER = "UPDATE supplier SET supplier_name = ?, address = ?, created_at = ?, updated_at = ? WHERE supplier_id = ?";
	private final String DELETE_SUPPLIER = "DELETE FROM supplier WHERE supplier_id = ?";
	
	@Override
	public List<Supplier> getAllSuppliers() {
		return (List<Supplier>) jdbcTemplate.query(FETCH_SUPPLIER, new SupplierMapper());
	}

	@Override
	public Supplier getSupplierById(int supplierId) {
		return jdbcTemplate.queryForObject(FETCH_SUPPLIER_BY_ID, new Object[] { supplierId }, new SupplierMapper());
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SUPPLIER, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, supplier.getSupplierName());
				ps.setString(2, supplier.getAddress());
				ps.setDate(4, (java.sql.Date) supplier.getCreatedAt());
				ps.setDate(5, (java.sql.Date) supplier.getUpdatedAt());
				return ps;
			}
		}, holder);
		
		int newSupllierId = holder.getKey().intValue();
		supplier.setSupplierId(newSupllierId);
		return supplier;
	}

	@Override
	public int updateSupplier(Supplier supplier) {
		int row = jdbcTemplate.update(UPDATE_SUPPLIER, new Object[]
		        { supplier.getSupplierName(), supplier.getAddress(), supplier.getCreatedAt(), supplier.getUpdatedAt(), supplier.getSupplierId() });
		return row;
	}

	@Override
	public int deleteSupplier(int supplierId) {
		int row = jdbcTemplate.update(DELETE_SUPPLIER, new Object[] {supplierId});
		return row;
	}
	
	@Override
	public boolean supplierExist(String name) {
		Supplier supplier = jdbcTemplate.queryForObject(FETCH_SUPPLIER_BY_NAME, new Object[] { name }, new SupplierMapper());
		if(supplier.getSupplierName().equals(name)) {
			return true;
		}
		return false;
	}

}
