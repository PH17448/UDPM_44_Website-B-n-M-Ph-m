package datn.udpm.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.databind.JsonNode;

import datn.udpm.entity.Order;

public interface OrderRespository extends JpaRepository<Order,Integer> {

	
	@Query("SELECT o FROM Order o WHERE o.accountOrder.email=?1")
	List<Order> findByEmail(String email);

	
	@Query("SELECT COUNT(o.id) FROM Order o WHERE o.status = 0 ")
	Integer findByOrderNotApprove();


	@Query("SELECT o FROM Order o WHERE o.status = 0")
	List<Order> findListNameOrder();

	
	
	
	
	

}
