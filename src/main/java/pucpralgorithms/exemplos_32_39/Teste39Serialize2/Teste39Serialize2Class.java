import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Teste39Serialize2Class {

	public static void main(String[] args) {
		
		
		//Cria-se o aluno 'Fulano da Silva'
		Aluno a1 = new Aluno("Fulano da Silva");
		a1.setN1(80);
		a1.setN2(72);
		
		//Cria-se duas disciplinas, 'Linguagem Java'
		//e 'Culinária moderna'
		Disciplina d1 = new Disciplina("Linguagem Java", 1);
		Disciplina d2 = new Disciplina("Culinária moderna", 1);
		
		//adiciona-se 'Fulano' às duas turmas
		d1.addAluno(a1, 0);
		d2.addAluno(a1, 0);
		
		//Mostra-se a média de ambas as turmas
		System.out.println("Média de " + d1.getNome() + ": " + d1.calculaMedia());
		System.out.println("Média de " + d2.getNome() + ": " + d2.calculaMedia());
		
		//Serializa-se os objetos. Note-se que o objeto referenciado
		//por a1 deve ser serializado UMA ÚNICA VEZ, mesmo possuindo
		//referências tanto em d1 quanto em d2
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("curso.dat"));
			
			oos.writeObject(a1);
			oos.writeObject(d1);
			oos.writeObject(d2);
			
			oos.close();
			
		} catch (FileNotFoundException e) {
		
		} catch (IOException e) {
		
		}
		
		//Aqui vamos recuperar as referências.
		
		Disciplina d1_rec, d2_rec;
		Aluno a1_rec;
		
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("curso.dat"));
			
			a1_rec = (Aluno)ois.readObject();
			d1_rec = (Disciplina)ois.readObject();
			d2_rec = (Disciplina)ois.readObject();
			
			ois.close();
			
			//Aqui altera-se a nota 2 do aluno. Se a serialização 
			//ocorreu corretamente a média das disciplinas d1 e d2
			//também deve ser alterada...
			a1_rec.setN1(60);
			
			System.out.println("Média alterada de " + d1_rec.getNome() + ": " + d1_rec.calculaMedia());
			System.out.println("Média alterada de " + d2_rec.getNome() + ": " + d2_rec.calculaMedia());
			
			
		} catch (FileNotFoundException e1) {
		
		} catch (IOException e1) {
		
		} catch (ClassNotFoundException e) {
			
		}
		
		
	}
}


class Disciplina implements Serializable
{
	Aluno [] matriculados;
	String nome;
	
	public int calculaMedia()
	{
		
		int soma = 0;
		for (int i = 0; i < matriculados.length; i++)
		{
			soma += matriculados[i].getMedia();
		}
		return soma / matriculados.length;
	}
	
	Disciplina(String nm, int n)
	{
		matriculados = new Aluno[n];
		nome = nm;
	}
	
	public boolean addAluno(Aluno a, int numero)
	{
		if (numero >= matriculados.length) return false;
		matriculados[numero] = a;
		return true;
	}
	
	public String getNome() { return nome;}
	
	
}

class Aluno implements Serializable
{
	//caso não deseje que seja serializado, declarar como transient
	//transient int n1 = 0;
	transient int n1 = 0;
	int n2 = 0;
	String nome;
	
	public int getMedia() 
	{ 
		return (n1 + n2)/2; 
	}
	
	Aluno (String n)
	{
		nome = n;
	}
	
	public void setN1(int valor)
	{
		n1 = valor;
	}
	public void setN2(int valor)
	{
		n2 = valor;
	}
	
	
}