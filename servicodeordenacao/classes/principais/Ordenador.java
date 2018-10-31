package br.com.williamcasa.servicodeordenacao.classes.principais;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

public class Ordenador {

	private List<Livro> listaAOrdenar;
	private List<String> parametros;
	
	public Ordenador(List<Livro>list,List<String>param) {
		this.listaAOrdenar = list;
		this.parametros = param;
	}
	public Ordenador() {
		
	}

	private List<Livro> ordenaPorTitulo(List<Livro> OrdenarNome, List<String> parametros) {
		Collections.sort(OrdenarNome, new Comparator<Livro>() { 

			@Override
			public int compare(Livro o1, Livro o2) {// Compara o próximo objeto, se for igual verifica se há próximo parâmetro.
				// TODO Auto-generated method stub
				int cont = 2;
				if (o1.getTitulo().compareToIgnoreCase(o2.getTitulo()) == 0) {
					if (cont < parametros.size()) {
						cont += 2;
						switch (parametros.get(2)) {
						case "autor":
							if (o1.getAutor().compareToIgnoreCase(o2.getAutor()) == 0) {
								if (cont < parametros.size()) {
									cont += 2;
									switch (parametros.get(4)) {
									case "ano":
										if (parametros.get(5).equals("descendente")) {
											return (o1.getAno() - o2.getAno()) * -1;
										}
										return o1.getAno() - o2.getAno();
									}
								}
							}
							if (parametros.get(3).equals("descendente")) {
								return (o1.getAutor().compareToIgnoreCase(o2.getAutor())) * -1;
							}
							return o1.getAutor().compareToIgnoreCase(o2.getAutor());

						case "ano":
							if (o1.getAno() - o2.getAno() == 0) {
								if (cont < parametros.size()) {
									cont += 2;
									switch (parametros.get(4)) {
									case "autor":
										if (parametros.get(5).equals("descendente")) {
											return (o1.getAutor().compareToIgnoreCase(o2.getAutor())) * -1;
										}
										return o1.getAutor().compareToIgnoreCase(o2.getAutor());
									}

								}
							}
							if (parametros.get(3).equals("descendente")) {
								return (o1.getAno() - o2.getAno()) * -1;
							}
							return o1.getAno() - o2.getAno();
						}
					}
				}
				if (parametros.get(1).equals("descendente")) {
					return (o1.getTitulo().compareToIgnoreCase(o2.getTitulo())) * -1;
				}
				return o1.getTitulo().compareToIgnoreCase(o2.getTitulo());
			}
		});

		return OrdenarNome;
	}

	private List<Livro> ordenaPorAutor(List<Livro> OrdenarAutor, List<String> parametros) {
		Collections.sort(OrdenarAutor, new Comparator<Livro>() { 

			@Override
			public int compare(Livro o1, Livro o2) {// Compara o próximo objeto, se for igual verifica se há próximo parâmetro.
				// TODO Auto-generated method stub
				int cont = 2;
				if (o1.getAutor().compareToIgnoreCase(o2.getAutor()) == 0) {
					if (cont < parametros.size()) {
						cont += 2;
						switch (parametros.get(2)) {
						case "titulo":
							if (o1.getTitulo().compareToIgnoreCase(o2.getTitulo()) == 0) {
								if (cont < parametros.size()) {
									cont += 2;
									switch (parametros.get(4)) {
									case "ano":
										if (parametros.get(5).equals("descendente")) {
											return (o1.getAno() - o2.getAno()) * -1;
										}
										return o1.getAno() - o2.getAno();
									}
								}
							}
							if (parametros.get(3).equals("descendente")) {
								return (o1.getTitulo().compareToIgnoreCase(o2.getTitulo())) * -1;
							}
							return o1.getTitulo().compareToIgnoreCase(o2.getTitulo());

						case "ano":
							if (o1.getAno() - o2.getAno() == 0) {
								if (cont < parametros.size()) {
									cont += 2;
									switch (parametros.get(4)) {
									case "titulo":
										if (parametros.get(5).equals("descendente")) {
											return (o1.getTitulo().compareToIgnoreCase(o2.getTitulo())) * -1;
										}
										return o1.getTitulo().compareToIgnoreCase(o2.getTitulo());
									}

								}
							}
							if (parametros.get(3).equals("descendente")) {
								return (o1.getAno() - o2.getAno()) * -1;
							}
							return o1.getAno() - o2.getAno();
						}
					}
				}
				if (parametros.get(1).equals("descendente")) {
					return (o1.getAutor().compareToIgnoreCase(o2.getAutor())) * -1;
				}

				return o1.getAutor().compareToIgnoreCase(o2.getAutor());
			}
		});
		return OrdenarAutor;
	}

	private List<Livro> ordenaPorAno(List<Livro> OrdenarAno, List<String> parametros) {
		Collections.sort(OrdenarAno, new Comparator<Livro>() {

			@Override
			public int compare(Livro o1, Livro o2) {// Compara o próximo objeto, se for igual verifica se há próximo parâmetro.
				// TODO Auto-generated method stub
				int cont = 2;
				if (o1.getAno() - o2.getAno() == 0) {
					if (cont < parametros.size()) {
						cont += 2;
						switch (parametros.get(2)) {
						case "titulo":
							if (o1.getTitulo().compareToIgnoreCase(o2.getTitulo()) == 0) {
								if (cont < parametros.size()) {
									cont += 2;
									switch (parametros.get(4)) {
									case "autor":
										if (parametros.get(5).equals("descendente")) {
											return (o1.getAutor().compareTo(o2.getAutor())) * -1;
										}
										return o1.getAutor().compareTo(o2.getAutor());
									}
								}
							}
							if (parametros.get(3).equals("descendente")) {
								return (o1.getTitulo().compareToIgnoreCase(o2.getTitulo())) * -1;
							}
							return o1.getTitulo().compareToIgnoreCase(o2.getTitulo());

						case "autor":
							if (o1.getAutor().compareTo(o2.getAutor()) == 0) {
								if (cont < parametros.size()) {
									cont += 2;
									switch (parametros.get(4)) {
									case "titulo":
										if (parametros.get(5).equals("descendente")) {
											return (o1.getTitulo().compareToIgnoreCase(o2.getTitulo())) * -1;
										}
										return o1.getTitulo().compareToIgnoreCase(o2.getTitulo());
									}

								}
							}
							if (parametros.get(3).equals("descendente")) {
								return (o1.getAutor().compareTo(o2.getAutor())) * -1;
							}
							return o1.getAutor().compareTo(o2.getAutor());
						}
					}
				}
				if (parametros.get(1).equals("descendente")) {
					return (o1.getAno() - o2.getAno()) * -1;
				}
				return o1.getAno() - o2.getAno();
			}
		});
		return OrdenarAno;
	}

	public List<Livro> Ordenar() {

		boolean check = false;
		List<Livro> listaOrdenada;
		switch (parametros.get(0)) {
		case "titulo":
			check = true;
			listaOrdenada = this.ordenaPorTitulo(listaAOrdenar, parametros);
			return listaOrdenada;
		case "autor":
			check = true;
			listaOrdenada = this.ordenaPorAutor(listaAOrdenar, parametros);
			return listaOrdenada;
		case "ano":
			check = true;
			listaOrdenada = this.ordenaPorAno(listaAOrdenar, parametros);
			return listaOrdenada;
		default:
			if (check = false) {
				JOptionPane.showMessageDialog(null,
						"Por favor, preencha corretamente a ordem por nome, autor ou ano no arquivo de configuração");
			}
			return null;
		}
	}
}
