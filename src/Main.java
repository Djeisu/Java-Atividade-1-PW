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
			System.out.println("Bem Vindo!");
			System.out.println("1: Add User");
			System.out.println("2: N�o Tem Nada");
			System.out.println("0: Sair");
			
			try {
				option = in.nextInt();
			}catch (Exception e){
				System.out.println(e);
			}
			
			switch (option) {
			case 1:
				System.out.println("\n\n Adicionou um user doid�o \n");
				continue;
			case 2:
				System.out.println("\n\n Aqui n�o tem nada ainda \n");
				continue;
			default:
				System.out.println("\n\n N�o tem esse valor n�o \n");
				continue;
			}
		} while (option != 0);
	}
}
