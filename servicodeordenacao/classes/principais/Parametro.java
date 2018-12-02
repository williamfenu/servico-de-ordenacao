package br.com.williamcasa.servicodeordenacao.classes.principais;

import br.com.williamcasa.servicodeordenacao.classes.templates.TemplateDeComparacao;

public class Parametro {
	private Criterio nome;
	private String ordem;
	
	public Parametro(Criterio nome, String ordem) {
		this.nome = nome;
		this.ordem = ordem;
		
	}
	public Criterio getNome() {
		return nome;
	}
	public String getOrdem() {
		return ordem;
	}
	public TemplateDeComparacao getComparavel() {
		return nome.getComparavel();
	}

}
