package br.com.williamcasa.servicodeordenacao.classes.templates;

import java.util.Comparator;
import br.com.williamcasa.servicodeordenacao.classes.principais.Livro;
import br.com.williamcasa.servicodeordenacao.classes.principais.Ordenador;
import br.com.williamcasa.servicodeordenacao.classes.principais.Parametro;

public abstract class TemplateDeComparacao implements Comparator<Livro> {
	private Ordenador ordenador;
	private TemplateDeComparacao proximoComparador;
	private int posicaoAtualDeComparacao = 0;

	@Override
	public int compare(Livro livro1, Livro livro2) {

		if (saoIguais(livro1, livro2) && existemProximosParametros()) {
			setProximoComparador();
			return proximoComparador.compare(livro1, livro2);
		}
		return verificaInversaoDaLista(livro1, livro2);
	}

	private boolean saoIguais(Livro livro1, Livro livro2) {
		return resultadoOrdenado(livro1, livro2) == 0;
	}

	private boolean existemProximosParametros() {
		return this.posicaoAtualDeComparacao < this.ordenador.getParametrosASeguir().size() - 1;
	}

	public void setProximoComparador() {
		int proximaPosicao = this.posicaoAtualDeComparacao + 1;
		this.proximoComparador = ordenador.getParametrosASeguir().get(proximaPosicao).getComparavel();
		proximoComparador.setPosicaoAtualDeComparacao(proximaPosicao);
		proximoComparador.setOrdenador(this.ordenador);
	}

	private int verificaInversaoDaLista(Livro livro1, Livro livro2) {
		Parametro parametroAtual = ordenador.getParametrosASeguir().get(this.posicaoAtualDeComparacao);
		if (parametroAtual.getOrdem() == "descendente") {
			return resultadoOrdenado(livro1, livro2) * -1;
		} else
			return resultadoOrdenado(livro1, livro2);

	}

	public void setOrdenador(Ordenador ordenador) {
		this.ordenador = ordenador;

	}

	private void setPosicaoAtualDeComparacao(int posicaoAtualDeComparacao) {
		this.posicaoAtualDeComparacao = posicaoAtualDeComparacao;
	}

	public abstract int resultadoOrdenado(Livro livro1, Livro livro2);
}
