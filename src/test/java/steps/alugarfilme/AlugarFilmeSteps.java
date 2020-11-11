package steps.alugarfilme;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import servicos.AluguelService;
import utils.DateUtils;

import java.util.Date;

import static validacao.Asserts.*;


public class AlugarFilmeSteps {

    Filme filme;
    TipoAluguel tipoAluguel;
    NotaAluguel notaAluguel;

    AluguelService aluguelService = new AluguelService();


    @Dado("^que o usuario queira alugar um filme com estoque (.+), aluguel (.+) e tipo de aluguel (.+)")
    public void queOUsuarioQueiraAlugarUmFilmeComEstoqueAluguelETipoDeAluguelComum(int estoque, int aluguel, String tipo) {
        filme = new Filme();
        filme.setEstoque(estoque);
        filme.setAluguel(aluguel);

        if(tipo.equals("comum")) {
            tipoAluguel = TipoAluguel.COMUM;
        } else if(tipo.equals("extendido")){
            tipoAluguel = TipoAluguel.EXTENDIDO;
        } else if(tipo.equals("semanal")) {
            tipoAluguel = TipoAluguel.SEMANAL;
        }
    }

    @Quando("o usuario fizer a locacao")
    public void oUsuarioFizerALocacao() {
        notaAluguel = aluguelService.alugar(filme, tipoAluguel);
    }

    @Então("^o preço do aluguel sera R (.+)")
    public void oPreçoDoAluguelSeraR(int precoAluguel) {
        assertEquals(precoAluguel, notaAluguel.getPreco());
    }

    @Então("^a data de entrega sera em (.+) dia")
    public void aDataDeEntregaSeraEmDia(int diaEntrega) {
        //assertEquals(DateUtils.obterDataDiferencaDias(diaEntrega), notaAluguel.getDataEntrega());
    }

    @Então("^o estoque do filme sera (.+) unidade")
    public void oEstoqueDoFilmeSeraUnidade(int estoqueFilme) {
        assertEquals(estoqueFilme, filme.getEstoque());
    }



    @Dado("^um filme com estoque de (.+) unidades")
    public void umFilmeComEstoqueDeUnidades(int estoqueFilme) {
        filme = new Filme();
        filme.setEstoque(estoqueFilme);
    }

    @Dado("^que o preço do aluguel seja R (.+)")
    public void queOPreçoDoAluguelSejaR(int precoAluguel) {
        filme.setAluguel(precoAluguel);
    }

    @Dado("^que o tipo do aluguel seja (.+)")
    public void queOTipoDoAluguelSejaComum(String tipo) {
        if(tipo.equals("comum")) {
            tipoAluguel = TipoAluguel.COMUM;
        } else if(tipo.equals("extendido")){
            tipoAluguel = TipoAluguel.EXTENDIDO;
        } else if(tipo.equals("semanal")) {
            tipoAluguel = TipoAluguel.SEMANAL;
        }
    }

    @Então("^a data de entrega sera em (.+) dias")
    public void aDataDeEntregaSeraEmDias(int dataEntrega) {

    }

    @Então("^a pontuacao sera de (.+) pontos")
    public void aPontuacaoSeraDePontos(int pontuaco) {
        assertEquals(pontuaco, notaAluguel.getPontuacao());
    }
}