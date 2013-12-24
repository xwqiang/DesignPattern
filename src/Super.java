import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public abstract class Super {
	protected BufferedReader br ;
	private final Object guardian = new Object(){
		@Override public void finalize(){
			destroy();
		}
	};
	String txt ;
	public Super(){
		try {
			br = new BufferedReader(new FileReader("d://777.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public abstract void  get(BufferedReader br);
	@Override
	public void finalize(){
		destroy();
	}
	private void destroy() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
