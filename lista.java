public class LinkedList {
    
    private No lista;
    
    private class No {
        int valor;
        No proximo;
        
        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
    
    public void inserirInicio(int valor) {
        No novo = new No(valor);
        
        if (lista == null) {
            lista = novo;
        } else {
            novo.proximo = lista;
            lista = novo;
        }
    }
    
    public void inserirMeio(int valor, int posicao) {
        No novo = new No(valor);
        
        if (lista == null) {
            lista = novo;
        } else {
            No atual = lista;
            int count = 1;
            
            while (count < posicao - 1 && atual.proximo != null) {
                atual = atual.proximo;
                count++;
            }
            
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
    }
    
    public void inserirFim(int valor) {
        No novo = new No(valor);
        
        if (lista == null) {
            lista = novo;
        } else {
            No atual = lista;
            
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            
            atual.proximo = novo;
        }
    }
    
    public void inserirOrdenado(int valor) {
        No novo = new No(valor);
        
        if (lista == null) {
            lista = novo;
        } else if (valor <= lista.valor) {
            novo.proximo = lista;
            lista = novo;
        } else {
            No atual = lista;
            
            while (atual.proximo != null && atual.proximo.valor < valor) {
                atual = atual.proximo;
            }
            
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
    }
    
    public void imprimir() {
        No atual = lista;
        
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        
        lista.inserirInicio(8);
        lista.inserirInicio(5);
        lista.inserirFim(10);
        lista.inserirMeio(9, 2);
        lista.inserirOrdenado(1);
        
        lista.imprimir();
    }
}