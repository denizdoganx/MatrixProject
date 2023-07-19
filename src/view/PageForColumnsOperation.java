package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Matrix;

import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class PageForColumnsOperation extends JFrame {

	private JPanel contentPane;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public PageForColumnsOperation(boolean fromSummation) {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 764, 539);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(Matrix.columnNumber, 1, 0, 10));
		
		if(fromSummation)
			initTheInsideOfViewForSummationOperation();
		else
			initTheInsideOfViewForMaximumOperation();
	}
	
	private void initTheInsideOfViewForSummationOperation() {
		double[] retArr = Matrix.getInstance().calculateSumOfColumns();
		for(int i = 0;i < Matrix.columnNumber; i++) {
			JLabel tempLabel = new JLabel("Column "+ (i + 1) + "                 " + retArr[i]);
			tempLabel.setHorizontalAlignment(JLabel.CENTER);
			tempLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			
			panel.add(tempLabel);
		}
	}
	
	private void initTheInsideOfViewForMaximumOperation() {
		
		double[] retArr = Matrix.getInstance().calculateMaximumValuesOfEachColumn();
		for(int i = 0;i < Matrix.columnNumber; i++) {
			JLabel tempLabel = new JLabel("Maximum Value of Column "+ (i + 1) + "                 " + retArr[i]);
			tempLabel.setHorizontalAlignment(JLabel.CENTER);
			tempLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			
			panel.add(tempLabel);
		}
		
	}
}
