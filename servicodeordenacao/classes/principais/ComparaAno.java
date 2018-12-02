package br.com.williamcasa.servicodeordenacao.classes.principais;

import br.com.williamcasa.servicodeordenacao.classes.templates.TemplateDeComparacao;

public class ComparaAno extends TemplateDeComparacao {

	public int resultadoOrdenado(Livro livro1, Livro livro2) {
		return livro1.getAno() - livro2.getAno();
	}
}