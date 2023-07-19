package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Matrix;

@SuppressWarnings("serial")
public class SolutionsView extends JScrollPane {

	/**
	 * Create the panel.
	 */
	private JPanel panel;
	
	public SolutionsView(double[] response) {
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(Matrix.rowNumber, 1, 10, 12));
		
		addAllSolutions(response);
		
		setViewportView(panel);
	}
	private void addAllSolutions(double[] response) {

		String unknown;
	
		for(int i = 0;i < response.length; i++) {
			unknown = "";
			unknown += "x" + (i+1) +"   =   ";
			unknown += response[i];
			JLabel rowLabel = new JLabel(unknown);
			rowLabel.setHorizontalAlignment(JLabel.CENTER);
			panel.add(rowLabel);
		}
	}
}
