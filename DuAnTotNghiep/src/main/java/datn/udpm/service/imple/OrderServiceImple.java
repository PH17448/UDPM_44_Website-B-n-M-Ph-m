package datn.udpm.service.imple;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import datn.udpm.entity.Order;
import datn.udpm.entity.OrderDetail;
import datn.udpm.respository.OrderDetailRespository;
import datn.udpm.respository.OrderRespository;
import datn.udpm.service.OrderService;
@Service
public class OrderServiceImple implements OrderService {
	
	@Autowired
	OrderRespository orderRepo ;
	
	@Autowired
	OrderDetailRespository orderDetailRepo;
	
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData,Order.class);
		orderRepo.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		orderDetailRepo.saveAll(details);
		
		return order ;
	}

	@Override
	public Order findById(Integer id) {
		return orderRepo.findById(id).get();
	}

	@Override
	public List<Order> findByEmail(String email) {
		
		return orderRepo.findByEmail(email);
	}

	@Override
	public Order save(Order result) {
		return orderRepo.save(result);
	}

	@Override
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	

	
	
	

}
