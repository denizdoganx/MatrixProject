package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MatrixResponse extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MatrixResponse(double[] response) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 764, 360);
		panel.setLayout(new GridLayout(1, 1, 10, 10));
		panel.add(new EquationsView());
		contentPane.add(panel);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 390, 764, 360);
		panel_1.setLayout(new GridLayout(1, 1, 10, 10));
		panel_1.add(new SolutionsView(response));
		contentPane.add(panel_1);
		
	}
}
