package threadSafe;

/**
 * Created by Administrator on 2019/3/23.
 */
public class Sychronizeds {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        //ctrl+d  复制当前行到下一行
        new Thread(threadPool).start();
        new Thread(threadPool).start();
        new Thread(threadPool).start();
        new Thread(threadPool).start();
    }
}

//方法重写 ALT+INSERT
class ThreadPool implements Runnable{
    private static int num = 0;
    @Override
    public void run() {
       synchronized (this){
           num++;
           System.out.println(Thread.currentThread().getName()+":"+num);
       }
    }
}
