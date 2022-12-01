package datn.udpm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import datn.udpm.entity.PaymentHistory;
import datn.udpm.respository.PaymentHistoryRepository;
import datn.udpm.service.PaymentHistoryService;
@Service
public class PayemntHistoryServiceImple implements PaymentHistoryService {

	@Autowired
	PaymentHistoryRepository paymentHistoryRepository ;
	
	@Override
	public List<PaymentHistory> findAll() {
		return paymentHistoryRepository.findAll();
	}

	@Override
	public PaymentHistory save(PaymentHistory paymentHistory) {
		return paymentHistoryRepository.save(paymentHistory);
	}

}
