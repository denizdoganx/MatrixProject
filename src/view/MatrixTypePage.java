package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Matrix;
import model.MatrixType;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class MatrixTypePage extends JFrame {

	private JPanel contentPane;

	private MatrixType idetifierOfMatrixType;
	private JLabel identity;
	private JLabel scalar;
	private JLabel diagonal;
	private JLabel zeroone;
	private JLabel symmetric;
	private JLabel permutation;
	/**
	 * Create the frame.
	 */
	public MatrixTypePage() {
		
		idetifierOfMatrixType = new MatrixType();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 60, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 2, 10, 10));
		
		JLabel lblNewLabel_1 = new JLabel("Identity Matrix : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_1);
		
		identity = new JLabel("New label");
		identity.setFont(new Font("Tahoma", Font.BOLD, 22));
		identity.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(identity);
		
		JLabel lblNewLabel_3 = new JLabel("Scalar Matrix : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_3);
		
		scalar = new JLabel("New label");
		scalar.setFont(new Font("Tahoma", Font.BOLD, 22));
		scalar.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(scalar);
		
		JLabel lblNewLabel_5 = new JLabel("Diagonal Matrix : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_5);
		
		diagonal = new JLabel("New label");
		diagonal.setFont(new Font("Tahoma", Font.BOLD, 22));
		diagonal.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(diagonal);
		
		JLabel lblNewLabel = new JLabel("Zero-One Matrix : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel);
		
		zeroone = new JLabel("New label");
		zeroone.setFont(new Font("Tahoma", Font.BOLD, 22));
		zeroone.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(zeroone);
		
		JLabel lblNewLabel_7 = new JLabel("Symmetric Matrix : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_7);
		
		symmetric = new JLabel("New label");
		symmetric.setFont(new Font("Tahoma", Font.BOLD, 22));
		symmetric.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(symmetric);
		
		JLabel lblNewLabel_9 = new JLabel("Permutation Matrix : ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_9);
		
		permutation = new JLabel("New label");
		permutation.setFont(new Font("Tahoma", Font.BOLD, 22));
		permutation.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(permutation);
		
		setTheMatrixTypes();
		
	}

	private void setTheMatrixTypes() {
		
		Matrix instance = Matrix.getInstance();
		
		double[][] matrix = instance.getOriginalMatrix();
		
		if(idetifierOfMatrixType.isIdentityMatrix(matrix)) {
			identity.setText("Yes");
		}
		else {
			identity.setText("No");
		}
		
		if(idetifierOfMatrixType.isScalarMatrix(matrix)) {
			scalar.setText("Yes");
		}
		else {
			scalar.setText("No");
		}
		
		if(idetifierOfMatrixType.isDiagonalMatrix(matrix)) {
			diagonal.setText("Yes");
		}
		else{
			diagonal.setText("No");
		}
		
		if(idetifierOfMatrixType.isZeroOneMatrix(matrix)) {
			zeroone.setText("Yes");
		}
		else {
			zeroone.setText("No");
		}
		
		if(idetifierOfMatrixType.isSymmetricMatrix(matrix)) {
			symmetric.setText("Yes");
		}
		else {
			symmetric.setText("No");
		}
		
		if(idetifierOfMatrixType.isPermutationMatrix(matrix)) {
			permutation.setText("Yes");
		}
		else {
			permutation.setText("No");
		}
	}
	
}
