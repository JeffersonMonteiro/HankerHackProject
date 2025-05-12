package designpatterns.singleton;

public class SingletonDoubleChecked {
    private static volatile SingletonDoubleChecked _instance;
    /** * Double checked locking code on Singleton
     * @return Singelton instance
     */public static SingletonDoubleChecked getInstance() {
        if (_instance == null) {
            synchronized (SingletonDoubleChecked.class) {
                if (_instance == null) {
                    _instance = new SingletonDoubleChecked();
                }
            }
        }return _instance;
    }
}
