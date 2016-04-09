package CLUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import User.Client;

public class CommandMain {


	public static void main(String [] args) throws IOException{
		
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Welcome to our EYMS system!");
		
		
		while( true ){
			System.out.println("If you want to order meal, please type in\"Client\"");
			System.out.println("If you are chef of the restaurant, please type in\"Resto\"");
			String ans=typein.readLine();
			if(ans.equals("Client")){
				//turn to Client UI
				//CommandClient.commandClient();
				break;
			}
			else if(ans.equals("Resto")){
				//turn to Resto UI
				break;
			}
			else{
				System.out.println("Invalid Input.");
				continue;
			}
		}
		
		
		System.out.println("Thank you for your visit");
		
	}
}
