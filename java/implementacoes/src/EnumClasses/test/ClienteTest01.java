package EnumClasses.test;

import EnumClasses.dominio.Cliente;
import EnumClasses.dominio.TipoCliente;
import EnumClasses.dominio.TipoPagamento;
import EnumClasses.dominio.Cliente;


public class ClienteTest01 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Lula", TipoCliente.PESSOA_FISICA, TipoPagamento.CREDITO);
        Cliente cliente2 = new Cliente("Bolsonaro", TipoCliente.PESSOA_FISICA, TipoPagamento.DEBITO);
        Cliente cliente3 = new Cliente("Xi jin ping", TipoCliente.PESSOA_JURIDICA, TipoPagamento.CREDITO);

        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        System.out.println(TipoPagamento.DEBITO.calcularDesconto(100));
        TipoCliente tipoCliente = TipoCliente.tipoClientePorNomeRelatiorio("Pessoa Fisica");
        System.out.println(tipoCliente);
    }
}
