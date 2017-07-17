package com.vsii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsii.dao.ISupplierDAO;
import com.vsii.entity.Supplier;

@Service
public class SupplierService implements ISupplierService {

	@Autowired
	private ISupplierDAO supplierDAO;
	
	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierDAO.getAllSuppliers();
	}

	@Override
	public Supplier getSupplierById(int supplierId) {
		return supplierDAO.getSupplierById(supplierId);
	}

	@Override
	public boolean addSupplier(Supplier supplier) {
		if(supplierDAO.supplierExist(supplier.getSupplierName())) {
			return false;
		}
		else {
			supplierDAO.addSupplier(supplier);
			return true;
		}
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		supplierDAO.updateSupplier(supplier);
	}

	@Override
	public void deleteSupplier(int supplierId) {
		supplierDAO.deleteSupplier(supplierId);
	}

}
