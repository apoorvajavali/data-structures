public class changePi {
	
	public String replacePi(String str) {
		  if(str.indexOf("pi") == -1){
		    return str;
		  }
		  str = replacePi(str.replace("pi", "3.14"));
		  return str;
		}
	
	public static void main(String[] args) {
		changePi c = new changePi();
		System.out.println(c.replacePi("xpix"));
	}
	
}

