package Java8StreamsStudy.study2;

import Java8StreamsStudy.study.Pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class MainTest3 {

    public static void main(String[] args) {

        List<Pessoa> listPessoas = new ArrayList<>();
        Pessoa pessoa5 = new Pessoa("Test5", 21);
        Pessoa pessoa2 = new Pessoa("Test2", 18);
        Pessoa pessoa1 = new Pessoa("Test1", 15);
        Pessoa pessoa4 = new Pessoa("Test4", 20);
        Pessoa pessoa3 = new Pessoa("Test3", 19);

        listPessoas.addAll(Arrays.asList(pessoa1, pessoa2,pessoa3, pessoa4, pessoa5));

//        List<String> palavras =
//                Arrays.asList("Casa do Código", "Alura", "Caelum");

        //Collections.sort(palavras);

        //palavras.sort(Comparator.naturalOrder());

        //palavras.sort(Comparator.reverseOrder());

        //palavras.forEach(p -> System.out.println(p.toString()));

        //Comparação por nomes usando o Function
//        Function<Pessoa, String> extraiNome = u -> u.getName();
//        Comparator<Pessoa> comparator=
//                Comparator.comparing(extraiNome);
//        listPessoas.sort(comparator);


        //Comparação por idade usando o Function
        //Pode dar problema de autoboxing pois devolve um integer aqui!!
//        Function<Pessoa, Integer> extraiIdade = u -> u.getAge();
//        Comparator<Pessoa> comparator=
//                Comparator.comparing(extraiIdade);
//        listPessoas.sort(comparator);


        //Comparação por idade usando o ToIntFunction
//        ToIntFunction<Pessoa> extraiIdade = u -> u.getAge();
//        Comparator<Pessoa> comparator=
//                Comparator.comparingInt(extraiIdade);
//        listPessoas.sort(comparator);

        //Versão enxuta do comparingInt
        listPessoas.sort(Comparator.comparingInt(u -> u.getAge()));

        listPessoas.forEach(p -> System.out.println("Nome: "+ p.getName() + " Idade: "+ p.getAge()));




    }
}
