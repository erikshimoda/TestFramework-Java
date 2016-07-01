package com.testframeworkdemo.step_definitions.mobile;

import static org.assertj.core.api.Assertions.assertThat;

import com.testframeworkdemo.page_object.mobile.RankingPage;

import cucumber.api.java.pt.Então;

public class RankingSteps {	
	private RankingPage rankingPage;

    public RankingSteps(RankingPage rankingPage) {
        this.rankingPage = rankingPage;
    }

	@Então("^eu visualizo no ranking o \"(.*?)\"$")
	public void eu_visualizo_no_ranking_o(String nome) {
		String texto = rankingPage.retornarLabelNomeId().getText();
		assertThat(nome).isEqualTo(texto);
	}

	@Então("^a idade \"(.*?)\"$")
	public void a_idade(String idade) {
		String texto = rankingPage.retornarLabelIdadeId().getText();
		assertThat(idade).isEqualTo(texto);
	}

	@Então("^a quantidade de pontos \"(.*?)\"$")
	public void a_quantidade_de_pontos(String qtdPontos) {
		String texto = rankingPage.retornarLabelPontosrId().getText();
		assertThat(qtdPontos).isEqualTo(texto);
	}

	@Então("^a duração \"(.*?)\"$")
	public void a_duração(String tempo) {
		String texto = rankingPage.retornarLabelTempoId().getText();
		assertThat(tempo).isEqualTo(texto);
	}

	@Então("^o QI de \"(.*?)\"$")
	public void o_QI_de(String qi) {
		String texto = rankingPage.retornarLabelQiId().getText();
		assertThat(qi).isEqualTo(texto);
	}	
}
