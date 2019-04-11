package threadSafe;

/**
 * Created by Administrator on 2019/3/23.
 */
public class ThreadLocals {

    private static ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
        // 重写这个方法，可以修改“线程变量”的初始值，默认是null
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    //ctrl+j
    public static void main(String[] args) {
        //创建第一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                num.set(num.get()+1);
                System.out.println("一号线程中ThreadLocal变量中保存的值为：" + num.get());
            }
        }).start();

        //创建第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                num.set(num.get()+3);
                // sout  Tab
                System.out.println("二号线程中ThreadLocal变量中保存的值为:" + num.get());
            }
        }).start();

        //主线程休息  Ctrl+Alt+T
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程中ThreadLocal变量中保存的值：" + num.get());
    }
}
