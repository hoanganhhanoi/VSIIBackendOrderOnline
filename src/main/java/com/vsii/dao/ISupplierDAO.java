package com.vsii.dao;

import java.util.List;

import com.vsii.entity.Supplier;

public interface ISupplierDAO {
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplierById(int supplierId);
    public void addSupplier(Supplier supplier);
    public void updateSupplier(Supplier supplier);
    public void deleteSupplier(int supplierId);
}
