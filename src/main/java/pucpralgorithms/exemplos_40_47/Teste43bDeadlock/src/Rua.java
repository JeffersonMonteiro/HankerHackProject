
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
	public /*synchronized*/ void enfileira()
	{
		
		carros++;
		
		System.out.println("Enfileirou " + name + ", quantidade " + carros);
	}
	
	/*
	 * Faz a travessia de um carro da rua atual através da rua 
	 * indicada pelo parâmetro cruzamento
	 */
	public  void atravessa(Rua cruzamento) //cruzamento da via
	{
		
		while (cruzamento.getCarros() >= 5)
		{
			try {
				Thread.sleep(50);
				
				
			} catch (InterruptedException e) {
			}
			
		}
		
		/*
		 * Se é possível atravessar o cruzamento...
		 */
		if (cruzamento.getCarros() < 5)
		{
			if (carros > 0) 
			{
				carros--;
				System.out.println("Atravessou a partir da via " + name + ", quantidade " + carros);
				
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
