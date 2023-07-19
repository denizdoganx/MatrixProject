package model;

public class Matrix implements MatrixInterface {
	
	private double[][] matrix;
	
	private static Matrix instance = null;
	public static int rowNumber;
	public static int columnNumber;
	
	private Matrix() {
		matrix = new double[rowNumber][columnNumber];
	}
	
	
	public static Matrix getInstance() {
		if(instance == null) {
			instance = new Matrix();
		}
		return instance;
	}

	public static void killTheInstance() {
		instance = null;
	}
	
	@Override
	public double[] calculateSumOfRows() {
		double[] sumOfRows = new double[this.matrix.length];
		double tempSummation;
		for(int i = 0;i < this.matrix.length; i++) {
			tempSummation = 0;
			for(int j  = 0;j < this.matrix[0].length; j++) {
				tempSummation += this.matrix[i][j];
			}
			sumOfRows[i] = tempSummation;
		}
		return sumOfRows;
	}

	@Override
	public double[] calculateSumOfColumns() {
		double[] sumOfColumns = new double[this.matrix[0].length];
		double tempSummation;
		for(int i = 0;i < this.matrix[0].length; i++) {
			tempSummation = 0;
			for(int j  = 0;j < this.matrix.length; j++) {
				tempSummation += this.matrix[j][i];
			}
			sumOfColumns[i] = tempSummation;
		}
		return sumOfColumns;
	}

	@Override
	public double getSumOfPrimaryDiagonal() {
		double sumOfPrimaryDiagonal = 0;
		for(int i = 0;i < this.matrix.length; i++) {
			for(int j  = 0;j < this.matrix[0].length; j++) {
				if(i == j) {
					sumOfPrimaryDiagonal += this.matrix[i][j];
				}
			}
		}
		return sumOfPrimaryDiagonal;
	}

	@Override
	public double calculateDeterminantOfMatrix() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double[][] getTranspose() {
		double[][] transpose = new double[columnNumber][rowNumber];
		for(int i = 0;i < columnNumber; i++) {
			for(int j = 0;j < rowNumber; j++) {
				transpose[i][j] = matrix[j][i];
			}
		}
		
		return transpose;
	}

	@Override
	public double[][] getOriginalMatrix() {
		return this.matrix;
	}


	@Override
	public double[] calculateMinumumValuesOfEachRow() {
		double[] minumumValuesOfEachRow = new double[this.matrix.length];
		double tempMinumum;
		for(int i = 0;i < this.matrix.length; i++) {
			tempMinumum = matrix[i][0];
			for(int j  = 0;j < this.matrix[0].length; j++) {
				
				if(matrix[i][j] < tempMinumum) {
					tempMinumum = matrix[i][j];
				}
				
			}
			minumumValuesOfEachRow[i] = tempMinumum;
		}
		return minumumValuesOfEachRow;
	}


	@Override
	public double[] calculateMaximumValuesOfEachColumn() {
		double[] maximumValuesOfEachColumn = new double[this.matrix[0].length];
		double tempMaximum;
		for(int i = 0;i < this.matrix[0].length; i++) {
			tempMaximum = matrix[0][i];
			for(int j  = 0;j < this.matrix.length; j++) {
				
				if(tempMaximum < matrix[j][i]) {
					tempMaximum = matrix[j][i];
				}
				
			}
			maximumValuesOfEachColumn[i] = tempMaximum;
		}
		return maximumValuesOfEachColumn;
	}


	@Override
	public double calculateMaximumOfMinumumValuesOfEachRow() {
		double[] minumumValuesOfEachRow = new double[this.matrix.length];
		double tempMinumum, max;
		for(int i = 0;i < this.matrix.length; i++) {
			tempMinumum = matrix[i][0];
			for(int j  = 0;j < this.matrix[0].length; j++) {
				
				if(matrix[i][j] < tempMinumum) {
					tempMinumum = matrix[i][j];
				}
				
			}
			minumumValuesOfEachRow[i] = tempMinumum;
		}
		
		max = minumumValuesOfEachRow[0];
		
		for(int i = 0;i < minumumValuesOfEachRow.length; i++) {
			if(max < minumumValuesOfEachRow[i]) {
				max = minumumValuesOfEachRow[i];
			}
		}
		
		return max;
	}


	@Override
	public double calculateMinumumOfMaximumValuesOfEachColumn() {
		double[] maximumValuesOfEachColumn = new double[this.matrix[0].length];
		double tempMaximum, min;
		for(int i = 0;i < this.matrix[0].length; i++) {
			tempMaximum = matrix[0][i];
			for(int j  = 0;j < this.matrix.length; j++) {
				
				if(tempMaximum < matrix[j][i]) {
					tempMaximum = matrix[j][i];
				}
				
			}
			maximumValuesOfEachColumn[i] = tempMaximum;
		}
		
		min = maximumValuesOfEachColumn[0];
		
		for(int i = 0;i < maximumValuesOfEachColumn.length; i++) {
			if(min > maximumValuesOfEachColumn[i]) {
				min = maximumValuesOfEachColumn[i];
			}
		}
		
		return min;
	}


	@Override
	public String compareMaxminToMinmax() {
		double maxmin = calculateMaximumOfMinumumValuesOfEachRow();
		double minmax = calculateMinumumOfMaximumValuesOfEachColumn();
		String retStr = null;
		if(maxmin > minmax) {
			retStr = "maxmin " + maxmin + " > " + "minmax " + minmax;
		}
		else if(maxmin < minmax) {
			retStr = "maxmin " + maxmin + " < " + "minmax " + minmax;
		}
		else {
			retStr = "maxmin " + maxmin + " = " + "minmax " + minmax;
		}
		return retStr;
	}
	
}
