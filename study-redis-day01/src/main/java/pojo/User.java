package pojo;

public class User {
	private String username;
	
	private String sex;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", sex=" + sex + "]";
	}
	
}
