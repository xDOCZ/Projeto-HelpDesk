package br.com.helpdesk.model;
import java.util.Scanner;

public class CadastrarTecnicos {
	private String nomeTecnico;
	private String sobrenomeTecnico;
	private String emailTecnico;
    private String telefoneTecnico;
	private Scanner sc;

	// Construtor
    public CadastrarTecnicos(String... dados) {
        this.setNomeTecnico(dados[0]);
        this.setSobrenomeTecnico(dados[1]);
        this.setEmailTecnico(dados[2]);
        this.setTelefoneTecnico(dados[3]);
    }

    // Validações 
    public static void validarNomeTecnico(String nomeTecnico) {
        if (nomeTecnico == null || nomeTecnico.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar em branco.");
        }
        if (!nomeTecnico.matches("[a-zA-ZÀ-ú ]+")) {
            throw new IllegalArgumentException("Nome deve conter apenas letras.");
        }
    }

    public static void validarSobrenomeTecnico(String sobrenomeTecnico) {
        if (sobrenomeTecnico == null || sobrenomeTecnico.trim().isEmpty()) {
            throw new IllegalArgumentException("Sobrenome não pode estar em branco.");
        }
        if (!sobrenomeTecnico.matches("[a-zA-ZÀ-ú ]+")) {
            throw new IllegalArgumentException("Sobrenome deve conter apenas letras.");
        }
    }

    public static void validarEmailTecnico(String emailTecnico, String nomeTecnico, String sobrenomeTecnico) {
        if (emailTecnico == null || emailTecnico.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode estar em branco.");
        }
        if (!emailTecnico.contains(nomeTecnico.toLowerCase()) || !emailTecnico.contains(sobrenomeTecnico.toLowerCase())) {
            throw new IllegalArgumentException("Email deve conter seu nome e sobrenome.");
        }
        if (!emailTecnico.endsWith("@mirage.tech")) {
            throw new IllegalArgumentException("Domínio inválido. Use @mirage.tech");
        }
    }

    public static void validarTelefoneTecnico(String telefoneTecnico) {
        if (telefoneTecnico == null || telefoneTecnico.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode estar em branco.");
        }
        if (!telefoneTecnico.matches("\\\\d{2}\\ \\d{4,5}\\d{4}")) {
            throw new IllegalArgumentException("Telefone inválido. Use o formato (11) 99999-9999");
        }
    }

    // Futuras mudanças de nomes, sobrenome, telefone e etc
    public void setNomeTecnico(String nomeTecnico) {
        validarNomeTecnico(nomeTecnico);
        this.nomeTecnico = nomeTecnico;
    }

    public void setSobrenomeTecnico(String sobrenomeTecnico) {
        validarSobrenomeTecnico(sobrenomeTecnico);
        this.sobrenomeTecnico = sobrenomeTecnico;
    }

    public void setEmailTecnico(String emailTecnico) {
        validarEmailTecnico(emailTecnico, this.nomeTecnico, this.sobrenomeTecnico);
        this.emailTecnico = emailTecnico;
    }

    public void setTelefoneTecnico(String telefoneTecnico) {
        validarTelefoneTecnico(telefoneTecnico);
        this.telefoneTecnico = telefoneTecnico;
    }

    // Método
    public int ExibirTecnicos() {
        int resposta;
        System.out.println("----------------------");
        System.out.println("INFORMAÇÕES CORRETAS?");
        System.out.println("Nome: " + nomeTecnico + " " + sobrenomeTecnico);
        System.out.println("Email: " + emailTecnico);
        System.out.println("Telefone: " + telefoneTecnico);
        System.out.println("1. SIM");
        System.out.println("2. NAO");
        System.out.println("----------------------");

        resposta = sc.nextInt();
        return resposta;
    }
    
	
}
