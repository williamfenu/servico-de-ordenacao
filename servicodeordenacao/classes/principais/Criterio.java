package br.com.williamcasa.servicodeordenacao.classes.principais;

import br.com.williamcasa.servicodeordenacao.classes.templates.TemplateDeComparacao;

public enum Criterio {
	TITULO(new ComparaTitulo()),
	AUTOR(new ComparaAutor()),
	ANO(new ComparaAno());
	
	private TemplateDeComparacao template;

	Criterio(TemplateDeComparacao template){
		this.template = template;		
	}
	public TemplateDeComparacao getComparavel() {
		return template;
	}
}
