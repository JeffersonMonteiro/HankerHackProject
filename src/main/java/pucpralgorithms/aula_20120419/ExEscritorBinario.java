import java.io.*;
public class ExEscritorBinario
{
	public static void main (String [] args)
	{
		//Escrever dados do aluno: 
		//código -> int
		//coeficiente de rendimento -> double (0.0 a 1.0)
		try
		{
				//Aqui um exemplo de combinação de funcionalidades de fluxos diferentes -> fluxo de primitivo para byte + fluxo de byte para arquivo
				DataOutputStream saida = new DataOutputStream(new FileOutputStream("dados.dat"));
				
				int codigo = 4362754;
				double coef = 0.81317;
				
				saida.writeInt(codigo);
				saida.writeDouble(coef);
				
				saida.close();
		
		}
		catch (IOException e)
		{
		
		}
		
	
	
	}

}