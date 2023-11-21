import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel implements ActionListener {

	// logic variables
	static boolean playerX;
	static boolean gameDone = false;
	static int winner = -1;
	static int player1wins = 0;
	static int player2wins = 0;
	static int[][] board = new int[3][3];

	static boolean maxWIN3 = false;
	static boolean maxWIN5 = false;
	static boolean noLimit = false;
        
        static boolean resetMaxWin = false;

	static int selX = 0;
	static int selY = 0;
	static int round = 0;

	static int surrenderCount = 0;
	
	static JTextField textFieldX = new JTextField();
	static JTextField textFieldO = new JTextField();
	
	static String textFieldXValue;
	static String textFieldOValue;
	
	static JButton max3 = new JButton("");
	static JButton max5 = new JButton("");
	static JButton maxNo = new JButton("");

	// paint variables
	int lineWidth = 5;
	int lineLength = 270;
	int x = 15, y = 100; // location of first line
	int offset = 95; // square width
	int a = 0;
	int b = 5;

	// COLORS
	Color dark = new Color(0x4b4b4b);

	// COMPONENTS
	static JButton jButton;
	static JButton jSurrender;

	public GamePanel() {
		Dimension size = new Dimension(605, 450);
		setLocation(100, 300);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		addMouseListener(new XOListener());
		jButton = new JButton("CONTINUE");
		jButton.setBounds(252, 400, 100, 26);
		jButton.setOpaque(false);
		jButton.setBorderPainted(true);
		jButton.setFocusPainted(false);
		jButton.setContentAreaFilled(false);
		jButton.addActionListener(this);
		setLayout(null);

		jSurrender = new JButton("Surrender?");
		jSurrender.setOpaque(false);
		jSurrender.setBorderPainted(true);
		jSurrender.setFocusPainted(false);
		jSurrender.setContentAreaFilled(false);

		jSurrender.addActionListener(e -> {
			JFrame frame = new JFrame();
			if (surrenderCount == 1) {
				int result = JOptionPane.showOptionDialog(frame, "Are you sure you want to surrender?",
						"Surrender Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Yes", "No, Continue" }, "Continue");
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(frame, "X is the winner");
					System.exit(0);
				} else if (result == JOptionPane.NO_OPTION) {
					surrenderCount = 0;
					resetGame();
				}
			} else if (surrenderCount == 2) {
				int result = JOptionPane.showOptionDialog(frame, "Are you sure you want to surrender?",
						"Surrender Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Yes", "No, Continue" }, "Continue");
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(frame, "O is the winner");
					System.exit(0);
				} else if (result == JOptionPane.NO_OPTION) {
					surrenderCount = 0;
					resetGame();
				}
			}
		});

		add(jButton);
		add(jSurrender);
		resetGame();
	}

	public static void resetGame() {
		playerX = true;
		winner = -1;
		gameDone = false;

		surrenderCount = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = 0; // all spots are empty
			}
		}
		round++;
		getJButton().setVisible(false);
		getJSurrender().setVisible(false);
	}

	public void paintComponent(Graphics page) {

		super.paintComponent(page);
		try {
			BufferedImage image = ImageIO.read(new File("FINAL-BG.jpg"));
			page.drawImage(image, 0, 0, this);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Font font = new Font("Proxima Nova Bold", Font.BOLD, 18);
		
		JLabel nameX = new JLabel(textFieldXValue);
		nameX.setFont(font);
		nameX.setBounds(25, 224, 120, 30);
//		nameX.setBorder(new LineBorder(Color.RED, 2));
		nameX.setForeground(new Color(83, 83, 83));
		nameX.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel nameO = new JLabel(textFieldOValue);
		nameO.setFont(font);
		nameO.setBounds(464, 224, 120, 30);
//		nameO.setBorder(new LineBorder(Color.RED, 2));
		nameO.setForeground(new Color(83, 83, 83));
		nameO.setHorizontalAlignment(JTextField.CENTER);
		
		add(nameX);
		add(nameO);
		
		drawUI(page);
		drawName(page);
		drawGame(page);
	}

	public void drawName(Graphics page) {
		Font font = new Font("Proxima Nova Bold", Font.BOLD, 21);
		page.setFont(font);
//		page.drawString(textFieldXValue, 39, 245);
//		page.drawString(textFieldOValue, 490, 247);
	}

	public void drawUI(Graphics page) {
		// SET COLOR AND FONT
		page.setColor(dark);
		Font font = new Font("Proxima Nova", Font.BOLD, 40);
		page.setFont(font);

		// SET WIN COUNTER
		page.setColor(dark);
		page.drawString(" " + player1wins, 63, 285);
		page.drawString(" " + player2wins, 502, 285);

		// DRAW score X
		ImageIcon xIcon = new ImageIcon("blackX.png");
		Image xImg = xIcon.getImage();
		Image newXImg = xImg.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newXIcon = new ImageIcon(newXImg);
		page.drawImage(newXIcon.getImage(), 62, 178, null);

		// DRAW score O
		ImageIcon oIcon = new ImageIcon("blackO.png");
		Image oImg = oIcon.getImage();
		Image newOImg = oImg.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newOIcon = new ImageIcon(newOImg);
		page.drawImage(newOIcon.getImage(), 500, 178, null);

		ImageIcon TicTacToe = new ImageIcon("TicTacToe.png");
		Image TicTacToeImg = TicTacToe.getImage();
		Image newTicTacToe = TicTacToeImg.getScaledInstance(135, 65, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newTicTacToeIcon = new ImageIcon(newTicTacToe);

		// DRAW WHOS TURN or WINNER
		page.setColor(dark);
		Font font1 = new Font("Proxima Nova Bold", Font.BOLD, 20);
		page.setFont(font1);

		page.drawString("Round " + round, 263, 40);

		if (gameDone) {
			Font End = new Font("Proxima Nova Bold", Font.BOLD, 21);
			page.setFont(End);
			page.drawString("Match Ended", 238, 372);
			if (winner == 1) { // x
				page.drawImage(newTicTacToeIcon.getImage(), 20, 120, null);
				Font fontX = new Font("Proxima Nova Bold", Font.BOLD, 16);
				page.setFont(fontX);
				page.drawString(textFieldXValue + " won!", 255, 390);
			} else if (winner == 2) { // o
				page.drawImage(newTicTacToeIcon.getImage(), 455, 120, null);
				Font fontO = new Font("Proxima Nova Bold", Font.BOLD, 16);
				page.setFont(fontO);
				page.drawString(textFieldOValue + " won!", 259, 390);
			} else if (winner == 3) { // tie
				Font fontDraw = new Font("Proxima Nova Bold", Font.BOLD, 16);
				page.setFont(fontDraw);
				page.drawString("Draw!", 277, 388);
			}
		} else {
			Font font3 = new Font("Proxima Nova Bold", Font.BOLD, 20);
			page.setFont(font3);
			//The turns
			if (playerX) {
//				page.drawString("X 's Turn", 265, 400);		//X
			} else {
//				page.drawString("O 's Turn", 265, 400);		//O
			}
		}
	}

	public void drawGame(Graphics page) {
		int xStart = (650 - (3 * offset)) / 2;
		int yStart = (450 - (3 * offset)) / 2;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {

				} else if (board[i][j] == 1) {
					ImageIcon xIcon = new ImageIcon("blackX.png");
					Image xImg = xIcon.getImage();
					page.drawImage(xImg, xStart + offset * i, yStart + offset * j, 50, 50, null);
				} else if (board[i][j] == 2) {
					ImageIcon oIcon = new ImageIcon("blackO.png");
					Image oImg = oIcon.getImage();
					page.drawImage(oImg, xStart + offset * i, yStart + offset * j, 50, 50, null);
				}
			}
		}
		repaint();
	}

	public void checkWinner() {

		int maxWins = 0;     
                
                if (resetMaxWin) {
                    maxWins = 0;
                }

		if (maxWIN3) {
			maxWins = 3;
		} else if (maxWIN5) {
			maxWins = 7;
		} else if (noLimit) {
			maxWins = Integer.MAX_VALUE;
		}
                
                

		if (gameDone == true) {
			System.out.print("gameDone");
			return;
		}
		// vertical
		int temp = -1;
		if ((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]) && (board[0][0] != 0)) {
			temp = board[0][0];
		} else if ((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]) && (board[1][0] != 0)) {
			temp = board[1][1];
		} else if ((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]) && (board[2][0] != 0)) {
			temp = board[2][1];

			// horizontal
		} else if ((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]) && (board[0][0] != 0)) {
			temp = board[0][0];
		} else if ((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]) && (board[0][1] != 0)) {
			temp = board[0][1];
		} else if ((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]) && (board[0][2] != 0)) {
			temp = board[0][2];

			// diagonal
		} else if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[0][0] != 0)) {
			temp = board[0][0];
		} else if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && (board[0][2] != 0)) {
			temp = board[0][2];
		} else {

			// CHECK FOR A TIE
			boolean notDone = false;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] == 0) {
						notDone = true;
						break;
					}
				}
			}
			if (notDone == false) {
				temp = 3;
			}
		}
		if (temp > 0) {
			winner = temp;
			if (winner == 1) {
				player1wins++;
				surrenderCount += 1;
				System.out.println("winner is X");
				System.out.println(surrenderCount + " | Player (O) can surrender");
				if (surrenderCount == 1) {
					jSurrender.setBounds(473, 295, 100, 26);
					getJSurrender().setVisible(true);
				}

				if (player1wins == maxWins) {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Game Ended: X Won the Game");
					System.exit(0);
				}

			} else if (winner == 2) {
				player2wins++;
				surrenderCount += 2;
				System.out.println("winner is O");
				System.out.println(surrenderCount + " | Player (X) can surrender");
				if (surrenderCount == 2) {
					jSurrender.setBounds(35, 295, 100, 26);
					getJSurrender().setVisible(true);
				}

				if (player2wins == maxWins) {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Game Ended: O Won the Game");
					System.exit(0);
				}

			} else if (winner == 3) {
				System.out.println("It's a tie");
				surrenderCount = 0;
				System.out.println(surrenderCount);
				getJSurrender().setVisible(false);
			}
			gameDone = true;
			getJButton().setVisible(true);
		}
	}

	public static JButton getJButton() {
		return jButton;
	}

	public static JButton getJSurrender() {
//		surrenderNa();
		return jSurrender;
	}

	public void setPlayerXWins(int a) {
		player1wins = a;
	}

	public void setPlayerOWins(int a) {
		player2wins = a;
	}

	public static void main(String[] args) {

		// Start Frame

		// Menu Frame
		JFrame menuFrame = new JFrame("Menu Frame");
		menuFrame.getContentPane().setLayout(null);
		menuFrame.setSize(620, 485);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setVisible(true);

		max3.setBounds(180, 295, 70, 50);
		max3.setOpaque(false);
		max3.setBorderPainted(false);
		max3.setFocusPainted(false);
		max3.setContentAreaFilled(false);

		max5.setBounds(268, 295, 70, 50);
		max5.setOpaque(false);
		max5.setBorderPainted(false);
		max5.setFocusPainted(false);
		max5.setContentAreaFilled(false);

		maxNo.setBounds(340, 295, 100, 50);
		maxNo.setOpaque(false);
		maxNo.setBorderPainted(false);
		maxNo.setFocusPainted(false);
		maxNo.setContentAreaFilled(false);

		menuFrame.getContentPane().add(max3);
		menuFrame.getContentPane().add(max5);
		menuFrame.getContentPane().add(maxNo);

		max3.addActionListener(e -> {
			maxWIN3 = true;
			max3.setBorderPainted(true);

			maxWIN5 = false;
			noLimit = false;
			max5.setBorderPainted(false);
			maxNo.setBorderPainted(false);
		});

		max5.addActionListener(e -> {
			maxWIN5 = true;
			max5.setBorderPainted(true);

			maxWIN3 = false;
			noLimit = false;
			max3.setBorderPainted(false);
			maxNo.setBorderPainted(false);
		});

		maxNo.addActionListener(e -> {
			noLimit = true;
			maxNo.setBorderPainted(true);

			maxWIN3 = false;
			maxWIN5 = false;
			max3.setBorderPainted(false);
			max5.setBorderPainted(false);
		});

		Font font = new Font("Proxima Nova Bold", Font.BOLD, 18);

		
		textFieldX.setPreferredSize(new Dimension(200, 30));
		textFieldX.setBounds(154, 185, 121, 33);
		menuFrame.getContentPane().add(textFieldX);

		textFieldX.setOpaque(false);
		textFieldX.setBorder(null);
		textFieldX.setFont(font);
		textFieldX.setHorizontalAlignment(JTextField.CENTER);

		textFieldO.setPreferredSize(new Dimension(200, 30));
		textFieldO.setBounds(330, 185, 121, 33);
		menuFrame.getContentPane().add(textFieldO);

		textFieldO.setOpaque(false);
		textFieldO.setBorder(null);
		textFieldO.setFont(font);
		textFieldO.setHorizontalAlignment(JTextField.CENTER);
		
		// Go to Game Window
		JButton toGame = new JButton("");
		toGame.setBounds(253, 367, 100, 50);
		toGame.setFocusPainted(false);
		toGame.setBorderPainted(true);
		toGame.setContentAreaFilled(false);
		toGame.setOpaque(false);
		menuFrame.getContentPane().add(toGame);

		// Game Frame
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.getContentPane();

		JButton Menu = new JButton("");
		Menu.setBounds(554, 8, 40, 40);
		Menu.setOpaque(false);
		Menu.setBorderPainted(false);
		Menu.setFocusPainted(false);
		Menu.setContentAreaFilled(false);

		GamePanel gamePanel = new GamePanel();
		frame.getContentPane().add(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();

		toGame.addActionListener(e -> {
			
			textFieldXValue = textFieldX.getText();
			textFieldOValue = textFieldO.getText();
			
			boolean ok = true;
			
			if (textFieldXValue.equals("") && textFieldOValue.equals("")) {
				JOptionPane.showMessageDialog(null, "Please select input player", "Invalid",
						JOptionPane.INFORMATION_MESSAGE);
				ok = false;
			} else if (textFieldXValue.equals("")) {
				JOptionPane.showMessageDialog(null, "Player X missing", "Invalid",
						JOptionPane.INFORMATION_MESSAGE);
				ok = false;
			} else if (textFieldOValue.equals("")) {
				JOptionPane.showMessageDialog(null, "Player O missing", "Invalid",
						JOptionPane.INFORMATION_MESSAGE);
				ok = false;
			}
			
			if (!(maxWIN3) && !(maxWIN5) && !(noLimit)) {
				JOptionPane.showMessageDialog(null, "Please select max wins", "Invalid",
						JOptionPane.INFORMATION_MESSAGE);
				ok = false;
			} 
			
			if (ok) {
				menuFrame.setVisible(false);
				resetMaxWin = false;
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			
		});

		try {
			Image backgroundImage = ImageIO.read(new File("MENU.jpg"));
			JLabel background = new JLabel(new ImageIcon(backgroundImage));
			menuFrame.getContentPane().add(background);
			background.setBounds(-8, -16, 620, 485);
			menuFrame.getContentPane().setLayout(null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		gamePanel.add(Menu);
		Menu.addActionListener(e -> {
			if (e.getSource() == Menu) {
				int result = JOptionPane.showOptionDialog(gamePanel, "Choose an option:", "Options",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Reset Game", "Exit Game", "Back to Menu" }, "Reset");
				if (result == JOptionPane.YES_OPTION) {
					restartGame();
				} else if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				} else if (result == JOptionPane.CANCEL_OPTION) {
					frame.setVisible(false);
					menuFrame.setVisible(true);
					backtoMenu();
				}
			}
		});
	}

	private class XOListener implements MouseListener {

		public void mouseClicked(MouseEvent event) {
			selX = -1;
			selY = -1;
			if (gameDone == false) {
				a = event.getX();
				b = event.getY();
				int clickX = 0, clickY = 0;
				int x = (610 - (30 + offset * 3)) / 2;
				int y = (420 - (30 + offset * 3)) / 2;
				if (a > x + 12 && a < x + 99) {
					clickX = 0;
				} else if (a > x + 103 && a < x + 195) {
					clickX = 1;
				} else if (a > x + 200 && a < x + 287) {
					clickX = 2;
				} else {
					clickX = -1;
				}

				if (b > y + 12 && b < y + 99) {
					clickY = 0;
				} else if (b > y + 103 && b < y + 195) {
					clickY = 1;
				} else if (b > y + 200 && b < y + 287) {
					clickY = 2;
				} else {
					clickY = -1;
				}
				if (clickX != -1 && clickY != -1) {

					if (board[clickX][clickY] == 0) {
						if (playerX) {
							board[clickX][clickY] = 1;
							playerX = false;
						} else {
							board[clickX][clickY] = 2;
							playerX = true;
						}
						checkWinner();
						System.out.println(
								"CLICK = x:" + a + ", y:" + b + " | Board Location X, Y: " + clickX + "," + clickY);

					}
				} else {
					System.out.println("invalid click");
				}
			}
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}

		public void mousePressed(MouseEvent event) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		resetGame();
	}

	public static void restartGame() {
		
		maxWIN3 = false;
		maxWIN5 = false;
		noLimit = false;
		
		textFieldX.setText("");
		textFieldO.setText("");
		
		round = 0;
		selX = 0;
		selY = 0;
		player1wins = 0;
		player2wins = 0;
		winner = -1;
		gameDone = false;
		surrenderCount = 0;
                resetMaxWin = true;
		resetGame();
	}

	public static void backtoMenu() {
		
		resetGame();
		
		maxWIN3 = false;
		maxWIN5 = false;
		noLimit = false;
		
		max3.setBorderPainted(false);
		max5.setBorderPainted(false);
		maxNo.setBorderPainted(false);
		
		textFieldX.setText("");
		textFieldO.setText("");
		
		round = 1;
		selX = 0;
		selY = 0;
		player1wins = 0;
		player2wins = 0;
		winner = -1;
		gameDone = false;
                resetMaxWin = true;
		surrenderCount = 0;
	}
}