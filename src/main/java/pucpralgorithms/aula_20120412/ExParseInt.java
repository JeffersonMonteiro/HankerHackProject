public class ExParseInt
{
	public static void main (String [] args)
	{
		String numero = "4632754rsre";
		try
		{
			int n = Integer.parseInt(numero);
			
			System.out.println("O pr�ximo � " + (n + 1));
		}
		catch (NumberFormatException e)
		{
			System.out.println("Ops, n�o � n�mero!");
		}
		
	}

}