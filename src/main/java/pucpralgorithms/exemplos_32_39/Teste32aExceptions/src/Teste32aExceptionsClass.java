import java.util.Scanner;

public class Teste32aExceptionsClass
{
	public static void main (String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o n�mero total de elementos:");
		int n = s.nextInt();
		System.out.println("Digite o n�mero de elementos de cada combina��o: ");
		int p = s.nextInt();
		
		//O bloco try cont�m o conjunto de instru��es do "caminho normal" de execu��o
		//do programa, mas que podem lan�ar uma exce��o. Caso exista um bloco catch
		//correspondente � classe da exce��o, se esta for lan�ada a execu��o � 
		//imediatamente desviada para esse bloco catch.
		try
		{
		
			int res = calculaComb(n, p);
			System.out.println("N�mero de combina��es � : " + res);
			
		}
		catch(FatorialException e)
		{
			System.out.println("Erro!");
			//printStackTrace permite visualizar o caminho da exce��o
			e.printStackTrace();		
		}
		
		
		
		/*if (res == 0)
		{
			System.out.println("Erro!");	
		}
		else
		{
			System.out.println("N�mero de combina��es � : " + res);
		}*/
	
	}
	
	//calculaComb chama fatorial, que pode lan�ar a exce��o FatorialException.
	//COmo calculaComb n�o sabe tratar a exce��o, deve declarar que ela � lan�ada
	//para a camada superior, atrav�s da declara��o throws no cabe�alho
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
	//M�todo fatorial declara que pode lan�ar a exce��o FatorialException
	public static int fatorial(int valor) throws FatorialException
	{
		if ((valor < 0) || (valor > 100))
		{
			//lan�a a exce��o e retorna imediatamente
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