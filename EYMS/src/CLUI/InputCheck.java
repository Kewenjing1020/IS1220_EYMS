package CLUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputCheck {
	
	BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
	
	public boolean inputcheck(String inputType) {
		
			if (this.equals(inputType))
				return true;
			else
				return false;
	}
	
	
}
