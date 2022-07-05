package exemplos.Elevador_v2021.logica;

import exemplos.Elevador_v2021.logica.dados.ElevadorDados;
import exemplos.Elevador_v2021.logica.estados.IElevadorEstado;
import exemplos.Elevador_v2021.logica.estados.ResChao;

public class Elevador {
    private IElevadorEstado estado;
    private ElevadorDados dados;

    public Elevador(){
        dados=new ElevadorDados();
        estado = new ResChao(dados);
    }

    public ElevadorSituacao getSituacaoAtual(){
        return estado.getSituacaoAtual();
    }
    //funcoes up e down funcionam de maneira difierente para cada classe
    public String toString(){
        return dados.toString();
    }
    private void setEstado(IElevadorEstado estado){
        this.estado=estado;
    }

    public void up(){
        setEstado(estado.up());
    }
    public void down(){
        setEstado(estado.down());
    }
    public void safetyKey() { this.estado = estado.safetyKey(); }
}
