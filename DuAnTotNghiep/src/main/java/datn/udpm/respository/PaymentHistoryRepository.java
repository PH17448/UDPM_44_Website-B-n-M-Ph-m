package datn.udpm.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import datn.udpm.entity.PaymentHistory;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory,Integer> {

}
