package exercises.e17;
import java.net.PortUnreachableException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map.Entry;

public class Inventario implements IInventario {
    protected LocalDateTime data; 
    protected HashMap<Integer, Produto> produtos; 
                    // codigo  // produto

    public Inventario() {
        this.data = LocalDateTime.now();
        produtos = new HashMap<Integer, Produto>();
    }

    @Override
    public void addProduto(String designacao, int codigo, int preco) {
        Produto novoProduto = new Produto(designacao, preco);
        produtos.put(codigo, novoProduto);      
    }

    @Override
    public float getPreco(int codigo) {
        if( produtos.containsKey(codigo) ){
            return produtos.get(codigo).getPreco();
        }
        return 0;
    }

    @Override
    public float getPreco(String designacao) {
        int key = getCodigo(designacao);
        if ( key != 0 )
            return produtos.get(key).getPreco();
        return 0;
    }

    @Override
    public int getCodigo(String designacao) {
       for ( Entry<Integer,Produto> entry : produtos.entrySet() ){
        if ( entry.getValue().getDesignacao() == designacao )
            return entry.getKey();
        }
        return 0;
    }

    @Override
    public String getNomes() {
        String s = ""; 
        for( Produto a : produtos.values() )
            s += a.getDesignacao() + " "; 
        return s; 
    }


    
}
