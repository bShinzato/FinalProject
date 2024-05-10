package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AvatarPanel extends JPanel {
	// Fields
	private ImageIcon selectedAvatar;
	private JLabel textLeft, textLeft1, titleLabel, avatarLabel;
	private JPanel panel1, panel2, panel3, panel5;
	private JRadioButton avatar1, avatar2, avatar3;
	private JButton continueButton;

	/*
	 * Constructor
	 */
	public AvatarPanel(GameFrame gameFrame) {
		super(new BorderLayout());
		avatarGUI(gameFrame);
	}

	private void avatarGUI(GameFrame gameFrame) {

		// Create 5 panels for this panel
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel5 = new JPanel();

		// Get username from gameFrame
		String userName = gameFrame.getUsername();

		// Labels
		textLeft = new JLabel("Hero " + userName);
		textLeft1 = new JLabel("Choose An Avatar");
		titleLabel = gameFrame.getTitleLabel();
		avatarLabel = new JLabel("Select Option to show an Avatar.");

		// Create continue button to proceed with game
		continueButton = new JButton("Continue");

		// Create 3 avatar Radio Buttons and group the Radio Buttons
		avatar1 = new JRadioButton("Avatar One");
		avatar2 = new JRadioButton("Avatar Two");
		avatar3 = new JRadioButton("Avatar Three");

		ButtonGroup bg = new ButtonGroup();
		bg.add(avatar1);
		bg.add(avatar2);
		bg.add(avatar3);

		// Action listener for radio buttons
		avatar1.addActionListener(new aActionListener());
		avatar2.addActionListener(new aActionListener());
		avatar3.addActionListener(new aActionListener());
		
		
		/*
		 * Action Listener for the continue Button.
		 * Purpose: Ensures that an avatar is selected and will switch to the timeline panel from gameFrame.
		 */
		continueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedAvatar != null) {
					gameFrame.switchToTimelinePanel();
				} else {
					JOptionPane.showMessageDialog(AvatarPanel.this, "Select an Avatar");
				}
			}
		});
		
		// Set font for title
		Font font1 = new Font("Serif", Font.BOLD, 26);
		titleLabel.setFont(font1);
		
		// Add Labels to panels
		panel1.add(titleLabel);
		panel2.add(textLeft);
		panel2.add(textLeft1);
		panel3.add(avatarLabel);

		// Add Radio Buttons to gameFrames panel2
		panel2.add(avatar1);
		panel2.add(avatar2);
		panel2.add(avatar3);

		// Add Continue button to panel5
		panel5.add(continueButton);

		// Add panel(s) to desired area
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.WEST);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		add(panel3, BorderLayout.CENTER);
		add(panel5, BorderLayout.SOUTH);
		
		panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel1.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.DARK_GRAY));
        panel2.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        panel2.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.DARK_GRAY));
        panel3.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panel3.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.DARK_GRAY));
        panel5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}

	/*
	 * ActionListener for JRadioButtons
	 * Purpose: When the user clicks an option an avatar will appear. The selected avatar will be saved.
	 */
	private class aActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			Image image = null;
			try {
				if (e.getSource() == avatar1) {
					image = ImageIO.read(getClass().getResourceAsStream("/avatarImages/avatar1.png"));
				} else if (e.getSource() == avatar2) {
					image = ImageIO.read(getClass().getResourceAsStream("/avatarImages/avatar2.png"));
				} else if (e.getSource() == avatar3) {
					image = ImageIO.read(getClass().getResourceAsStream("/avatarImages/avatar3.png"));
				}
				if (image != null) {
					selectedAvatar = new ImageIcon(image);
					avatarLabel = new JLabel(selectedAvatar);
					panel3.removeAll();
					panel3.add(avatarLabel);
					SavedAvatar.setSelectedAvatar(selectedAvatar); // Save/store selectedAvatar 
				}
				panel3.repaint();
				panel3.revalidate();

			} catch (IllegalArgumentException | IOException exception1) {
				exception1.printStackTrace();
				JLabel errorLabel = new JLabel("Image not Found");
				panel3.add(errorLabel);
			}
		}
	}
	
}

