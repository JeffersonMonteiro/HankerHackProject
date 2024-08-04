/*class Shape {
    int side = 0; //Line n1

    protected int getSide() { //Line n2
        return side;
    }
}

class Square extends Shape {
    private int side = 4; //Line n3

     protected int getSide() { //Line n4
        return side;
    }
}*/


import java.io.IOException;


/*class Super {
    Super() throws RuntimeException {
        System.out.print("CARPE ");
    }
}

class Sub extends Super {
    Sub() throws IOException {
        System.out.print("DIEM ");
    }
}


class Paper {
    static String getType() { //Line n1
        return "GENERIC";
    }
}

class RuledPaper extends Paper {
    String getType() { //Line n2
        return "RULED";
    }
}*/


/*class Base {
    String msg = "INHALE"; //Line n1
}

class Derived extends Base {
    Object msg = "EXHALE"; //Line n2
}*/


/*class Base {
    public void log() throws NullPointerException {
        System.out.println("Base: log()");
    }
}

class Derived extends Base {
    public void log() throws RuntimeException {
        System.out.println("Derived: log()");
    }
}*/


class X {
    void A() {
        System.out.print("A");
    }
}


class Y extends X {
    void A() {
        System.out.print("A-");
    }

    void B() {
        System.out.print("B-");
    }

    void C() {
        System.out.print("C-");
    }
}

public class Test {
   /* private static void div(int i, int j) throws Exception {
        try {
            System.out.println(i / j);
        } catch (ArithmeticException e) {
            Exception ex = new Exception(e);
            throw ex;
        }
    }

    public static void main(String[] args) {
        try {
            div(5, 0);
        } catch (Exception e) {
            System.out.println("END");
        }
    }*/



   /* public static void main(String[] args) {
        Shape s = new Square();
        System.out.println(s.side + ":" + s.getSide());
        new Test();
    }

    Test() {
        System.out.println("TEste");
    }*/





      /*  public static void main(String[] args) throws Exception {
            String [] arr = {"1st", "2nd", "3rd", "4th", "5th"};
            String place = "faraway";
            System.out.println(arr[place.indexOf("a", 3)]); //Line n1
        }*/

/*
    public static void main(String[] args) {
        String arr1 [], arr2, arr3 = null; //Line n1
        arr1 = new String[2];
        arr1[0] = "A";
        arr1[1] = "B";
        arr2 = arr3 = arr1; //Line n2
        log(arr2); //Line n3
    }

    private static void log(String... vals) {
        for(String s : vals)
            System.out.print(s);
    }*/



   /* public static void main(String[] args) {
        int var = 3;
        String [][] arr = new String[--var][var++]; //Line n1
        arr[1][1] = "X"; //Line n2
        arr[1][2] = "Y"; //Line n3
        for(String [] arr1 : arr) {
            for(String s : arr1) {
                if(s != null)
                    System.out.print(s);
            }
        }
    }*/


   /* int i1 = 10;
    static int i2 = 20;

    private void change1(int val) {
        i1 = ++val; //Line n1
        i2 = val++; //Line n2
    }

    private static void change2(int val) {
        i1 = --val; //Line n3
        i2 = val--; //Line n4
    }*/

/*
    public interface GetSetGo {
        int count = 1; //Line n1
    }

    private static void test() throws Exception {
        throw new Exception();
    }


    static void play() throws Exception {
        throw new Exception("INJURED");
    }*/





    public static void main(String[] args) {
       /* change1(5); //Line n5
        change2(5); //Line n6
        System.out.println(i1 + i2); //Line n7*/

       /* boolean status = true;
        System.out.println(status = false || status = true | status = false);
        System.out.println(status);*/


      /*  Base obj1 = new Base(); //Line n3
        Base obj2 = new Derived(); //Line n4
        Derived obj3 = (Derived) obj2; //Line n5
        String text = obj1.msg + "-" + obj2.msg + "-" + obj3.msg; //Line n6
        System.out.println(text); //Line n7
*/


          /*  Base obj = new Derived();
            obj.log();*/


        /*int num = 10;
        if(num++ == num++) {
            System.out.println("EQUAL " + num);
        } else {
            System.out.println("NOT EQUAL " + num);
        }
*/
/*
        byte b1 = 10; //Line n1
        int i1 = b1; //Line n2
        byte b2 = (byte) i1; //Line n3
        System.out.println(b1 + i1 + b2);*/





      /*  GetSetGo [] arr = new GetSetGo[5]; //Line n2
        for(GetSetGo obj : arr) {
            obj.count++; //Line n3
        }
        System.out.println(GetSetGo.count); //Line n4*/


       /* try {
            test();
        } finally {
            System.out.println("GAME ON");
        }*/

       /* try {
            play();
            return;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        } finally {
            System.out.println("MATCH ABANDONED");
        }
        System.out.println("DONE");*/


        X obj = new Y(); //Line n1
        obj.A(); //Line n2
        ((Y) obj).B(); //Line n3
        ((Y) obj).C(); //Line n4



    }


}
