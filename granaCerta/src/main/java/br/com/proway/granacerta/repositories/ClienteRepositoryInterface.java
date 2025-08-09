/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.proway.granacerta.repositories;

import br.com.proway.granacerta.bean.Cliente;
import br.com.proway.granacerta.bean.Conta;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Master
 */
public interface ClienteRepositoryInterface {

    void adicionar(Cliente cliente) throws SQLException;
    List<Cliente> obterTodos() throws SQLException;
    Cliente obterPorId(int id) throws SQLException;
    void editar(Cliente cliente) throws SQLException;
    void apagar(int id) throws SQLException;

}

