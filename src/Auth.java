import java.util.Scanner;

public class Auth {
	private User currentUser;
	private Scanner in;
	
	Auth(){
		this.currentUser = new User();
		this.in = new Scanner(System.in);
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
					state++;
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			case 2:
				System.out.println("Informe o seu Usuario:");
				try {
					this.currentUser.setLogin(in.nextLine());
					state++;
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			case 3:
				System.out.println("Informe o seu Email:");
				try {
					this.currentUser.setEmail(in.nextLine());
					state++;
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			case 4:
				System.out.println("Informe o sua Senha:");
				try {
					this.currentUser.setSenha(in.nextLine());
					state = 0;
				}catch (Exception e){
					System.out.println(e);
				}
				continue;
			}
		}while(state != 0);
		
		System.out.println(this.currentUser.getName());
		System.out.println(this.currentUser.getLogin());
		System.out.println(this.currentUser.getEmail());
		System.out.println(this.currentUser.getSenha());
	}
}
