import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;

public class AuthService {
	private	String pathTxt, pathDir;
	private	File db,users;
	
	public AuthService() {
		this.pathDir = "db/";
		this.pathTxt = "users.txt";
		
		this.createFile();
	}
	
	public boolean validateLogin(String login) {
		for (String element : this.searchInFile()) {
			if(login.equals(element.split(";")[2]))
				return true;
		}
		return false;
	}
	
	public boolean validateEmail(String email) {
		for (String element : this.searchInFile()) {
			if(email.equals(element.split(";")[1]))
				return true;
		}
		return false;
	}
	
	public boolean validateUser(User u) {
		for (String element : this.searchInFile()) {
			if(this.checkStringRegister(u,element))
				return true;
		}
		return false;
	}
	
	public void signup(User u){
		this.writeInFile(u.getUserLineRegister());
	}

	public void alterUserInFile(User ol, User ne) {
		ArrayList<String> temp = this.searchInFile();
		this.removeFile();
		this.createFile();
		for (String element : temp) {
			if(!this.checkStringRegister(ol,element))
				this.writeInFile(element);
			else
				this.writeInFile(ne.getUserLineRegister());
		}
	}
	
	public User login(User u){
		return new User();
	}
	
	public User getUser(User u) {
		for (String element : this.searchInFile()) {
			String[] temp = element.split(";");
			if(this.checkStringRegister(u,element))
				return new User(temp[0],temp[1],temp[2],temp[3]);
		}
		return new User();
	}
	
	public void getAllUser() {
		for (String element : this.searchInFile()) {
			System.out.println(element);
		}
	}
	
	public void removeUserInFile(User u) {
		ArrayList<String> temp = this.searchInFile();
		this.removeFile();
		this.createFile();
		for (String element : temp) {
			if(!this.checkStringRegister(u,element))
				this.writeInFile(element);
		}
	}
	
	private void createFile() {
		this.db = new File("./" + this.pathDir);
		this.users = new File("./" + this.pathDir + this.pathTxt);
		
		if(!this.users.exists() || !this.db.exists()) {
			try {
				this.db.mkdir();
				this.users.createNewFile();
			}catch (Exception e) {
				System.out.println("Não foi possível criar o arquivo dos usuários, tente novamente");
			}
		}
	}
	
	private void removeFile() {
		this.users.delete();
	}
	
	private boolean checkStringRegister(User u, String element) {
		String[] temp = element.split(";");
		return (u.getEmail().equals(temp[1]) || u.getLogin().equals(temp[2])) && u.getPassword().equals(temp[3]);
	}
	
    private ArrayList<String> searchInFile() {
    	ArrayList<String> listUsers = new ArrayList<String>();
    	
    	try {
    		FileReader fr = new FileReader("./" + this.pathDir + this.pathTxt);
    		BufferedReader br = new BufferedReader(fr);
    		
    		while(br.ready()) {	listUsers.add(br.readLine()); }
    		
    		br.close();
    		fr.close();
    		
    	}catch (Exception e){
    		System.out.println("Error" + e);
    	}
    	
    	return listUsers;
    }
    
    private void writeInFile(String u) {
    	try {
    		FileWriter fw = new FileWriter(this.users,true);
    		BufferedWriter bw = new BufferedWriter(fw);
    		bw.write(u);
    		bw.newLine();
    		bw.close();
    		fw.close();	
    	}catch(Exception e){
    		System.out.println("Error" + e);
    	}
    }
}
