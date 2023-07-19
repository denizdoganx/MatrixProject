package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Matrix;
import util.ControllerOfFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StartPage extends JFrame {

	private JPanel contentPane;
	private JTextField rowNum;
	private JTextField columnNum;
	/**
	 * Create the frame.
	 */
	public StartPage() {
		setTitle("The Matrix");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number of Row : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(94, 68, 121, 14);
		contentPane.add(lblNewLabel);
		
		rowNum = new JTextField();
		rowNum.setHorizontalAlignment(SwingConstants.CENTER);
		rowNum.setBounds(225, 65, 57, 20);
		contentPane.add(rowNum);
		rowNum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Number of Column : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(94, 117, 121, 14);
		contentPane.add(lblNewLabel_1);
		
		columnNum = new JTextField();
		columnNum.setHorizontalAlignment(SwingConstants.CENTER);
		columnNum.setBounds(225, 114, 57, 20);
		contentPane.add(columnNum);
		columnNum.setColumns(10);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rowNumStrFormat = StartPage.this.rowNum.getText();
				String columnNumStrFormat = StartPage.this.columnNum.getText();
				
				
				if(ControllerOfFormat.numberControl(rowNumStrFormat) &&
						ControllerOfFormat.numberControl(columnNumStrFormat) &&
						ControllerOfFormat.isItJustZero(rowNumStrFormat) &&
						ControllerOfFormat.isItJustZero(columnNumStrFormat)) 
				{
					StartPage.this.dispose();
					
					Matrix.rowNumber = Integer.valueOf(rowNumStrFormat);
					Matrix.columnNumber = Integer.valueOf(columnNumStrFormat);
					
					
					new MatrixElementEntrancePage();
				}
				else {
					JOptionPane.showMessageDialog(null, "You can only enter a number other than 0 in this fields.", "Error !", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setBounds(172, 179, 89, 23);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
