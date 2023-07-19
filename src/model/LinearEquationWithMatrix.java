package model;

public class LinearEquationWithMatrix implements LinearEquationWithMatrixInterface {

	@Override
	public double[] solveByGaussElimination(double[][] matrix) {
		
		double[][] m = new double[matrix.length][matrix[0].length];
		
		
		for(int i = 0;i < m.length; i++) {
			for(int j = 0;j < m[0].length; j++) {
				m[i][j] = matrix[i][j];
			}
		}
		
		double[] unknowns = new double[m.length];
		for(int i = 0;i < m.length; i++) {
			solveOneCycle(i, i, m);
		}
		for(int i = m.length-1;i >= 0; i--) {
			for(int j = m[0].length-1;j >= 0; j--) {
				if(j < m[0].length -1) {
					if(i != j) {
						m[i][m[0].length-1] = m[i][m[0].length-1] + (m[i][j]*unknowns[j]*(-1));
					}
					else {
						break;
					}
				}
			}
			unknowns[i] = m[i][m[0].length-1];
		}
		for(int i = 0;i < unknowns.length; i++) {
			System.out.println((i+1)+ ".Result: " + unknowns[i]);
		}
		return unknowns;
	}
	
	private void solveOneCycle(int givenRow, int givenColumn, double[][] m) {
		double[] firstRow = m[givenRow];
		double[] tempRow = new double[m[0].length - givenColumn];
		double tempDivisor;
		for(int i = givenRow;i < m.length; i++) {
			
			for(int j = givenColumn;j < m[0].length; j++) {
				tempRow[j - givenColumn] = m[i][j];
			}
			if(i == givenRow) {
				if(controlOf1or0(m, givenRow, true)) {
					exchangeGivenRow(m, givenRow, givenColumn, true);
				}
				else if(controlOf1or0(m, givenRow, false)) {
					exchangeGivenRow(m, givenRow, givenColumn, false);
					divideWith1ForGivenOrder(m, givenRow);
				}
				else {
					divideWith1ForGivenOrder(m, givenRow);
				}
				firstRow = m[givenRow];
			}
			else {
				if(tempRow[0] != 0) {
					tempDivisor = firstRow[givenColumn] / tempRow[0];
					tempDivisor = tempDivisor * (-1);
					multiplyWithGivenNumberForGivenOrder(m, i, tempDivisor);
					plusWithGivenOrders(m, i, givenRow);
				}
			}
		}
	}
	
	private boolean controlOf1or0(double[][] m, int row, boolean isOne) {
		int controlValue;
		boolean flag = false;
		if(isOne) {
			controlValue = 1;
		}
		else {
			controlValue = 0;
		}
		for(int i = row;i < m.length; i++) {
			if(m[i][0] == controlValue) {
				flag = true;
			}
		}
		return flag;
	}
	
	private void exchangeGivenRow(double[][] m, int row, int column, boolean isOne) {
		double[] rowArray = m[row];
		int controlValue;
		if(isOne) {
			controlValue = 1;
			for(int i = row;i < m.length; i++) {
				if(m[i][column] == controlValue) {
					m[row] = m[i];
					m[i] = rowArray;
					break;
				}
			}
		}
		else {
			controlValue = 0;
			for(int i = row;i < m.length; i++) {
				if(m[i][column] != controlValue) {
					m[row] = m[i];
					m[i] = rowArray;
					break;
				}
			}
		}
	}
	
	private void divideWith1ForGivenOrder(double[][] m, int order) {
		double divisor;
		boolean isFoundADivisor;
		for(int i = order;i <= order; i++) {
			divisor = 0.0;
			isFoundADivisor = false;
			for(int j = 0;j < m[0].length; j++) {
				if(i == j && m[i][j] != 1) {
					divisor = m[i][j];
					isFoundADivisor = true;
				}
				if(isFoundADivisor) {
					if(divisor != 0) {
						m[i][j] = m[i][j] / divisor;
					}
				}
			}
		}
	}
	
	private void multiplyWithGivenNumberForGivenOrder(double[][] m, int order, double multiplyNumber) {
		for(int i = 0;i < m[0].length; i++) {
			m[order][i] *= multiplyNumber;
		}
	}
	
	private void plusWithGivenOrders(double[][] m, int toOrder, int fromOrder) {
		for(int i = 0;i < m[0].length; i++) {
			m[toOrder][i] = m[toOrder][i] + m[fromOrder][i];
		}
	}
}
