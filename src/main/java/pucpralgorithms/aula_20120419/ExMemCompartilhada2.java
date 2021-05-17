class Incrementador extends Thread
{
	private Contador rep;
	public Incrementador(Contador r)
	{
		rep = r;
	}
	public void run()
	{
		for (int i = 0; i < 10000; i++)
		{
			rep.incrementar();
			
			try
			{
				sleep((int)(Math.random()*4));
			
			}
			catch(InterruptedException e)
			{
				
			}
		
		}
	
	}

}




class Contador
{	
	private int contador = 0;
	public void incrementar() { contador++;}	
	public void mostrar() { System.out.println("" + contador); }
}

public class ExMemCompartilhada2
{
	public static void main (String [] args)
	{
		Contador rep = new Contador();
		Incrementador i1 = new Incrementador(rep);
		Incrementador i2 = new Incrementador(rep);
		
		i1.start();
		i2.start();
		
		try
		{
			//join -> aguarda até a thread terminar
			i1.join();
			i2.join();	
		}
		catch (InterruptedException e)
		{
			
		}
		rep.mostrar();
	
	}
}