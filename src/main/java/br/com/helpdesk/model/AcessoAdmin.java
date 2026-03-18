package br.com.helpdesk.model;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.helpdesk.view.Main;

public class AcessoAdmin {
    String adminUserName, adminPassword;
    String correctAdminUserName = "naughtuser", correctAdminPassword = "40028922";

    ArrayList<CadastrarUser> users = new ArrayList<>();
    ArrayList<CadastrarTecnicos> tecnicos = new ArrayList<>();

    public void loginAdmin(Scanner sc) {
        int tentativas = 3;
        sc.nextLine(); 


        while (tentativas > 0) {
            System.out.println("POR FAVOR, INSIRA OS DADOS DE LOGIN:");
            System.out.println("USER: ");
            adminUserName = sc.nextLine().toLowerCase();
            System.out.println("SENHA: ");
            adminPassword = sc.nextLine().toLowerCase();

            if (adminUserName.equals(correctAdminUserName) && adminPassword.equals(correctAdminPassword)) {
                System.out.println("ACESSO PERMITIDO!");
                Main.limparTela();

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
                    	do {
                    		System.out.println("----------------------");
                    		System.out.println("CADASTRAR USUARIO:");
                            System.out.print("Nome: ");
                            String nome = sc.nextLine();
                            System.out.print("Setor: ");
                            String setor = sc.nextLine();
                            System.out.print("Email: ");
                            String email = sc.nextLine();
                            System.out.print("Telefone: ");
                            String telefone = sc.nextLine();
                            System.out.println("----------------------");
                         
                            CadastrarUser u = new CadastrarUser(nome, setor, email, telefone);
                            opc = u.ExibirUser();
                          
                            if (opc == 1) {
                                users.add(u);
                            }
                            
                    	} while(opc != 1);
                    	
                    	Main.limparTela();
                        break;
                    }
                    case 2: {
                    	int opc;
						do {
							System.out.println("----------------------");
                            System.out.println("CADASTRAR TECNICO:");
                            System.out.print("Nome: ");
                            String nome = sc.nextLine();
                            System.out.print("Email: ");
                            String email = sc.nextLine();
                            System.out.print("Telefone: ");
                            String telefone = sc.nextLine();
                            System.out.println("----------------------");

                            CadastrarTecnicos t = new CadastrarTecnicos(nome, email, telefone);
                            opc = t.ExibirTecnicos();

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