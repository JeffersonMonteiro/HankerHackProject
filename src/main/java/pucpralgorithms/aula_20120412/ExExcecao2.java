import java.util.Scanner;
public class ExExcecao2
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("n?");
		long n = s.nextLong();
		System.out.println("p?");
		long p = s.nextLong();
		
		
		try
		{		
			long res = calculaComb(n, p);			
			System.out.println("Res = " + res);
		}
		catch (ValorForaDaFaixaException e)
		{
			System.out.println("Erro! Valor fora da faixa");
			System.out.println("O valor foi " + e.getValor());	
			
		}

		
	
	
	}
	
	
	//o throws neste método indica que ele propaga a exceção gerada
	//na camada inferior
	public static long calculaComb(long n, long p) throws ValorForaDaFaixaException
	{
		return fatorial(n)/(fatorial(p)*fatorial(n-p));
	}
	
	//throws -> indica que este método, sob situações excepcionais,
	//é capaz de lançar a exceção
	public static long fatorial(long valor) throws ValorForaDaFaixaException
	{
		if (valor > 30)
		{
			throw new ValorForaDaFaixaException(valor);
		}
		
		long res = 1;
		while (valor > 1)
		{
			res = res*valor;
			valor--;
		}
		return res;
	
	}



}

//Aqui criei uma classe específica para tratamento da exceção de 
//valor fora da faixa para o fatorial,derivada de Exception
class ValorForaDaFaixaException extends Exception
{
	private long valor;
	public ValorForaDaFaixaException(long valor)
	{
		this.valor = valor;
	}
	public long getValor() { return valor;}
}