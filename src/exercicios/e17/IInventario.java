package exercicios.e17;


public interface IInventario {
    public void addProduto( String designacao, int codigo, int quantidade); 
    public float getPreco ( int codigo ); 
    public float getPreco ( String designacao );
    public int  getCodigo ( String designacao ); 
    public String getNomes(); 
}
