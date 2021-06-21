package pucpralgorithms.exemplos_40_47.Teste43cDeadlockSolved.src;

public class Rua {
	
	private int carros = 0;
	private long tempo;	
	private int intervalo;	
	private boolean liberado = false;
	private String name;
	
	public Rua (String n)
	{
		name = n;
	}

	/*
	 * Enfileira carros na rua atual no aguardo pelo cruzamento
	 */
	public synchronized void enfileira()
	{
		/*
		 * O trecho do while a seguir simula uma "yellow box". Caso ele seja retirado,
		 * ocorrer� um deadlock caso uma das ruas tenha mais do que 4 carros 
		 * e a outra tamb�m chegue a 4 carros antes que a primeira tenha a oportunidade
		 * de desenfileirar algum.
		 */
		while (carros == 4)
		{
			liberado = true;
			try {
				System.out.println("Yellow box em " + name);
				wait();
				System.out.println("Avan�ando em " + name);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
		liberado = false;
		carros++;
		
		System.out.println("Enfileirou " + name + " " + carros);
	}
	
	/*
	 * Faz a travessia de um carro da rua atual atrav�s da rua 
	 * indicada pelo par�metro cruzamento
	 */
	public synchronized void atravessa(Rua cruzamento) //cruzamento da via
	{
		
		/*
		 * Se o n�mero de carros na rua que pretendemos cruzar � maior ou 
		 * igual a 5, significa que o cruzamento est� trancado.
		 * Em teoria, como h� uma yellow box na rua do cruzamento, esta 
		 * condi��o deve ser sempre falsa.
		 */
//		if (cruzamento.getCarros() >= 5)
//		{
//			try {
//				Thread.sleep(50);
//				this.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		/*
		 * Se � poss�vel atravessar o cruzamento...
		 */
		if (cruzamento.getCarros() < 5)
		{
			if (carros > 0) 
			{
				carros--;
				System.out.println("Atravessou a partir da via " + name + " " + carros);
				
				/* aqui ocorre a libera��o de quem 
				* est� esperando atr�s da yellow box nesta rua
				*	(chamada de wait() no m�todo enfileira, que foi efetuada
				*  por uma das threads da classe Fila)
				*/ 
				notify();
				
				/*
				 * Se havia algum carro esperando para cruzar na outra rua, pelo fato de termos
				 * mais do que 4 carros enfileirados aqui, ent�o notificamos a outra thread.
				 * Teoricamente este trecho n�o deveria ser necess�rio, dado que esta
				 * rua nunca deveria ter mais do que 4 carros enfileirados em 
				 * fun��o de existir uma yellow box.
				 */
//				if (carros == 4)
//				{
//					cruzamento.notify();
//				}
			}
			
		
		}		
	}
	
	
	public void setCarros(int carros) {
		this.carros = carros;
	}
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

	public int getCarros() {
		return carros;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public boolean isLiberado() {
		return liberado;
	}

	public String getName() {
		return name;
	}

	public long getTempo() {
		return tempo;
	}

}
