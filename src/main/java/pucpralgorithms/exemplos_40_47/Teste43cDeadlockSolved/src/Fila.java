
public class Fila extends Thread 
{
	private Rua rua;
	public Fila(Rua r)
	{
		rua = r;
		
	}
	public void run()
	{
		
		while (true)
		{
			/*
			 * enfileira novos carros na rua de acordo com um tempo aleatório
			 */
			rua.enfileira();
			rua.setTempo(System.currentTimeMillis());
			int intervalo = (int)(Math.random()*5000);
			rua.setIntervalo(intervalo);
			try {
				sleep(intervalo);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
