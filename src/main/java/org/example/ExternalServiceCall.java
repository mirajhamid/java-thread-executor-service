package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

public class ExternalServiceCall {

    //Assume create a response, have to complete 3 tasks
    public static ArrayList<Callable<String>> getExternalServiceCalls(String param) {
        //Assume
        ArrayList<Callable<String>> callables = new ArrayList<Callable<String>>();
        Random rand = new Random();
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                int sleepTime = rand.nextInt((2000 - 1) + 1) + 1;
                Thread.sleep(sleepTime);
                System.out.println(param + " Task 1 "+ sleepTime);
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                int sleepTime = rand.nextInt((2000 - 1) + 1) + 1;
                Thread.sleep(sleepTime);
                System.out.println(param + " Task 2 "+ sleepTime);
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                int sleepTime = rand.nextInt((2000 - 1) + 1) + 1;
                Thread.sleep(sleepTime);
                System.out.println(param + " Task 3 "+ sleepTime);
                return "Task 3";
            }
        });

        return callables;

    }

}