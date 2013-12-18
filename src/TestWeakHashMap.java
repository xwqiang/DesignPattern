import java.util.WeakHashMap;
public class TestWeakHashMap  
{  
    @SuppressWarnings("unchecked")
	public static void main(String[] args)   
    {  
    	long start = System.currentTimeMillis();
        WeakHashMap whm = new WeakHashMap();  
        for(int i = 0;i<2000;i++){
        	whm.put(i, "test");
        }
        System.gc();  
        System.runFinalization();
        System.out.println(whm.size());
        System.out.println(whm.get(12)+" ");
        for(int i = 0 ;i< 2000;i++){
        	System.out.print(whm.get(i)+" ");
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("size"+whm.size());
        System.out.println(end- start);
        
        /*//添加三个键值对  
        //三个键都是匿名字符串对象(没有其它引用)  
        whm.put(new String("语文"),new String("良好"));  
        whm.put(new String("数学"),new String("及格"));  
        whm.put(new String("英文"),new String("中等"));  
        //添加一个键值对  
        //该Key是一个系统缓存的字符串对象  
        whm.put("java",new String("中等"));  
        //输出whm,将看到四个键值对  
        System.out.println(whm);  
        //通知系统进行垃圾回收  
        System.gc();  
        System.runFinalization();
        try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //通常情况下将只看到一个键值对  
        System.out.println(whm);  */
    }  
}  