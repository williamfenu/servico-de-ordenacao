package br.com.williamcasa.servicodeordenacao.classes.auxiliares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.williamcasa.servicodeordenacao.classes.principais.Livro;

public class ControladorLista {
	private List<Livro> listaDeLivros;

	public void carregaLista(File file) {
		try {
			listaDeLivros = new ArrayList<>();
			InputStream is = new FileInputStream(file);
			InputStreamReader fr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(fr);

			String dados = br.readLine();
			if (dados != null) {
				boolean passou=true;
				while (dados != null) {
					try {
					String[] dadosSeparados = dados.split("/");
					if(dadosSeparados.length!=3) {
						JOptionPane.showMessageDialog(null, "O livro precisa ter exatamente três atributos separados por '/' sem espaços");
						passou=false;
						break;
					}
					int anoFormatado = Integer.parseInt(dadosSeparados[2]);
					Livro livro = new Livro(dadosSeparados[0], dadosSeparados[1], anoFormatado);
					listaDeLivros.add(livro);
					dados = br.readLine();
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Ë necessário inserir um valor válido para data");
						passou=false;
						break;
					}
				}if(passou) {
				JOptionPane.showMessageDialog(null, "Lista carregada com sucesso");
				}
			} else {
				JOptionPane.showMessageDialog(null, "A lista está vazia");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void salvarListaOrdenada(File file, List<Livro> listaOrdenada) {
		try {
			OutputStream is = new FileOutputStream(file + ".txt");
			OutputStreamWriter isw = new OutputStreamWriter(is);
			BufferedWriter bw = new BufferedWriter(isw);
			int i = 0;
			bw.write("********Lista Ordenada********\r\n");
			bw.newLine();
			while (i<listaOrdenada.size()) {
				bw.write(listaOrdenada.get(i).toString());
				bw.newLine();
				i++;
			}
			bw.close();
			JOptionPane.showMessageDialog(null, "A lista foi gravada com sucesso");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Livro> recuperaLista() {
		return this.listaDeLivros;
	}
}
