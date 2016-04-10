package CLUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import DataBase.DataClient;
import FidelityCard.LotteryFidelityCard;
import FidelityCard.PointFidelityCard;
import User.Client;

public class CL_clientLogin {
	static String delim="[ ,<>()]+";
	
	public static void main(String [] args) throws IOException{
		Client curr_client=new Client();
		ArrayList<Client> all_clients= DataClient.Load_ClientData();
		Register_start(curr_client);
		curr_client=Register(all_clients,curr_client);
		System.out.println(curr_client);
	
	}
	
	
	
	public static void Login_start(Client curr_client) throws IOException{
		System.out.println("Please type in your login information in the form of: login <username, password>");
	}
	public static Client Login(ArrayList<Client> all_clients,Client curr_client) throws IOException{
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		String[] cmdline=answer.split(delim);
		if(cmdline[0].equals("login") && DataClient.tryLogin(all_clients, cmdline[1], cmdline[2])){
			curr_client=DataClient.login(all_clients, cmdline[1], cmdline[2]);
		}else if(!DataClient.verify(all_clients, cmdline[1])){
			System.out.println("incorrect password");
			Login_start(curr_client);
			Login(all_clients,curr_client);
		}
		else{
			System.out.println("Invalid input");
			Login_start(curr_client);
			Login(all_clients,curr_client);
		}
		return curr_client;
		
	}
	
	
	/**
	 * 
	 * @param curr_client
	 * @throws IOException
	 */
	public static void Register_start(Client curr_client) throws IOException{
		System.out.println("please type in your personnal information in the form of \n"
				+ " registerClient <firstName, lastName, username, password>");
	}
	/**
	 * 
	 * @param all_clients
	 * @param curr_client
	 * @return
	 * @throws IOException
	 */
	public static Client Register(ArrayList<Client> all_clients,Client curr_client) throws IOException{
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		String[] cmdline=answer.split(delim);
		
		if(cmdline.length != 5 ||!(cmdline[0].equals("registerClient"))){
			System.out.println(cmdline.length);
			System.out.println("Invalid Input.");	
			Register_start(curr_client);
			Register(all_clients,curr_client);
		}else if(!DataClient.verify(all_clients, cmdline[3])){
			System.out.println("the username "+cmdline[3]+" is already used.");
			Register_start(curr_client);
			Register(all_clients,curr_client);
		}else{
			curr_client=new Client(cmdline[1],cmdline[2],cmdline[3],cmdline[4]);
			
			//addContactInfo<email, phonenumber>
			CL_clientLogin.addContactInfo_start(curr_client);
			CL_clientLogin.addContactInfo(curr_client);
			
			//associateCard <cardType>
			CL_clientLogin.associateCard_start(curr_client);
			CL_clientLogin.associateCard(curr_client);
			
			//associateAgreement <agreement>
			}
			return curr_client;
		}
	
	/**
	 * 
	 * @param curr_client
	 * @throws IOException
	 */
	public static void associateCard_start(Client curr_client) throws IOException{
		System.out.println("now you can do the operation following: \n"
								+ "type in : associateCard <cardType> , to choose a cardtype(BasicFidelityCard, LotteryFidelityCard or PointFidelityCard)");
						System.out.println("type in : next, to skip this step");
	}
	/**
	 * 
	 * @param curr_client
	 * @return
	 * @throws IOException
	 */
	public static Client associateCard(Client curr_client) throws IOException{
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		String[] cmdline=answer.split(delim);
		
		if(cmdline[0].equals("associateCard")){
			switch (cmdline[1]){
				case "BasicFidelityCard":{
					break;
				}
				case "LotteryFidelityCard":{
					curr_client.setFidelityCard(new LotteryFidelityCard());
					break;
				}
				case "PointFidelityCard":{
					curr_client.setFidelityCard(new PointFidelityCard());
					break;
				}	
			}
		}
		else if(answer.equals("next")){
			return curr_client;
		}
		else {
			associateCard_start(curr_client);
			associateCard(curr_client);
		}
		return curr_client;
		}
		
		

	
	
	/**
	 * 
	 * @param curr_client
	 * @throws IOException
	 */
	public static void addContactInfo_start(Client curr_client) throws IOException{
		System.out.println("please type in your contact information, in the form of:"
				+ "addContactInfo<email, phonenumber> \n");
	}
	/**
	 * 
	 * @param curr_client
	 * @return
	 * @throws IOException
	 */
	public static Client addContactInfo(Client curr_client) throws IOException{
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		String[] cmdline=answer.split(delim);
		if((cmdline.length==3) && (cmdline[0].equals("addContactInfo"))){
			curr_client.add_email(cmdline[1]);
			curr_client.add_phone_number(cmdline[2]);
			System.out.println("contack info is ok");
		}else{
			System.out.println("invalid input");
			addContactInfo_start(curr_client);
			addContactInfo(curr_client);
			
		}
		return curr_client;
		
	}
	

		
 
 
	 
	 
 
	
	
}
