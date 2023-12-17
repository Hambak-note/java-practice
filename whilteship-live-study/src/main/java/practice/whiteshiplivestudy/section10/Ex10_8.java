package practice.whiteshiplivestudy.section10;

public class Ex10_8 {

    public static void main(String[] args) {
        Thread10_8_1 th1 = new Thread10_8_1();
        Thread10_8_2 th2 = new Thread10_8_2();
        th1.start();
        th2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.print("<<main>>");
    }
}


class Thread10_8_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) System.out.print("-");
        System.out.println("<<th1>>");
    }
}

class Thread10_8_2 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) System.out.print("|");
        System.out.println("<<th2>>");
    }
}
