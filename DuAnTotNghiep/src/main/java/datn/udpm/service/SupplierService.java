package datn.udpm.service;

import java.util.List;

import datn.udpm.entity.Supplier;

public interface SupplierService {
	
	List<Supplier> findAll();

	Supplier save(Supplier supplier);

	Supplier findById(Integer id);


	void delete(Supplier result);
	
}
