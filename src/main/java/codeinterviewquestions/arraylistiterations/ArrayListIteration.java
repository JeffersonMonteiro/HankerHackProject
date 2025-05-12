package codeinterviewquestions.arraylistiterations;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIteration
{
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("20");
        list.add("30");
        list.add("40");
        System.out.println(list.size());
        System.out.println("While Loop:");

        Iterator itr = list.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("Advanced For Loop:");
        for(Object obj : list) {
            System.out.println(obj);
        }

        System.out.println("For Loop:");
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

//****************IMPORTANT*******************************
//An Array can be converted into an ArrayList by making use of the
//asList() method provided by the Array class. It is a static method that accepts List objects as a parameter.
//
//Syntax:
//
//        Arrays.asList(item)
//Whereas an ArrayList can be converted into an Array using the toArray() method of the ArrayList class.
//
//Syntax:
//
//        List_object.toArray(new String[List_object.size()])
//****************IMPORTANT*******************************

