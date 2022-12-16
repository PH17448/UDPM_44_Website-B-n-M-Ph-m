package datn.udpm.respository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import datn.udpm.entity.Product;

public interface ProductRespository extends JpaRepository<Product,Integer> {
	
	
	@Query("SELECT p FROM Product p WHERE p.subCategory.id=?1")
	List<Product> findBySubCategoryId(Integer cid);

}
