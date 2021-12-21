package arquivos.stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProdutoBean {
	Produto produto;
	Produto[] produtos;

	int id;
	String nome;
	Float preco;
	int quantidadeEstoque;

	String linha;
	FileWriter fileWriter;
	FileReader fileReader;
	BufferedReader bufferedReader;

	FileOutputStream fileOutputStream;
	ObjectOutputStream objectOutputStream;

	FileInputStream fileInputStream;
	ObjectInputStream objectInputStream;

	private static final String ERRO = "Erro: ";

	public int contarLinhas(String nomeArquivo) {
		int total = 0;

		try {
			this.fileReader = new FileReader(nomeArquivo);
			this.bufferedReader = new BufferedReader(this.fileReader);
			this.linha = this.bufferedReader.readLine();

			while (this.linha != null) {
				total++;
				this.linha = this.bufferedReader.readLine();
			}

		} catch (Exception e) {
			System.out.println(ERRO + e.getMessage());
		}
		return total;
	}

	public Produto[] lerEstoqueLinhaLinha(String nomeArquivo) {
		this.produtos = new Produto[this.contarLinhas(nomeArquivo)];

		int contador = 0;

		try {
			this.fileReader = new FileReader(nomeArquivo);
			this.bufferedReader = new BufferedReader(this.fileReader);

			this.linha = this.bufferedReader.readLine();
			String[] produtoLinha;

			while (this.linha != null) {
				produtoLinha = this.linha.split(";");
				this.id = Integer.parseInt(produtoLinha[0]);
				this.nome = produtoLinha[1];
				this.preco = Float.parseFloat(produtoLinha[2]);
				this.quantidadeEstoque = Integer.parseInt(produtoLinha[3]);
				this.produto = new Produto(this.id, this.nome, this.preco, this.quantidadeEstoque);
				this.produtos[contador++] = this.produto;
				this.linha = this.bufferedReader.readLine();
			}
			this.bufferedReader.close();

		} catch (Exception e) {
			System.out.println(ERRO + e.getMessage());
		}
		return this.produtos;
	}

	public void gravarEstoque(String nomeArquivo, Produto[] produtos) {
		try {
			this.fileOutputStream = new FileOutputStream(nomeArquivo);
			this.objectOutputStream = new ObjectOutputStream(this.fileOutputStream);
			this.objectOutputStream.writeObject(produtos);
			this.objectOutputStream.close();
		} catch (Exception e) {
			System.out.println(ERRO + e.getMessage());
		}
	}

	public Produto[] lerEstoque(String nomeArquivo) {
		try {
			this.fileInputStream = new FileInputStream(nomeArquivo);
			this.objectInputStream = new ObjectInputStream(this.fileInputStream);
			this.produtos = (Produto[]) this.objectInputStream.readObject();
			this.objectInputStream.close();
		} catch (Exception e) {
			System.out.println(ERRO + e.getMessage());
		}
		return this.produtos;
	}

	public void gravarEstoqueLinhaLinha(String nomeArquivo, Produto[] produtos) {
		try {
			this.fileWriter = new FileWriter(nomeArquivo);
			
			for (int i = 0; i < produtos.length; i++) {
				this.produto = produtos[i];
				this.fileWriter.write(this.produto.toStringFile());
			}
			this.fileWriter.close();
		} catch (Exception e) {
			System.out.println(ERRO + e.getMessage());
		}
	}
}
