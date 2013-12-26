
public class FinallyTest {
	int i = 0;
	public int foo(){
		try {
			return ++i;
		} finally{
			i=4;
		}
	}
	public int get(){
		return i;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FinallyTest t = new FinallyTest();
		int i = t.foo();
		int j = t.get();
		System.out.println(i);
		System.out.println(j);
	}

}
