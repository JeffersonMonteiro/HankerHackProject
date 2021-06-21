package pucpralgorithms.aula_20120419;

import java.io.*;
public class ExRandomFile
{
	public static void main (String [] args)
	{
		try
		{
			RandomAccessFile arquivo = new RandomAccessFile(
				"dados.dat", "r");
			//s� quero ler o coeficiente, por isso vou avan�ar 4 bytes
			//para "pular" os dados do n�mero inteiro
			arquivo.seek(4);
			double coef = arquivo.readDouble();
			System.out.println(coef);
			
			arquivo.close();
			
		}
		catch (IOException e)
		{
			
		}
	
	
	
	}

}