package br.com.williamcasa.servicodeordenacao.classes.principais;

import br.com.williamcasa.servicodeordenacao.classes.templates.TemplateDeComparacao;

public class ComparaTitulo extends TemplateDeComparacao {

	public int resultadoOrdenado(Livro livro1, Livro livro2) {
		return livro1.getTitulo().compareToIgnoreCase(livro2.getTitulo());
	}
}
