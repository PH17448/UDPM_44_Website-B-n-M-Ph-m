package datn.udpm.service;

import java.util.List;

import org.springframework.data.domain.Page;

import datn.udpm.entity.Category;
import datn.udpm.entity.Product;
import datn.udpm.entity.SubCategory;

public interface SubCategoryService {

	List<SubCategory> findAll();

	List<SubCategory> findByById(Integer id);

	void save(SubCategory sub);

	SubCategory findById(Integer id);

	void delete(SubCategory sub);
	
	Page<SubCategory> findPage(int page, int size);

}
