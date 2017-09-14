package com.vsii.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.vsii.entity.Supplier;
import com.vsii.service.ISupplierService;

@Controller
@RequestMapping(value="suppliers")
public class SupplierController {
	
	@Autowired
	private ISupplierService supplierService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Supplier> getUserById(@PathVariable("id") int id) {
		Supplier supplier = supplierService.getSupplierById(id);
		return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Supplier>> getAllSuppliers() {
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		if (suppliers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="", method = RequestMethod.POST, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
	public ResponseEntity<Void> addSupplier(@RequestBody Supplier supplier, UriComponentsBuilder builder) {
		boolean flag = supplierService.addSupplier(supplier);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("{id}").buildAndExpand(supplier.getSupplierId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Supplier> updateUser(@RequestBody Supplier supplier) {
		int result = supplierService.updateSupplier(supplier);
		if(result > 0) 
			return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
		else
			return new ResponseEntity<Supplier>(supplier, HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		int result = supplierService.deleteSupplier(id);
		if(result > 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}
}
