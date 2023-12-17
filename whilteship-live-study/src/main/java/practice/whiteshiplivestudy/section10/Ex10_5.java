package practice.whiteshiplivestudy.section10;

import javax.swing.*;

public class Ex10_5 {

    public static void main(String[] args) {
        ThreadEx10_5 th1 = new ThreadEx10_5();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력");
        System.out.println("입력값 : " + input);
    }
}

class ThreadEx10_5 extends Thread {
    public void run() {
        for(int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception e) {}
        }
    }
}