package datn.udpm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="news")
public class News implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@Column(name="title")
	private String title ;
	
	@Column(name="sumary")
	private String sumary ;
	
	@Column(name="content")
	private String content ;
	
	@Column(name="create_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="dd/MM/yyyy")
	private Date createDate = new Date();
	
	@Column(name="author")
	private String author ;
}
