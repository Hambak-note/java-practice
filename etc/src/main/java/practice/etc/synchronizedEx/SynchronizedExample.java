package practice.etc.synchronizedEx;

public class SynchronizedExample {

    private static int counter = 0;

    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {

            new Thread( () -> {
                synchronized (SynchronizedExample.class) {

                    //counter 증가
                    counter++;
                    System.out.println("Counter 값 : " + counter);
                }
            }).start();
        }
    }
}
