/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.proway.granacerta.repositories;

import br.com.proway.granacerta.bean.Conta;
import java.sql.SQLException;
import java.util.List;

/*
Interface define metodos sem implementação, servindo como um contrato para as
 classes que a implementam. Ela permite a criação de códigos mais flexíveis e
reutilizáveis, promovendo a abstração.
*/
public interface ContaRepositoryInterfaceJava {
    // void adicionar (String nome, String tipo, double saldo, String descricao);
    
    void adicionar(Conta conta)throws SQLException;
    List <Conta> obterTodos()throws SQLException;
    Conta obterPorId(int id)throws SQLException;
    void editar (Conta conta)throws SQLException;
    void apagar(int id) throws SQLException;
    
}
