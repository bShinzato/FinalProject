package Main;

import javax.swing.ImageIcon;

public class SavedAvatar {
	// Field to hold the avatar that was selected
	private static ImageIcon selectedAvatar;

	// Setter for selectedAvatar
	public static void setSelectedAvatar(ImageIcon avatar) {
		selectedAvatar = avatar;
	}
	
	// Getter for selectedAvatar
	public static ImageIcon getSelectedAvatar() {
		return selectedAvatar;
	}
}
