package datn.udpm.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import datn.udpm.entity.Product;

public interface ProductService {

	List<Product> findAll();

	List<Product> findBySubCategoryId(Integer cid);

	Product findById(Integer id);

	Product save(Product product);

	void delete(Product pro);
	
	Page<Product> findPage(int page, int size);

}
