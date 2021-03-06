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

public class LeitorDeProperties {
	private List<String> parametrosDeOrdenacao = new ArrayList<String>();
	
	public List<String> lerProperties() {
		try {
			Properties prop = new Properties();
			FileInputStream is = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
			prop.load(is);
			String atributos = prop.getProperty("atributos");
			String ordem = prop.getProperty("ordem");
			is.close();
			boolean validado=false;
			if (!atributos.equals("") || !ordem.equals("")) {
				String[] valores = atributos.split("/");
				String[] ascOrDesc = ordem.split("/");
				if(valores.length!=ascOrDesc.length) {
					JOptionPane.showMessageDialog(null, "� necess�rio um ordenamento para cada atributo");
					return null;
				}
				validado=true;
				for (int i = 0; i < valores.length; i++) {
					parametrosDeOrdenacao.add(valores[i]=valores[i].toLowerCase());
					if(!valores[i].equals("titulo")&&!valores[i].equals("autor")&&!valores[i].equals("ano")) {
						JOptionPane.showMessageDialog(null, "parametros de nome, autor ou ano inv�lidos no arquivo de configura��o. "
								+ "Separe os atributos por '/'sem espa�os");
						validado = false;
						break;
					}
					parametrosDeOrdenacao.add(ascOrDesc[i].toLowerCase());
					if(!ascOrDesc[i].equals("ascendente")&&!ascOrDesc[i].equals("descendente")) {
						JOptionPane.showMessageDialog(null, "parametros de ordena��o ascendente ou "
								+ "descendente inv�lidos. Certifique-se de ter escrito corretamente e separe os atributos por '/'sem espa�os");
						validado = false;
						break;
					}
				}if(validado) {
					return parametrosDeOrdenacao;
				}
				
				return null;
			} else {
				JOptionPane.showMessageDialog(null,
						"Valores inv�lidos no arquivo de configura��o. Separe os atributos por '/' sem espa�os");
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
					"Op��es dispon�veis (preencher em min�sculo e separado por \"/\") - atri:autor,titulo,ano, ord:ascendente, descentente\r\n");
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
		if(!file.exists()) {
			this.refazerProperties(file);
		}
	}
}
