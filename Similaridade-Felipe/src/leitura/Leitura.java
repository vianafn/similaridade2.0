package leitura;

import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Leitura {
	protected String caminho;
	private String nome;
	private String ext;
	public Map<String,Double> palavras = new HashMap<String, Double>();
	
	public String getCaminho()
	{
		return this.caminho;
	}
	
	public Leitura(String caminho) {
		this.caminho = caminho;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getExtensao() {
		return this.ext;
	}
	public void setExtensao(String ext) {
		this.ext = ext;
	}
	
	public abstract void lerArquivo() throws IOException, FileNotFoundException;
	
	public void processarPalavras(String texto) {
		
		String[] palavra = texto.split(" ");
		Double i = 0.0;
		
		for(String item : palavra) {
			
			i = palavras.get(item);			
			if(i == null) {
				i = 0.0; 
			}
			palavras.put(item, i + 1);
			//System.out.println("Colocado: " + item);
		}
		
		/*
		for (String key : palavras.keySet()) {
			System.out.println(key + ": " + palavras.get(key));
		}
		System.out.println("Processando outro arquivo..");
		*/
	}
	
	public static Leitura criaArquivo(String caminho) {
		 
		
		 if(caminho.endsWith(".txt") && caminho != null) {
			 //System.out.println("Lendo TXT");
			 LeituraTxt arquivo = new LeituraTxt(caminho);
			 return arquivo;
		 }
		 else if(caminho.endsWith(".pdf") && caminho != null) {
			 System.out.println("Lendo PDF");
			 LeituraPdf arquivo = new LeituraPdf(caminho);
			 return arquivo;
		 }
		 else if(caminho.endsWith(".doc") || caminho.endsWith(".docx") && caminho != null) {
			 System.out.println("Lendo DOC e DOCX");
			 //LeituraDoc arquivo = new LeituraDoc(caminho);
			 //return arquivo;
		 }

	    return null;
	}

	

	

}

