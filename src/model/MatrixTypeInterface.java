package model;

public interface MatrixTypeInterface {

	boolean isIdentityMatrix(double[][] matrix);
	
	boolean isScalarMatrix(double[][] matrix);
	
	boolean isDiagonalMatrix(double[][] matrix);
	
	boolean isZeroOneMatrix(double[][] matrix);
	
	boolean isSymmetricMatrix(double[][] matrix);
	
	boolean isPermutationMatrix(double[][] matrix);
}
