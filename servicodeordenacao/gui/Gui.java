package br.com.williamcasa.servicodeordenacao.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.williamcasa.servicodeordenacao.classes.auxiliares.ControladorLista;
import br.com.williamcasa.servicodeordenacao.classes.auxiliares.LeitorDeParametro;
import br.com.williamcasa.servicodeordenacao.classes.principais.Livro;
import br.com.williamcasa.servicodeordenacao.classes.principais.Ordenador;

public class Gui {
	private JFrame frame;
	private JPanel panelBotoes;
	private JButton bTCarregar, bTOrdenar;
	private JLabel avisoLabel;
	private ControladorLista controlarLista;
	private ArrayList<Livro> listaDeLivros;

	public void iniciar() {
		frame = new JFrame("Módulo de Ordenação de Livros");
		panelBotoes = new JPanel();
		bTCarregar = new JButton("Carregar lista de livros");
		bTOrdenar = new JButton("Ordenar livros");
		avisoLabel = new JLabel("Atenção: Os parametros de ordenação deverão ser feitos no arquivo de configuração");
		controlarLista = new ControladorLista();
		
		avisoLabel.setForeground(Color.RED);
		bTCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/williamcasa/servicodeordenacao/icons/iconLoad2.png")));
		bTCarregar.setToolTipText("Carrega uma lista de livros à partir de um arquivo .txt para que possam ser ordenados.");
		bTCarregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser carregar = new JFileChooser();
				carregar.setDialogTitle("Carregar lista de livros");
				carregar.setFileFilter(new FileNameExtensionFilter("Lista de livros (.txt)", "txt"));
				if(carregar.showSaveDialog(frame)!=JFileChooser.APPROVE_OPTION){
					   return;
				}
				controlarLista.carregaLista(carregar.getSelectedFile());
			}
		});
			bTOrdenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/williamcasa/servicodeordenacao/icons/iconOrganize.png")));
			bTOrdenar.setToolTipText("Ordena os livros carregados à partir de um arquivo .txt");
			bTOrdenar.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listaDeLivros = (ArrayList<Livro>) controlarLista.recuperaLista();
				if(listaDeLivros == null) {
					JOptionPane.showMessageDialog(null, "É necessário carregar a lista de livros");
				}
				Ordenador ordenador = new Ordenador(listaDeLivros,new LeitorDeParametro().lerProperties());
				ArrayList<Livro> listaOrdenada = (ArrayList<Livro>) ordenador.ordenarLista();
				JFileChooser ordenar = new JFileChooser();
				ordenar.setDialogTitle("Seleciona onde salvar a lista ordenada");
				ordenar.setFileFilter(new FileNameExtensionFilter("Lista de livros (.txt)","txt"));
				if(ordenar.showSaveDialog(frame)!=JFileChooser.APPROVE_OPTION){
					   return;
				}
				controlarLista.salvarListaOrdenada(ordenar.getSelectedFile(), listaOrdenada);
				
			}
		});
		panelBotoes.add(bTCarregar);
		panelBotoes.add(bTOrdenar);
		frame.setSize(520,120);
		frame.setLocationRelativeTo(null);
		avisoLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		frame.getContentPane().add(BorderLayout.NORTH,avisoLabel);
		frame.getContentPane().add(BorderLayout.CENTER,panelBotoes);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
