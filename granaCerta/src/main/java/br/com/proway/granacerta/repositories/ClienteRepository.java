/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.proway.granacerta.repositories;

import br.com.proway.granacerta.bancoDados.BancoDadosUtil;
import br.com.proway.granacerta.bean.Cliente;
import br.com.proway.granacerta.bean.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Master
 */
public class ClienteRepository implements ClienteRepositoryInterface {

    @Override
    public void adicionar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, cnpj) VALUES (?, ?)";
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            PreparedStatement preparadorDeSQL = conexao.prepareStatement(sql);
            preparadorDeSQL.setString(1, cliente.getNome());
            preparadorDeSQL.setString(2, cliente.getCnpj());
            preparadorDeSQL.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
        }
    }

    @Override
    public List<Cliente> obterTodos() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            String sql = "SELECT id, nome, cnpj FROM clientes;";
            Statement executorSql = conexao.createStatement();
            executorSql.execute(sql);
            ResultSet registros = executorSql.getResultSet();

            while (registros.next()) {
                int id = registros.getInt("id");
                String nome = registros.getString("nome");
                String cnpj = registros.getString("cnpj");

                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCnpj(cnpj);

                clientes.add(cliente);
            }
        }
        return clientes;
    }

    @Override
    public Cliente obterPorId(int id) throws SQLException {
        String sql = "SELECT nome, cnpj FROM clientes WHERE id = ?";
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            PreparedStatement preparadorDeSQL = conexao.prepareStatement(sql);
            preparadorDeSQL.setInt(1, id);
            preparadorDeSQL.execute();
            ResultSet registros = preparadorDeSQL.getResultSet();
            if (registros.next()) {
                String nome = registros.getString("nome");
                String cnpj = registros.getString("cnpj");

                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCnpj(cnpj);
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void editar(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, cnpj = ? WHERE id = ?";
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, cliente.getNome());
            preparadorSQL.setString(2, cliente.getCnpj());
            preparadorSQL.setInt(3, cliente.getId());
            preparadorSQL.execute();
        }
    }

    @Override
    public void apagar(int id) throws SQLException {
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            String sql = "DELETE FROM clientes WHERE id = ?";
            PreparedStatement preparadorDeSQL = conexao.prepareStatement(sql);
            preparadorDeSQL.setInt(1, id);
            preparadorDeSQL.execute();
        }
    }
}
