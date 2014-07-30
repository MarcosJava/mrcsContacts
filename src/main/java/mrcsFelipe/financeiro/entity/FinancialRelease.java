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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="financial_release")
public class FinancialRelease implements java.io.Serializable{

	@Id @GeneratedValue
	private Integer id;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="account_id")
	@JsonIgnore
	private Account account;
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date dateRelease;
	
	private String description;
	
	@Column(precision=10, scale=2)
	private BigDecimal value;
	
	
	private String typeValue;
	
	public FinancialRelease() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Date getDateRelease() {
		return dateRelease;
	}


	public void setDateRelease(Date dateRelease) {
		this.dateRelease = dateRelease;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getValue() {
		return value;
	}


	public void setValue(BigDecimal value) {
		this.value = value;
	}


	public String getTypeValue() {
		return typeValue;
	}


	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}

	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateRelease == null) ? 0 : dateRelease.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((typeValue == null) ? 0 : typeValue.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinancialRelease other = (FinancialRelease) obj;
		if (dateRelease == null) {
			if (other.dateRelease != null)
				return false;
		} else if (!dateRelease.equals(other.dateRelease))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (typeValue == null) {
			if (other.typeValue != null)
				return false;
		} else if (!typeValue.equals(other.typeValue))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "FinancialRelease [id=" + id + ", dateRelease=" + dateRelease
				+ ", description=" + description + ", value=" + value
				+ ", typeValue=" + typeValue + "]";
	}
	
	
	
	
}
