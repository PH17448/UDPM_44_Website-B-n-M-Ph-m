package datn.udpm.service;

import java.util.List;

import datn.udpm.entity.DiscountProduct;

public interface DiscountService {

	List<DiscountProduct> findAll();

	DiscountProduct save(DiscountProduct discountProduct);

	DiscountProduct findById(Integer id);

	void delete(DiscountProduct result);

}
