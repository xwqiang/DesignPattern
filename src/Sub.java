import java.io.BufferedReader;
import java.io.IOException;


public class Sub extends Super{

	@Override
	public void get(BufferedReader br) {
		try {
			String str =null;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void foo(){
		get(super.br);
	}
	public static void main(String[] args){
		Sub s = new Sub();
		s.foo();
	}

}
