package datn.udpm.service.imple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import datn.udpm.entity.Product;
import datn.udpm.respository.ProductRespository;
import datn.udpm.service.ProductService;
@Service
public class ProductServiceImple implements ProductService {

	@Autowired
	ProductRespository productRepo ;
	
	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public List<Product> findBySubCategoryId(Integer cid) {
		return productRepo.findBySubCategoryId(cid);
	}

	@Override
	public Product findById(Integer id) {
		return productRepo.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepo.findAll(pageable);
	}


}
