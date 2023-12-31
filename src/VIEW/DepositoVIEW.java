/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VIEW;

import DAO.PessoaFisicaDAO;
import DTO.PessoaFisicaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author thiag
 */
public class DepositoVIEW extends javax.swing.JInternalFrame {

    /**
     * Creates new form DepositoVIEW
     */
    public DepositoVIEW() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnDepositar = new javax.swing.JButton();

        setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Valor do depósito:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("CPF:");

        btnDepositar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDepositar.setText("Depositar");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDepositar)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
      
            try {
            /* Criando as variaveis para quando os dados for digitados nos campos,
            serem armazenadas nelas
                */
            String cpf_titular, valorDepositado;
            cpf_titular =  txtCpf.getText();
            valorDepositado = txtValor.getText();
           
            
            // instanciando a classe PessoaFisicaDTO para usar a variavel cpf_titular
            PessoaFisicaDTO cadastradto = new PessoaFisicaDTO();
            cadastradto.setCpf_titular(cpf_titular);
            // instanciando a classe pessoaFisicaDAO para usar os metodos verificarSaldo.
            PessoaFisicaDAO objfdao = new PessoaFisicaDAO();
            
            
            if(objfdao.verficarCpf(cadastradto)){
               /* puxando com a váriavel objfdao o metodo verificaSaldo, assim se obtiver retorno,
                 os dados será armazenado na váriavel saldoAtual 
               */
               
               String saldoAtual = objfdao.verificarSaldoParaDeposito(cadastradto);
               
               /* 
               Se o saldo atual na tabela já tiver algum dados (!= null), ele somará,
               o depósito novo com o que já está lá.
               */
               if(saldoAtual != null){
                // Converta o saldo atual e o valor depositado em numeros
                double saldoDouble = Double.parseDouble(saldoAtual);
                double valorDouble = Double.parseDouble(valorDepositado);
                
                // Calculando o valor do novo deposito com o que já está na tabela
                double novoSaldo = valorDouble + saldoDouble;
                String novoSaldoString = String.valueOf(novoSaldo);
                // Atualiza o saldo no objeto cadastradto
                cadastradto.setSaldo(novoSaldoString);
                // Atualiza o saldo no banco de dados
                objfdao.Depositar(cadastradto);
                JOptionPane.showMessageDialog(null, "Deposito de " + "R$" + valorDepositado + " feito");
            }
           
           } 
            /* puxando com a váriavel objfdao o metodo verificaSaldo, assim se obtiver retorno,
                 os dados será armazenado na váriavel saldoAtual 
               */
           if(objfdao.verficarCpf(cadastradto)){
                String primeiroDeposito = objfdao.verificarSaldoParaDeposito(cadastradto);
                /* 
               Se o primeiroDeposito na tabela estiver nenhum dado(== null),
               ele irá fazer o primeiro depósito
               */
                if(primeiroDeposito == null){
                 // o objeto cadastradto está puxando da classe PessoaFisicaDTO a váriavel saldo
                cadastradto.setSaldo(valorDepositado);
                // o objeto está objfdao está puxando o metodo deposita da classe PessoaFisicaDAO
                objfdao.Depositar(cadastradto);
                JOptionPane.showMessageDialog(null, "Deposito de R$" + valorDepositado + " feito");   
                }         
               
            // Cai aqui caso o Cpf não for encontrado
            }else {
                JOptionPane.showMessageDialog(null, "Cpf não registrado");
              }
           // Cai aqui caso a conexão não for executada por algum erro dentro desse metodo
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BtnDepositar " + e);
        }
             
            
            
            
       
        
       
       
        
        
        
        
       
       
    }//GEN-LAST:event_btnDepositarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepositar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
