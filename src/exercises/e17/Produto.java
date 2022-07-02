package exercises.e17;

public class Produto {
    protected String designacao; 
    protected float preco; 

    public Produto( String designacao, float preco){
        this.designacao = designacao; 
        this.preco = preco;
    }

    public String getDesignacao(){
        return this.designacao; 
    }

    public float getPreco(){
        return this.preco;
    }

    public void setPreco( float preco){
        this.preco = preco; 
    }
    
}
