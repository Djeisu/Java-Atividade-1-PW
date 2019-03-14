import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		//Faz toda a configuracao de autenticacao
		Auth auth = new Auth();
		
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
		int option = -1;
		
		do {
			System.out.println("Bem Vindo! \n");
			System.out.println("1: Incluir um novo usuario");
			System.out.println("2: Alterar um usuario existente");
			System.out.println("3: Remover um usuario existente");
			System.out.println("4: Exibir um usuario existente");
			System.out.println("5: Exibir todos os usuarios existentes");
			System.out.println("0: Sair");
			
			try {
				option = in.nextInt();
			}catch (Exception e){
				System.out.println(e);
			}
			
			switch (option) {
			case 0:
				System.out.println("\n\n Valeu, meu fi, volte sempre \n");
				continue;
			case 1: //Adicionar novo usuario
				auth.signup();
				System.out.println("\n\n Adicionou um user doidao \n");
				continue;
			case 2: //Alterar usuario existante
				System.out.println("\n\n Aqui nao tem nada ainda \n");
				continue;
			case 3: //Remover um usuario existante
				System.out.println("\n\n Aqui nao tem nada ainda \n");
				continue;
			case 4: //Exibir usuario existante
				System.out.println("\n\n Aqui nao tem nada ainda \n");
				continue;
			case 5: //Exibir todos os usuarios
				System.out.println("\n\n Aqui nao tem nada ainda \n");
				continue;
			default:
				System.out.println("\n\n Nao tem esse valor nao \n");
				continue;
			}
		} while (option != 0);
	}
}
