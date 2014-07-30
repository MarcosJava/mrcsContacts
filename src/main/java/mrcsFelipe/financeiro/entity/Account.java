package mrcsFelipe.financeiro.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name="account")
public class Account implements java.io.Serializable {

	@Id @GeneratedValue
	private Integer id;
	
	private String name;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreate;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal amountStart;
	
	@Transient
	private BigDecimal total;
	
	private boolean favorite;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="system_user_id")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy="account" ,cascade={CascadeType.MERGE, CascadeType.REMOVE})
	@JsonIgnore
	private List<FinancialRelease> financialRelease;
	
	public Account() {
		
	}
	
	/**
	 * 
	 * Getter & Setter
	 */
	
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

	
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public List<FinancialRelease> getFinancialRelease() {
		return financialRelease;
	}

	public void setFinancialRelease(List<FinancialRelease> financialRelease) {
		this.financialRelease = financialRelease;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((amountStart == null) ? 0 : amountStart.hashCode());
		result = prime * result
				+ ((dateCreate == null) ? 0 : dateCreate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (favorite ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Account other = (Account) obj;
		if (amountStart == null) {
			if (other.amountStart != null)
				return false;
		} else if (!amountStart.equals(other.amountStart))
			return false;
		if (dateCreate == null) {
			if (other.dateCreate != null)
				return false;
		} else if (!dateCreate.equals(other.dateCreate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (favorite != other.favorite)
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
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", description="
				+ description + ", dateCreate=" + dateCreate + ", amountStart="
				+ amountStart + ", favorite=" + favorite + "]";
	}
	
	
	
}
