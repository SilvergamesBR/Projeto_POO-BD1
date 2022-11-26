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
        float totalcompra =0;
        Cliente cliente = null;
        Unidade lojacompra = null;
        ArrayList<Produto> carrinho = new ArrayList<Produto>();
        Produto prodTemp = null;
        ArrayList<Unidade> unidadesAcessiveis;
        DatabaseCliente ClienteDB = new DatabaseCliente();
        DatabaseUnidade UnidadeDB = new DatabaseUnidade();
        DatabaseCliente_Has_Unidade ConectDB = new DatabaseCliente_Has_Unidade();
        DatabaseProduto ProdDB = new DatabaseProduto();

        MostraCoisas.BemVindo();

        if (PedeCoisas.PerguntaNovo() == 1 ){
            MostraCoisas.AvisoLogar();
            cliente = ClienteDB.researchCliente(PedeCoisas.PedeCPF(), PedeCoisas.PedeSenha());
            while(cliente == null){
                MostraCoisas.AvisoLogErro();
                cliente = ClienteDB.researchCliente(PedeCoisas.PedeCPF(), PedeCoisas.PedeSenha());
            }
        }else{
            cliente= new Cliente(PedeCoisas.PedeNome(),PedeCoisas.PedeCPF(),PedeCoisas.PedeGenero(),PedeCoisas.PedeSenha());
            ClienteDB.insertCliente(cliente);
        }
        unidadesAcessiveis = UnidadeDB.researchUnidade(cliente);
        if(unidadesAcessiveis.size() < 4) {
            aux = PedeCoisas.PerguntaNovaUnid();
            while (aux == 0) {
                String nomeUnid = PedeCoisas.PedeUnidade(unidadesAcessiveis);
                ConectDB.insertCliente_Has_Unidade(cliente, UnidadeDB.researchUnidadeID(nomeUnid));
                unidadesAcessiveis = UnidadeDB.researchUnidade(cliente);
                aux = PedeCoisas.PerguntaNovaUnid();
            }
            unidadesAcessiveis = UnidadeDB.researchUnidade(cliente);
        }
        aux=0;
        while(aux == 0){
            lojacompra=PedeCoisas.PedeUnidadeCompra(unidadesAcessiveis);
            prodTemp = PedeCoisas.PedeProduto(lojacompra.getProdutos());
            prodTemp.setQuantidade(PedeCoisas.PedeQuantidade(prodTemp));
            carrinho.add(prodTemp);
            aux=PedeCoisas.PerguntaContComp();
        }

        for (Produto produto:carrinho) {
            totalcompra += (produto.getValor()*produto.getQuantidade());
        }
        ProdDB.updateCarrinho(carrinho);
        MostraCoisas.MostraTotal(totalcompra);
    }
}
