package datn.udpm.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import datn.udpm.entity.Voucher;

public interface VoucherRespository extends JpaRepository<Voucher,String> {

}
