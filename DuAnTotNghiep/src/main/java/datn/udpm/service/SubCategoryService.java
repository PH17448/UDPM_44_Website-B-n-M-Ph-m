package datn.udpm.service;

import java.util.List;

import datn.udpm.entity.Category;
import datn.udpm.entity.SubCategory;

public interface SubCategoryService {

	List<SubCategory> findAll();

	List<SubCategory> findByById(Integer id);

	void save(SubCategory sub);

	SubCategory findById(Integer id);

	void delete(SubCategory sub);

}
