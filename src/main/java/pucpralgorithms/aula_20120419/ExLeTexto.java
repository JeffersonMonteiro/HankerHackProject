import java.io.*;
import java.util.*;
public class ExLeTexto
{
	public static void main (String [] args)
	{
		try
		{
			//Criando um scanner acoplado a um fluxo de entrada de 
			//arquivo -> escanear dados primitivos a partir do arquivo
			Scanner s = new Scanner(new FileInputStream("texto.txt"));
			String frase = s.nextLine();
			double d = s.nextDouble();
			int i = s.nextInt();
			
			System.out.println(frase + " " + d + " " + i);
			
			
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Erro");
		}
	
	
	}



}