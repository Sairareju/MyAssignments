package week1.day2;

public class findDuplicates {

	public static void main(String[] args) {
		int[] nums = { 2, 5, 7, 7, 5, 9, 2, 3 };

		int len = nums.length;
		// output: 2,5,7

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {

				if (nums[i] == nums[j]) {
					System.out.println("Duplicate numbers are: " + nums[i]);
				}
			}

		}

	}

}
