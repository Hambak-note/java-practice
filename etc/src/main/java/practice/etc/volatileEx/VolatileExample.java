package practice.etc.volatileEx;

public class VolatileExample {

    private static volatile boolean flag = false;

    public static void main(String[] args) {

        // 쓰레드 생성 및 시작
        new Thread(() -> {
            while(!flag) {
                // do some work
            }
            System.out.println("쓰레드 finished");
        }).start();

        //딜레이 후에 flag true 로 세팅
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
    }
}
