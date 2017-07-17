package com.vsii.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vsii.dao.ISupplierDAO;
import com.vsii.entity.Supplier;

@Transactional
@Repository
public class SupplierDAO implements ISupplierDAO {

	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getAllSuppliers() {
		String sql = "FROM Supplier ORDER BY supplier_id";
		return (List<Supplier>) entityManager.createQuery(sql).getResultList();
	}

	@Override
	public Supplier getSupplierById(int supplierId) {
		return entityManager.find(Supplier.class, supplierId);
	}

	@Override
	public void addSupplier(Supplier supplier) {
		entityManager.persist(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		Supplier old_supplier = getSupplierById(supplier.getSupplierId());
		old_supplier.setSupplierName(supplier.getSupplierName());
		old_supplier.setAddress(supplier.getAddress());
		old_supplier.setUpdatedAt(supplier.getUpdatedAt());
	}

	@Override
	public void deleteSupplier(int supplierId) {
		entityManager.remove(getSupplierById(supplierId));
	}
	
	@Override
	public boolean supplierExist(String name) {
		String sql = "FROM Supplier WHERE supplier_name = ?";
		int count = entityManager.createQuery(sql).setParameter(1, name).getResultList().size();
		return count > 0 ? true : false;
	}

}
