package practice.whiteshiplivestudy.section10;

public class Ex10_3 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < 300; i++)
            System.out.printf("s", new String("-"));

        System.out.print("소요시간 : " + (System.currentTimeMillis() - startTime));

        for(int i = 0; i < 300; i++)
            System.out.printf("s", new String("|"));

        System.out.print("소요시간 : " + (System.currentTimeMillis() - startTime));
    }
}
