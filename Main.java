import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print(" Escolha o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Escolha o preço do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Escolha a quantidade do produto: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); 
                    Produto produto = new Produto(nome, preco, quantidade);
                    estoque.adicionarEstoque(produto);
                    System.out.println("Produto adicionado com sucesso exclusivo!!");
                    break;

                case 2:
                    System.out.print("Nome do produto a remover: ");
                    String nomeRemover = scanner.nextLine();
                    Produto produtoRemover = estoque.buscarProduto(nomeRemover);
                    if (produtoRemover != null) {
                        estoque.removerEstoque(produtoRemover);
                        System.out.println("Produto removido com sucesso!");
                    } else if(produtoRemover == null) {
                        System.out.println("Produto não encontrado.");
                    }

                    break;

                case 3:
                    System.out.println("\n Produtos em estoque:");
                    for (Produto p : estoque.getProdutos()){
                        System.out.println("Nome: " + p.getNome() + ", Preço: " + p.getPreco() + ", Quantidade: " + p.getQuantidade());
                    }
                    break;

                case 4:
                    System.out.print("Nome do produto a buscar: ");
                    String nomeBuscar = scanner.nextLine();
                    Produto produtoBuscar = estoque.buscarProduto(nomeBuscar);
                    if (produtoBuscar != null) {
                        System.out.println("Produto encontrado: Nome: " + produtoBuscar.getNome() + ", Preço: " + produtoBuscar.getPreco() + ", Quantidade: " + produtoBuscar.getQuantidade());
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
       
    }
    private static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto");
        System.out.println("3. Listar produtos");
        System.out.println("4. Buscar produto");
        System.out.println("5. Sair");
    }
}