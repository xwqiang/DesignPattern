package com.test.finalizergard;
public class Parent {

    public static void main(final String[] args) throws Exception {
        doIt();
        System.gc();
        Thread.sleep(5000); //  5 sec sleep
    }
    @SuppressWarnings("unused")
    private final Object guardian = new Object() {
        @Override protected void finalize() {
            doFinalize();
        }
    };

    @Override protected void finalize() {
        doFinalize();
    }

    private void doFinalize() {
        System.out.println("Finalize of class Parent");
    }

    public static void doIt() {
        Child c = new Child();
        System.out.println(c);
        
    }

}

