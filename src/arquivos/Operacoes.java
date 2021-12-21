package arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Operacoes {

	public void criarArquivo(String conteudo) {
		try (FileWriter fw = new FileWriter("C:\\Cursos\\Udemy\\leitura-escrita-arquivos\\arquivo.txt")) {
			fw.write(conteudo + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adicionarNoArquivo(String conteudo) {
		try (FileWriter fw = new FileWriter("C:\\Cursos\\Udemy\\leitura-escrita-arquivos\\arquivo.txt", true)) {
			fw.write(conteudo + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lerLinhaArquivo() {
		try (FileReader fr = new FileReader("C:\\Cursos\\Udemy\\leitura-escrita-arquivos\\arquivo.txt");
				BufferedReader br = new BufferedReader(fr)) {
			String linha = br.readLine();
			System.out.println("Linha 1: " + linha);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lerTodoArquivo() {
		try (FileReader fr = new FileReader("C:\\Cursos\\Udemy\\leitura-escrita-arquivos\\arquivo.txt");
				BufferedReader br = new BufferedReader(fr)) {
			String linha = br.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
