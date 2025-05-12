package designpatterns.singleton;

public class SingletonWithEnum {
    public static void main(String[] args) {
        //You can access this Singleton as Singleton.INSTANCE and call any method like below
        Singleton.INSTANCE.showEnum();
    }
}
