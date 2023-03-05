package week1.day1;

public class IsPrime {
	public static void main(String[] args) {
		
		int num= 2;
		boolean nonprime = false;
		for (int i = 2; i <= (num/2); i++) {
			
			if(num%i==0)
			{
				nonprime = true;
		
			}
			
		
		}
			if (nonprime==false)
			{
				System.out.println("Prime Number");
		}
			
			else
			{
				System.out.println("Non Prime Number");
			}
			
		}
		
}

