package week1.day2;

public class Calculator {

	public int getAdd(int inpt1, int inpt2, int inp3) {
		int sum = inpt1 + inpt2 + inp3;
		return (sum);
	}

	public int getMul(int inpt1, int inpt2) {

		int result = inpt1 * inpt2;
		return (result);

	}

	public void getSub() {

		int a = 19;
		int b = 12;
		int sub = a - b;
		System.out.println("Diff" + sub);

	}
}
