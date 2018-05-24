package visual.tela_vender_imovel;

import controle.Dados;
import controle.VenderImovelControl;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import util.TabelaAbstrataVenderImoveis;
import visual.tela_principal.TelaPrincipalDoSistema;
import static visual.tela_principal.TelaPrincipalDoSistema.botaoBuscarVendaDeImovel;
import static visual.tela_principal.TelaPrincipalDoSistema.facade;
import static visual.tela_vender_imovel.PainelEditarVenderImoveis.campoEditarValorNegociadoDaVendaEditar;

/**
 * @author Marcelo Henrique
 */
public class PainelPesquisarVenderImovel extends javax.swing.JPanel {

    public PainelPesquisarVenderImovel() {
        initComponents();
        mostrarTabelaVenderImovel();
    }

    public static void mostrarTabelaVenderImovel() {
        facade.listarVenderImoveis();
        
        tabelaVenderImoveis.setModel(new TabelaAbstrataVenderImoveis(Dados.listaVenderImoveis));
        
        tabelaVenderImoveis.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
      
            Component resultado = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (row % 2 == 0) {  
                    resultado.setBackground(new Color(0, 204, 204));
                    resultado.setForeground(Color.WHITE);
                    setHorizontalAlignment(CENTER);
                } else {
                    resultado.setBackground(Color.WHITE);
                    resultado.setForeground(Color.BLACK);
                    setHorizontalAlignment(CENTER);
                }

                if (isSelected) {
                    setBackground(new Color(255, 255, 153));
                    setForeground(Color.BLACK);
                }

                
                return resultado; 
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVenderImoveis = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        campoPesquisarVenderImovel = new javax.swing.JTextField();
        campoPesquisaCliente2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoVoltarVenderImovel = new javax.swing.JButton();

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(469, 419));

