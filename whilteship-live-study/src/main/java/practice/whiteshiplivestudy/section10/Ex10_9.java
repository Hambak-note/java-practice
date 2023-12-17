package practice.whiteshiplivestudy.section10;

import javax.swing.*;

public class Ex10_9 {

    public static void main(String[] args) {
        Thread10_9 th = new Thread10_9();
        th.start();

        String input = JOptionPane.showInputDialog("값 입력;");
        System.out.println("input value : " + input);
        th.interrupt();
        System.out.println("isInterrupted():" + th.isInterrupted()); //true
        //아래는 static 메서드인 interrupted 호출 결과
        //interrupted는 static 메서드로 현재 main 스레드에 대해서 결과 호출
        System.out.println("interrupted : " + Thread.interrupted()); //false
    }
}


class Thread10_9 extends Thread {
    @Override
    public void run() {
        int i = 10;

        while(i!=0 && !isInterrupted()) {
            System.out.println(i--);
            for(long x=0;x<2500000000L;x++); // 시간 지연
        }
        System.out.println("카운트 종료");
    }
}