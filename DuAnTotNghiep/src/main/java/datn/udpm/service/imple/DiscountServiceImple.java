package datn.udpm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import datn.udpm.entity.DiscountProduct;
import datn.udpm.respository.DiscountProductRespository;
import datn.udpm.service.DiscountService;
@Service
public class DiscountServiceImple implements DiscountService {

	@Autowired
	DiscountProductRespository discountRepo ;
	
	@Override
	public List<DiscountProduct> findAll() {
		return discountRepo.findAll();
	}

	@Override
	public DiscountProduct save(DiscountProduct discountProduct) {
		return discountRepo.save(discountProduct);
	}

	@Override
	public DiscountProduct findById(Integer id) {
		return discountRepo.findById(id).get();
	}

	@Override
	public void delete(DiscountProduct result) {
		discountRepo.delete(result);
	}

}
