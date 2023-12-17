package practice.whiteshiplivestudy.section10;

import javax.swing.*;

public class Ex10_4 {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("아무 값이나 입력.");
        System.out.println("입력값 : " + input);

        for(int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1초간 시간을 지연
            }catch (Exception e) {}
        }
    }
}
