package commonquestions;
public class Singleton {
    private static volatile Singleton _instance;

    /**
     * Double checked locking code on Singleton
     *
     * @return Singelton instance
     */
    public static Singleton getInstance() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                if (_instance == null) {
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }
}

