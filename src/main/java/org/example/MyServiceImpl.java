package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MyServiceImpl implements MyService {

    @Override
    public String getSomeInfo() throws Exception {

        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ArrayList<Callable<String>> singleCalls = ExternalServiceCall.getExternalServiceCalls("Single");
        ArrayList<Callable<String>> invokeAllCalls = ExternalServiceCall.getExternalServiceCalls("InvokeALl");

        System.out.println("-------single invoke---------");
        Future<String> result1 = executorService.submit(singleCalls.get(0));
        Future<String> result2 = executorService.submit(singleCalls.get(1));
        Future<String> result3 = executorService.submit(singleCalls.get(2));

        System.out.println("-------invokeAll---------");
        List<Future<String>> invokeAllResult = executorService.invokeAll(invokeAllCalls, 3, TimeUnit.SECONDS);
        System.out.println("invokeAll time: " + (System.currentTimeMillis() - start));
        System.out.println("invokeAll response: " + (long) invokeAllResult.size());
        System.out.println("getSomeInfo time: " + (System.currentTimeMillis() - start));

        executorService.shutdown();

        return result1.get();
    }

}