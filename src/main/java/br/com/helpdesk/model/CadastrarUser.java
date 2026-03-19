package br.com.helpdesk.model;

import java.util.Scanner;

public class CadastrarUser {
    private String nomeUser;
    private String sobrenomeUser;
    private String setorUser;
    private String emailUser;
    private String telefoneUser;
    private Scanner sc;

    // Construtor
    public CadastrarUser(String... dados) {
        this.setNomeUser(dados[0]);
        this.setSobrenomeUser(dados[1]);
        this.setSetorUser(dados[2]);
        this.setEmailUser(dados[3]);
        this.setTelefoneUser(dados[4]);
    }

    // Validações 
    public static void validarNomeUser(String nomeUser) {
        if (nomeUser == null || nomeUser.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar em branco.");
        }
        if (!nomeUser.matches("[a-zA-ZÀ-ú ]+")) {
            throw new IllegalArgumentException("Nome deve conter apenas letras.");
        }
    }

    public static void validarSobrenomeUser(String sobrenomeUser) {
        if (sobrenomeUser == null || sobrenomeUser.trim().isEmpty()) {
            throw new IllegalArgumentException("Sobrenome não pode estar em branco.");
        }
        if (!sobrenomeUser.matches("[a-zA-ZÀ-ú ]+")) {
            throw new IllegalArgumentException("Sobrenome deve conter apenas letras.");
        }
    }

    public static void validarSetorUser(String setorUser) {
        if (setorUser == null || setorUser.trim().isEmpty()) {
            throw new IllegalArgumentException("Setor não pode estar em branco.");
        }
        if (!setorUser.matches("[a-zA-ZÀ-ú ]+")) {
            throw new IllegalArgumentException("Setor deve conter apenas letras.");
        }
    }

    public static void validarEmailUser(String emailUser, String nomeUser, String sobrenomeUser) {
        if (emailUser == null || emailUser.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode estar em branco.");
        }
        if (!emailUser.contains(nomeUser.toLowerCase()) || !emailUser.contains(sobrenomeUser.toLowerCase())) {
            throw new IllegalArgumentException("Email deve conter seu nome e sobrenome.");
        }
        if (!emailUser.endsWith("@mirage.tech")) {
            throw new IllegalArgumentException("Domínio inválido. Use @mirage.tech");
        }
    }

    public static void validarTelefoneUser(String telefoneUser) {
        if (telefoneUser == null || telefoneUser.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode estar em branco.");
        }
        if (!telefoneUser.matches("\\\\d{2}\\ \\d{4,5}\\d{4}")) {
            throw new IllegalArgumentException("Telefone inválido. Use o formato (11) 99999-9999");
        }
    }

    // Futuras mudanças de nomes, sobrenome, telefone e etc
    public void setNomeUser(String nomeUser) {
        validarNomeUser(nomeUser);
        this.nomeUser = nomeUser;
    }

    public void setSobrenomeUser(String sobrenomeUser) {
        validarSobrenomeUser(sobrenomeUser);
        this.sobrenomeUser = sobrenomeUser;
    }

    public void setSetorUser(String setorUser) {
        validarSetorUser(setorUser);
        this.setorUser = setorUser;
    }

    public void setEmailUser(String emailUser) {
        validarEmailUser(emailUser, this.nomeUser, this.sobrenomeUser);
        this.emailUser = emailUser;
    }

    public void setTelefoneUser(String telefoneUser) {
        validarTelefoneUser(telefoneUser);
        this.telefoneUser = telefoneUser;
    }

    // Método
    public int ExibirUser() {
        int resposta;
        System.out.println("----------------------");
        System.out.println("INFORMAÇÕES CORRETAS?");
        System.out.println("Nome: " + nomeUser + " " + sobrenomeUser);
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