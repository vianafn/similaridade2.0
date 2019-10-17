package leitura;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LeituraTxt extends Leitura{
	
	public LeituraTxt(String caminho) {
		super(caminho);
	}
	
	@Override
	public void lerArquivo() throws FileNotFoundException {
		
		File arqCaminho = new File(caminho);
		
		//System.out.println("Nome" + arqCaminho.getName());
		
		Scanner arq = new Scanner(arqCaminho);
		
		while(arq.hasNextLine()) {
			String linha = arq.nextLine();
			//System.out.println(linha);
			this.processarPalavras(linha);
		}
		this.setNome(arqCaminho.getName());
		this.setExtensao(".txt");
		arq.close();
		
	}
}
