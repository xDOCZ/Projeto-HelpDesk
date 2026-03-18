package br.com.helpdesk.model;
import java.util.Scanner;

public class AcessoUser {
	// Attributes
    String userUserName; 
    String userUserPassword;
    // Correct credentials
    String correctUserName = "comercial12";
    String correctUserPassword = "20147x1";

    // ## Login method ## //	
    public void loginUser() {
        Scanner sc = new Scanner(System.in);
        int tentativas = 3;

       
        while (tentativas > 0) {
            System.out.println("PLEASE INSERT YOUR CREDENTIALS");
            System.out.print("USERNAME: ");
            userUserName = sc.nextLine().toLowerCase();
            // Achar uma forma de ocultar essa senha 
            System.out.print("PASSWORD: ");
            userUserPassword = sc.nextLine().toLowerCase();
            
            // ## Check if the credentials are correct ## //
            if (userUserName.equals(correctUserName) && userUserPassword.equals(correctUserPassword)) {
                System.out.println("ACESSO PERMITIDO!");
            	System.out.println("----------------------");
				System.out.println("BEM VINDO DE VOLTA");
				System.out.println("----------------------");
				System.out.println("1. CADASTRAR USUARIO");
				System.out.println("2. CADASTRAR TECNICO");
				System.out.println("----------------------");
                
            } else {
                tentativas--;
                
                // ## It denies if the credentials are not correct ## //
                if (tentativas == 0) {
                    System.out.println("ACESS DENIED!");
                } else {
                    System.out.println("THE CREDENTIALS ARE NOT CORRECT. YOU STILL HAVE: " + tentativas + " REMAING");
                }
            }
        }

        sc.close();
    }
}
