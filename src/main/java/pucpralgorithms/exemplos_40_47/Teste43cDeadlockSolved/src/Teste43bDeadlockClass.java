package pucpralgorithms.exemplos_40_47.Teste43cDeadlockSolved.src;

/*
 * Exemplo de deadlock.
 * Cada thread 'Fila' controla o enfileiramento de carros em uma Rua (norte ou sul),
 * ao passo que cada thread 'Cruzamento' controla a travessia de carros em um dos 
 * cruzamentos (norte para sul ou sul para norte)
 */
public class Teste43bDeadlockClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rua norte = new Rua("Norte");
		Rua sul = new Rua("Sul");
		Fila fn = new Fila(norte);
		Fila fs = new Fila(sul);
		Cruzamento cn = new Cruzamento(norte, sul);
		Cruzamento cs = new Cruzamento(sul, norte);
		
		fn.start();
		fs.start();
		cn.start();
		cs.start();

	}

}
