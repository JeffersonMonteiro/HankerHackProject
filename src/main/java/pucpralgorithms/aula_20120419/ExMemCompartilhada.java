class Produtor extends Thread
{
	private Repositorio rep;
	public Produtor(Repositorio r)
	{
		rep = r;
	}
	public void run()
	{
		while (true)
		{
			rep.produzir();
			System.out.println("Produzi!");
			rep.mostrar();
			try
			{
				sleep((int)(Math.random()*2000));
			
			}
			catch(InterruptedException e)
			{
				
			}
		
		}
	
	}

}


class Consumidor extends Thread
{
	private Repositorio rep;
	public Consumidor(Repositorio r)
	{
		rep = r;
	}
	
	public void run()
	{
		while (true)
		{
			rep.consumir();
			System.out.println("Consumi!");
			rep.mostrar();
			try
			{
				sleep((int)(Math.random()*1000));
			
			}
			catch(InterruptedException e)
			{
				
			}
		
		}
	
	}

}

class Repositorio
{	
	private int contador = 0;
	public void produzir() { contador++;}
	public void consumir() { contador--; }
	public void mostrar() { System.out.println("" + contador); }
}

public class ExMemCompartilhada
{
	public static void main (String [] args)
	{
		Repositorio rep = new Repositorio();
		Produtor p = new Produtor(rep);
		Consumidor c = new Consumidor(rep);
		
		p.start();
		c.start();
	
	}
}