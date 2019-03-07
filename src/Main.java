import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
		int option = -1;
		
		do {
			System.out.println("Bem Vindo! \n");
			System.out.println("1: Incluir um novo usuário");
			System.out.println("2: Alterar um usuário existente");
			System.out.println("3: Remover um usuário existente");
			System.out.println("4: Exibir um usuário existente");
			System.out.println("5: Exibir todos os usuários existentes");
			System.out.println("0: Sair");
			
			try {
				option = in.nextInt();
			}catch (Exception e){
				System.out.println(e);
			}
			
			switch (option) {
			case 1:
				System.out.println("\n\n Adicionou um user doidão \n");
				continue;
			case 2:
				System.out.println("\n\n Aqui não tem nada ainda \n");
				continue;
			default:
				System.out.println("\n\n Não tem esse valor não \n");
				continue;
			}
		} while (option != 0);
	}
}
