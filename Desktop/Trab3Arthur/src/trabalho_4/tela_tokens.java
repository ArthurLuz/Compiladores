/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_4;

import javax.swing.table.DefaultTableModel;

import conversao_infixa_posfixa.Conversao_infixa_posfixa;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import trab3.converterToAFD;
import trabson2_comp.Automato;

/**
 *
 * @author CCSST
 */
public class tela_tokens extends javax.swing.JFrame {

    ArrayList<Character> posfixa = new ArrayList<Character>();
    String saida;
    Automato afn = new Automato();
    ArrayList<Afd> listaafd = new ArrayList<>();
    /**
     * Creates new form tela_tokens
     */
    public tela_tokens() {
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

        padrao = new javax.swing.JTextField();
        token = new javax.swing.JTextField();
        inserir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        remover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setResizable(false);

        padrao.setToolTipText("");
        padrao.setName(""); // NOI18N
        padrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                padraoActionPerformed(evt);
            }
        });

        token.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokenActionPerformed(evt);
            }
        });

        inserir.setText("Inserir");
        inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Padrão(Expressão Regular)", "Token"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        remover.setText("Remover");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        jLabel1.setText("Padrão(Expressão Regular)");

        jLabel2.setText("Token");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pósfixa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(padrao, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(token, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inserir, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(padrao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(token, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirActionPerformed
        // TODO add your handling code here:
        try{
        String auxiliar = "";
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        String texttable, textpadrao;
        texttable=token.getText();
        textpadrao = padrao.getText();
        if("".equals(texttable)||"".equals(textpadrao)) throw new RuntimeException();
       
        model.addRow(new String[]{""+model.getRowCount(), textpadrao, "<" + texttable + ">"});
        
        Conversao_infixa_posfixa a = new Conversao_infixa_posfixa(padrao.getText());
        
        try{
         auxiliar = a.Arrumar_o_Erro_do_usuario_burro();
            //System.out.println("Auxiliar: " + auxiliar);
        
        posfixa = a.Converte(auxiliar);
            //System.out.println("posfixa:" + posfixa.toString());
        
        saida = posfixa.toString();
        saida = saida.replace(", ", "");
        saida = saida.replace("[", "");
        saida = saida.replace("]", "");
        
        if("maior".equals(saida)||"menor".equals(saida)||"parents".equals(saida)||"fecho".equals(saida)){
            throw new IllegalArgumentException();
        }
        }catch(IllegalArgumentException er){
            switch( auxiliar ){
            case "maior":
                JOptionPane.showMessageDialog(null, "Falta fechar Parenteses","Alerta", 2);
                break;
            case "menor":case "parents":
                JOptionPane.showMessageDialog(null, "Falta abrir Parenteses","Alerta", 2);
                
                break;
            case "fecho": 
            JOptionPane.showMessageDialog(null, "Falta operandos para ' * '","Alerta", 2);
                break;
           
            }
        
        }
        System.out.println("saida: " + saida);
        
        Automato aut = new Automato(saida);
        afn = aut.er_para_afn(saida);
        
        String fecho;
        
        afn = afn.Set_Afn(afn);
        afn.set_Tabela(afn);
        fecho = afn.Fecho_E("q0");
        converterToAFD converter = new converterToAFD(fecho, afn, saida);
        
        converter.afntoafd();
        set_Afd(converter.estados.size(), converter.alfabeto.length()-1, converter.alfabeto, converter.matrizAFD(), token.getText());
        padrao.setText("");
        token.setText("");
        }catch(RuntimeException b){
            JOptionPane.showMessageDialog(null, "falta preencher campo","Alerta", 2);
        }
        
        
        //Analisar ana = new Analisar(padrao.getText().toString());
    }//GEN-LAST:event_inserirActionPerformed

    void set_Afd(int li, int col, String alfa, String[][] tabela, String toke){
        Afd afd = new Afd();
        afd.alfabeto = alfa;
        afd.token = toke;
        afd.linhas = li;
        afd.colunas = col;
        afd.Alocatable(li, col);
        afd.tableafd = tabela;
          for(int i = 0 ; i < li; i++){
                //afd[i][0] = estados.get(i);
                for(int k = 0; k < col; k++){
                    System.out.print(":" + afd.tableafd[i][k]);
                }
                System.out.print("\n");
            }
        listaafd.add(afd);
    }
    
    
    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        // TODO add your handling code here:
        try{
        listaafd.remove(tabela.getSelectedRow());
        ((DefaultTableModel) tabela.getModel()).removeRow(tabela.getSelectedRow());
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null,"Nada pra remover"," ", 1);
        }
//System.out.println("Row selecionado" + tabela.getSelectedRow());
    }//GEN-LAST:event_removerActionPerformed

    public ArrayList<Afd> getListaAfd(){
        return listaafd;
    }
    
    private void padraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_padraoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_padraoActionPerformed

    private void tokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tokenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tokenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{    
            int selRow = tabela.getSelectedRow();
        Object valor = tabela.getModel().getValueAt(selRow, 1);
        
        String s = valor.toString();
            System.out.println("sout  "+s);
        String j;
        Conversao_infixa_posfixa b = new Conversao_infixa_posfixa(s);
            j= b.Arrumar_o_Erro_do_usuario_burro();
            posfixa=b.Converte(j);
            s = posfixa.toString();
        s = s.replace(", ", "");
       s = s.replace("[", "");
        s= s.replace("]", "");
            JOptionPane.showMessageDialog(null,""+s,"Pósfixa ", 1);
        }catch(ArrayIndexOutOfBoundsException p){
            JOptionPane.showMessageDialog(null,"Selecione uma linha ","Alerta ", 1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tela_tokens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tela_tokens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tela_tokens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela_tokens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela_tokens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inserir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField padrao;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField token;
    // End of variables declaration//GEN-END:variables
}
