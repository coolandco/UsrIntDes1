package Schnittstellenschicht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class consoleHandler {

	
	/**
	 * hier wird der Befehl ausgeführt, den die Console entgegennimmt.
	 * 
	 * 
	 * @param befehl
	 * @return wenn befehl erkannt, dann true, wenn nicht erkannt dann false
	 */
	abstract  protected boolean befehl(String befehl);
	
	
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public void newBefehl() {
		
//		System.out.println(welcomeMessage);//zeigt die Startaufforderung
		
		
		while(true) {
			
			try {
				if( befehl(in.readLine()))//führt den befehl aus der eingelesen wird. Wenn nicht richtig, dann:
					break;//all good, so exit loop
				else
					System.out.println("Befehl falsch, bitte versuchen Sie es erneut:");
				
			} catch (IOException e) {
				
				System.out.println("Exeption : Wrong Input. Try again");
			}
		}
		
	}
	
	
	/**
	 * 
	 * @return returns a string that has been entered by the user into the console
	 */
	public String newRequest() {
		try {
			return in.readLine();
		} catch (IOException e) {
			System.out.println("Exeption : Wrong Input. Try again");
			return newRequest();//in case of wrong input
		}
		
		
		
	}
	
	
	
	
	
}
