/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.proway.granacerta.telas;

import br.com.proway.granacerta.bancoDados.BancoDadosUtil;
import br.com.proway.granacerta.bean.Cliente;
import br.com.proway.granacerta.bean.Conta;
import br.com.proway.granacerta.repositories.ClienteRepository;
import br.com.proway.granacerta.repositories.ClienteRepositoryInterface;
import br.com.proway.granacerta.repositories.ContaRepository;
import br.com.proway.granacerta.repositories.ContaRepositoryInterfaceJava;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Master
 */
public class ClientesJFrame extends javax.swing.JFrame {

    private final DefaultTableModel modeloTabela;
    private final ClienteRepositoryInterface clienteRepo = new ClienteRepository();
    private Integer idClienteSelecionado = null;

    public ClientesJFrame() {
        initComponents();
        modeloTabela = (DefaultTableModel) jTableClientes.getModel();
        carregarClientes(); // Agora este método funciona
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelCNPJ = new javax.swing.JLabel();
        jFormattedTextFieldCNPJ = new javax.swing.JFormattedTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNome.setText("Nome");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabelCNPJ.setText("CNPJ");

        jFormattedTextFieldCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCNPJActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonApagar.setText("Apagar");
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "CNPJ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableClientes);
        if (jTableClientes.getColumnModel().getColumnCount() > 0) {
            jTableClientes.getColumnModel().getColumn(0).setResizable(false);
            jTableClientes.getColumnModel().getColumn(1).setResizable(false);
            jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCNPJ)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldNome))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonApagar)
                            .addComponent(jButtonEditar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCNPJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonSalvar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jFormattedTextFieldCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldCNPJActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        salvarCliente();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        editarCliente();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed
        apagarCliente();

    }//GEN-LAST:event_jButtonApagarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ClientesJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new ClientesJFrame().setVisible(true));
    }

    private void salvarCliente() {
        String nome = jTextFieldNome.getText().trim();
        String cnpj = jFormattedTextFieldCNPJ.getText().trim();

        if (nome.isEmpty() || cnpj.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setCnpj(cnpj);

            if (idClienteSelecionado == null) {
                clienteRepo.adicionar(cliente);
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                cliente.setId(idClienteSelecionado);
                clienteRepo.editar(cliente);
                JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            limparCampos();
            carregarClientes();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarCliente() {
        int linhaSelecionada = jTableClientes.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente na tabela para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        idClienteSelecionado = (Integer) modeloTabela.getValueAt(linhaSelecionada, 0);
        jTextFieldNome.setText((String) modeloTabela.getValueAt(linhaSelecionada, 1));
        jFormattedTextFieldCNPJ.setText((String) modeloTabela.getValueAt(linhaSelecionada, 2));
    }

    private void apagarCliente() {
        int linhaSelecionada = jTableClientes.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para apagar.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja apagar este cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int id = (Integer) modeloTabela.getValueAt(linhaSelecionada, 0);
                clienteRepo.apagar(id);
                carregarClientes();
                limparCampos();
                JOptionPane.showMessageDialog(this, "Cliente apagado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao apagar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limparCampos() {
        jTextFieldNome.setText("");
        jFormattedTextFieldCNPJ.setText("");
        idClienteSelecionado = null;
        jTableClientes.clearSelection();
        jTextFieldNome.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedTextFieldCNPJ;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables


    private void carregarClientes() {
        modeloTabela.setRowCount(0); // Limpa a tabela
        try {
            for (Cliente cliente : clienteRepo.obterTodos()) {
                modeloTabela.addRow(new Object[]{
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getCnpj()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
