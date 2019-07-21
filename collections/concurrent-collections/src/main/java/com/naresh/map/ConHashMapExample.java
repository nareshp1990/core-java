package com.naresh.map;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConHashMapExample {

    private static final Map<String, AtomicInteger> conMap = new ConcurrentHashMap<>();

    public static void processRecords() {

        conMap.keySet().stream()
                .forEach(
                        city -> {
                            for (int i = 0; i < 50; i++) {

                                conMap.get(city).getAndIncrement();
                            }
                        });
    }

    public static void main(String[] args) throws InterruptedException {

        conMap.put("Vizag", new AtomicInteger(1));
        conMap.put("Hyd", new AtomicInteger(1));
        conMap.put("TPTY", new AtomicInteger(1));
        conMap.put("Delhi", new AtomicInteger(1));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Before : " + conMap);

        executorService.submit(ConHashMapExample::processRecords);
        executorService.submit(ConHashMapExample::processRecords);

        executorService.awaitTermination(15, TimeUnit.SECONDS);
        executorService.shutdown();

        System.out.println("After : " + conMap);

        Iterator<String> iterator = conMap.keySet().iterator();

        while (iterator.hasNext()) {

            String key = iterator.next();

            conMap.put(
                    "NewCity",
                    new AtomicInteger(
                            1)); // If it is not concurrent hashmap it will throw concurrent modification
            // exception
        }
    }
}
