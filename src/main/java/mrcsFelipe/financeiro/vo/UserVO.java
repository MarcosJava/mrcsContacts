package mrcsFelipe.financeiro.vo;

public class UserVO {

	private int id;
	private String name;
	private String email;
	private boolean enable;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(int id, String name, String email, boolean enable) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.enable = enable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	
	
	
}
