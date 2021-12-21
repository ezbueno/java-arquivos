package arquivos;

public class App {

	public static void main(String[] args) {
		Operacoes op = new Operacoes();
		op.criarArquivo("ABC");
		op.adicionarNoArquivo("AEIOU");
		op.lerLinhaArquivo();
		op.lerTodoArquivo();
	}
}
