import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class PasswordChecker extends JFrame implements ActionListener {

    // Labels
    private JLabel iconLabel;
    private JLabel iconLabel2;
    private JLabel iconLabel3;
    private JLabel iconLabel4;
    private JLabel iconLabel5;
    
    private JLabel iconLabelShow;
    private JLabel iconLabelHide;
       
    // Image Icons   
    private ImageIcon showIcon = new ImageIcon("show.png");
    private ImageIcon hideIcon = new ImageIcon("hide.png");
    
    private ImageIcon greenIcon = new ImageIcon("green.png");
    private ImageIcon redIcon = new ImageIcon("red.png");
    
	// Elements
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	
	// Instruction Labels
	private static JLabel I1;
	private static JLabel I2;
	private static JLabel I22;
	private static JLabel I3;
	private static JLabel I33;
	private static JLabel I4;
	private static JLabel I5;
	private static JLabel I55;	
	
	// Red & Green Indicator
	private boolean G1 = false;
	private boolean G2 = false;
	private boolean G3 = false;
	private boolean G4 = false;
	private boolean G5 = false;
	
	private JButton clickButton;
	private boolean clicked = false;
	
    public PasswordChecker() {
        super("Password Checker");
     
        iconLabelShow = new JLabel();
        iconLabelShow.setIcon(showIcon);
        iconLabelShow.setBounds(300, 65, 35, 25);
        
        iconLabelHide = new JLabel();
        iconLabelHide.setIcon(hideIcon);
        iconLabelHide.setBounds(300, 65, 35, 25);
        
        clickButton = new JButton(hideIcon);        
        clickButton.setBounds(300, 60, 35, 34);
        clickButton.setBorderPainted(true);
        clickButton.setContentAreaFilled(false);
        clickButton.setOpaque(false);    
        
        
        clickButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (clicked) {
                	clickButton.setIcon(hideIcon);
                    clicked = false;
                    passwordText.setEchoChar('•');                    
                } else {
                	clickButton.setIcon(showIcon);
                    clicked = true;
                    passwordText.setEchoChar((char)0);
                }
            }
        });
 
        
        // Green        
        iconLabel = new JLabel();
        iconLabel.setBounds(70, 106, 25, 25);
        
        iconLabel2 = new JLabel();
        iconLabel2.setBounds(70, 134, 25, 25);
        
        iconLabel3 = new JLabel();
        iconLabel3.setBounds(70, 173, 25, 25);
        
        iconLabel4 = new JLabel();
        iconLabel4.setBounds(70, 210, 25, 25);
        
        iconLabel5 = new JLabel();
        iconLabel5.setBounds(70, 239, 25, 25);
          
        updateIcon();       
        
        JPanel content = new JPanel();
        content.setLayout(null);
        
        // add icons
        content.add(iconLabel);
        content.add(iconLabel2);
        content.add(iconLabel3);
        content.add(iconLabel4);
        content.add(iconLabel5);        
        
        content.add(clickButton);
        
        passwordLabel = new JLabel("Enter Password");
	    passwordLabel.setBounds(118, 28, 200, 25);
	    passwordLabel.setFont(new Font("Proxima Nova Bold", Font.BOLD, 20));
	    content.add(passwordLabel);
	    
	    passwordText = new JPasswordField(20);
	    passwordText.setBounds(57, 60, 245, 35);
	    passwordText.setFont(new Font("Proxima Nova Bold", Font.BOLD, 20));
	    content.add(passwordText);
	    
	    JButton button = new JButton();
	    button = new JButton("Check");
	    button.setBounds(147, 300, 90, 30);	    
	    button.setFont(new Font("Proxima Nova Bold", Font.BOLD, 18));
	    button.setBorderPainted(true);
	    button.setContentAreaFilled(false);
	    button.setOpaque(false);    
	    button.addActionListener(this);	    
	    content.add(button);
	    
	    I1 = new JLabel("At least 8 Characters long.");
	    I1.setBounds(100, 105, 200, 25);
	    I1.setFont(new Font("Proxima Nova Bold", Font.BOLD, 14));
	    content.add(I1);
	    	  
	    I2 = new JLabel("Contains at least one");
	    I22 = new JLabel("uppercase letter.");
	    I2.setBounds(100, 130, 200, 25);
	    I22.setBounds(100, 145, 200, 25);
	    I2.setFont(new Font("Proxima Nova Bold", Font.BOLD, 14));
	    I22.setFont(new Font("Proxima Nova Bold", Font.BOLD, 14));
	    content.add(I2);
	    content.add(I22);	   
	    
	    I3 = new JLabel("Contains at least one");
	    I33 = new JLabel("lowercase letter.");
	    I3.setBounds(100, 170, 200, 25);
	    I33.setBounds(100, 185, 200, 25);
	    I3.setFont(new Font("Proxima Nova Bold", Font.BOLD, 14));
	    I33.setFont(new Font("Proxima Nova Bold", Font.BOLD, 14));
	    content.add(I3);
	    content.add(I33);
	    
	    I4 = new JLabel("Contains at least one number.");
	    I4.setBounds(100, 210, 250, 25);
	    I4.setFont(new Font("Proxima Nova Bold", Font.BOLD, 14));
	    content.add(I4);
	    
	    I5 = new JLabel("Contains special characters:");
	    I55 = new JLabel("@, #, $, %, &, *, or +");
	    I5.setBounds(100, 235, 200, 25);
	    I55.setBounds(100, 250, 200, 25);
	    I5.setFont(new Font("Proxima Nova Bold", Font.BOLD, 14));
	    I55.setFont(new Font("Proxima Nova Bold", Font.BOLD, 14));
	    content.add(I5);
	    content.add(I55);    
        
        setLocationRelativeTo(null);
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void updateIcon() {

        if (G1) {
            iconLabel.setIcon(greenIcon);
        } else {
            iconLabel.setIcon(redIcon);
        }
        
        if (G2) {
            iconLabel2.setIcon(greenIcon);
        } else {
            iconLabel2.setIcon(redIcon);
        }
       
        if (G3) {
            iconLabel3.setIcon(greenIcon);
        } else {
            iconLabel3.setIcon(redIcon);
        }
        
        if (G4) {
            iconLabel4.setIcon(greenIcon);
        } else {
            iconLabel4.setIcon(redIcon);
        }
        
        if (G5) {
            iconLabel5.setIcon(greenIcon);
        } else {
            iconLabel5.setIcon(redIcon);
        }      
    }
    
    public void actionPerformed(ActionEvent e) {
    	
    	char[] password = passwordText.getPassword();
    	String passwordString = new String(password);
    	
    	boolean isValid = true;
    	
    	// Validation
    	boolean hasUpperCase = false;
    	boolean hasLowerCase = false;
    	boolean hasDigit = false;
    	boolean hasSpecialChar = false;
    	
    	// Length
    	if (passwordString.length() >= 8) {
    		G1 = true;
    		I1.setForeground(Color.GREEN);
    	} else {
    		I1.setForeground(Color.RED);
      	    G1 = false;
    		isValid = false;
    	}
 	
    	for (char c : password) {
    		if (c >= 'A' && c <= 'Z') {
    			hasUpperCase = true;
    		} else if (c >= 'a' && c <= 'z') {
    			hasLowerCase = true;
    		} else if (c >= '0' && c <= '9') {
    			hasDigit = true;
    		} else if (c == '@' || c == '#' || c == '$' || c == '%' || c == '&' || c == '*' || c == '+') {
    			hasSpecialChar = true;
    		}    		
    	}
    	
    	if (hasUpperCase) {
      	     I2.setForeground(Color.GREEN);
      	     I22.setForeground(Color.GREEN);
      	     G2 = true;
      	 } else {
      	     I2.setForeground(Color.RED);
      	     I22.setForeground(Color.RED);
      	     G2 = false;
      	     isValid = false;
      	 }
    	
    	if (hasLowerCase) {
      	     I33.setForeground(Color.GREEN);
      	     I3.setForeground(Color.GREEN);
      	     G3 = true;
      	 } else {
      	     I3.setForeground(Color.RED);
      	     I33.setForeground(Color.RED);
      	     G3 = false;
      	     isValid = false;
      	 }
    	
    	if (hasDigit) {
      	     I4.setForeground(Color.GREEN);
      	     G4 = true;
      	 } else {
      	     I4.setForeground(Color.RED);
      	     G4 = false;
      	     isValid = false;
      	 }
		
    	if (hasSpecialChar) {
      	     I5.setForeground(Color.GREEN);
      	     I55.setForeground(Color.GREEN);
      	     G5 = true;
      	 } else {
      	     I5.setForeground(Color.RED);
      	     I55.setForeground(Color.RED);
      	     G5 = false;
      	     isValid = false;
      	 }
		
		updateIcon();
		
		 if (isValid) {
			 JOptionPane.showMessageDialog(null, "Password is valid | Strong");
		 } else {
			 JOptionPane.showMessageDialog(null, "Password is not valid | Too Weak");
		 }
		 
		 
}
    
    public static void main(String[] args) {
    	
    	UIManager.put("OptionPane.messageFont", new Font("Proxima Nova Bold", Font.BOLD, 16));

		JFrame instructions = new JFrame("Instructions");
		instructions.setSize(400, 500);		
		instructions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		instructions.setLayout(null);
		instructions.setLocationRelativeTo(null);
		
		JPanel panelinstructions = new JPanel();
		instructions.add(panelinstructions);
		
		JOptionPane.showMessageDialog(panelinstructions,
                "Welcome to Password Checker | Created By Marlou \n\n" +
                        "This program validates a password\n" +
                		" base on the following rules:\n\n" +
                        "1. The password must be at least 8 Characters long.\n" +
                        "2. The password must contain at least one uppercase letter.\n" +
                        "3. The password must contain at least one lowercase letter.\n" +
                        "4. The password must contain at least one digit.\n" +
                        "5. The password may contain special characters such as\n" +
                        "(@, #, $, %, &, *, or +)\n\n" +
                        "Click 'OK' to continue.",
                "Instructions",
                JOptionPane.INFORMATION_MESSAGE);
		instructions.dispose();	
    	
    	
        PasswordChecker frame = new PasswordChecker();
        frame.setSize(400, 390);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
    }   
}
