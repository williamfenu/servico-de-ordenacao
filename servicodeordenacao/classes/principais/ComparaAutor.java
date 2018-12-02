package br.com.williamcasa.servicodeordenacao.classes.principais;

import br.com.williamcasa.servicodeordenacao.classes.templates.TemplateDeComparacao;

public class ComparaAutor extends TemplateDeComparacao {

	@Override
	public int resultadoOrdenado(Livro livro1, Livro livro2) {
		return livro1.getAutor().compareToIgnoreCase(livro2.getAutor());
	}
}