package com.parla;

public class Main {
    public static void main(String[] args) {
        MyRunnable myRannable = new MyRunnable();
        Thread thread = new Thread(myRannable, "thread not runnable");
        System.out.println(thread.getName());

//        System.out.println(list);
    }
}

