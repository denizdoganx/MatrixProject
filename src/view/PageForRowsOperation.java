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
public class PageForRowsOperation extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	/**
	 * Create the frame.
	 */
	public PageForRowsOperation(boolean fromSummation) {

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
		panel.setLayout(new GridLayout(Matrix.rowNumber, 1, 0, 10));
		
		if(fromSummation)
			initTheInsideOfViewForSummationOperation();
		else
			initTheInsideOfViewForMinumumOperation();
	}
	
	private void initTheInsideOfViewForSummationOperation() {
		double[] retArr = Matrix.getInstance().calculateSumOfRows();
		for(int i = 0;i < Matrix.rowNumber; i++) {
			JLabel tempLabel = new JLabel("Row "+ (i + 1) + "                 " + retArr[i]);
			tempLabel.setHorizontalAlignment(JLabel.CENTER);
			tempLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			
			panel.add(tempLabel);
		}
		
	}
	
	private void initTheInsideOfViewForMinumumOperation() {
		
		double[] retArr = Matrix.getInstance().calculateMinumumValuesOfEachRow();
		for(int i = 0;i < Matrix.rowNumber; i++) {
			JLabel tempLabel = new JLabel("Minumum Value of Row "+ (i + 1) + "                 " + retArr[i]);
			tempLabel.setHorizontalAlignment(JLabel.CENTER);
			tempLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			
			panel.add(tempLabel);
		}
		
	}
}
