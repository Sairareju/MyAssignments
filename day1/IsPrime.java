package week1.day1;

public class IsPrime {

	/*public static void main(String[] args) {
		
		
		
		for (int i=2; i<1000; i++) {
			//int n=i;
			
			if (i==2||i==3||i==5)
			{
				System.out.println(i + " " +"PrimeNumber");
			}
				
			else if (i%2==0||i%3==0||i%5==0||i%7==0)
			{
				//System.out.println(i + " " +"Not a PrimeNumber");
				continue;
			}
			/*else if (i%3==0)
			{
				//System.out.println(i + " " +"Not a PrimeNumber");
				continue;
			}
			else if (i%5==0)
			{
				//System.out.println(i + " " +"Not a PrimeNumber");
				continue;
			}
			else
			{
				System.out.println(i + " " +"PrimeNumber");
			}
			
			
			
					
		}
	}
*/
public static void main(String[] args) {
	
	int  n=100;
	for (int i = 2; i < (n-1); i++) {
		
		if (n%i==0)
		{
		System.out.println(i + " " +"PrimeNumber");
		}
	}
}
}
