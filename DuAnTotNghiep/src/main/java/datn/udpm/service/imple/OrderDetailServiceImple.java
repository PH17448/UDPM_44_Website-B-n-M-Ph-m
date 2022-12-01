package datn.udpm.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import datn.udpm.entity.OrderDetail;
import datn.udpm.respository.OrderDetailRespository;
import datn.udpm.service.OrderDetailService;
@Service
public class OrderDetailServiceImple implements OrderDetailService {
	
	@Autowired
	OrderDetailRespository orderDetailRespository ;
	
	@Override
	public OrderDetail findById(Integer id) {
		return orderDetailRespository.findById(id).get();
	}

}
