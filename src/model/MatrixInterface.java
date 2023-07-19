package model;

public interface MatrixInterface {
	
	double[] calculateSumOfRows();
	
	double[] calculateSumOfColumns();
	
	double getSumOfPrimaryDiagonal();
	
	double calculateDeterminantOfMatrix();
	
	double[][] getTranspose();
	
	double[][] getOriginalMatrix();
	
	double[] calculateMinumumValuesOfEachRow();
	
	double[] calculateMaximumValuesOfEachColumn();
	
	double calculateMaximumOfMinumumValuesOfEachRow();
	
	double calculateMinumumOfMaximumValuesOfEachColumn();
	
	String compareMaxminToMinmax();
}
