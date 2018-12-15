package br.com.williamcasa.servicodeordenacao.classes.auxiliares;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class ConnectionFactory {
	
	public Properties pegarLeitorDeProperties(String url) {
		try {
			Properties prop = new Properties();
			FileInputStream is = new FileInputStream(url);
			prop.load(is);
			return prop;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public BufferedWriter pegarWriter(File file) {
		try {
		OutputStream os = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		return bw;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
