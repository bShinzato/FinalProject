package Main;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
	// Fields
	private final int WINDOW_WIDTH = 650;
	private final int WINDOW_HEIGHT = 450;
	private JTextField username;
	private JLabel titleLabel, textLeft, textLeft1, textMiddle, textRight, textRight1, textRight2, textRight3;
	private JPanel panel1, panel2, panel3, panel4, panel5;
	private JButton bottomButton;
	
	
	public GameFrame() {
		// Set title of JFrame
		this.setTitle("Click and Slash");
		// Set size of window
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// Set operation to close window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set a new borderlayout for GameFrame
		this.setLayout(new BorderLayout());
		
		// Create 5 Panels
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		panel5 = new JPanel();
		
		// Create text fields
		titleLabel = new JLabel("Click and Slash");
		bottomButton = new JButton("Start");
		textLeft = new JLabel("Instructions: ");
		textLeft1 = new JLabel("Insturctions go here..");
		textMiddle = new JLabel("Enter Hero Name: ");
		username = new JTextField();
		username.setPreferredSize(new Dimension(100, 20));
		textRight = new JLabel("Author: ");
		textRight1 = new JLabel("Brandon Shinzato");
		textRight2 = new JLabel("Date: ");
		textRight3 = new JLabel("05/XX/2024");
		
		// Add to panels
		panel1.add(titleLabel);
		panel2.add(textLeft);
		panel2.add(textLeft1);
		panel3.add(textMiddle);
		panel3.add(username);
		panel4.add(textRight);
		panel4.add(textRight1);
		panel4.add(textRight2);
		panel4.add(textRight3);
		panel5.add(bottomButton);
		
		// Set fonts
		Font font1 = new Font("Serif", Font.BOLD, 26);
		titleLabel.setFont(font1);
		
		
		// Add Borders to panels
		panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel1.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.DARK_GRAY));
        panel2.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        panel2.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.DARK_GRAY));
        panel3.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panel3.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.DARK_GRAY));
        panel4.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        panel4.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.DARK_GRAY));
        panel5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		
		// Add the five panels to the content pane
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.WEST);
		this.add(panel3, BorderLayout.CENTER);
		this.add(panel4, BorderLayout.EAST);
		this.add(panel5, BorderLayout.SOUTH);
		
		// add ActionListener to bottomButton
		bottomButton.addActionListener(new ButtonListener());
	}
	
	/*
	 * Inner Class for ButtonListener that adds a new panel referring to GameFrame of the outer class.
	 * Purpose: When button is clicked it will remove all contents from the window, switch to the avatar panel and add it to the window, using repaint and revalidate the GUI.
	 * revalidate found from: https://docs.oracle.com/javase/8/docs/api/javax/swing/JComponent.html
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getContentPane().removeAll();
			AvatarPanel avatarPanel = new AvatarPanel(GameFrame.this);
			getContentPane().add(avatarPanel);
			getContentPane().repaint();
			getContentPane().revalidate();
		}
	}
	
	/*
	 * Method to go to the timelinePanel
	 * Purpose: After selecting continue on AvatarPanel, it will jump to timelinePanel
	 */
	public void switchToTimelinePanel() {
		getContentPane().removeAll();
		TimelinePanel timelinePanel = new TimelinePanel(this);
		getContentPane().add(timelinePanel);
		getContentPane().repaint();
		getContentPane().revalidate();
	}
	
	/*
	 * Getter Methods for all 5 panels
	 */
	public JPanel getPanel1() {
		return panel1;
	}
	
	public JPanel getPanel2() {
		return panel2;
	}
	
	public JPanel getPanel3() {
		return panel3;
	}
	
	public JPanel getPanel4() {
		return panel4;
	}
	
	public JPanel getPanel5() {
		return panel5;
	}
	
	/*
	 * Setter Method for all 5 panels
	 */
	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}
	
	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}
	
	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}
	
	public void setPanel4(JPanel panel4) {
		this.panel4 = panel4;
	}
	
	public void setPanel5(JPanel panel5) {
		this.panel5 = panel5;
	}
	
	/*
	 * Getter Methods for all JLabels and JButton
	 */
	public JLabel getTitleLabel() {
		return titleLabel;
	}
	
	public JLabel getTextLeft() {
		return textLeft;
	}
	
	public JLabel getTextLeft1() {
		return textLeft1;
	}
	
	public JLabel getTextMiddle() {
		return textMiddle;
	}
	
	public String getUsername() {
		return username.getText();
	}
	
	public JLabel getTextRight() {
		return textRight;
	}
	
	public JLabel getTextRight1() {
		return textRight1;
	}
	
	public JLabel getTextRight2() {
		return textRight2;
	}
	
	public JLabel getTextRight3() {
		return textRight3;
	}
	
	public JButton getBottomButton() {
		return bottomButton;
	}
	
	/*
	 * Setter Methods for all JLabels and JButton
	 */
	
	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}
	
	public void setTextLeft(JLabel textLeft) {
		this.textLeft = textLeft;
	}
	
	public void setTextLeft1(JLabel textLeft1) {
		this.textLeft1 = textLeft1;
	}
	
	public void setTextMiddle(JLabel textMiddle) {
		this.textMiddle = textMiddle;
	}
	
	public void setTextRight(JLabel textRight) {
		this.textRight = textRight;
	}
	
	public void setTextRight1(JLabel textRight1) {
		this.textRight1 = textRight1;
	}
	
	public void setTextRight2(JLabel textRight2) {
		this.textRight2 = textRight2;
	}
	
	public void setTextRight3(JLabel textRight3) {
		this.textRight3 = textRight3;
	}
	
	public void setBottomButton(JButton bottomButton) {
		this.bottomButton = bottomButton;
	}
}
