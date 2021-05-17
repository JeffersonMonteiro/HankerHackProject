import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Teste35PrintWriterClass {

	public static void main(String[] args) {
		
		String codigo = null;
		String nome = null;
		
		/*
		 * associa um fluxo buferizado a um fluxo de entrada de caracteres
		 * correspondente à entrada padrão (System.in)
		 * É uma alternativa ao uso de um Scanner
		 */
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		try {
			System.out.println("Digite o código do aluno:");
			codigo = br.readLine();
			System.out.println("Digite o nome do aluno:");
			nome = br.readLine();
			
		} catch (IOException e) {
			
			
			System.exit(0);
		}
		
		try {
			
			/*
			 * Aqui inicializa-se o Writer associado ao arquivo dados.txt,
			 * que vai receber o texto em formato compatível com o do 
			 * charset passado como parâmetro
			 */
			PrintWriter out = null;
			//try {
				out = new PrintWriter(new OutputStreamWriter(
						new FileOutputStream("dados.txt")));
			//} /*catch (UnsupportedEncodingException e) {
				
			//}
			out.print(codigo);
			out.print(" ");
			out.println(nome);
			
			out.close();
			
			
		} catch (FileNotFoundException e1) {
			
		}
		
		
		
			
		
	}
}


