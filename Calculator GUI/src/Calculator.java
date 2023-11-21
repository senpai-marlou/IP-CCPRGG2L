
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	double firstnum;
	double secondnum;
	double result;
	String operations;
	String answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 270, 50);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(textField);
		textField.setColumns(10);

		// --------------ROW 1--------------

		JButton btnBackSpace = new JButton("\uF0E7");
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String backspace = null;

				if (textField.getText().length() > 0) {
					StringBuilder strB = new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length() - 1);
					backspace = strB.toString();
					textField.setText(backspace);
				}
			}
		});
		btnBackSpace.setBounds(10, 72, 60, 60);
		btnBackSpace.setFont(new Font("Wingdings", Font.BOLD, 23));
		contentPane.add(btnBackSpace);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnC.setBounds(80, 72, 60, 60);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField.setText(null);
		contentPane.add(btnC);

		JButton btnPercent = new JButton("%");
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "%";
			}
		});
		btnPercent.setBounds(150, 72, 60, 60);
		btnPercent.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(btnPercent);

		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "+";
			}
		});
		btnPlus.setBounds(220, 72, 60, 60);
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnPlus);

		// --------------ROW 2--------------

		JButton btn7 = new JButton("7");
		btn7.setBounds(10, 142, 60, 60);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String EnterNumber = textField.getText() + btn7.getText();
				textField.setText(EnterNumber);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn8.getText();
				textField.setText(EnterNumber);
			}
		});
		btn8.setBounds(80, 142, 60, 60);
		btn8.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn9.getText();
				textField.setText(EnterNumber);
			}
		});
		btn9.setBounds(150, 142, 60, 60);
		btn9.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn9);

		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "-";
			}
		});
		btnSub.setBounds(220, 142, 60, 60);
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnSub);

		// --------------ROW 3--------------

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn4.getText();
				textField.setText(EnterNumber);
			}
		});
		btn4.setBounds(10, 212, 60, 60);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn5.getText();
				textField.setText(EnterNumber);
			}
		});
		btn5.setBounds(80, 212, 60, 60);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn6.getText();
				textField.setText(EnterNumber);
			}
		});
		btn6.setBounds(150, 212, 60, 60);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn6);

		JButton btnMul = new JButton("×");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "*";
			}
		});
		btnMul.setBounds(220, 212, 60, 60);
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnMul);

		// --------------ROW 4--------------

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn1.getText();
				textField.setText(EnterNumber);
			}
		});
		btn1.setBounds(10, 282, 60, 60);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn2.getText();
				textField.setText(EnterNumber);
			}
		});
		btn2.setBounds(80, 282, 60, 60);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn3.getText();
				textField.setText(EnterNumber);
			}
		});
		btn3.setBounds(150, 282, 60, 60);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn3);

		JButton btnDiv = new JButton("÷");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "/";
			}
		});
		btnDiv.setBounds(220, 282, 60, 60);
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnDiv);

		// --------------ROW 5--------------

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn0.getText();
				textField.setText(EnterNumber);
			}
		});
		btn0.setBounds(10, 352, 60, 60);
		btn0.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btn0);

		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().contains(".")) {
					textField.setText(textField.getText() + btnDot.getText());
				}
			}
		});
		btnDot.setBounds(80, 352, 60, 60);
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnDot);

		JButton btnPM = new JButton("±");
		btnPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = ops * (-1);
				textField.setText(String.valueOf(ops));
			}
		});
		btnPM.setBounds(150, 352, 60, 60);
		btnPM.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnPM);

		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String answer;
				secondnum = Double.parseDouble(textField.getText());

				if (operations == "+") {
					result = firstnum + secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				} else if (operations == "-") {
					result = firstnum - secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				} else if (operations == "*") {
					result = firstnum * secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				} else if (operations == "/") {
					result = firstnum / secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				} else if (operations == "%") {
					result = firstnum % secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}

			}
		});
		btnEqual.setBounds(220, 352, 60, 60);
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnEqual);

	}
}
