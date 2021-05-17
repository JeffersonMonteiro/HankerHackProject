import java.util.Scanner;

public class Teste32aExceptionsClass
{
	public static void main (String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o número total de elementos:");
		int n = s.nextInt();
		System.out.println("Digite o número de elementos de cada combinação: ");
		int p = s.nextInt();
		
		//O bloco try contém o conjunto de instruções do "caminho normal" de execução
		//do programa, mas que podem lançar uma exceção. Caso exista um bloco catch
		//correspondente à classe da exceção, se esta for lançada a execução é 
		//imediatamente desviada para esse bloco catch.
		try
		{
		
			int res = calculaComb(n, p);
			System.out.println("Número de combinações é : " + res);
			
		}
		catch(FatorialException e)
		{
			System.out.println("Erro!");
			//printStackTrace permite visualizar o caminho da exceção
			e.printStackTrace();		
		}
		
		
		
		/*if (res == 0)
		{
			System.out.println("Erro!");	
		}
		else
		{
			System.out.println("Número de combinações é : " + res);
		}*/
	
	}
	
	//calculaComb chama fatorial, que pode lançar a exceção FatorialException.
	//COmo calculaComb não sabe tratar a exceção, deve declarar que ela é lançada
	//para a camada superior, através da declaração throws no cabeçalho
	public static int calculaComb (int n, int p) throws FatorialException
	{
		/*int x1, x2, x3;
		x1 = fatorial(n);
		if (x1 == 0) return 0;//comb 0 significa erro
		x2 = fatorial(p);
		if (x2 == 0) return 0;
		x3 = fatorial(n-p);
		if (x3 == 0) return 0;
		return x1/(x2*x3);*/
		
		return fatorial(n) / (fatorial(p)* fatorial(n-p));	
	}
	//Método fatorial declara que pode lançar a exceção FatorialException
	public static int fatorial(int valor) throws FatorialException
	{
		if ((valor < 0) || (valor > 100))
		{
			//lança a exceção e retorna imediatamente
			FatorialException fe = new FatorialException();
			throw fe;
			
			
			//return 0; //fatorial 0 significa erro
		}
		
		int res = 1;
		while (valor > 1)
		{
			res = res*valor;
			valor--;	
		}	
		return res;
	}


}


class FatorialException extends Exception
{
}