package datn.udpm.service;

import java.util.List;
import java.util.Optional;

import datn.udpm.entity.Product;

public interface ProductService {

	List<Product> findAll();

	List<Product> findBySubCategoryId(Integer cid);

	Product findById(Integer id);

	Product save(Product product);
	

}
