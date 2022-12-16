package datn.udpm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name="products")
public class Product  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@Column(name="name")
	private String name ;
	
	@Column(name="price")
	private Double price ;
	
	@Column(name="description")
	private String description ;
	
	@Column(name="picture1")
	private String picture1 ;
	
	@Column(name="picture2")
	private String picture2 ;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate = new Date() ;
	
	@Column(name="available")
	private Boolean available ;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="expire_date")
	private Date expireDate ;
	
	@Column(name="quantity")
	private Integer quantity ;
	
	@Column(name="quantity_sold")
	private Integer quantitySold ;
	
	@OneToMany(mappedBy = "product")
	private List<Favourite> favourities ;
	
	@ManyToOne
	@JoinColumn(name = "sup_id")
	private Supplier supplier ;
	
	@ManyToOne
	@JoinColumn(name = "supcategory_id")
	private SubCategory subCategory ;
	
	@OneToMany(mappedBy = "productCapacities")
	@JsonIgnore
	private List<Capacity> capacities ;
	
	@ManyToOne
	@JoinColumn(name = "discount_id")
	private DiscountProduct discount ;
	
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<OrderDetail> orderDetails ;
}
