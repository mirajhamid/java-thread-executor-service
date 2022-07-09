package org.example;

public class Main {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        MyService myService = new MyServiceImpl();
        String result= "";
        try {
            result = myService.getSomeInfo();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("This is the final result " + result);
        System.out.println("Main time: " + (System.currentTimeMillis() - start));
    }
}