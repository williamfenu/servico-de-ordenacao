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

	public List<Livro> ordenarLista() {
		TemplateDeComparacao comparavelInicial = parametrosASeguir.get(0).getComparavel();
		comparavelInicial.setOrdenador(this);
		Collections.sort(listaAOrdenar, comparavelInicial);
		return listaAOrdenar;
	}

	public List<Livro> getListaAOrdenar() {
		return Collections.unmodifiableList(listaAOrdenar);
	}

	public List<Parametro> getParametrosASeguir() {
		return Collections.unmodifiableList(parametrosASeguir);
	}

	public Ordenador getOrdenador() {

		return this;
	}
}
