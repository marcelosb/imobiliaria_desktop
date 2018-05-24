package visual.tela_login;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 * @author Desconhecido
 */

public class ImagemDeFundoTelaLogin implements Border{
    public BufferedImage back;

    public ImagemDeFundoTelaLogin() {
         try{
            URL caminhoDaImagem = new URL(getClass().getResource("/imagens/tela_de_login/carro_tunado.jpg").toString());
            back = ImageIO.read(caminhoDaImagem);
        }catch(Exception erro){ }   
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, (x+(width-back.getWidth())/2), (y+(height-back.getHeight())/2), null);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
