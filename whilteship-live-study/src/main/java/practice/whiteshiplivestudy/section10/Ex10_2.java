package practice.whiteshiplivestudy.section10;

public class Ex10_2 {

    static long startTime = 0;

    public static void main(String[] args) {

        ThreadEx10_2_1 th1 = new ThreadEx10_2_1();
        ThreadEx10_2_2 th2 = new ThreadEx10_2_2();

        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try{
            th1.join(); //main 쓰레드가 th1의 작업이 끝날때까지 기다림
            th2.join(); //main 쓰레드가 th2의 작업이 끝날때까지 기다림
        } catch (InterruptedException e) {}

        System.out.println();
        System.out.println("소요시간: " + (System.currentTimeMillis() - Ex10_2.startTime));

    }
}

class ThreadEx10_2_1 extends Thread {
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    }
}

class ThreadEx10_2_2 extends Thread {
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }
}
