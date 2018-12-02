package br.com.williamcasa.servicodeordenacao.classes.templates;

import java.util.Comparator;
import br.com.williamcasa.servicodeordenacao.classes.principais.Livro;
import br.com.williamcasa.servicodeordenacao.classes.principais.Ordenador;

public abstract class TemplateDeComparacao implements Comparator<Livro> {
	protected Ordenador ordenador;
	private TemplateDeComparacao proximoComparador;
	private int posicaoAtualDeComparacao = 0;

	@Override
	public int compare(Livro livro1, Livro livro2) {
		if (resultadoOrdenado(livro1, livro2) == 0) {
			ordenador.aceitaComparador(this);
			return proximoComparador.compare(livro1, livro2);
		}
		return resultadoOrdenado(livro1, livro2);
	}

	public abstract int resultadoOrdenado(Livro livro1, Livro livro2);

	public void setProximo(TemplateDeComparacao proximo) {
		this.proximoComparador = proximo;
		proximoComparador.setPosicaoAtualDeComparacao(this.posicaoAtualDeComparacao + 1);
		proximoComparador.setOrdenador(this.ordenador);
	}

	public void setOrdenador(Ordenador ordenador) {
		this.ordenador = ordenador;

	}

	public int getPosicaoAtualDeComparacao() {
		return posicaoAtualDeComparacao;
	}

	public void setPosicaoAtualDeComparacao(int posicaoAtualDeComparacao) {
		this.posicaoAtualDeComparacao = posicaoAtualDeComparacao;
	}
}
