package arquivos.stream;

import java.io.Serializable;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private float preco;
	private int quantidadeEstoque;

	public Produto(int id, String nome, float preco, int quantidadeEstoque) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidadeEstoque() {
		return this.quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String str = "";
		
		str = "Nome: ";
		sb.append(str);
		sb.append(this.getNome());
		sb.append("\n");
		
		str = "Preço: ";
		sb.append(str);
		sb.append(this.getPreco());
		sb.append("\n");
		
		str = "Quantidade: ";
		sb.append(str);
		sb.append(this.getQuantidadeEstoque());
		sb.append("\n");
		
		return sb.toString();
	}
	
	public String toStringFile() {
		StringBuilder sb = new StringBuilder();
		String str = "";
		
		str = "ID: ";
		sb.append(str);
		sb.append(this.getId() + ";");
		
		str = "Nome: ";
		sb.append(str);
		sb.append(this.getNome() + ";");
		
		str = "Preço: ";
		sb.append(str);
		sb.append(this.getPreco());
		
		str = "Quantidade: ";
		sb.append(str);
		sb.append(this.getQuantidadeEstoque() + ";");
		sb.append("\n");
		
		return sb.toString();
	}
}
