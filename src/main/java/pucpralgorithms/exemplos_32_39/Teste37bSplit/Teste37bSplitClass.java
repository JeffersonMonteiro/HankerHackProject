
public class Teste37bSplitClass {

	
	public static void main(String[] args) {
		
		String teste = "Um teste de split";
		/* efetua split das strings ao redor do caracter de espa�o (" ") */
		String [] str_array = teste.split("t");
		
		for (int i = 0; i < str_array.length; i++)
		{
			System.out.println(str_array[i]);
		}
		
		
		
	}

}
