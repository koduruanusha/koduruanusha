package so.what;

public class Freak {
	
	private static int i =0;
	
	private static void f1() {
		// TODO Auto-generated method stub
		int j = i;
		if ( i < 3)
		{
				i++;
				f1();
			
		}
		System.out.println(j + "hello" + i);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();

	}


	
}
