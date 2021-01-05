package test.designepattern.singleton;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:16
 */
public class Singleton8 {
    private static final ThreadLocal<Singleton8> tlSingleton = new ThreadLocal<Singleton8>() {
        @Override
        protected Singleton8 initialValue() {
            return new Singleton8();
        }
    };

    private Singleton8() {}

    public static Singleton8 getInstance() {
        return tlSingleton.get();
    }

}
