package com.test.finalizergard;

public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;
	public void isalive(){
		System.out.println("I'm still alive");
	}
	/**
	 * finalize所能做的工作，try-finally能做的更好 更及时，可以完全忘记java中有这个方法的存在
	 */
	@Override
	public void finalize() throws Throwable{
		super.finalize();
		System.out.println("finalize method executed");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}
	
	public static void main(String[] args) throws InterruptedException{
		SAVE_HOOK = new FinalizeEscapeGC();
		SAVE_HOOK = null ;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isalive();
		}else{
			System.out.println("I'm dead");
		}
		
		SAVE_HOOK = null ;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isalive();
		}else{
			System.out.println("I'm dead");
		}
	}
}	
