package threadSafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/23.
 */
public class Volatiles2 {
    volatile int count = 0;

    void m() {
        for (int i = 0; i < 10000; i++){
            synchronized (this){
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Volatiles2 t = new Volatiles2();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "t" + i));
        }
        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
