import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Teste37TokenizerClass {

	public static void main(String[] args) {
		
		String read_str = null;
		String codigo = null;
		String nome = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("dados.txt"));
			
			while ((read_str = br.readLine()) != null)
			{
				//Associa-se um tokenizer à string com um espaço 
				//como separador
				StringTokenizer st = new StringTokenizer(read_str, " ");
				codigo = st.nextToken();
				nome = st.nextToken();
				System.out.println("Registro lido:");
				System.out.println("Nome: " + nome);
				System.out.println("Codigo: " + codigo);
				//System.out.println(codigo + " " + nome);
				
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
