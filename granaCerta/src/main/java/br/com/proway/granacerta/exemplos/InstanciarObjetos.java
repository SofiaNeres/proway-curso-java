/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.proway.granacerta.exemplos;

import br.com.proway.granacerta.bean.Proprietário;
import javax.swing.JOptionPane;

/**
 *
 * @author Master
 */
public class InstanciarObjetos {
    public static void main(String[] args) {
        //Instanciando um objeto chamado "joão" da classe Proprietário
        Proprietário joao = new Proprietário();
        //Definindo valor para os atributos do objeto joao
        joao.nome = "João";
        joao.email = "joao@gmail.com";
        joao.id = 73;
        joao.cpf = "456.291.200-10";
        joao.senha = "123";
        
        //Instanciando um objeto chamado "maria" da classe Proprietário
        Proprietário maria = new Proprietário();
        //Definindo valor para os atributos do objeto joao
        maria.nome = "Maria da Silva";
        maria.email = "maria@gmail.com";
        maria.id = 74;
        maria.cpf = "123.456.789-10";
        maria.senha = "1234";
        
        //Alterar nome Joao
        joao.nome = "Joao Souza";
        
        JOptionPane.showMessageDialog(null,
                "id: " + joao.id +
                "\nNome: " + joao.nome +
                "\nCPF: " + joao.cpf +
                "\nEmail: " + joao.email +
                "\n\nId: " + maria.id +
                "\nNome: " + maria.nome +
                "\nCPF: " + maria.cpf +
                "\nEmail: " + maria.email); 
        
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
