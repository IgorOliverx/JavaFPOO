package com.example.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TelaDeLogin {

    public static void main(String[] args) {
        
    
    BufferedImage img = null;

    try{
        img = ImageIO.read(new File("img.png"));
    }catch(IOException e ){
        e.printStackTrace();
    }
    JLabel label = new JLabel();
    label.setText("Concessionaria");
    label.setText("teste");
    label.setFont(new Font("Calibri", Font.BOLD, 120));
    label.setForeground(Color.white);
    label.setHorizontalTextPosition(JLabel.CENTER);


    JFrame janela = new JFrame();
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setSize(1280, 720);

    Image dimg = img.getScaledInstance(janela.getWidth(), janela.getHeight(), Image.SCALE_SMOOTH);

    ImageIcon imageIcon = new ImageIcon(dimg);
    label.setIcon(imageIcon);


    }

}