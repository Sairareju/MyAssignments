package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		int totalsum = cal.getAdd(31, 55, 76);
		int mul = cal.getMul(5, 7);

		System.out.println("Sum" + totalsum);
		System.out.println("Prod" + mul);
		cal.getSub();

	}

}
