package br.com.helpdesk.model;

public class CadastrarUser {
    String nomeUser;
    String setorUser;
    String emailUser;
    String telefoneUser;

    public CadastrarUser(String... dados) {
        this.nomeUser = dados[0];
        this.setorUser = dados[1];
        this.emailUser = dados[2];
        this.telefoneUser = dados[3];
    }

    public void Exibir() {
        System.out.println("INFORMAÇÕES CORRETAS?");
        System.out.println("Nome: " + nomeUser);
        System.out.println("Setor: " + setorUser);
        System.out.println("Email: " + emailUser);
        System.out.println("Telefone: " + telefoneUser);
    }
}