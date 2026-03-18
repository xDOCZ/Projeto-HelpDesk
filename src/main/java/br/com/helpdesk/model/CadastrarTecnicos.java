package br.com.helpdesk.model;
import java.util.Scanner;

public class CadastrarTecnicos {
	String nomeTecnico;
    String emailTecnico;
    String telefoneTecnico;
	private Scanner sc;

    // Construtor
    public CadastrarTecnicos(String... dados) {
        this.nomeTecnico = dados[0];
        this.emailTecnico = dados[1];
        this.telefoneTecnico = dados[2];
    }

    // Metodos
    public int ExibirTecnicos() {
    	sc = new Scanner(System.in);
    	int resposta;
    	System.out.println("----------------------");
        System.out.println("INFORMAÇÕES CORRETAS?");
        System.out.println("Email: " + emailTecnico);
        System.out.println("Telefone: " + telefoneTecnico);
        System.out.println("1. SIM");
        System.out.println("2. NAO");
        System.out.println("----------------------");
        
        resposta = sc.nextInt();
        return resposta;
    }
}
