package practice.whiteshiplivestudy.section10;

public class Ex10_6 {

    public static void main(String[] args) {

        Thread10_6_1 th1 = new Thread10_6_1();
        Thread10_6_2 th2 = new Thread10_6_2();

        th2.setPriority(7);

        System.out.println("Priority of th1(-) : " + th1.getPriority());
        System.out.println("Priority of th2(|) : " + th2.getPriority());

        th1.start();
        th2.start();
    }
}

class Thread10_6_1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.print("-");
            for(int x = 0; x < 10000000; x++);
        }
    }
}

class Thread10_6_2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.print("|");
            for(int x = 0; x < 10000000; x++);
        }
    }
}