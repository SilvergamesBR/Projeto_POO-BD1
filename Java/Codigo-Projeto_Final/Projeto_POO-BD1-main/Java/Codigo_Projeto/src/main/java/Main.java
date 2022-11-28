import br.inatel.projeto.control.DatabaseCliente;
import br.inatel.projeto.control.DatabaseCliente_Has_Unidade;
import br.inatel.projeto.control.DatabaseProduto;
import br.inatel.projeto.control.DatabaseUnidade;
import br.inatel.projeto.model.Cliente;
import br.inatel.projeto.model.Produto;
import br.inatel.projeto.model.Unidade;
import br.inatel.projeto.view.MostraCoisas;
import br.inatel.projeto.view.PedeCoisas;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int aux = 0;
        int auxPrincipal;
        float totalcompra = 0;
        Cliente cliente = null;
        Unidade lojacompra = null;
        ArrayList<Produto> carrinho = new ArrayList<Produto>();
        Produto prodTemp = null;
        ArrayList<Unidade> unidadesAcessiveis = null;
        DatabaseCliente ClienteDB = new DatabaseCliente();
        DatabaseUnidade UnidadeDB = new DatabaseUnidade();
        DatabaseCliente_Has_Unidade ConectDB = new DatabaseCliente_Has_Unidade();
        DatabaseProduto ProdDB = new DatabaseProduto();

        MostraCoisas.BemVindo();

        if (PedeCoisas.PerguntaNovo() == 1) {
            MostraCoisas.AvisoLogar();
            cliente = ClienteDB.researchCliente(PedeCoisas.PedeCPF(), PedeCoisas.PedeSenha());
            while (cliente == null) {
                MostraCoisas.AvisoLogErro();
                cliente = ClienteDB.researchCliente(PedeCoisas.PedeCPF(), PedeCoisas.PedeSenha());
            }

        } else {
            cliente = new Cliente(PedeCoisas.PedeNome(), PedeCoisas.PedeCPF(), PedeCoisas.PedeGenero(), PedeCoisas.PedeSenha());
            ClienteDB.insertCliente(cliente);
            String nomeUnid = PedeCoisas.PedeUnidade(unidadesAcessiveis);
            ConectDB.insertCliente_Has_Unidade(cliente, UnidadeDB.researchUnidadeID(nomeUnid));
            unidadesAcessiveis = UnidadeDB.researchUnidade(cliente);
        }
        unidadesAcessiveis = UnidadeDB.researchUnidade(cliente);

        auxPrincipal = PedeCoisas.PerguntaPrincipal();
        while (auxPrincipal != 4) {
            if (auxPrincipal == 0) {
                if (unidadesAcessiveis.size() < 4) {
                    aux = PedeCoisas.PerguntaNovaUnid();
                    while (aux == 0) {
                        String nomeUnid = PedeCoisas.PedeUnidade(unidadesAcessiveis);
                        ConectDB.insertCliente_Has_Unidade(cliente, UnidadeDB.researchUnidadeID(nomeUnid));
                        unidadesAcessiveis = UnidadeDB.researchUnidade(cliente);
                        aux = PedeCoisas.PerguntaNovaUnid();
                    }
                    unidadesAcessiveis = UnidadeDB.researchUnidade(cliente);
                }
            }
            else if (auxPrincipal == 1) {
                aux = 0;
                while (aux == 0) {
                    lojacompra = PedeCoisas.PedeUnidadeCompra(unidadesAcessiveis);
                    prodTemp = PedeCoisas.PedeProduto(lojacompra.getProdutos());
                    prodTemp.setQuantidade(PedeCoisas.PedeQuantidade(prodTemp));
                    carrinho.add(prodTemp);
                    aux = PedeCoisas.PerguntaContComp();
                }
            }
            else if (auxPrincipal == 2){
                ClienteDB.updateCliente(cliente,PedeCoisas.PedeNovaSenha());
                MostraCoisas.AvisoSenha();
            }
            else if (auxPrincipal == 3){
                ClienteDB.deleteCliente(cliente);
                MostraCoisas.AvisoDeletado();
                break;
            }
            auxPrincipal = PedeCoisas.PerguntaPrincipal();
        }

        for (Produto produto : carrinho) {
            totalcompra += (produto.getValor() * produto.getQuantidade());
        }
        ProdDB.updateCarrinho(carrinho);
        MostraCoisas.MostraTotal(totalcompra);
    }
}
