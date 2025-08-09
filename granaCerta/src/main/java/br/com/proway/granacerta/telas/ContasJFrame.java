/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.proway.granacerta.telas;

import br.com.proway.granacerta.bancoDados.BancoDadosUtil;
import br.com.proway.granacerta.bean.Conta;
import br.com.proway.granacerta.repositories.ContaRepository;
import br.com.proway.granacerta.repositories.ContaRepositoryInterfaceJava;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Constutor é chamado quando ocorre um new da classe, exemplo:
 * newContasJFrame();
 */
public class ContasJFrame extends javax.swing.JFrame {

    private final DefaultTableModel modeloTabela;
    private int idEditar;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ContasJFrame.class.getName());

    public ContasJFrame() {
        initComponents();
        //Pegar o modelo do jTable das contas fazendo um
        // cast para DefaulTableModel
        modeloTabela = (DefaultTableModel) jTableContas.getModel();
        //idEditar começa com -1 pq é o metodo de cadastro
        idEditar = -1;
        consultarContas();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipo = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContas = new javax.swing.JTable();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelTipo = new javax.swing.JLabel();
        jRadioButtonTipoCorrente = new javax.swing.JRadioButton();
        jRadioButtonTipoPoupanca = new javax.swing.JRadioButton();
        jLabelSaldo = new javax.swing.JLabel();
        jFormattedTextFieldSaldo = new javax.swing.JFormattedTextField();
        jLabelDescricao = new javax.swing.JLabel();
        jScrollPaneDescricao = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jButtonEditar = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Tipo", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableContas);
        if (jTableContas.getColumnModel().getColumnCount() > 0) {
            jTableContas.getColumnModel().getColumn(0).setResizable(false);
            jTableContas.getColumnModel().getColumn(1).setResizable(false);
            jTableContas.getColumnModel().getColumn(2).setResizable(false);
            jTableContas.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabelNome.setText("Nome");

        jLabelTipo.setText("Tipo");

        buttonGroupTipo.add(jRadioButtonTipoCorrente);
        jRadioButtonTipoCorrente.setText("Corrente");

        buttonGroupTipo.add(jRadioButtonTipoPoupanca);
        jRadioButtonTipoPoupanca.setText("Poupança");

        jLabelSaldo.setText("Saldo");

        jFormattedTextFieldSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldSaldoActionPerformed(evt);
            }
        });

        jLabelDescricao.setText("Descrição");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPaneDescricao.setViewportView(jTextAreaDescricao);

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

        jButtonCancelar.setText("Cancelar");

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonTipoCorrente)
                        .addGap(6, 6, 6)
                        .addComponent(jRadioButtonTipoPoupanca))
                    .addComponent(jLabelSaldo)
                    .addComponent(jFormattedTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescricao)
                    .addComponent(jScrollPaneDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButtonCancelar)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonCadastrar)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButtonEditar)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonApagar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelTipo)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonTipoCorrente)
                            .addComponent(jRadioButtonTipoPoupanca))
                        .addGap(6, 6, 6)
                        .addComponent(jLabelSaldo)
                        .addGap(6, 6, 6)
                        .addComponent(jFormattedTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelDescricao)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPaneDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonCadastrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonApagar))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldSaldoActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        String nome = jTextFieldNome.getText();
        double saldo = Double.parseDouble(jFormattedTextFieldSaldo.getText().replace(",", "."));
        String descricao = jTextAreaDescricao.getText();
        int tipoSelecionado;
        if (jRadioButtonTipoPoupanca.isSelected()) {
            tipoSelecionado = 0;
        } else {
            tipoSelecionado = 1;
        }

        Conta conta = new Conta();
        conta.setNome(nome);
        conta.setTipo(tipoSelecionado);
        conta.setDescricao(descricao);
        conta.setSaldo(saldo);

        if (idEditar == -1) {
            cadastrarConta(conta);
        } else {
            conta.setId(idEditar);
            editarConta(conta);
        }

        //comando q sera executado no nosso banco de dados
        cadastrarConta(nome, tipoSelecionado, saldo, descricao);
    }//GEN-LAST:event_jButtonCadastrarActionPerformed


    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed

        int indiceLinhaSelecionada = jTableContas.getSelectedRow();
        idEditar = Integer.parseInt(modeloTabela.getValueAt(indiceLinhaSelecionada, 0).toString());

        try {
            ContaRepositoryInterfaceJava repositorio = new ContaRepository();
            repositorio.apagar(idEditar);

            JOptionPane.showMessageDialog(null, "Conta Apagada com sucesso");
            consultarContas();
            idEditar = -1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel apagar a conta");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonApagarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        String sql = "SELECT nome, saldo, tipo, descricao FROM contas WHERE id = ?";

        int indiceLinhaSelecionada = jTableContas.getSelectedRow();
        idEditar = Integer.parseInt(modeloTabela.getValueAt(indiceLinhaSelecionada, 0).toString());

        try {
            ContaRepositoryInterfaceJava repository = new ContaRepository();
            Conta conta = repository.obterPorId(idEditar);

            jTextFieldNome.setText(conta.getNome());
            jFormattedTextFieldSaldo.setText(String.valueOf(conta.getSaldo()).replace(".", ","));
            jTextAreaDescricao.setText(conta.getDescricao());
            if (conta.getTipo() == 0) {
                jRadioButtonTipoPoupanca.setSelected(true);

            } else {
                jRadioButtonTipoCorrente.setSelected(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar a conta");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed
    //METODO SEM RETORNO
    private void limparCampos() {
        jTextFieldNome.setText("");
        jTextAreaDescricao.setText("");
        buttonGroupTipo.clearSelection();
        jFormattedTextFieldSaldo.setText("");
        idEditar = -1;
    }

    private void consultarContas() {
        modeloTabela.setRowCount(0);
        try {
            ContaRepositoryInterfaceJava repositorio = new ContaRepository();
            List<Conta> contas = repositorio.obterTodos();

            for (Conta conta : contas){
                modeloTabela.addRow(new Object[]{
                    conta.getId(),
                    conta.getNome(),
                    conta.getTipo(),
                    conta.getSaldo()
                });           
            }

            }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar as contas");
        }
        }

    

    private void cadastrarConta(Conta conta) {
        try {
            ContaRepositoryInterfaceJava repositorio = new ContaRepository();
            repositorio.adicionar(conta);

            JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso");
            limparCampos();
            consultarContas();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar a conta");
            e.printStackTrace();
        }
    }

    private void editarConta(Conta conta) {

        try {
            ContaRepositoryInterfaceJava repositorio = new ContaRepository();
            repositorio.editar(conta);

            limparCampos();
            consultarContas();
            JOptionPane.showMessageDialog(null, "Conta alterada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a conta");
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JFormattedTextField jFormattedTextFieldSaldo;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JRadioButton jRadioButtonTipoCorrente;
    private javax.swing.JRadioButton jRadioButtonTipoPoupanca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneDescricao;
    private javax.swing.JTable jTableContas;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

    private void cadastrarConta(String nome, int tipoSelecionado, double saldo, String descricao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
