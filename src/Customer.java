
public class Customer {

	public String name;
	public String id;
	public String email;
	public String password;
	static Customer cust = new Customer();
	/*public Customer(String email, String password) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
	}*/	
	private Customer() {	
	}	
	public static Customer getInstance() {
		return cust;
	}
	public void setName(String email) {
		// TODO Auto-generated constructor stub
	}		
	public void setID(String id) {
		// do later
		this.id = id;
	}
	public String getemail() {
		// TODO Auto-generated constructor stub
		return this.email;
	}	
	public void setemail(String email) {
		// TODO Auto-generated constructor stub
		this.email = email;
	}		
	public String getpassword() {
		// TODO Auto-generated constructor stub
		return this.email;
	}	
	public void setpassword(String password) {
		// TODO Auto-generated constructor stub
		this.password = password;
	}	
	public String getID(String email) {
		// do later
		return this.id;
	}
}
