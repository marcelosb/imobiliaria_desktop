package visual.tela_login;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 * @author Marcelo Henrique
 */
public class TelaDeLogin extends javax.swing.JFrame {
    
    public TelaDeLogin() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTelaDeLogin = new javax.swing.JPanel();
        painelLogoDoSistema = new javax.swing.JPanel();
        botaoFecharMensagem = new javax.swing.JButton();
        textoErro = new javax.swing.JLabel();
        textoEsqueceuSenha = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();
        painelAcessoLogin = new javax.swing.JPanel();
        campoUsuario = new javax.swing.JTextField();
        campoUsuario2 = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        campoSenha2 = new javax.swing.JTextField();
        botaoLogin = new javax.swing.JButton();
        textoImagemUsuarioLogin = new javax.swing.JLabel();
        PainelSenhaEsqueceu = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        textoMensagemDeInformacao = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Area de Login");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/tela_de_login/icone_imobiliaria.png")).getImage()

        );
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        painelTelaDeLogin.setBackground(new java.awt.Color(0, 102, 102));
        painelTelaDeLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        painelLogoDoSistema.setBackground(new java.awt.Color(102, 153, 255));
        painelLogoDoSistema.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoFecharMensagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_de_login/botao_fechar.png"))); // NOI18N
        botaoFecharMensagem.setToolTipText("Fechar mensagem");
        botaoFecharMensagem.setBorder(null);
        botaoFecharMensagem.setBorderPainted(false);
        botaoFecharMensagem.setContentAreaFilled(false);
        botaoFecharMensagem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoFecharMensagem.setFocusable(false);
        botaoFecharMensagem.setPreferredSize(new java.awt.Dimension(30, 30));
        botaoFecharMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharMensagemActionPerformed(evt);
            }
        });
        painelLogoDoSistema.add(botaoFecharMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 30, 30));
        botaoFecharMensagem.setVisible(false);

        textoErro.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        textoErro.setForeground(new java.awt.Color(255, 255, 255));
        textoErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoErro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_de_login/logo.png"))); // NOI18N
        painelLogoDoSistema.add(textoErro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        textoEsqueceuSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textoEsqueceuSenha.setForeground(new java.awt.Color(255, 255, 255));
        textoEsqueceuSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoEsqueceuSenha.setText("Esqueceu a senha?");
        textoEsqueceuSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textoEsqueceuSenha.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                textoEsqueceuSenhaMouseMoved(evt);
            }
        });
        textoEsqueceuSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoEsqueceuSenhaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textoEsqueceuSenhaMouseExited(evt);
            }
        });

        painelPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        painelPrincipal.setLayout(new java.awt.CardLayout());

        painelAcessoLogin.setBackground(new java.awt.Color(51, 51, 51));
        painelAcessoLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoUsuario.setOpaque(false);
        campoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoUsuarioFocusLost(evt);
            }
        });
        campoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoUsuarioKeyReleased(evt);
            }
        });
        painelAcessoLogin.add(campoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 250, 40));

        campoUsuario2.setEditable(false);
        campoUsuario2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoUsuario2.setForeground(new java.awt.Color(153, 153, 153));
        campoUsuario2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoUsuario2.setText(" Usuário");
        painelAcessoLogin.add(campoUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 250, 40));

        campoSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoSenha.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoSenha.setToolTipText("");
        campoSenha.setOpaque(false);
        campoSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoSenhaFocusLost(evt);
            }
        });
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoSenhaKeyReleased(evt);
            }
        });
        painelAcessoLogin.add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 250, 40));

        campoSenha2.setEditable(false);
        campoSenha2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoSenha2.setForeground(new java.awt.Color(153, 153, 153));
        campoSenha2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoSenha2.setText(" Senha");
        campoSenha2.setToolTipText("");
        painelAcessoLogin.add(campoSenha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 250, 40));

        botaoLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botaoLogin.setForeground(new java.awt.Color(51, 51, 51));
        botaoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_de_login/botao_login_claro.png"))); // NOI18N
        botaoLogin.setBorder(null);
        botaoLogin.setBorderPainted(false);
        botaoLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoLogin.setFocusPainted(false);
        botaoLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_de_login/botao_login_escuro.png"))); // NOI18N
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });
        painelAcessoLogin.add(botaoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        textoImagemUsuarioLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoImagemUsuarioLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_de_login/usuario_de_login_novo.png"))); // NOI18N
        textoImagemUsuarioLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoImagemUsuarioLoginMouseClicked(evt);
            }
        });
        painelAcessoLogin.add(textoImagemUsuarioLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 23, -1, -1));

        painelPrincipal.add(painelAcessoLogin, "login");

        PainelSenhaEsqueceu.setBackground(new java.awt.Color(255, 255, 255));

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        textoMensagemDeInformacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_de_login/mensagem_de_informacao.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoMensagemDeInformacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoMensagemDeInformacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("RECUPERAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtSenha.setBackground(new java.awt.Color(255, 255, 204));
        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Digite seu E-mail:");

        javax.swing.GroupLayout PainelSenhaEsqueceuLayout = new javax.swing.GroupLayout(PainelSenhaEsqueceu);
        PainelSenhaEsqueceu.setLayout(PainelSenhaEsqueceuLayout);
        PainelSenhaEsqueceuLayout.setHorizontalGroup(
            PainelSenhaEsqueceuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelSenhaEsqueceuLayout.createSequentialGroup()
                .addGroup(PainelSenhaEsqueceuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PainelSenhaEsqueceuLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(PainelSenhaEsqueceuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelSenhaEsqueceuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PainelSenhaEsqueceuLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PainelSenhaEsqueceuLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PainelSenhaEsqueceuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );
        PainelSenhaEsqueceuLayout.setVerticalGroup(
            PainelSenhaEsqueceuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelSenhaEsqueceuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelPrincipal.add(PainelSenhaEsqueceu, "esqueceu_senha");

        javax.swing.GroupLayout painelTelaDeLoginLayout = new javax.swing.GroupLayout(painelTelaDeLogin);
        painelTelaDeLogin.setLayout(painelTelaDeLoginLayout);
        painelTelaDeLoginLayout.setHorizontalGroup(
            painelTelaDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaDeLoginLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addGroup(painelTelaDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTelaDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelLogoDoSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelTelaDeLoginLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(textoEsqueceuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        painelTelaDeLoginLayout.setVerticalGroup(
            painelTelaDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaDeLoginLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(painelLogoDoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textoEsqueceuSenha)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaDeLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaDeLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        painelTelaDeLogin.setBorder(new ImagemDeFundoTelaLogin());

        setSize(new java.awt.Dimension(866, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void personalizandoCampoUsuario(Color cor) {
        if (campoUsuario.getText().isEmpty()) {
            campoUsuario2.setVisible(true);
            campoUsuario2.setBackground(cor);
            campoUsuario.setOpaque(false);
        }
        if (!campoUsuario.getText().isEmpty()) {
            campoUsuario.setOpaque(true);
            campoUsuario.setBackground(cor);
            campoUsuario2.setVisible(false);
        }
    }
    
    private void campoUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoUsuarioFocusGained
        personalizandoCampoUsuario(new Color(255, 255, 153));
    }//GEN-LAST:event_campoUsuarioFocusGained

    private void campoUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoUsuarioFocusLost
        personalizandoCampoUsuario(new Color(255, 255, 255));
    }//GEN-LAST:event_campoUsuarioFocusLost

    private void campoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoUsuarioKeyPressed
        
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            campoSenha.requestFocus();
        }
    }//GEN-LAST:event_campoUsuarioKeyPressed
    
    
    
    private void personalizandoCampoSenha(Color cor) {
        if (String.valueOf(campoSenha.getPassword()).isEmpty()) {
            campoSenha2.setVisible(true);
            campoSenha2.setBackground(cor);
            campoSenha.setOpaque(false);
        }
        if (!String.valueOf(campoSenha.getPassword()).isEmpty()) {
            campoSenha.setOpaque(true);
            campoSenha.setBackground(cor);
            campoSenha2.setVisible(false);
        }
    }
    
    private void campoSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoSenhaFocusGained
        personalizandoCampoSenha(new Color(255, 255, 153));
    }//GEN-LAST:event_campoSenhaFocusGained

    private void campoSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoSenhaFocusLost
        personalizandoCampoSenha(new Color(255, 255, 255));        
    }//GEN-LAST:event_campoSenhaFocusLost

    private void campoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            efetuarLogin();
        }
    }//GEN-LAST:event_campoSenhaKeyPressed

    private void textoEsqueceuSenhaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoEsqueceuSenhaMouseMoved
        textoEsqueceuSenha.setForeground(Color.CYAN);
    }//GEN-LAST:event_textoEsqueceuSenhaMouseMoved

    private void textoEsqueceuSenhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoEsqueceuSenhaMouseExited
        textoEsqueceuSenha.setForeground(Color.WHITE);
    }//GEN-LAST:event_textoEsqueceuSenhaMouseExited

    private void campoUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoUsuarioKeyReleased
        
        personalizandoCampoUsuario(new Color(255, 255, 153));        
    }//GEN-LAST:event_campoUsuarioKeyReleased

    private void campoSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyReleased
        
        personalizandoCampoSenha(new Color(255, 255, 153));        
    }//GEN-LAST:event_campoSenhaKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        if (evt.getButton() == MouseEvent.BUTTON1) {
            painelTelaDeLogin.requestFocus();
        }
    }//GEN-LAST:event_formMouseClicked

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        efetuarLogin();
    }//GEN-LAST:event_botaoLoginActionPerformed

    private void textoImagemUsuarioLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoImagemUsuarioLoginMouseClicked
        textoImagemUsuarioLogin.requestFocus();
    }//GEN-LAST:event_textoImagemUsuarioLoginMouseClicked

    private void textoEsqueceuSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoEsqueceuSenhaMouseClicked
        java.awt.CardLayout cartaoEsqueceuSenha = (java.awt.CardLayout) painelPrincipal.getLayout();
        cartaoEsqueceuSenha.show(painelPrincipal, "esqueceu_senha");
    }//GEN-LAST:event_textoEsqueceuSenhaMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        java.awt.CardLayout cartao = (java.awt.CardLayout) painelPrincipal.getLayout();
        cartao.show(painelPrincipal, "login");
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoFecharMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharMensagemActionPerformed
        textoErro.setIcon(new ImageIcon(getClass().getResource("/imagens/tela_de_login/logo.png")));
        botaoFecharMensagem.setVisible(false);
    }//GEN-LAST:event_botaoFecharMensagemActionPerformed
     
    public void efetuarLogin() {
        
        /**
        boolean verdade = false;
        if (campoUsuario.getText().isEmpty() && String.valueOf(campoSenha.getPassword()).isEmpty() ) {
            //Toolkit.getDefaultToolkit().beep();
            textoErro.setIcon(new ImageIcon(getClass().getResource("/imagens/tela_de_login/campos_vazios.png")));
            botaoFecharMensagem.setVisible(true);
            campoUsuario.requestFocus();
        } else if (campoUsuario.getText().isEmpty()) {
            textoErro.setIcon(new ImageIcon(getClass().getResource("/imagens/tela_de_login/campo_usuario_vazio.png")));
            botaoFecharMensagem.setVisible(true);
            campoUsuario.requestFocus();
        } else if (String.valueOf(campoSenha.getPassword()).isEmpty()) {
            textoErro.setIcon(new ImageIcon(getClass().getResource("/imagens/tela_de_login/campo_senha_vazio.png")));
            botaoFecharMensagem.setVisible(true);
            campoSenha.requestFocus();
        } else if (!campoUsuario.getText().isEmpty() && !String.valueOf(campoSenha.getPassword()).isEmpty()) {
            UsuarioControl.listarUsuarios();
            for (int i = 0; i < Dados.listaDeUsuarios.size(); i++) {
                
                
                
                if (campoUsuario.getText().equals(Dados.listaDeUsuarios.get(i).getUsuario()) && String.valueOf(campoSenha.getPassword()).equals(Dados.listaDeUsuarios.get(i).getSenha())) {
                    verdade = true;
                    Dados.codigo = Dados.listaDeUsuarios.get(i).getCodigo();
                    Dados.nome = Dados.listaDeUsuarios.get(i).getNome();
                    Dados.sobrenome = Dados.listaDeUsuarios.get(i).getSobrenome();
                    Dados.usuario = Dados.listaDeUsuarios.get(i).getUsuario();
                    Dados.senha = Dados.listaDeUsuarios.get(i).getSenha();
                    Dados.email = Dados.listaDeUsuarios.get(i).getEmail();
                    Dados.perfilUsuario = Dados.listaDeUsuarios.get(i).getPerfilUsuario();
                }
            }
            
            if (verdade == false) {
                textoErro.setIcon(new ImageIcon(getClass().getResource("/imagens/tela_de_login/campos_invalidos.png")));
                botaoFecharMensagem.setVisible(true);
            } else {
                dispose();
                new TelaPrincipalDoSistema().setVisible(true);                
            }
            
        }
        
        **/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        // Define o Look And Feel multi-plataforma (também chamado de "Metal")
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeLogin().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelSenhaEsqueceu;
    private javax.swing.JButton botaoFecharMensagem;
    private javax.swing.JButton botaoLogin;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoSenha2;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JTextField campoUsuario2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel painelAcessoLogin;
    private javax.swing.JPanel painelLogoDoSistema;
    private javax.swing.JPanel painelPrincipal;
    public static javax.swing.JPanel painelTelaDeLogin;
    private javax.swing.JLabel textoErro;
    private javax.swing.JLabel textoEsqueceuSenha;
    private javax.swing.JLabel textoImagemUsuarioLogin;
    private javax.swing.JLabel textoMensagemDeInformacao;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
