package Exceptions.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RunTimeExceptiontest04 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dentro do ArrayIndexOutBound");
        } catch(IndexOutOfBoundsException e){
            System.out.println("Dentro do IndexOutBound");
        } catch(ArithmeticException e) {
            System.out.println("Dentro do Arithmetic");
        } catch(RuntimeException e){
            System.out.println("Dentro do RunTime");
        }

        try {
            talvezLanceException();
        } catch (SQLException | FileNotFoundException e) {
            
        }

    }

    private static void talvezLanceException() throws SQLException, FileNotFoundException{
        
    }
}
