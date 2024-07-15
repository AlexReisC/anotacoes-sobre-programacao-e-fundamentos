package Exceptions.test;

public class RunTimeExceptionTest03 {
    public static void main(String[] args) {
        try {
            System.out.println("Abrindo arquivo");
            System.out.println("Escrevendo no arquivo");
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // bloco finally sempre executa
            System.out.println("Fechando recurso liberado pelo SO");
        }

        // também é possível:
        /* try {
            
        } finally {
            
        } */
    }
}
