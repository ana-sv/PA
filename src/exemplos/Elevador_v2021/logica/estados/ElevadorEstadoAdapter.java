package exemplos.Elevador_v2021.logica.estados;

import exemplos.Elevador_v2021.logica.dados.ElevadorDados;

public abstract class ElevadorEstadoAdapter implements IElevadorEstado {

        private final ElevadorDados dados;

        public ElevadorEstadoAdapter(ElevadorDados dados){
            this.dados=dados;
        }

        public ElevadorDados getDados(){
        return dados;
    }

        public IElevadorEstado up(){
            return this;
        }

        public IElevadorEstado down(){
            return this;
        }

        public IElevadorEstado safetyKey() {
            return this;
        }
}
