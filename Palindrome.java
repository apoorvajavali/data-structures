
public class Palindrome {
	public static void main(String[] args) {
		String s = "abcdacba";
		System.out.println(isPalindrome(s, 0, s.length()-1));
	}
	
	static boolean isPalindrome(String s, int i, int j) {
		if(i >= j) 
			return true;
		char[] c = s.toCharArray();
		if(c[i] != c[j])
			return false;
		return isPalindrome(s, i+1, j-1);
	}
}
