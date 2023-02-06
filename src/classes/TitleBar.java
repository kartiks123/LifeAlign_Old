package classes;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel; // Used to fit text, image or both in a short space
import javax.swing.JPanel; // Used to fit components in a precise manner, in a GUI

public class TitleBar extends JPanel{

	TitleBar()
	{
		this.setPreferredSize(new Dimension(400,80));
		
		this.setBackground(Color.white);
		JLabel titleText = new JLabel("LifeAlign");
		titleText.setPreferredSize(new Dimension(200,80));
		titleText.setFont(new Font("Sans-serif",Font.BOLD, 30));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		this.add(titleText);
	}
}