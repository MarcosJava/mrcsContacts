package mrcsFelipe.financeiro.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="account")
public class Account {

	@Id @GeneratedValue
	private Integer id;
	
	private String name;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreate;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal amountStart;
	
	private boolean favorite;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="system_user_id")
	private User user;
	
	public Account() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	

	public BigDecimal getAmountStart() {
		return amountStart;
	}

	public void setAmountStart(BigDecimal amountStart) {
		this.amountStart = amountStart;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", description="
				+ description + ", dateCreate=" + dateCreate + ", amountStart="
				+ amountStart + ", favorite=" + favorite + "]";
	}
	
	
	
}
