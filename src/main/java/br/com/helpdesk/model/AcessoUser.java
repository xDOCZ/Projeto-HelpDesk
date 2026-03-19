package br.com.helpdesk.model;

import java.util.Scanner;

public class AcessoUser {
	// Atributos
	private String userUserName;
	private String userUserPassword;
	// Credenciais corretas
	private static String correctUserName = "comercial12";
	private static String correctUserPassword = "20147x1";

	// Metodo de login
	public void loginUser() {
		Scanner sc = new Scanner(System.in);
		int tentativas = 3;

		while (tentativas > 0) {
			System.out.println("----------------------");
			System.out.println("POR FAVOR INSIRA AS SUAS CREDENCIAIS");
			System.out.println("----------------------");
			System.out.print("USERNAME: ");
			userUserName = sc.nextLine().toLowerCase();

			// Achar uma forma de ocultar essa senha
			System.out.print("SENHA: ");
			userUserPassword = sc.nextLine().toLowerCase();

			// Valida se as credenciais estão corretas
			if (userUserName.equals(correctUserName) && userUserPassword.equals(correctUserPassword)) {
				int opcMenuUser;
				do {
					System.out.println("----------------------");
					System.out.println("ACESSO PERMITIDO!");
					System.out.println("----------------------");
					System.out.println("BEM VINDO DE VOLTA");
					System.out.println("----------------------");
					System.out.println("1. CRIAR TICKET");
					System.out.println("2. VISUALIZAR TICKETS");
					System.out.println("0. SAIR");
					System.out.println("----------------------");

					opcMenuUser = sc.nextInt();

				} while (opcMenuUser != 0);

				switch (opcMenuUser) {
				case 1: CriarTick
				case 2:
				}

			} else {
				tentativas--;

				// ## It denies if the credentials are not correct ## //
				if (tentativas == 0) {
					System.out.println("ACESS O NEGADO!");
				} else {
					System.out
							.println("AS CREDENCIAIS NÃO ESTÃO CORRETAS. VOCÊ AINDA TEM: " + tentativas + " RESTANTES");
				}
			}
		}

		sc.close();
	}
}
