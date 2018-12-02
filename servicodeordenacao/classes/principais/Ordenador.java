package br.com.williamcasa.servicodeordenacao.classes.principais;

import java.util.Collections;
import java.util.List;

import br.com.williamcasa.servicodeordenacao.classes.templates.TemplateDeComparacao;

public class Ordenador {

	private List<Livro> listaAOrdenar;
	private List<Parametro> parametrosASeguir;

	public Ordenador(List<Livro> list, List<Parametro> param) {
		this.listaAOrdenar = list;
		this.parametrosASeguir = param;
	}

	public List<Livro> ordenar() {
		TemplateDeComparacao comparavelInicial = parametrosASeguir.get(0).getComparavel();
		comparavelInicial.setOrdenador(this);
		Collections.sort(listaAOrdenar, comparavelInicial);
		return listaAOrdenar;
	}

	public void aceitaComparador(TemplateDeComparacao comparador) {
		if (comparador.getPosicaoAtualDeComparacao() < parametrosASeguir.size()) {

			int proximaPosicao = comparador.getPosicaoAtualDeComparacao() + 1;
			comparador.setProximo(parametrosASeguir.get(proximaPosicao).getComparavel());
		}
	}

	public List<Livro> getListaAOrdenar() {
		return listaAOrdenar;
	}

	public List<Parametro> getParametrosASeguir() {
		return parametrosASeguir;
	}

	public Ordenador getOrdenador() {

		return this;
	}
}
