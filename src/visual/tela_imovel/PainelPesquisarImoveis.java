package visual.tela_imovel;

import controle.Dados;
/*import controle.ImovelControl;*/
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import util.TabelaAbstrataImoveis;
import static visual.tela_principal.TelaPrincipalDoSistema.facade;

/**
 * @author Marcelo Henrique
 */
public class PainelPesquisarImoveis extends javax.swing.JPanel {

    public PainelPesquisarImoveis() {
        initComponents();
        mostrarTabelaDeImoveis();
    }
    
    public static void mostrarTabelaDeImoveis() {
        
        facade.listarImoveis();
        TabelaAbstrataImoveis tabelaAbstrataImoveis = new TabelaAbstrataImoveis(Dados.listaDeImoveis);
        tabelaImoveis.setModel(tabelaAbstrataImoveis);   
        
        tabelaImoveis.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if(isSelected){
                    setBackground(new Color(255, 204, 0));
                    setForeground(Color.WHITE); 
                }else{
                    setBackground(Color.WHITE);
                    setForeground(Color.BLACK); 
                }
                
                if(value.equals("Disponível")){
                    setBackground(new Color(204, 255, 204));
                    setForeground(new Color(0, 153, 51));    
                    if(isSelected){
                        setBackground(new Color(255, 204, 0));
                        setForeground(Color.WHITE); 
                    }
                }
                else if(value.equals("Indisponível")){
                    setBackground(new Color(255, 204, 204));
                    setForeground(new Color(204, 0, 0));   
                    if(isSelected){
                        setBackground(new Color(255, 204, 0));
                        setForeground(Color.WHITE); 
                    }
                }
                
                setHorizontalAlignment(CENTER);
                
                return this;
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
        tabelaImoveis = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        campoPesquisarImovel = new javax.swing.JTextField();
        campoPesquisaImovel2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(860, 520));
        setMinimumSize(new java.awt.Dimension(860, 520));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tabelaImoveis.setAutoCreateRowSorter(true);
        tabelaImoveis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabelaImoveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaImoveis.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaImoveis.setFocusable(false);
        tabelaImoveis.setGridColor(new java.awt.Color(204, 204, 204));
        tabelaImoveis.setRequestFocusEnabled(false);
        tabelaImoveis.setRowHeight(30);
        tabelaImoveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaImoveisMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaImoveis);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(860, 520));
        jPanel1.setMinimumSize(new java.awt.Dimension(860, 520));
        jPanel1.setPreferredSize(new java.awt.Dimension(860, 520));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoPesquisarImovel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoPesquisarImovel.setForeground(new java.awt.Color(255, 153, 51));
        campoPesquisarImovel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoPesquisarImovel.setToolTipText("");
        campoPesquisarImovel.setBorder(null);
        campoPesquisarImovel.setOpaque(false);
        campoPesquisarImovel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPesquisarImovelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoPesquisarImovelFocusLost(evt);
            }
        });
        campoPesquisarImovel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPesquisarImovelKeyReleased(evt);
            }
        });
        jPanel1.add(campoPesquisarImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 430, 30));

        campoPesquisaImovel2.setEditable(false);
        campoPesquisaImovel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoPesquisaImovel2.setForeground(new java.awt.Color(153, 153, 153));
        campoPesquisaImovel2.setText("Digite o nome do proprietário ou código do imóvel");
        campoPesquisaImovel2.setBorder(null);
        jPanel1.add(campoPesquisaImovel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 430, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/pesquisa_veiculos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
     private void personalizandoCampoUsuario(Color cor) {
        if (campoPesquisarImovel.getText().isEmpty()) {
            campoPesquisaImovel2.setVisible(true);
            campoPesquisaImovel2.setBackground(cor);
            campoPesquisarImovel.setOpaque(false);
        }
        if (!campoPesquisarImovel.getText().isEmpty()) {
            campoPesquisarImovel.setOpaque(true);
            campoPesquisarImovel.setBackground(cor);
            campoPesquisaImovel2.setVisible(false);
        }
    }
                  
    
    private void campoPesquisarImovelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisarImovelFocusGained
        personalizandoCampoUsuario(new Color(255, 255, 153)); 
    }//GEN-LAST:event_campoPesquisarImovelFocusGained

    private void campoPesquisarImovelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisarImovelFocusLost
        personalizandoCampoUsuario(new Color(255, 255, 255));
    }//GEN-LAST:event_campoPesquisarImovelFocusLost

    private void tabelaImoveisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaImoveisMouseReleased
        popularPainelEditarImovel();
    }//GEN-LAST:event_tabelaImoveisMouseReleased

    private void campoPesquisarImovelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarImovelKeyReleased
        personalizandoCampoUsuario(new Color(255, 255, 153));
        facade.pesquisarImovel(campoPesquisarImovel.getText());
    }//GEN-LAST:event_campoPesquisarImovelKeyReleased

    public static boolean estaDisponivel = false;
    public static boolean estaIndisponivel = false;
    public void popularPainelEditarImovel() {
        if (tabelaImoveis.getSelectedRow() != -1) {
            
            Dados.imovelEstaticoBean.setCodigo(Integer.parseInt(String.valueOf(tabelaImoveis.getValueAt(tabelaImoveis.getSelectedRow(), 0))));
            
            PainelEditarImoveis.campoEditarProprietarioDoImovel.setText((String)tabelaImoveis.getValueAt(tabelaImoveis.getSelectedRow(), 1));
            PainelEditarImoveis.campoEditarSelecaoTipoDoImovel.setSelectedItem( tabelaImoveis.getValueAt(tabelaImoveis.getSelectedRow(), 2));
            PainelEditarImoveis.campoEditarSelecaoFinalidadeDoImovel.setSelectedItem(tabelaImoveis.getValueAt(tabelaImoveis.getSelectedRow(), 3));
            
            String valorComRS = tabelaImoveis.getValueAt(tabelaImoveis.getSelectedRow(), 4).toString();
            String valorSemRS = valorComRS.replaceAll("R$", "");
            PainelEditarImoveis.campoEditarValorCobradoDoImovel.setText(valorSemRS.trim());
            
            PainelEditarImoveis.campoEditarSelecaoStatus.setSelectedItem(tabelaImoveis.getValueAt(tabelaImoveis.getSelectedRow(), 5));
            if(PainelEditarImoveis.campoEditarSelecaoStatus.getSelectedItem().equals("Disponível")){
                estaDisponivel = true;
            }else{
                estaDisponivel = false;
            }
            
            if(PainelEditarImoveis.campoEditarSelecaoStatus.getSelectedItem().equals("Indisponível")){
                estaIndisponivel = true;
            }else{
                estaIndisponivel = false;
            }
            
            Dados.imovelBeanSelecioneImovelVendaAlteracaoAnterior.setCodigo(Integer.parseInt(String.valueOf(tabelaImoveis.getValueAt(tabelaImoveis.getSelectedRow(), 0))));
            Dados.imovelBeanSelecioneImovelVendaAlteracaoAnterior.setTipo((String) tabelaImoveis.getValueAt(tabelaImoveis.getSelectedRow(), 2));

        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField campoPesquisaImovel2;
    public static javax.swing.JTextField campoPesquisarImovel;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabelaImoveis;
    // End of variables declaration//GEN-END:variables
}