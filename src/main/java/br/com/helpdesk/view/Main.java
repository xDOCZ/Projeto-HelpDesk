package br.com.helpdesk.view;

import java.util.Scanner;
import br.com.helpdesk.model.AcessoAdmin;
import br.com.helpdesk.model.AcessoUser;

public class Main {
	// Objects
	static Scanner sc = new Scanner(System.in);
	static AcessoAdmin acessoAdmin = new AcessoAdmin();
	static AcessoUser acessoUser = new AcessoUser();

	// Faz a limpeza do terminal
	public static void limparTela() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	public static void retornarMenu() {
		menu();
	}

	public static void menu() {
		int opc = 0;

		System.out.println("teste branch sandbox");

		do {
			System.out.println("----------------------");
			System.out.println("MIRAGE SYSTEMS");
			System.out.println("----------------------");
			System.out.println("1. LOGIN COMO ADMIN");
			System.out.println("2. LOGIN COMO USER");
			System.out.println("0. SAIR");
			System.out.println("----------------------");
			System.out.print("ESCOLHA:");
			opc = sc.nextInt();

			limparTela();

			if (opc == 1) {
				acessoAdmin.loginAdmin(sc);
			} else if (opc == 2) {
				acessoUser.loginUser();
			}
		} while (opc != 0);
	}

	public static void main(String[] args) {
		menu();
		sc.close();
	}
}