public class ExThread5
{
	public static void main (String [] args)
	{
		//criar uma thread a partir da classe MinhaThread3
		MinhaThread5 mt5_1 = new MinhaThread5(1);
		MinhaThread5 mt5_2 = new MinhaThread5(2);
		
		//cada thread conhece a outra (seu "competidor")
		mt5_1.setOutra(mt5_2);
		mt5_2.setOutra(mt5_1);
		
		//aqui habilita a thread para começar a executar
		mt5_1.start();
		mt5_2.start();
		
		
	
	}


}
class MinhaThread5 extends Thread
{
	private int numero;
	private MinhaThread5 outra;
	public MinhaThread5(int numero)
	{
		this.numero = numero;
	}
	
	public void setOutra(MinhaThread5 mt)
	{
			outra = mt;
	}
	
	//Este método é obrigatório porque define o ponto de entrada da thread
	public void run()
	{		
		for (int i = 0; i < 500; i++)
		{
			System.out.println("Em " + numero + ": " + i);	
			if (i % 10 == 0)
			{
				try
				{
					//dorme por tempo aleatório ms
					sleep((int)(Math.random()*50));
				}
				catch (InterruptedException e)
				{
					System.out.println("Perdi " + numero);
					return;
				}
			}
			
		}
		
		System.out.println("Ganhei " + numero);
		//terminou antes, "mata" a outra thread
		outra.interrupt();
		
		
	}//se chegar aqui a thread é finalizada

}