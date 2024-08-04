package Java8StreamsStudy.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainTest {

    public static void main(String[] args) {
        List<Pessoa> listPessoas = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa("Test1", 15);
        Pessoa pessoa2 = new Pessoa("Test2", 18);
        Pessoa pessoa3 = new Pessoa("Test3", 19);
        Pessoa pessoa4 = new Pessoa("Test4", 20);
        Pessoa pessoa5 = new Pessoa("Test5", 21);
        listPessoas.addAll(Arrays.asList(pessoa1, pessoa2,pessoa3, pessoa4, pessoa5));
//
//        listPessoas.forEach(u -> System.out.println(u.getAge()));
//
//        Validador<String> validadorCEP =
//                valor -> {
//                    return valor.matches("[0-9]{5}-[0-9]{3}");
//                };

  //      System.out.println(validadorCEP.valida("04101-300"));

//        Consumer<Pessoa> mostraMensagem = p -> System.out.println("Antes de imprimir");
//
//        Consumer<Pessoa> imprimeNome = p -> System.out.println(p.getName());
//
//        listPessoas.forEach(mostraMensagem.andThen(imprimeNome));

        TestPredicate(listPessoas);


    }

    private static void TestPredicate(List<Pessoa> listPessoas) {
        Predicate<Pessoa> predicado = new Predicate<Pessoa>() {
            public boolean test(Pessoa u) {
                return u.getAge() > 19;
            }
        };

        //listPessoas.removeIf(predicado);
        listPessoas.removeIf(u -> u.getAge() > 19);
        listPessoas.forEach(u -> System.out.println(u.getName()));


    }
}
