package br.com.williamcasa.servicodeordenacao.main;

import br.com.williamcasa.servicodeordenacao.classes.auxiliares.LeitorDeParametro;
import br.com.williamcasa.servicodeordenacao.gui.Gui;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeitorDeParametro verifica = new LeitorDeParametro();
		verifica.verificaProperties();
		Gui gui = new Gui();
		gui.iniciar();
	}
}
