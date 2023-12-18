package practice.etc.atomic;

public class NotUserAtomicExample {

    private static Integer counter = 0;

    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                int value = counter++;
                System.out.println("Counter 값 : " + value);
            }).start();
        }
    }
}
