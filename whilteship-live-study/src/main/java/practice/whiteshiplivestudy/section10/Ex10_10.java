package practice.whiteshiplivestudy.section10;

public class Ex10_10 {

    static long startTime = 0;

    public static void main(String[] args) {
        Thread10_10_1 th1 = new Thread10_10_1();
        Thread10_10_2 th2 = new Thread10_10_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            th1.join(); //main 쓰레드가 th1의 작업이 끝날 때까지 기다림
            th2.join(); //main 쓰레드가 th2의 작업이 끝날 때까지 기다림
        } catch (InterruptedException e) {}

        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
    }
}

class Thread10_10_1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    }
}

class Thread10_10_2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }
}
