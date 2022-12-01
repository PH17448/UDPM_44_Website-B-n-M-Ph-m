package datn.udpm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="payment")
public class Payment  implements Serializable{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@Column(name="name")
	private String name ;
	
	@OneToMany(mappedBy = "payment")
	@JsonIgnore
	private List<Order> orders ;	
	
	@OneToMany(mappedBy = "paymentHistory")
	@JsonIgnore
	private List<PaymentHistory> paymentHistories ;
}
