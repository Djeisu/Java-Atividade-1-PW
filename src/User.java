
public class User {
	private String name;
	private String login;
	private String password;
	private String email;
	
	User(){
		
	}
	
	User(String n, String e, String l, String p){
		this.name = n;
		this.login = l;
		this.password = p;
		this.email = e;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String senha) {
		this.password = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean validateName(){
		return this.getName() != "";
	}
	
	public boolean validateEmail(){
		return (this.getEmail().split("@").length == 2);
	}

	public boolean validateLogin(){
		return this.getLogin() != "";
	}

	public boolean validatePassword(){
		return this.getPassword() != "";
	}
	
	public String getUserLineRegister(){
		return this.getName() + ";" + this.getEmail() + ";" + this.getLogin() + ";" + this.getPassword(); 
	}
	
	public String getUserLineRegister(User u){
		return u.getName() + ";" + u.getEmail() + ";" + u.getLogin() + ";" + u.getPassword(); 
	}
}
