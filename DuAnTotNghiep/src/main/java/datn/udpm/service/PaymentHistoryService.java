package datn.udpm.service;

import java.util.List;

import datn.udpm.entity.PaymentHistory;

public interface PaymentHistoryService {

	List<PaymentHistory> findAll();

	PaymentHistory save(PaymentHistory paymentHistory);

}
