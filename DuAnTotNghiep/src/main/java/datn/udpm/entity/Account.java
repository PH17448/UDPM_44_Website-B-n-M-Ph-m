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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="email")
	private String email ;
	
	@Column(name="username")
	private String username ;
	
	@Column(name="password")
	private String password ;
	
	@Column(name="fullname")
	private String fullname ;
	
	@Column(name="createDate")
	@Temporal(TemporalType.DATE)
	private Date createDate = new Date() ;
	
	@Column(name="phone")
	private String phone ;
	
	@Column(name="image")
	private String image ;
	
	@Column(name="address")
	private String address ;
	
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role ;
	
	
	@OneToMany(mappedBy = "accountOrder")
	@JsonIgnore
	private List<Order> orders ;
}
