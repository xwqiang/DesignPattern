import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortTest {
	public static void main(String[] a){
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("d");
		list.add("c");
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
	}
}
