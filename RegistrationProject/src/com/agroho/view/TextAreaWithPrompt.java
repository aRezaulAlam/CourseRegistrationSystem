package com.agroho.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.FocusManager;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaWithPrompt extends JTextArea{

@Override
protected void paintComponent(java.awt.Graphics g) {
    super.paintComponent(g);

    if(getText().isEmpty() && ! (FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)){
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setBackground(Color.gray);
        g2.setFont(getFont().deriveFont(Font.PLAIN));
        g2.drawString( "separated by commas"
        		, 5, 10); //figure out x, y from font's FontMetrics and size of component.
        g2.dispose();
    }
  }
}