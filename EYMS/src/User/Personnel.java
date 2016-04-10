package User;

public class Personnel extends User implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6014730461542734062L;

	public Personnel(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public Personnel(String firstName,String lastName, String username, String password){
		this.first_name=firstName;
		this.last_name=lastName;
		this.user_name=username;
		this.password=password;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
