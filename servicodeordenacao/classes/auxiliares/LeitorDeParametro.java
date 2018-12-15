package br.com.williamcasa.servicodeordenacao.classes.auxiliares;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import br.com.williamcasa.servicodeordenacao.classes.principais.Criterio;
import br.com.williamcasa.servicodeordenacao.classes.principais.Parametro;

public class LeitorDeParametro {
	private List<Parametro> parametrosDeOrdenacao = new ArrayList<>();

	public List<Parametro> lerProperties() {
		try {
			Properties prop = new Properties();
			FileInputStream is = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
			prop.load(is);
			String atributos = prop.getProperty("atributos");
			String ordem = prop.getProperty("ordem");
			is.close();
			boolean validado = false;
			if (!atributos.equals("") || !ordem.equals("")) {
				String[] valores = atributos.split("/");
				String[] ascOrDesc = ordem.split("/");
				if (valores.length != ascOrDesc.length) {
					JOptionPane.showMessageDialog(null, "É necessário um ordenamento para cada atributo");
					return null;
				}
				validado = true;
				for (int i = 0; i < valores.length; i++) {
					String parametroFormatado = valores[i].toUpperCase();

					if (!parametroFormatado.equals("TITULO") && parametroFormatado.equals("AUTOR") && parametroFormatado.equals("ANO")) {
						JOptionPane.showMessageDialog(null,
								"parametros de nome, autor ou ano inválidos no arquivo de configuração. "
										+ "Separe os atributos por '/'sem espaços");
						validado = false;
						break;
					}
					
					String ordemFormatada = ascOrDesc[i].toLowerCase();

					if (!ordemFormatada.equals("ascendente") && !ordemFormatada.equals("descendente")) {
						JOptionPane.showMessageDialog(null, "parametros de ordenação ascendente ou "
								+ "descendente inválidos. Certifique-se de ter escrito corretamente e separe os atributos por '/'sem espaços");
						validado = false;
						break;
					}
					parametrosDeOrdenacao.add(new Parametro(Enum.valueOf(Criterio.class, parametroFormatado),ordemFormatada));
				}
				if (validado) {
					return parametrosDeOrdenacao;
				}

				return null;
			} else {
				JOptionPane.showMessageDialog(null,
						"Valores inválidos no arquivo de configuração. Separe os atributos por '/' sem espaços");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void refazerProperties(File file) {
		try {
			OutputStream is = new FileOutputStream(file);
			OutputStreamWriter isw = new OutputStreamWriter(is);
			BufferedWriter bw = new BufferedWriter(isw);
			bw.write(
					"*******************************************CONFIG**********************************************************************");
			bw.newLine();
			bw.write(
					"Opções disponíveis (preencher em minúsculo e separado por \"/\") - atri:autor,titulo,ano, ord:ascendente, descentente\r\n");
			bw.newLine();
			bw.write("atributos = ");
			bw.newLine();
			bw.write("ordem = ");
			bw.flush();
			bw.close();
			JOptionPane.showMessageDialog(null, "Arquivo config.properties gerado!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void verificaProperties() {
		File file = new File(System.getProperty("user.dir") + "\\config.properties");
		if (!file.exists()) {
			this.refazerProperties(file);
		}
	}
}