import java.util.Scanner;

public class Auth {
	private User currentUser;
	private Scanner in;
	private AuthService authService;
	
	Auth(){
		this.currentUser = new User();
		this.in = new Scanner(System.in);
		this.authService = new AuthService();
	}
	
	public User getCurrentUser(){
		return this.currentUser;
	}
	
	public void signup(){
		int state = 1;
		do{
			switch(state){
			case 1:
				System.out.println("Informe o seu nome:");
				try {
					this.currentUser.setName(in.nextLine());
					if(this.currentUser.validateName())
						state++;
					else
						System.out.println("Nome inválido, tente novamente!");
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			case 2:
				System.out.println("Informe o seu Usuario:");
				try {
					this.currentUser.setLogin(in.nextLine());
					if(this.currentUser.validateLogin())
						state++;
					else
						System.out.println("Login inválido, tente novamente!");
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			case 3:
				System.out.println("Informe o seu Email:");
				try {
					this.currentUser.setEmail(in.nextLine());
					if(this.currentUser.validateEmail())
						state++;
					else
						System.out.println("Email inválido, tente novamente!");
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			case 4:
				System.out.println("Informe o sua Senha:");
				try {
					this.currentUser.setPassword(in.nextLine());
					if(this.currentUser.validatePassword())
						state = 0;
					else
						System.out.println("Senha inválido, tente novamente!");
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			}
		}while(state != 0);
		
		this.authService.signup(this.currentUser);
	}
}
