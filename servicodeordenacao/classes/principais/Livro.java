package br.com.williamcasa.servicodeordenacao.classes.principais;

public class Livro{
	private String titulo, autor;
	private int ano;
	
	public Livro(String titulo, String autor, int ano){
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}
	public Livro() {
		
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	public String getAutor() {
		return this.autor;
	}
	public void setAutor(String autor) {
		this.autor=autor;
	}
	public int getAno() {
		return this.ano;
	}
	public void setAno(int ano) {
		this.ano=ano;
	}
	
	public String toString() {
		String quebraDeLinha = System.lineSeparator();
		return "Título do Livro: "+this.titulo + quebraDeLinha + "Autor: " + this.autor + quebraDeLinha + "Ano de edição: " + this.ano + quebraDeLinha;
	}
}
