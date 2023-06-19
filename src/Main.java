import Sistema.SystemImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

       SystemImpl sistema=new SystemImpl();
       sistema.leerArchivo(sistema);
       sistema.menuPrincipal();

    }
}