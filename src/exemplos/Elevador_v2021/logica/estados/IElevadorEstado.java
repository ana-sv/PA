package exemplos.Elevador_v2021.logica.estados;


import exemplos.Elevador_v2021.logica.ElevadorSituacao;

public interface IElevadorEstado {
        IElevadorEstado up();
        IElevadorEstado down();
        IElevadorEstado safetyKey();
        ElevadorSituacao getSituacaoAtual();
}
