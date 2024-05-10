package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.*;


public class TimelinePanel extends JPanel {
	 private JLabel textLeft, textLeft1, titleLabel, textGrid, textGrid1;
	 private JPanel panel1, panel2, panel3, panel4, panel5;
	 private ImageIcon avatar;

	public TimelinePanel(GameFrame gameFrame) {
		super(new BorderLayout());
		TimelineGUI(gameFrame);
	}
	
	private void TimelineGUI(GameFrame gameFrame) {
		
		panel1 = gameFrame.getPanel1();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		
		String userName = gameFrame.getUsername();
		
		avatar = SavedAvatar.getSelectedAvatar();
		
		titleLabel = new JLabel("Choose A Timeline");
		textLeft = new JLabel("Hero " + userName);
		textLeft1 = new JLabel(avatar);
		textGrid = new JLabel("Story:");
		textGrid1 = new JLabel("The Storm was heavy, you washed...");
		
		
		textLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLeft1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel1.add(titleLabel);
		panel2.add(textLeft);
		panel2.add(textLeft1);
		panel3.add(textGrid);
		panel3.add(textGrid1);
		
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel3.setLayout(new GridLayout(2, 2, 10, 10));
		
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.WEST);
		add(panel3, BorderLayout.CENTER);
		
		
		
		
		panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel1.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.DARK_GRAY));
        panel2.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        panel2.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.DARK_GRAY));
	}

}
