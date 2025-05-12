package designpatterns.singleton;

public class SingletonUsingStaticField {
    private static final SingletonUsingStaticField SINGLETON_USING_STATIC_FIELD = new SingletonUsingStaticField();

    private SingletonUsingStaticField(){ }

    public static SingletonUsingStaticField getInstanceStaticField(){
        return SINGLETON_USING_STATIC_FIELD;
    }
    public void show(){
        System.out.println("Singleon using static initialization in Java");
    }

    public static void main(String[] args) {
        //Here is how to access this Singleton class
        SingletonUsingStaticField.getInstanceStaticField().show();
    }
}
