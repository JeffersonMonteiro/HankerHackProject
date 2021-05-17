//Exemplo de como declarar uma exceção customizada
//e customizar a sua mensagem
public class Teste33bMyExceptionClass {

	
	public static void main(String[] args) {
		try
		{
			exceptionLauncher();
		}
		catch(MyException e)
		{
			//A chamada a printStackTrace mostra a mensagem
			//exibida pela exceção e toda a pilha de chamadas
			//percorrida pelo seu lançamento
			e.printStackTrace();
		}
	}
	
	static void exceptionLauncher() throws MyException
	{
		//instancia MyException com uma mensagem customizada
		throw new MyException("exceptionLauncher");
	}

}

class MyException extends Exception
{
	public MyException(String msg)
	{
		super("Exceção encontrada em: " + msg);
	}
	
}
