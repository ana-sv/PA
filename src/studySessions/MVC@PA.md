# Model View Controler @ PA

### Package Model 
> classes que gerem dados e logica 
> tem uma classe Proxy, Facade ou similar que permite esconder as especificidades internas do modelo. 

### View-Controler 
> Tem as classes que iplementam os vários ecrãs da interface gráica
> Inclui os métodos createVire, registerHandlers e update 


## Main 
> Tem o método main 


### MainFX 
> Classe que deriva da classe Application do JavaFX 
> responsável por configurar pelo o menos o primeiro objeto do tipo stage 
> responsável por criar o primeiro objecto view-controler 