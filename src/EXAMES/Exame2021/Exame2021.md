## Resolução Exame - Época Normal 2021

# 1 
``` java
Inicio_M , MsgAa: 10 , MsgBb: 11 , MsgCa 12 , MsgAa: 13 , MsgBb: 14 , MsgAb: 15 ,MsgCb: 16 , MsgCc: 17 , Fim_M 
```
> Inicio_M , ----> print na Main
MsgAa: 10 , MsgBb: 11 , MsgCa 12 ,  ---->  " construir C "
MsgAa: 13 , MsgBb: 14 , ---> "construtir b"
MsgAb: 15 ,MsgCb: 16 ,  ----> B instance of A == true 
MsgCc: 17 ----> apos o equals 
Fim_M ----> print na Main


# 2
``` java
ler(), escrever() e increverAluno()
ler(), escrever(), cantar() e inscreverAluno()
```
> As classes que derivam de classes abstractas devem fornecer implementação para os métodos abstractos ou entao serem também consideradas abstractas. 


# 3
``` java
agua terra ar mar 
```
> f==1 »»» throw EstaExcepcao e temos *agua*  »»» throw e ( finally acontece sempre entao *terra* )  *ar*  »»»  na main  *mar*




# 4 
``` java
public class Main{
    
    public static void main(String [] args ){
        List<AnimalEstimacao> animais = new ArrayList<>();
        animais.add( new Cao() ); 
        animais.add( new Gato() );
        for( AnimalEstimacao a : animais ){
            a.produzSom();
           /* ERRO
            if( a.getEspecie().equals("Cao")){
                a.produzSom();
            }else if(a.getEspecie().equals("Gato")){
                a.produzSom();
            }*/
        }
    }

}

abstract class AnimalEstimacao{
    private String especie;
    public AnimalEstimacao(String especie){
        this.especie= especie;
    }
    public String getEspecie(){
        return especie;
    }
    public void setEspecie(String especie){
        this.especie = especie;
    }
    public void produzSom(){
    }
}

class Cao extends AnimalEstimacao{
    public Cao(){ super("Cao"); }    //ERRO: public Cao{ setEspecie("Cao");}
    
      public void ladrar(){ System.out.println("AU AU AU"); }
    @Override                                    
     public void produzSom(){ ladrar(); }
   
}

class Gato extends AnimalEstimacao{
    public Gato(){ super("Gato"); }    // ERRO: public Cao{ setEspecie("Cao");}
    public void miar(){ System.out.println("MIAU MIAU MIAU"); };
    @Override
    public void produzSom(){ miar(); }
}
```

> linhas 14 e 18 : erros na construção da classe derivada;
linhas 28 e 30 : erros nos metodos herdados, inclusao do @override 



# 5 
``` java
true true true false 
```
> ArrayList Hashcode : returns the hashCode value for THE LIST; 
HashSet HashCode: returns the hashCode value for the set and this is defined to be THE SUM of the hashCodes of the elements in the set, where the hasCode os a null element is defined to be zero. 

> Conclui-se:
    . o hashCode é definido pelo número de alunos
    . quando o número de alunos é alterado: 
    .. a coleccao1 não sofre alterações por ser uma coleção de ArrayList e os hashCode de uma ArrayList é definido pela lista e não pelos seus elementos
    .. a coleccao2 sobre alterações porque o hashCode de um hashSet depende do hashCode de cada um dos seus elementos. 

>Assim, alterando o número de alunos e consequentemente o hashCode do objecto poo : a coleccao 1 continua na mesma mas a colaccao2 já nao reconhece o objecto como equal




``` java

```