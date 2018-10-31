package br.com.williamcasa.servicodeordenacao.main;

import br.com.williamcasa.servicodeordenacao.classes.auxiliares.LeitorDeProperties;
import br.com.williamcasa.servicodeordenacao.gui.Gui;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeitorDeProperties verifica = new LeitorDeProperties();
		verifica.verificaProperties();
		Gui gui = new Gui();
		gui.iniciar();
	}
}
