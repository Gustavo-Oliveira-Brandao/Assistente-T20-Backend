package ob.gustavo.assistentet20spring.exceptions;

import java.io.Serial;

public class RegistroNaoEncontrado extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1l;

    public RegistroNaoEncontrado(Long id){
        super("Registro não encontrado");
    }


}
