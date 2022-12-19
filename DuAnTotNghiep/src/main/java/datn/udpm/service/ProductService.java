package datn.udpm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import datn.udpm.entity.Product;

public interface ProductService {

	List<Product> findAll();

	List<Product> findBySubCategoryId(Integer cid);

	Product findById(Integer id);

	Product save(Product product);


	Page<Product> findAll(Pageable pageable);


	void delete(Product pro);

	Page<Product> findPage(int page, int size);


}
