package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Matrix;
import util.ControllerOfFormat;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MatrixElementEntrancePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	/**
	 * Create the frame.
	 */
	public MatrixElementEntrancePage() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 864, 530);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAlignmentX(Component.RIGHT_ALIGNMENT);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(40);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Row and Column", "Element"
				}
			));
			
		model = (DefaultTableModel) table.getModel();
			
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int selectedRowIndex = MatrixElementEntrancePage.this.table.getSelectedRow();
				
				//int selectedColumnIndex = MatrixElementEntrancePage.this.table.getSelectedColumn();
				
				//Object data = MatrixElementEntrancePage.this.model.getValueAt(selectedRowIndex, selectedColumnIndex);
				
				//System.out.println(data);
				
				
				if(!MatrixElementEntrancePage.this.setItemsOfMatrix()) {
					MatrixElementEntrancePage.this.dispose();
					new MatrixInfoPage();
				}
			}
		});
		btnNewButton.setBounds(374, 596, 123, 48);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Press enter after entering new element");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(217, 666, 448, 14);
		contentPane.add(lblNewLabel);
		
		initTable();

	}
	
	private boolean setItemsOfMatrix() {
		
		Matrix matrixInstance = Matrix.getInstance();
		boolean isFoundAError = false;
		double[][] matrix = matrixInstance.getOriginalMatrix();
		
		int tableIndex = 0;
		String strNumber;
		for(int i = 0;i < Matrix.rowNumber; i++) {
			for(int j = 0;j < Matrix.columnNumber; j++) {
				strNumber = String.valueOf(this.model.getValueAt(tableIndex, 1));
				if(ControllerOfFormat.isItDouble(strNumber)) {
					matrix[i][j] = Double.valueOf(strNumber);
				}
				else {
					JOptionPane.showMessageDialog(null, (i+1)+".row " + (j+1)+".column format error found !", "Error !", JOptionPane.ERROR_MESSAGE);
					isFoundAError = true;
				}
				tableIndex++;
			}
		}
		return isFoundAError;
	}
	
	private void initTable() {
		String rowString;
		for(int i = 0;i < Matrix.rowNumber; i++) {
			
			for(int j = 0;j < Matrix.columnNumber; j++) {
				
				rowString = (i+1) + ".Row and " + (j+1) + ".Column";
				
				model.addRow(new Object[] {rowString, 0});
			}
		}
	}
}
