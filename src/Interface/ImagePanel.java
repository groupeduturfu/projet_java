/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * source internet
 */
public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
 
    private Image img;
     
    public ImagePanel(Image img){
        this.img = img;
    }
     
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
