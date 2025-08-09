/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.proway.granacerta.repositories;

import br.com.proway.granacerta.bancoDados.BancoDadosUtil;
import br.com.proway.granacerta.bean.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public List<Conta> obterTodos() throws SQLException {
        List<Conta> contas = new ArrayList<>();
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            String sql = "SELECT id, nome, saldo, tipo, descricao FROM contas;";
            Statement executorSql = conexao.createStatement();
            executorSql.execute(sql);
            ResultSet registros = executorSql.getResultSet();

            while (registros.next()) {
                int id = registros.getInt("id");
                String nome = registros.getString("nome");
                double saldo = registros.getDouble("saldo");
                int tipo = registros.getInt("tipo");

                Conta conta = new Conta();
                conta.setId(id);
                conta.setNome(nome);
                conta.setSaldo(saldo);
                conta.setTipo(tipo);

                contas.add(conta);

            }

        }
        return contas;
    }

    @Override
    public Conta obterPorId(int id) throws SQLException {
        String sql = "SELECT nome, saldo, tipo, descricao FROM contas WHERE id = ?";
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            PreparedStatement preparadorDeSQL = conexao.prepareStatement(sql);
            preparadorDeSQL.setInt(1, id);
            preparadorDeSQL.execute();
            ResultSet registros = preparadorDeSQL.getResultSet();
            if (registros.next()) {
                String nome = registros.getString("nome");
                double saldo = registros.getDouble("saldo");
                int tipo = registros.getInt("tipo");
                String descricao = registros.getString("descricao");

                Conta conta = new Conta();
                conta.setNome(nome);
                conta.setSaldo(saldo);
                conta.setTipo(tipo);
                conta.setDescricao(descricao);
                conta.setId(id);
                return conta;
            }
        }
        return null;
    }

    @Override
    public void editar(Conta conta) throws SQLException {
        String sql = "UPDATE contas SET nome = ?, tipo = ?, saldo = ?, descricao = ? WHERE id = ?";
        try (Connection conexao = BancoDadosUtil.getConnection()) {
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
    public void apagar(int id) throws SQLException {
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            //comando q sera executado no banco de dados
            String sql = "DELETE FROM contas WHERE id = ?";
            PreparedStatement preparadorDeSQL = conexao.prepareStatement(sql);
            preparadorDeSQL.setInt(1, id);
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
