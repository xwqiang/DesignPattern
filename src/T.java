import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class T {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
//		System.out.println(void.class.getName());
//		System.out.println(String.class.getName());
		
		Constructor[] constructors = Class.forName("java.lang.String").getConstructors();
		
		System.out.println(constructors[0]);
		
		//new String(new StringBuffer("abc"));  
		Constructor constructor = String.class.getConstructor(StringBuffer.class);  
		String str = (String)constructor.newInstance(new StringBuffer("abc"));// *.newInstance("abc")运行时错误  
		System.out.println(str);
		//String.class获得String类的字节码  
		//String.class.getConstructor()通过字节码获得该类的相对应的构造函数  
		//constructor.newInstance()通过构造函数生成该类的对象  
		//(String) ：newInstance()返回类型为Object，多态，因此必须强制转化为String  
		    //Person p = new Chinese();  
		    //Chinese c = (Chinese)p;  
	}

}
