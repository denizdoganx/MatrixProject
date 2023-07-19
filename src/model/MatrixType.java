package model;

import java.util.ArrayList;

public class MatrixType implements MatrixTypeInterface {

	
	
	@Override
	public boolean isIdentityMatrix(double[][] matrix) {
		
		boolean isIdentity;
		
		if(isDiagonalMatrix(matrix)) {
			isIdentity = true;
			for(int i = 0;i < matrix.length; i++) {
				if(matrix[i][i] != 1) {
					isIdentity = false;
				}
			}
		}
		else{
			isIdentity = false;
		}
		return isIdentity;
	}

	@Override
	public boolean isScalarMatrix(double[][] matrix) {
		
		boolean isScalar;
		
		if(isDiagonalMatrix(matrix)) {
			isScalar = true;
			double first = matrix[0][0];
			for(int i = 0;i < matrix.length; i++) {
				
				if(matrix[i][i] != first) {
					isScalar = false;
				}
			}
		}
		else {
			isScalar = false;
		}
		
		return isScalar;
	}

	@Override
	public boolean isDiagonalMatrix(double[][] matrix) {
		
		boolean isDiagonal;
		
		if(matrix.length == matrix[0].length) {
			isDiagonal = true;
			
			for(int i = 0;i < matrix.length; i++) {
				for(int j = 0;j < matrix[0].length; j++) {
					if(i != j && matrix[i][j] != 0) {
						isDiagonal = false;
					}
				}
			}
		}
		else {
			isDiagonal = false;
		}
		
		return isDiagonal;
	}

	@Override
	public boolean isZeroOneMatrix(double[][] matrix) {
		
		boolean isZeroOne;
		
		if(matrix.length == matrix[0].length) {
			isZeroOne = true;
			for(int i = 0;i < matrix.length; i++) {
				
				for(int j = 0;j < matrix[0].length; j++) {
					
					if(matrix[i][j] != 0 && matrix[i][j] != 1) {
						isZeroOne = false;
					}
				}
			}
		}
		else {
			isZeroOne = false;
		}

		
		return isZeroOne;
	}

	@Override
	public boolean isSymmetricMatrix(double[][] matrix) {
		
		boolean isSymmetric;
		
		if(matrix.length == matrix[0].length) {
			isSymmetric = true;
			double[][] transpose = Matrix.getInstance().getTranspose();
			for(int i = 0;i < matrix.length; i++) {
				for(int j = 0;j < matrix[0].length; j++) {
					if(matrix[i][j] != transpose[i][j]) {
						isSymmetric = false;
					}
				}
			}
		}
		else {
			isSymmetric = false;
		}
		return isSymmetric;
	}

	@Override
	public boolean isPermutationMatrix(double[][] matrix) {
		
		boolean isPermutation;
		
		if(isZeroOneMatrix(matrix)) {
			ArrayList<Integer> pointsX = new ArrayList<>();
			ArrayList<Integer> pointsY = new ArrayList<>();
			
			isPermutation = true;
			boolean trigger;
			
			for(int i = 0;i < matrix.length; i++) {
				trigger = false;
				for(int j = 0;j < matrix[0].length; j++) {
					
					if(matrix[i][j] == 1) {
						
						trigger = true;
						
						if(pointsX.contains(i) || pointsY.contains(j)) {
							trigger = false;
							break;
						}
						else {
							pointsX.add(i);
							pointsY.add(j);
						}
					}
					
				}
				if(!trigger) {
					isPermutation = false;
					break;
				}
			}
		}
		else {
			isPermutation = false;
		}
		return isPermutation;
	}
	


}
