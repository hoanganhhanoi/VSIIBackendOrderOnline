package com.vsii.service;

import java.util.List;

import com.vsii.entity.Supplier;

public interface ISupplierService {
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplierById(int supplierId);
    public boolean addSupplier(Supplier supplier);
    public int updateSupplier(Supplier supplier);
    public int deleteSupplier(int supplierId);
}
