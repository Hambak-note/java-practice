package practice.whiteshiplivestudy.section10;

public class SimpleThreadTest {

    public static void main(String[] args) {
        Thread_1 t1 = new Thread_1();
        Thread t2 = new Thread(new Thread_2());

        t1.start();
        t2.start();
    }
}

class Thread_1 extends Thread { //상속
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(getName()); //조상인 Thread의 getName()을 호출
        }
    }
}

class Thread_2 implements Runnable { //인터페이스 구현

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());//현재 실행중인 쓰레드 반환
        }
    }
}
