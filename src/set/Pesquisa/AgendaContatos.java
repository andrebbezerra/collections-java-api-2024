/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author andre
 */
public class AgendaContatos {
    //atributos
    private Set<Contato> contatoSet;

    public AgendaContatos(Set<Contato> contatoSet) {
        this.contatoSet = new HashSet<>();
    }
    
    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }
    
    public void exibirContatos(){
        System.out.println(contatoSet);
    }
    
    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();
        for(Contato c: contatoSet){
            if(c.getNome().startsWith(nome)){
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }
    
    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for(Contato c : contatoSet){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    } 
    
    public static void main(String[] args) {

    }
}
