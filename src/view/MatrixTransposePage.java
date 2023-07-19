package view;


import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MatrixTransposePage extends JFrame {

	private MatrixView contentPane;



	/**
	 * Create the frame.
	 */
	public MatrixTransposePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new MatrixView(false);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
