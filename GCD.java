import java.util.Scanner;

public class GCD {
	
  public static int rGcd(int a, int b) {
	  if(a>b) {
		  if(b==0) {
			  return a;
		  }
		  return rGcd(b, a%b);
	  } else {
		  if(a==0)
			  return b;
		  return rGcd(a, b%a);
	  }
	 
  }
  public static void main(String[] args) {
	  Scanner s = new Scanner(System.in);
	  System.out.println("Enter two numbers:");
	  int a = s.nextInt();
	  int b = s.nextInt();
	  s.close();
	  System.out.println("GCD of " + a + " and " + b + " is: " + rGcd(a,b));
  }
}
