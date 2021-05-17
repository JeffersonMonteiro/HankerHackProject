import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


 
public class Teste36ZipInputClass {

	public static void main(String[] args) {
		
		//Para aceitar as entradas do teclado
		String entrada;
		Scanner s = new Scanner(System.in);
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		
		String zip_input_str = null;
		ZipInputStream zip = null;
		try {
			
			//Abrir o fluxo de dados zipados a partir do arquivo zipado.zip
			zip = new ZipInputStream(new FileInputStream("zipado.zip"));
		} catch (FileNotFoundException e) {
			
			System.out.println("Arquivo não encontrado");
			System.exit(0);
		}
		
		ZipEntry zip_entry;
		
		try {
			//Aqui cria-se um Reader para ler o conteúdo de
			//cada uma das entradas do arquivo ZIP
			BufferedReader zip_input = new BufferedReader(new InputStreamReader(zip));
			
			//Nesta linha obtém-se a próxima entrada do arquivo ZIP
			//As leituras subsequentes do fluxo zip_input retornarão o conteúdo
			//da entrada atual
			while ((zip_entry = zip.getNextEntry())!= null)
			{
				System.out.println();
				System.out.println("Arquivo zipado: " + zip_entry.getName());
				System.out.println("Pressione qualquer tecla para mostrar o arquivo...");
				entrada = s.nextLine();
				while ((zip_input_str = zip_input.readLine()) != null)
				{
					System.out.println(zip_input_str);
					
				}
				
				//fecha a entrada atual, permitindo que a leitura a partir do fluxo
				//obtenha os dados da próxima entrada
				zip.closeEntry();
				
			}
		} catch (IOException e1) {
			
			System.out.println("Error");
			System.exit(0);
		}
		
		
		
		
	}
}
