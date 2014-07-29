package mrcsFelipe.financeiro.vo;

import java.math.BigDecimal;
import java.util.Date;

public class AccountVO {
	
private Integer id;
	
	private String name;
	
	private String description;
	
	private Date dateCreate;
	
	private BigDecimal amountStart;

	private boolean favorite;
	
	public AccountVO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	

}
