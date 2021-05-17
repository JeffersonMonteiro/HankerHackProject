public class ExSingleton
{
	public static void main (String [] args)
	{
		///getInstance é estático, portanto deve ser chamado
		//com o nome da classe na frente
		Singleton s1 = Singleton.getInstance();
		//s2 na verdade acaba referenciando o mesmo objeto que s1 -> 
		//o getInstance() sempre retorna o mesmo objeto...
		Singleton s2 = Singleton.getInstance();
		
	}	


}


class Singleton
{
	private static Singleton eu = null;
	
	//Como a construtora é privada, não é possível instanciar os 
	//objetos diretamente de fora desta classe
	private Singleton()
	{
		//qualquer coisa....
	}
	
	public static Singleton getInstance()
	{
		if (eu == null)
		{
			eu = new Singleton();
		}
		return eu;
	}
	///
}