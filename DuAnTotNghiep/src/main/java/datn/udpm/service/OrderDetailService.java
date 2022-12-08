package datn.udpm.service;

import datn.udpm.entity.OrderDetail;

public interface OrderDetailService {

	OrderDetail findById(Integer id);

	OrderDetail findByOrderId(Integer id);

}
