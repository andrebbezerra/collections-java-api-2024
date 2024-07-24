package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author andre
 */
public class AgendaEventos {
    //atributos
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }
    
    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventosMap.put(data, new Evento(nome, atracao));
    }
    
    public void exibirAgenda(){
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventoTreeMap);
    }
    
    public void obterProximoEvento(){
     // Set<LocalDate> dataSet =  eventosMap.keySet();
     // Collection<Evento> values = eventosMap.values();
     //eventosMap.get(this);
     
     LocalDate dataAtual = LocalDate.now();
     LocalDate proximaData = null;
     Evento proximoEvento = null;
     Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
     for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
       if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
           proximaData = entry.getKey();
           proximoEvento = entry.getValue();
           System.out.println("O próximo evento: "+ proximoEvento + " acontecerá na data "+proximaData);
           break;
       }  
     }
     
    }
    
    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 15),"Evento 1","Atracao 1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.AUGUST, 9),"Evento 2","Atracao 2");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.JANUARY, 10),"Evento 3","Atracao 3");
        
        agendaEventos.exibirAgenda();
        
        agendaEventos.obterProximoEvento();
    }
     
}
