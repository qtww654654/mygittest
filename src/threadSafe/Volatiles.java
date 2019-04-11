package threadSafe;

/**
 * Created by Administrator on 2019/3/23.
 */
public class Volatiles {
    private static volatile int num = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                num = 5;
                System.out.println(Thread.currentThread().getName()+": "+num);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+": "+num);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                num = 10;
                System.out.println(Thread.currentThread().getName()+": "+num);
            }
        }).start();
    }
}

