package datn.udpm.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import datn.udpm.entity.Order;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Integer id);

	List<Order> findByEmail(String email);

	Order save(Order result);

	List<Order> findAll();

	Integer findByOrderNotApprove();

	List<Order> getListNamePeople();



}
