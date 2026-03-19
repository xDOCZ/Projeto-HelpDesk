package br.com.helpdesk.model;

import java.util.ArrayList;
import java.util.Scanner;
import br.com.helpdesk.view.Main;

public class AcessoAdmin {
	private String adminUserName, adminPassword;
	private String correctAdminUserName = "naughtuser", correctAdminPassword = "40028922";

	ArrayList<CadastrarUser> users = new ArrayList<>();
	ArrayList<CadastrarTecnicos> tecnicos = new ArrayList<>();

	public void loginAdmin(Scanner sc) {
		int tentativas = 3;
		sc.nextLine();

		while (tentativas > 0) {
			System.out.println("----------------------");
			System.out.println("POR FAVOR, INSIRA OS DADOS DE LOGIN:");
			System.out.println("USER: ");
			adminUserName = sc.nextLine().toLowerCase();
			System.out.println("SENHA: ");
			adminPassword = sc.nextLine().toLowerCase();

			Main.limparTela();

			if (adminUserName.equals(correctAdminUserName) && adminPassword.equals(correctAdminPassword)) {
				System.out.println("----------------------");
				System.out.println("ACESSO PERMITIDO!");

				int opcAdmin = 0;

				do {
					System.out.println("----------------------");
					System.out.println("BEM VINDO DE VOLTA, MEU REI");
					System.out.println("----------------------");
					System.out.println("1. CADASTRAR USUARIO");
					System.out.println("2. CADASTRAR TECNICO");
					System.out.println("0. VOLTAR");
					System.out.println("----------------------");
					System.out.print("ESCOLHA: ");
					opcAdmin = sc.nextInt();
					sc.nextLine();

					Main.limparTela();

					switch (opcAdmin) {
					case 1: {
						int opc = 0;
						CadastrarUser u = null;

						do {
							System.out.println("----------------------");
							System.out.println("CADASTRAR USUARIO:");
							System.out.println("----------------------");

							// Nome
							String nome = "";
							while (true) {
								System.out.print("Nome: ");
								nome = sc.nextLine();
								try {
									CadastrarUser.validarNomeUser(nome);
									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							}

							// Sobrenome
							String sobrenome = "";
							while (true) {
								System.out.print("Sobrenome: ");
								sobrenome = sc.nextLine();
								try {
									CadastrarUser.validarSobrenomeUser(sobrenome);
									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							}

							// Setor
							String setor = "";
							while (true) {
								System.out.print("Setor: ");
								setor = sc.nextLine();
								try {
									CadastrarUser.validarSetorUser(setor);
									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							}

							// Email
							String email = "";
							while (true) {
								System.out.print("Email: ");
								email = sc.nextLine();
								try {
									CadastrarUser.validarEmailUser(email, nome, sobrenome);
									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							}

							// Telefone
							String telefone = "";
							while (true) {
								System.out.print("Telefone: ");
								telefone = sc.nextLine();
								try {
									CadastrarUser.validarTelefoneUser(telefone);
									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							}

							System.out.println("----------------------");

							// Cria o user
							u = new CadastrarUser(nome, sobrenome, setor, email, telefone);
							opc = u.ExibirUser();

							// Valida se os dados estão corretos
							if (opc == 1) {
								users.add(u);
							}

						} while (opc != 1);

						Main.limparTela();
						break;
					}
					case 2: {
						int opc = 0;
						CadastrarTecnicos t = null;

						do {
							System.out.println("----------------------");
							System.out.println("CADASTRAR TECNICOS:");
							System.out.println("----------------------");

							// Nome
							String nome = "";
							while (true) {
								System.out.print("Nome: ");
								nome = sc.nextLine();
								try {
									CadastrarTecnicos.validarNomeTecnico(nome);
									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							}

							// Sobrenome
							String sobrenome = "";
							while (true) {
								System.out.print("Sobrenome: ");
								sobrenome = sc.nextLine();
								try {
									CadastrarTecnicos.validarSobrenomeTecnico(sobrenome);
									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							}

							// Email
							String email = "";
							while (true) {
								System.out.print("Email: ");
								email = sc.nextLine();
								try {
									CadastrarTecnicos.validarEmailTecnico(email, nome, sobrenome);
									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							}

							// Telefone
							String telefone = "";
							while (true) {
								System.out.print("Telefone: ");
								telefone = sc.nextLine();
								try {
									CadastrarTecnicos.validarTelefoneTecnico(telefone);
									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							}

							System.out.println("----------------------");

							// Cria o user
							t = new CadastrarTecnicos(nome, sobrenome, email, telefone);
							opc = t.ExibirTecnicos();

							// Valida se os dados estão corretos
							if (opc == 1) {
								tecnicos.add(t);
							}

						} while (opc != 1);

						Main.limparTela();
						break;
					}
					case 0: {
						System.out.println("----------------------");
						System.out.println("RETORNANDO AO MENU...");
						Main.retornarMenu();
						System.out.println("----------------------");
					}
					default:
						System.out.println("----------------------");
						System.out.println("OPÇÃO INVALIDA !!");
						System.out.println("----------------------");
					}

				} while (opcAdmin != 0);

			} else {
				tentativas--;
				if (tentativas == 0) {
					System.out.println("ACESSO NEGADO!");
				} else {
					System.out.println("OS DADOS DE LOGIN ESTÃO ERRADOS. VOCE TEM : " + tentativas + " RESTANTES");
				}
			}
		}
	}
}