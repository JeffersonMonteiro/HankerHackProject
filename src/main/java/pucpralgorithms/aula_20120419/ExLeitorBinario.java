import java.io.*;
public class ExLeitorBinario
{
	public static void main (String [] args)
	{
		//Escrever dados do aluno: 
		//código -> int
		//coeficiente de rendimento -> double (0.0 a 1.0)
		try
		{
				//Aqui um exemplo de combinação de funcionalidades de fluxos diferentes -> fluxo de primitivo para byte + fluxo de byte para arquivo
				DataInputStream entrada = new DataInputStream(new FileInputStream("dados.dat"));
				
				int codigo;
				double coef;
				
				codigo = entrada.readInt();
				coef = entrada.readDouble();
				
				System.out.println("codigo = " + codigo);
				System.out.println("coef = " + coef);
				
				entrada.close();
		
		}
		catch (IOException e)
		{
		
		}
		
	
	
	}

}