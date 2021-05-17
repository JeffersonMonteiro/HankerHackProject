
public class Cruzamento extends Thread
{
	private Rua ruaCruzada, ruaOrigem;
	public Cruzamento(Rua cruz, Rua orig)
	{
		ruaCruzada = cruz;
		ruaOrigem = orig;
		
	}
	public void run()
	{
		while (true)
		{
			/*
			 * Caso haja tempo suficiente, efetua o cruzamento a partir da rua de origem
			 * para dentro da outra rua (cruzada)
			 */
			if ((ruaCruzada.getTempo() + ruaCruzada.getIntervalo() > 
			System.currentTimeMillis() + 3000) /*|| (ruaCruzada.isLiberado())*/)
			{
				ruaOrigem.atravessa(ruaCruzada);				
			}
			
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
}
