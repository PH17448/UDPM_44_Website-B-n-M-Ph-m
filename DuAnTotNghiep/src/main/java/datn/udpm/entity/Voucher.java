package datn.udpm.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="voucher")
public class Voucher  implements Serializable{
	
	
	@Column(name="discount")
	private Double discount ;
	
	@Id
	@Column(name="code")
	private String code ;
	
	@Column(name="voucher_name")
	private String voucherName;
	
	@Column(name="create_date")
	private Date createDate ;
	
	@Column(name="from_time")
	private Date fromTime ;
	
	@Column(name="to_time")
	private Date toTime ;
	
	@OneToMany(mappedBy = "voucher")
	@JsonIgnore
	private List<Order> orders ; 
}
