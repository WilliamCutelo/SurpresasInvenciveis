import java.util.ArrayList;
import java.util.List;


public class Estoque {
    private List<Produto> produtoList;

    public Estoque(){
        this.produtoList = new ArrayList<>();
    }

    public void adicionarEstoque (Produto p){
        produtoList.add(p);
    }
    
    public void removerEstoque (Produto p){
        produtoList.remove(p);
    }

    public List<Produto> getProdutos(){
        return produtoList;
    }

    public Produto buscarProduto(String nome) {
        for (Produto produto : produtoList) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
}