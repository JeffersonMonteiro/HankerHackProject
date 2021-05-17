import java.util.Scanner;
public class ExExcecao
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("n?");
		long n = s.nextLong();
		System.out.println("p?");
		long p = s.nextLong();
		
		long res = calculaComb(n, p);
		
		if (res == -1)
		{
			System.out.println("Erro!");	
		}
		else
		{
			System.out.println("Res = " + res);
		}	
		
	
	
	}
	
	public static long calculaComb(long n, long p)
	{
		long res1, res2, res3;	
		
		res1 = fatorial(n);
		if (res1 == -1)
		{
			//-1 -> deu erro
			return -1;	
		}
		res2 = fatorial(p);
		if (res2 == -1)
		{
			return -1;	
		}
		res3 = fatorial(n-p);
		if (res3 == -1)
		{
			return -1;	
		}		
		return res1/(res2*res3);
	}
	
	public static long fatorial(long valor)
	{
		if (valor > 30)
		{
			//-1 -> deu erro
			return -1;	
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