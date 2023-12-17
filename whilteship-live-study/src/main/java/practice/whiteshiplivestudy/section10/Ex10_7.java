package practice.whiteshiplivestudy.section10;

public class Ex10_7 implements Runnable{

    static boolean autoSave = false;

    public static void main(String[] args) {

        Thread th = new Thread(new Ex10_7());
        th.setDaemon(true);
        th.start();

        for(int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println(i);

            if(i == 5) autoSave = true;
        }

    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3 * 1000); //3초마다
            } catch (InterruptedException e) {}

            //autoSave 의 값이 true이면 autoSave()를 호출
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("작업파일이 자동저장됨");
    }
}
