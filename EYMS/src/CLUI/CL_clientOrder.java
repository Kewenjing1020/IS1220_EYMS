package CLUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import DataBase.DataResto;
import Restaurant.Restaurant;

public class CL_clientOrder {
	
	static String delim="[ ,<>()]+";
	
	public static void selectResto_start(){
		System.out.println("please choose a restaurant \n "
				+ "type in the form of: selectResto < restoName>");
	}
	public static Restaurant selectResto(ArrayList<Restaurant> all_Resto, Restaurant curr_resto) throws IOException{
		
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		String[] cmdline=answer.split(delim);
		if(cmdline[0].equals("selectResto") && DataResto.tryfind_resto(all_Resto,cmdline[1])){
			curr_resto=DataResto.find_resto(all_Resto, cmdline[1]);
			curr_resto.printMenuForClient();
		}else{
			System.out.println("Invalid input");
			selectResto_start();
			selectResto(all_Resto, curr_resto);
		}
		
		return curr_resto;
		
	}
	
}
