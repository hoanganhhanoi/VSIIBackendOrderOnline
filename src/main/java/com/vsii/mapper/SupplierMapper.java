package com.vsii.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vsii.entity.Supplier;

public class SupplierMapper implements RowMapper<Supplier> {

	@Override
	public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
		Supplier supplier = new Supplier();
		supplier.setSupplierId(rs.getInt("supplier_id"));
		supplier.setSupplierName(rs.getString("supplier_name"));
		supplier.setAddress(rs.getString("address"));
		supplier.setCreatedAt(rs.getDate("created_at"));
		supplier.setUpdatedAt(rs.getDate("updated_at"));
		
		return supplier;
	}
	
}
