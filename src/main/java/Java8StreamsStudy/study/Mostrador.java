package Java8StreamsStudy.study;

import java.util.function.Consumer;

public class Mostrador implements Consumer<Pessoa> {

    @Override
    public void accept(Pessoa pessoa) {
        System.out.println(pessoa.getName());
    }
}
