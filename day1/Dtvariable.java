package week1.day1;

import java.util.Iterator;

public class Dtvariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Displaying the data types/variables
		int noofmonths = 12;
		boolean istodaymarch = true;
		char firstletter = 'M';
		String currentmonth = "March";
		long numberofdaysin10yrs = 3650l;
		float mileage = 17.6f;
		double longfloat = 18888.8;
		
		System.out.println("noofmonths:" + noofmonths + '\n' + "istodaymarch: " + istodaymarch + '\n' + "firstletter: " 
				+ firstletter + '\n' + "currentmonth: " + currentmonth + '\n' + "numberofdaysin10yrs: " + numberofdaysin10yrs 
				+ '\n' + "mileage:" + mileage + '\n'+ "longfloat:" + longfloat   );
		
		
		
	


		for (int i = 1; i <=10; i++) {
			System.out.println(i);
			if(i==3) {
				System.out.println(i);
			break;
			
		}
			
		}
	}
}
