package practice.whiteshiplivestudy.section10;


import java.util.ArrayList;

class Customer implements Runnable {

    private Table table;
    private String food;

    Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while(true) {
            try { Thread.sleep(10); } catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();

            if(eatFood()) System.out.println(name + " ate a " + food);
            System.out.println(name + " failed to eat. :(");
        }
    }

    boolean eatFood() { return table.remove(food);}
}

class Cook implements Runnable {

    private Table table;

    Cook(Table table) { this.table = table;}

    @Override
    public void run() {

        while(true) {
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}

class Table{

    String[] dishNames = {"도넛", "도넛", "버거"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();
    public synchronized void add(String dish) {
        if(dishes.size() >= MAX_FOOD) return;
        dishes.add(dish);
        System.out.println("Dishes: " + dishes.toString());
    }

    public boolean remove(String dishName) {
        synchronized (this) {
            while(dishes.size()==0) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting");
                try { Thread.sleep(500);} catch (InterruptedException e) { }
            }

            for(int i = 0; i < dishes.size(); i++) {
                if(dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public int dishNum() {return dishNames.length; }
}



public class Ex10_12 {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table(); //여러 쓰레드가 공유하는 객체

        new Thread(new Cook(table), "COOK").start();
        new Thread(new Customer(table, "도넛"), "CUS1").start();
        new Thread(new Customer(table, "버거"), "CUS2").start();

        Thread.sleep(5000);
        System.exit(0);
    }
}
