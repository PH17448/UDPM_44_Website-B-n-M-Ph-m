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

}
