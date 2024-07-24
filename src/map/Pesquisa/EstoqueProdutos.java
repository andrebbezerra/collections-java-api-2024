package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author andre
 */
public class EstoqueProdutos {
    //atributos
    private Map<Long , Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }
    
    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }
    
    public void exibirProduto(){
        System.out.println(estoqueProdutosMap);
    }
    
    public double calculaValorTotalEstoque(){
        double valorTotalEstoque = 0;
        if(!estoqueProdutosMap.isEmpty()){
            for(Produto p : estoqueProdutosMap.values()){
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }
    
    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()){
            for(Produto p : estoqueProdutosMap.values()){
                if(p.getPreco() > maiorPreco){
                    produtoMaisCaro = p;
                }
            }
        }
        return produtoMaisCaro;
    }
    
    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.exibirProduto();
        
        estoque.adicionarProduto(1L, "Produto A", 10, 5.6);
        estoque.adicionarProduto(2L, "Produto B", 5, 10.0);
        estoque.adicionarProduto(3L, "Produto C", 2, 15.0);
        
        estoque.exibirProduto();
        
        System.out.println("Valor total do estoque: R$ "+ estoque.calculaValorTotalEstoque());
        System.out.println("Produto mais Caro: "+ estoque.obterProdutoMaisCaro());
    }
}
