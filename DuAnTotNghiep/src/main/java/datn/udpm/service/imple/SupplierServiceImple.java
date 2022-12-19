package datn.udpm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import datn.udpm.entity.Supplier;
import datn.udpm.respository.SupplierRespository;
import datn.udpm.service.SupplierService;
@Service
public class SupplierServiceImple implements SupplierService {
	@Autowired
	SupplierRespository supRepo;
	
	@Override
	public List<Supplier> findAll() {
		return supRepo.findAll();
	}

	
	
	
	@Override
	public Supplier save(Supplier supplier) {
		return supRepo.save(supplier);
	}

	@Override
	public Supplier findById(Integer id) {
		return supRepo.findById(id).get();
	}

	@Override
	public void delete(Supplier result) {
		supRepo.delete(result);
	}
	
}
