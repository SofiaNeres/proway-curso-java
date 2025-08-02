/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.proway.granacerta.repositories;

import br.com.proway.granacerta.bancoDados.BancoDadosUtil;
import br.com.proway.granacerta.bean.Conta;
import br.com.proway.granacerta.telas.PreparadorDeSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ContaRepository implements ContaRepositoryInterfaceJava {

    @Override
    public void adicionar(Conta conta) throws SQLException {
        String sql = "INSERT INTO contas (nome, tipo, saldo, descricao) VALUES (?, ?, ?, ?)";
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            PreparedStatement preparadorDeSQL = conexao.prepareStatement(sql);
            preparadorDeSQL.setString(1, conta.getNome());
            preparadorDeSQL.setInt(2, conta.getTipo());
            preparadorDeSQL.setDouble(3, conta.getSaldo());
            preparadorDeSQL.setString(4, conta.getDescricao());
            preparadorDeSQL.execute();
            JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso");
        }
    }

    @Override
    public List<Conta> obterTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public conta obterPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Conta conta)throws SQLException {
        String sql = "UPDATE contas SET nome = ?, tipo = ?, saldo = ?, descricao = ? WHERE id = ?";
        try (Connection conexao = BancoDadosUtil.getConnection()){
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, conta.getNome());
            preparadorSQL.setInt(2, conta.getTipo());
            preparadorSQL.setDouble(3, conta.getSaldo());
            preparadorSQL.setString(4, conta.getDescricao());
            preparadorSQL.setInt(5, conta.getId());
            preparadorSQL.execute();      
        }
    }

    @Override
    public void apagar(int id)throws SQLException {
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            //comando q sera executado no banco de dados
            String sql = "DELETE FROM contas WHERE id = ?";
            PreparedStatement preparadorDeSQL = conexao.prepareStatement(sql);
            preparadorDeSQL.setInt(1, idEditar);
            preparadorDeSQL.execute();
        }
    }
// Create, READ, Update, DELETE
    //adicionar
    //consultarTodos
    //consultarPorId
    //editar
    //apagar
    
//  CRUD;;
}