        tabelaVenderImoveis.setAutoCreateRowSorter(true);
        tabelaVenderImoveis.setBackground(new java.awt.Color(240, 240, 240));
        tabelaVenderImoveis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabelaVenderImoveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaVenderImoveis.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaVenderImoveis.setFocusable(false);
        tabelaVenderImoveis.setGridColor(new java.awt.Color(204, 204, 204));
        tabelaVenderImoveis.setPreferredSize(new java.awt.Dimension(1200, 480));
        tabelaVenderImoveis.setRequestFocusEnabled(false);
        tabelaVenderImoveis.setRowHeight(30);
        tabelaVenderImoveis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaVenderImoveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVenderImoveisMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaVenderImoveisMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVenderImoveis);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoPesquisarVenderImovel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoPesquisarVenderImovel.setForeground(new java.awt.Color(51, 51, 51));
        campoPesquisarVenderImovel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoPesquisarVenderImovel.setBorder(null);
        campoPesquisarVenderImovel.setOpaque(false);
        campoPesquisarVenderImovel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPesquisarVenderImovelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoPesquisarVenderImovelFocusLost(evt);
            }
        });
        campoPesquisarVenderImovel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPesquisarVenderImovelKeyReleased(evt);
            }
        });
        jPanel1.add(campoPesquisarVenderImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 430, 30));

        campoPesquisaCliente2.setEditable(false);
        campoPesquisaCliente2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoPesquisaCliente2.setForeground(new java.awt.Color(153, 153, 153));
        campoPesquisaCliente2.setText("Digite o nome do corretor ou o nome do cliente");
        campoPesquisaCliente2.setBorder(null);
        jPanel1.add(campoPesquisaCliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 430, 30));

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/pesquisa_veiculos.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, 53));

        botaoVoltarVenderImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_vender_imovel/botao_voltar_vender_imovel.png"))); // NOI18N
        botaoVoltarVenderImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoVoltarVenderImovel.setMaximumSize(new java.awt.Dimension(150, 40));
        botaoVoltarVenderImovel.setMinimumSize(new java.awt.Dimension(150, 40));
        botaoVoltarVenderImovel.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoVoltarVenderImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarVenderImovelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoVoltarVenderImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoVoltarVenderImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaVenderImoveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVenderImoveisMouseClicked
        
    }//GEN-LAST:event_tabelaVenderImoveisMouseClicked

    private void tabelaVenderImoveisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVenderImoveisMouseReleased

        //popularPainelEditar(); 
        popularPainelEditarVenderImoveis();
    }//GEN-LAST:event_tabelaVenderImoveisMouseReleased

    public static Double valorNegociadoAuxiliarEdit = 0.0;
    public void popularPainelEditarVenderImoveis() {
        
        if ((tabelaVenderImoveis.getSelectedRow() != -1)){
            
           Dados.venderImovelEstaticoBean.setCodigo(Integer.parseInt(String.valueOf(tabelaVenderImoveis.getValueAt(tabelaVenderImoveis.getSelectedRow(), 0))));

           String dataDaVenda  = tabelaVenderImoveis.getValueAt(tabelaVenderImoveis.getSelectedRow(), 1).toString();
           // Exemplo: 06/08/2016
           String [] vetorData = dataDaVenda.split("/");
           
           PainelEditarVenderImoveis.campoDiaDataDaVendaEditar.setText(vetorData[0]);
           PainelEditarVenderImoveis.campoMesDataDaVendaEditar.setText(vetorData[1]);
           PainelEditarVenderImoveis.campoAnoDataDaVendaEditar.setText(vetorData[2]);
           
           //PainelEditarVenderImoveis.campoEditarDataDaVendaVenderImovel.setText(String.valueOf(tabelaVenderImoveis.getValueAt(tabelaVenderImoveis.getSelectedRow(), 1)));
           PainelEditarVenderImoveis.campoSelecioneCorretorDaVendaEditar.setSelectedItem(String.valueOf(tabelaVenderImoveis.getValueAt(tabelaVenderImoveis.getSelectedRow(), 2)));
           PainelEditarVenderImoveis.campoEditarImovelVenderImovel.setText(String.valueOf(tabelaVenderImoveis.getValueAt(tabelaVenderImoveis.getSelectedRow(), 3)));
           PainelEditarVenderImoveis.campoSelecioneClienteDaCompraEditar.setSelectedItem(String.valueOf(tabelaVenderImoveis.getValueAt(tabelaVenderImoveis.getSelectedRow(), 4)));
           PainelEditarVenderImoveis.campoEditarValorNegociadoDaVendaEditar.setText(String.valueOf(tabelaVenderImoveis.getValueAt(tabelaVenderImoveis.getSelectedRow(), 5)));
           
           valorNegociadoAuxiliarEdit = Double.parseDouble(converteValorBRemEUAEditar(campoEditarValorNegociadoDaVendaEditar.getText().trim()));
           
        }
        
    }
    
    private String converteValorBRemEUAEditar(String valorEmBR){
        // esta assim R$ 80.000,90
        
        String removeRS = valorEmBR.replace("R$", "").trim();
        // fica assim 80.000,90
        
        String subistituiVirgulaPorPonto = removeRS.replace(',', 'a').trim();
        // fica assim 80.000a90
        
        String removePonto = subistituiVirgulaPorPonto.replace(".", "").trim();
         // fica assim 80000a90
          
        String fiaal = removePonto.replace('a', '.');
        // fica assim 80000.90
        
        String finall = fiaal;
        
        return finall;
    }
    
    private void personalizandoCampoUsuario(Color cor) {
        if (campoPesquisarVenderImovel.getText().isEmpty()) {
            campoPesquisaCliente2.setVisible(true);
            campoPesquisaCliente2.setBackground(cor);
            campoPesquisarVenderImovel.setOpaque(false);
        }
        if (!campoPesquisarVenderImovel.getText().isEmpty()) {
            campoPesquisarVenderImovel.setOpaque(true);
            campoPesquisarVenderImovel.setBackground(cor);
            campoPesquisaCliente2.setVisible(false);
        }
    }
                     
    
    private void campoPesquisarVenderImovelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarVenderImovelKeyReleased
        personalizandoCampoUsuario(new Color(255, 255, 153));
        facade.pesquisarVenderImovel(campoPesquisarVenderImovel.getText());
    }//GEN-LAST:event_campoPesquisarVenderImovelKeyReleased

    private void campoPesquisarVenderImovelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisarVenderImovelFocusGained
        personalizandoCampoUsuario(new Color(255, 255, 153));
        
    }//GEN-LAST:event_campoPesquisarVenderImovelFocusGained

    private void campoPesquisarVenderImovelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisarVenderImovelFocusLost
        personalizandoCampoUsuario(new Color(255, 255, 255));
        
    }//GEN-LAST:event_campoPesquisarVenderImovelFocusLost

    private void botaoVoltarVenderImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarVenderImovelActionPerformed
        botaoBuscarVendaDeImovel.setEnabled(true);
        
        TelaPrincipalDoSistema.exibirPainelVenderImovel();
        TelaPrincipalDoSistema.botaoEditarVenderImovel.setVisible(false);
        TelaPrincipalDoSistema.botaoExcluirVenderImovel.setVisible(false);
    }//GEN-LAST:event_botaoVoltarVenderImovelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton botaoVoltarVenderImovel;
    public static javax.swing.JTextField campoPesquisaCliente2;
    public static javax.swing.JTextField campoPesquisarVenderImovel;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabelaVenderImoveis;
    // End of variables declaration//GEN-END:variables
}