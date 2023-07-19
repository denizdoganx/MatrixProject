package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Matrix;

@SuppressWarnings("serial")
public class EquationsView extends JScrollPane {

	/**
	 * Create the panel.
	 */
	
	private JPanel panel;
	
	public EquationsView() {

		panel = new JPanel();
		
		panel.setLayout(new GridLayout(Matrix.rowNumber, 1, 10, 12));
		
		addAllEquations();
		
		setViewportView(panel);
	}

	private void addAllEquations() {
		String rowEquation;
		double coefficent;
		String unknown;
		double[][] m = Matrix.getInstance().getOriginalMatrix();
		for(int i = 0;i < Matrix.rowNumber; i++) {
			rowEquation = "Equation " + (i+1)+ " :            ";
			
			for(int j = 0;j < Matrix.columnNumber; j++) {

				if(Matrix.rowNumber > j) {
					coefficent = m[i][j];
					unknown = "x" + (j+1);
					rowEquation += coefficent + unknown;
					
					if(Matrix.rowNumber != j+1) {
						rowEquation += " ";
						rowEquation += "+";
						rowEquation += " ";
					}
				}
				else {
					rowEquation += " ";
					rowEquation += "=";
					rowEquation += " " + m[i][j];
				}
			}
			JLabel rowLabel = new JLabel(rowEquation);
			rowLabel.setHorizontalAlignment(JLabel.CENTER);
			panel.add(rowLabel);
		}
		
	}
}
