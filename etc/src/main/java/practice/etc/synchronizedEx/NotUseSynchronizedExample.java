package practice.etc.synchronizedEx;

import java.util.HashSet;
import java.util.Set;

public class NotUseSynchronizedExample {

    private static int counter = 0;
    private static Set<Integer> testSet = new HashSet<>();

    public static void main(String[] args) {

        for(int i = 0; i < 200000; i++) {

            new Thread( () -> {

                    //counter 증가
                    counter++;
                    testSet.add(counter);
            }).start();
        }

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) { }

        System.out.println("Set size : " + testSet.size());
    }
}
