package Java8StreamsStudy.study;

@FunctionalInterface
public interface Validador <T> {

    boolean valida(T t);
}
