package arquivos.stream;

public class App {

	public static void main(String[] args) {
		ProdutoBean produtoBean = new ProdutoBean();
		Produto[] produtos;
		produtos = produtoBean.lerEstoqueLinhaLinha("estoque.txt");

		System.out.println("Quantidade de produtos: " + produtos.length);
		System.out.println("==== Dados dos produtos ====");
		for (int i = 0; i < produtos.length; i++) {
			System.out.println(produtos[i]);
		}
		
		produtoBean.gravarEstoque("estoque.obj", produtos);
		
		Produto[] produtos2;
		produtos2 = produtoBean.lerEstoque("estoque.obj");
		
		Produto[] produtos3;
		produtos3 = new Produto[produtos2.length + 1];
		
		for (int i = 0; i < produtos2.length; i++) {
			produtos3[i] = produtos2[i];
		}
		
		int id = produtos2[produtos2.length - 1].getId() + 1;
		produtos3[produtos3.length - 1] = new Produto(id, "Produto d", 500.80f, 11);
		
		System.out.println("==== Produto 3 ====");
		for (int i = 0; i < produtos3.length; i++) {
			System.out.println(produtos3[i]);
		}
		
		produtoBean.gravarEstoque("estoque3.obj", produtos3);
		produtoBean.gravarEstoqueLinhaLinha("estoque3.txt", produtos3);
	}
}
