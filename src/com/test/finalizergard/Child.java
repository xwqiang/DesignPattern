package com.test.finalizergard;
class Child extends Parent {

    // Note, Child class does not call super.finalize()
    @Override protected void finalize() {
        System.out.println("Finalize of class Child");
    }

}
