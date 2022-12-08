package datn.udpm.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import datn.udpm.entity.OrderDetail;

public interface OrderDetailRespository extends JpaRepository<OrderDetail,Integer> {

	
	@Query("SELECT oddt FROM OrderDetail oddt WHERE oddt.order.id=?1")
	OrderDetail findByOrderId(Integer id);

}
