package view;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.LinearEquationWithMatrix;
import model.Matrix;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MatrixInfoPage extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public MatrixInfoPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 423, 739);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 5, 5));
		
		JButton btnNewButton_2 = new JButton("Calculate Sum of Rows");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PageForRowsOperation(true);
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Calculate Sum of Columns");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PageForColumnsOperation(true);
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Calculate Sum of the Primary Diagonal");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OnlyOnePage(0);
			}
		});
		panel.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("Calculate Transpose of Matrix");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MatrixTransposePage();
				
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_7 = new JButton("Determine the Matrix Type");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MatrixTypePage();
			}
		});
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("Calculate the Minumum Values of Each Row");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PageForRowsOperation(false);
			}
		});
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_9 = new JButton("Calculate the Maximum Values of Each Column");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PageForColumnsOperation(false);
			}
		});
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_8 = new JButton("Calculate the Maximum of Minumum Values of Each Row(maxmin)");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OnlyOnePage(2);
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_11 = new JButton("Calculate the Minumum of Maximum Values of Each Column(minmax)");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OnlyOnePage(3);
			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_10 = new JButton("Compare Maxmin to Minmax");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OnlyOnePage(4);
			}
		});
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_1 = new JButton("Apply Gauss Elimination Method");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Matrix.rowNumber != Matrix.columnNumber-1) {
					JOptionPane.showMessageDialog(null, "Gauss Elimination can be applied only for (n)x(n+1) matrices.", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				else {
					LinearEquationWithMatrix equationSystem = new LinearEquationWithMatrix();
					double[] response = equationSystem.solveByGaussElimination(Matrix.getInstance().getOriginalMatrix());
					new MatrixResponse(response);
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_12 = new JButton("Change the Entered Matrix");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matrix.killTheInstance();
				MatrixInfoPage.this.dispose();
				new StartPage();
			}
		});
		panel.add(btnNewButton_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(443, 11, 811, 739);
		
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		panel_1.add(new MatrixView(true));
		contentPane.add(panel_1);
	}
}
