package com.vsii.dao;

import java.util.List;

import com.vsii.entity.Supplier;

public interface ISupplierDAO {
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplierById(int supplierId);
    public Supplier addSupplier(Supplier supplier);
    public int updateSupplier(Supplier supplier);
    public int deleteSupplier(int supplierId);
    public boolean supplierExist(String SupplierName);
}
