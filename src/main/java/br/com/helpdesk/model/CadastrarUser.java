package br.com.helpdesk.model;
import java.util.Scanner;

public class CadastrarUser {
    String nomeUser;
    String setorUser;
    String emailUser;
    String telefoneUser;
    private Scanner sc;
    
    // Construtor
    public CadastrarUser(String... dados) {
        this.nomeUser = dados[0];
        this.setorUser = dados[1];
        this.emailUser = dados[2];
        this.telefoneUser = dados[3];
    }

    // Metodos
    public int ExibirUser() {
    	sc = new Scanner(System.in);
    	int resposta;
    	System.out.println("----------------------");
        System.out.println("INFORMAÇÕES CORRETAS?");
        System.out.println("Nome: " + nomeUser);
        System.out.println("Setor: " + setorUser);
        System.out.println("Email: " + emailUser);
        System.out.println("Telefone: " + telefoneUser);
        System.out.println("1. SIM");
        System.out.println("2. NAO");
        System.out.println("----------------------");
        
        resposta = sc.nextInt();
        return resposta;
    }
}