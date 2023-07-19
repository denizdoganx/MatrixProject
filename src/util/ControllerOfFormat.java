package util;

public class ControllerOfFormat {

	
	public static boolean numberControl(String number) {
		
		int charNum;
		boolean flag = true;
		for(int i = 0;i < number.length(); i++) {
		
			charNum = (int) number.charAt(i);
			
			if(charNum < 48 || charNum > 57) {
				flag = false;
			}
		}
		
		return flag;
	}
	
	public static boolean isItJustZero(String number) {
		
		int counter = 0;
		for(int i = 0;i < number.length(); i++) {
		
			if(number.charAt(i) == '0') {
				counter++;
			}
		}
		
		return counter < number.length();
		
	}
	
	public static boolean isItDouble(String number) {
		try {
			Double.valueOf(number);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
