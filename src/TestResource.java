import com.test.util.PropUtil;


public class TestResource {
	public static void main(String[] args){
		PropUtil.load1();
		String ss = PropUtil.get("serverIp");
		System.out.println(ss+".");
	}
}
