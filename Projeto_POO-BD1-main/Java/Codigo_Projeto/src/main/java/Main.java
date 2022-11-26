import br.inatel.projeto.control.DatabaseCliente;
import br.inatel.projeto.model.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente cliente;
        DatabaseCliente ClienteDB = new DatabaseCliente();

        cliente = ClienteDB.researchCliente("123.123.123.02","popopipi");
        ClienteDB.deleteCliente(cliente);

    }
}
