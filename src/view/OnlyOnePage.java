package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Matrix;

import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class OnlyOnePage extends JFrame {

	private JPanel contentPane;
	private JLabel lblText;
	private JLabel lblValue;


	/**
	 * Create the frame.
	 */
	public OnlyOnePage(int type) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 10, 10, 10));

		setContentPane(contentPane);
		
		lblText = new JLabel();
		lblText.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblText);
		
		lblValue = new JLabel("New label");
		lblValue.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblValue);
		
		Matrix instance = Matrix.getInstance();
		
		if(type == 0) {
			lblText.setText("Sum of the Primary Diagonal : ");		
			lblValue.setText(String.valueOf(instance.getSumOfPrimaryDiagonal()));
		}
		else if (type == 1) {
			lblText.setText("Determinant of the Matrix : ");		
			lblValue.setText(String.valueOf(instance.calculateDeterminantOfMatrix()));
		}
		else if(type == 2) {
			lblText.setText("The Maximum of Minumum Values of Each Row : ");		
			lblValue.setText(String.valueOf(instance.calculateMaximumOfMinumumValuesOfEachRow()));
		}
		else if(type == 3) {
			lblText.setText("The Minumum of Maximum Values of Each Column : ");		
			lblValue.setText(String.valueOf(instance.calculateMinumumOfMaximumValuesOfEachColumn()));
		}
		else if(type == 4) {
			lblText.setText("Comparison of Maxmin and Minmax : ");		
			lblValue.setText(instance.compareMaxminToMinmax());
		}
	}

}
