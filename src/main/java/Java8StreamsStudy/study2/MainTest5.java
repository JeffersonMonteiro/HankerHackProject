package Java8StreamsStudy.study2;

import Java8StreamsStudy.study.Pessoa;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

public class MainTest5 {

    public MainTest5() {
    }

    public static void main(String[] args) {
        //Utilizamos um Supplier sempre para criar um novo objeto a partir de seu
        //construtor default.
        Supplier<Pessoa> criadorDeUsuarios = Pessoa::new;
        Pessoa novo = criadorDeUsuarios.get();


        //Precisamos de uma interface funcional que receba tanto o que será criado, que
        //neste caso é o tipo Pessoa, como também qual argumento será passado para o
        //construtor!
        Function<String, Pessoa> criadorDeUsuariosOneParameter = Pessoa::new;
        //criar novos Pessoas invocando seu único método abstrato, o apply:
        Pessoa rodrigo = criadorDeUsuariosOneParameter.apply("Rodrigo Turini");
        Pessoa paulo = criadorDeUsuariosOneParameter.apply("Paulo Silveira");


        //criar um Pessoa usando o construtor de dois parâmetros?
        BiFunction<String, Integer, Pessoa> criadorDeUsuariosTwoParameters=
                Pessoa::new;
        //criar novos Pessoas invocando seu único método abstrato, o apply:
        Pessoa rodrigo2 = criadorDeUsuariosTwoParameters.apply("Rodrigo Turini", 50);
        Pessoa paulo2 = criadorDeUsuariosTwoParameters.apply("Paulo Silveira", 300);


        BiFunction<Integer, Integer, Integer> max = Math::max;
        ToIntBiFunction<Integer, Integer> max2 = Math::max;
        IntBinaryOperator max3 = Math::max;
    }
}
