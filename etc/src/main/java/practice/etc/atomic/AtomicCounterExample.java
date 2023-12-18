package practice.etc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterExample {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        // 멀티 쓰레드 생성 및 시작
        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                //counter 증가
                int value = counter.incrementAndGet();
                System.out.println("Counter 값 : " + value);
            }).start();
        }
    }
}
