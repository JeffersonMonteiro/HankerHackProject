package Java8StreamsStudy.study2;

import Java8StreamsStudy.study.Pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainTest2 {

    public static void main(String[] args) {

        List<Pessoa> listPessoas = new ArrayList<>();
        Pessoa pessoa5 = new Pessoa("Test5", 21);
        Pessoa pessoa2 = new Pessoa("Test2", 18);
        Pessoa pessoa1 = new Pessoa("Test1", 15);
        Pessoa pessoa4 = new Pessoa("Test4", 20);
        Pessoa pessoa3 = new Pessoa("Test3", 19);

        listPessoas.addAll(Arrays.asList(pessoa1, pessoa2,pessoa3, pessoa4, pessoa5));

//        Anonymous Class
//        Comparator<Pessoa> comparator = new Comparator<Pessoa>() {
//            public int compare(Pessoa p1, Pessoa p2) {
//                return p1.getName().compareTo(p2.getName());
//            }
//        };

//        Returning the comparator to be ordered
//        Comparator<Pessoa> comparator =
//                (u1, u2) -> u1.getName().compareTo(u2.getName());

      //  Collections.sort(listPessoas, comparator);

        //One Line with the order
//        Collections.sort(listPessoas,
//                (u1, u2) -> u1.getName().compareTo(u2.getName()));


        // Sort from interface List
        //listPessoas.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));


        //Interface Comparator
//        Comparator<Pessoa> comparator = Comparator.comparing(u -> u.getName());
//        listPessoas.sort(comparator);

        //Interface Comparator
        //One Line
        listPessoas.sort(Comparator.comparing(u -> u.getName()));

        listPessoas.forEach(p -> System.out.println(p.getName()));

    }
}
