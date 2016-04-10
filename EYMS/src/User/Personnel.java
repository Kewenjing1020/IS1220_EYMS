package User;

public class Personnel extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6014730461542734062L;

	public Personnel(String username, String password) {
		super(username, password);
	}
	
	public Personnel(String firstName,String lastName, String username, String password){
		this.first_name=firstName;
		this.last_name=lastName;
		this.user_name=username;
		this.password=password;
	}

	@Override
	public String toString() {
		return "Personnel [user_name=" + user_name + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", password=" + password + "]";
	}
	
	



}
