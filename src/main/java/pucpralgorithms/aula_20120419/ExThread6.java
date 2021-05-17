public class ExThread6
{
	public static void main (String [] args)
	{
		//criar uma thread a partir da classe MinhaThread3
		MinhaThread6 mt6_1 = new MinhaThread6(1);
		MinhaThread6 mt6_2 = new MinhaThread6(2);
		
		mt6_1.setPriority(Thread.MIN_PRIORITY);
		mt6_2.setPriority(Thread.MAX_PRIORITY);
		
		//cada thread conhece a outra (seu "competidor")
		mt6_1.setOutra(mt6_2);
		mt6_2.setOutra(mt6_1);
		
		//aqui habilita a thread para começar a executar
		mt6_1.start();
		mt6_2.start();
		
		
	
	}


}
class MinhaThread6 extends Thread
{
	private int numero;
	private MinhaThread6 outra;
	public MinhaThread6(int numero)
	{
		this.numero = numero;
	}
	
	public void setOutra(MinhaThread6 mt)
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