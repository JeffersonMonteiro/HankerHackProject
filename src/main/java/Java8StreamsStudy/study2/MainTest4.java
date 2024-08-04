package Java8StreamsStudy.study2;

import Java8StreamsStudy.study.Pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class MainTest4 {

    public static void main(String[] args) {
        List<Pessoa> listPessoas = new ArrayList<>();
        Pessoa pessoa5 = new Pessoa("Test5", 21);
        Pessoa pessoa2 = new Pessoa("Test2", 18);
        Pessoa pessoa1 = new Pessoa("Test1", 15);
        Pessoa pessoa4 = new Pessoa("Test4", 20);
        Pessoa pessoa3 = new Pessoa("Test3", 19);

        listPessoas.addAll(Arrays.asList(pessoa1, pessoa2,pessoa3, pessoa4, pessoa5));

        //Using Method Function
        //listPessoas.sort(Comparator.comparingInt(Pessoa::getAge));

        //Usando a função com method Reference
        //Function<Pessoa, String> byName = Pessoa::getName;
        //listPessoas.sort(comparing(byName));

      //Compondo comparadores, eg, por idade e depois por nome
//        listPessoas.sort(Comparator.comparingInt(Pessoa::getAge)
//                .thenComparing(Pessoa::getName));

        //Com isso, todos os usuários nulos da nossa lista estarão posicionados no fim, e
        //o restante ordenado pelo nome! Há também o método estático nullsFirst.
     //   listPessoas.sort(Comparator.nullsLast(
      //          Comparator.comparing(Pessoa::getName)));

        //E se desejar ordenar por pontos, porém na ordem decrescente? Utilizamos o
        //método default reversed() no Comparator
        listPessoas.sort(Comparator.comparing(Pessoa::getAge).reversed());


        listPessoas.forEach(p -> System.out.println("Nome: "+ p.getName() + " Idade: "+ p.getAge()));
    }
}
