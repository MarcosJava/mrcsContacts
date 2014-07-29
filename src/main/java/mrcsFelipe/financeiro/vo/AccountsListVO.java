package mrcsFelipe.financeiro.vo;

import java.io.Serializable;
import java.util.List;

import mrcsFelipe.financeiro.entity.Account;

public class AccountsListVO implements Serializable{
	private int pagesCount;
	private long totalAccounts;
	
	private List<Account> accounts;

	public AccountsListVO(int pagesCount, long totalAccounts,
			List<Account> accounts) {
		super();
		this.pagesCount = pagesCount;
		this.totalAccounts = totalAccounts;
		this.accounts = accounts;
	}
	/**
	 * 
	 * GETTER & SETTER
	 */

	public int getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}

	public long getTotalAccounts() {
		return totalAccounts;
	}

	public void setTotalAccounts(long totalAccounts) {
		this.totalAccounts = totalAccounts;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
