package threadSafe;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2019/3/23.
 */
public class CycilerBarrierDemo {
    public static void main(String[] args)throws Exception
    {
        CyclicBarrier barrier = new CyclicBarrier(5,new Runnable() {
            @Override
            public void run()
            {
                System.out.println("preparing-开始执行所有等待线程");
            }
        });
        for(int i=0;i<10;i++)
        {
            Thread.sleep(1000);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("已有"+barrier.getNumberWaiting()+"线程准备");
                    try{
                        barrier.await();
                    }catch(Exception ex) {}
                    System.out.println("execute"+Thread.currentThread());
                }
            });
            t.start();
        }
    }
}
