package com.company;

public class RunnableLambda {

    public static void main(String[] args) throws InterruptedException {
        /* Anonymous class implementation */
//        Runnable runnable = new Runnable() {
//
//            @Override
//            public void run() {
//                for (int i =0; i < 3; i++) {
//                    System.out.println(
//                            "Hello World from thread [" +
//                                    Thread.currentThread().getName() + "]");
//                }
//            }
//        };

        /* Lambda Expression implementation */
        Runnable runnableLambda = () -> {
            for(int i =0; i < 3; i++) {
                System.out.println(
                    "Hello World from thread [" +
                            Thread.currentThread().getName() + "]");
            }
        };

//        Thread t = new Thread(runnable);
        Thread t = new Thread(runnableLambda);
        t.start();
        t.join();
    }
}
