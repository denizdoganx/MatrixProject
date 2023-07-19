package view;

import javax.swing.JScrollPane;

import model.Matrix;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class MatrixView extends JScrollPane {

	/**
	 * Create the panel.
	 */
	private JPanel panel;
	
	
	public MatrixView(boolean isOriginalMatrix) {
		
		panel = new JPanel();

		if(isOriginalMatrix) {
			panel.setLayout(new GridLayout(Matrix.rowNumber+1, Matrix.columnNumber+1, 10, 12));
			addAllOriginalMatrixItems();
		}
		else {
			panel.setLayout(new GridLayout(Matrix.columnNumber+1, Matrix.rowNumber+1, 10, 12));
			addAllTransposeMatrixItems();
		}
		setViewportView(panel);
		
	}

	private void addAllOriginalMatrixItems() {
		
		panel.add(new JLabel());
		double[][] matrix = Matrix.getInstance().getOriginalMatrix();
		for(int i = 0;i < matrix.length+1; i++) {
			if(i != 0) {
				JLabel rowLabel = (new JLabel("Row" + i));
				rowLabel.setHorizontalAlignment(JLabel.CENTER);
				panel.add(rowLabel);
			}
			for(int j = 0;j < matrix[0].length+1; j++) {
				if(i == 0) {
					if(j != 0) {
						JLabel columnLabel = new JLabel("Column" + j);
						columnLabel.setHorizontalAlignment(JLabel.CENTER);
						panel.add(columnLabel);
					}		
				}
				else {
					if(j != 0 && i != 0) {
						JLabel elementLabel = new JLabel(String.valueOf(matrix[i-1][j-1]));
						elementLabel.setHorizontalAlignment(JLabel.CENTER);
						panel.add(elementLabel);
					}		
				}
			}	
		}
	}
	
	private void addAllTransposeMatrixItems() {
		panel.add(new JLabel());
		double[][] matrix = Matrix.getInstance().getTranspose();
		for(int i = 0;i < matrix.length+1; i++) {
			if(i != 0) {
				JLabel rowLabel = (new JLabel("Row" + i));
				rowLabel.setHorizontalAlignment(JLabel.CENTER);
				panel.add(rowLabel);
			}
			for(int j = 0;j < matrix[0].length+1; j++) {
				if(i == 0) {
					if(j != 0) {
						JLabel columnLabel = new JLabel("Column" + j);
						columnLabel.setHorizontalAlignment(JLabel.CENTER);
						panel.add(columnLabel);
					}		
				}
				else {
					if(j != 0 && i != 0) {
						JLabel elementLabel = new JLabel(String.valueOf(matrix[i-1][j-1]));
						elementLabel.setHorizontalAlignment(JLabel.CENTER);
						panel.add(elementLabel);
					}		
				}
			}	
		}
	}
}
