package com.thread.daemon;
import static java.util.concurrent.TimeUnit.*;  
public class DaemonTest {  
    public static void main(String[] args) throws InterruptedException {  
        Runnable r = new Runnable() {  
            public void run() {  
                for (int time = 10; time > 0; --time) {  
                    System.out.println("Time #" + time);  
                    try {  
                        SECONDS.sleep(1);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        };  
          
        Thread t = new Thread(r);  
        t.setDaemon(false);  // 主线程（main）等待两秒钟 ，主线程结束后 daemon线程也被销毁
        t.start();  
          
        System.out.println("Main thread waiting...");  
        SECONDS.sleep(2);  
        System.out.println("Main thread exited.");  
    }  
}  