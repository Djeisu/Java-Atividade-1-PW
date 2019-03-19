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
		this.getFullUser();
		this.authService.signup(this.currentUser);
	}
	
	public void uploadUser() {
		System.out.println("Conta Atual");
		User oUser = this.getUserByLoginOrEmail();
		System.out.println("\nNova Conta");
		User nUser = this.getFullUser();
		
		boolean state = false;
		do {
			System.out.print("Tem certeza que deseja alterar o usuário? (y/n):");
			try {
				String response = in.nextLine();
				if(response.equalsIgnoreCase("y")) {
					this.authService.alterUserInFile(oUser, nUser);
					System.out.println("\n\nO usuário foi alterado com sucesso!");
					state = true;
				}	
				else if(response.equalsIgnoreCase("n")) {
					System.out.println("\n\nO usuário não foi alterado");
					state = true;
				}
				else {
					state = false;
				}
			}catch (Exception e){
				System.out.println(e);
			}
		}while(!state);
	}
	
	public void login() {
		this.getUserByLoginOrEmail();
		System.out.println(this.currentUser.getUserLineRegister());
	}
	
	public void listUsers() {
		this.authService.getAllUser();
	}
	
	public void removeAccount() {
		this.getUserByLoginOrEmail();
		this.authService.removeUserInFile(this.currentUser);
	}
	
	private User getFullUser() {
		int state = 1;
		do{
			switch(state){
			case 1:
				System.out.print("Informe o seu nome:");
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
				System.out.print("Informe o seu Usuario:");
				try {
					this.currentUser.setLogin(in.nextLine());

					if(this.currentUser.validateLogin())
						if(this.authService.validateLogin(this.currentUser.getLogin()))
							System.out.println("\nEste usuário já está em uso, tente outro, por favor!\n");
						else
							state++;
					else
						System.out.println("Login inválido, tente novamente!");
					
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			case 3:
				System.out.print("Informe o seu Email:");
				try {
					this.currentUser.setEmail(in.nextLine());
					
					if(this.currentUser.validateEmail())
						if(this.authService.validateEmail(this.currentUser.getEmail()))
							System.out.println("\nEste e-mail já está em uso, tente outro, por favor!\n");
						else
							state++;
					else
						System.out.println("Email inválido, tente novamente!");
					
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			case 4:
				System.out.print("Informe o sua Senha:");
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
		
		return this.currentUser;
	}
	
	private User getUserByLoginOrEmail() {
		int state = 1;
		do{
			switch(state){
			case 1:
				System.out.print("Informe o seu login ou e-mail:");
				try {
					String tempNameEmail = in.nextLine();
					this.currentUser.setEmail(tempNameEmail);
					
					//Verifica se o login está salvo na base de dados
					if(!this.currentUser.validateEmail()) {
						this.currentUser.setLogin(tempNameEmail);
						if(!this.authService.validateLogin(this.currentUser.getLogin()))
							System.out.println("Não encontramos seu login na nossa base, por favor tente novamente!");
						else 
							state++;
					}
					//verifica se o email está salvo na base de dados
					else {
						if(!this.authService.validateEmail(this.currentUser.getEmail()))
							System.out.println("Não encontramos seu email na nossa base, por favor tente novamente!");
						else
							state++;
					}
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			case 2:
				System.out.print("Informe o sua Senha:");
				try {
					this.currentUser.setPassword(in.nextLine());
					if(this.currentUser.validatePassword() && this.authService.validateUser(this.currentUser))
						state = 0;
					else
						System.out.println("Senha inválido, tente novamente!");
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			}
		}while(state != 0);
		
		this.currentUser = this.authService.getUser(this.currentUser);
		return this.authService.getUser(this.currentUser);
	}
}
