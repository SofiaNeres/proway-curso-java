/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.proway.granacerta.exemplos;

import br.com.proway.granacerta.bean.Proprietario;
import javax.swing.JOptionPane;

/**
 *
 * @author Master
 */
public class InstanciarObjetos {
    public static void main(String[] args) {
        // Instanciando um objeto chamado "joao" da clsse Proprietario
        Proprietario joao = new Proprietario();
        // Definindo valor para os atributos do objeto jao
        joao.setNome("João");
        joao.setEmail("joao@gmail.com");
//        joao.id = 73;
        joao.setId(73);
        joao.setCPF("456.291.200-10");
        joao.setSenha("123");

        // Instnciando um objeto chamdo "maria" da classe Proprietario
        Proprietario maria = new Proprietario();
        maria.setId(74);
        maria.setEmail("maria@gmail.com");
        maria.setNome("Maria da Silva");
        maria.setSenha("1234");
        maria.setCPF("123.456.789.10");

        // Alterar o nome do joão
        joao.setNome("João Souza");

        JOptionPane.showMessageDialog(null,
                "Id: " + joao.getId()
                + "\nNome: " + joao.getNome()
                + "\nCPF: " + joao.getCPF()
                + "\nE-mail: " + joao.getEmail()
                + "\n\nId: " + maria.getId()
                + "\nNome: " + maria.getNome()
                + "\nCPF: " + maria.getCPF()
                + "\nE-mail: " + maria.getEmail()); 
        
        /*
        Criar classe Conta na package bean com os seguintes atributos:
        - id int, tipo String, nome String, saldo double
        Na classe InstanciarObjetos dentro do main, após o JOptionPane.showMessageDialog 
        Instanciar 3 objetos de Conta para os seguintes bancos e definir valor para os atributos (id, nome, tipo e saldo)
        - Objeto 1 criar como contaViacredi
        - Objeto 2 criar como contaItau
        - Objeto 3 criar como contaSantander

        Exemplo de tipos de Conta: Poupança, Salário
        */
    }
}
