package pucpralgorithms.aula_20120419;

import java.io.*;
public class ExEscreveTexto
{
	public static void main (String [] args)
	{
		try
		{
			PrintStream pw = new PrintStream("texto.txt");
			
			pw.println("Frase de teste");
			pw.println(23546.236);
			pw.println(367);
			pw.close();
			
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Erro");
		}
	
	
	}



}