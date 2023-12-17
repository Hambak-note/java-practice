package practice.whiteshiplivestudy.section10;

import java.util.Map;

public class Ex10_11 {

    public static void main(String[] args) {

        RunnableEx10_11 r = new RunnableEx10_11();
        new Thread(r).start();
        new Thread(r).start();

    }
}

class Account {
    private int balance = 1000; //private으로 선언 시 동기화 의미가 있음

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) { //메서드 동기화
        if (balance >= money ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            balance -= money;
        }
    }
}

class RunnableEx10_11 implements Runnable {
    Account acc = new Account();

    public void run() {
        while(acc.getBalance() > 0 ) {
            int money = (int)(Math.random() * 3 * 1) * 100;
            acc.withdraw(money);
            System.out.println("잔고 : " + acc.getBalance());
        }
    }
}