package Singleton;

public class SingletonUsingStaticField {
    private static final SingletonUsingStaticField INSTANCE = new SingletonUsingStaticField();

    private SingletonUsingStaticField(){ }

    public static SingletonUsingStaticField getInstance(){
        return INSTANCE;
    }
    public void show(){
        System.out.println("Singleon using static initialization in Java");
    }

    public static void main(String[] args) {
        //Here is how to access this Singleton class
        SingletonUsingStaticField.getInstance().show();
    }
}
