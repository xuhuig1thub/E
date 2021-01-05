package test.designepattern.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:15
 */
public class Singleton9 {

    private static final AtomicReference<Singleton9> INSTANCE = new AtomicReference<Singleton9>();

    private Singleton9() {
    }

    public static Singleton9 getInstance() {
        for (; ; ) {
            Singleton9 current = INSTANCE.get();

            if (current != null) {
                return current;
            }

            current = new Singleton9();

            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }

}
