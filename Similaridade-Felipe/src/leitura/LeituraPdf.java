package leitura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class LeituraPdf extends Leitura{

	
	public LeituraPdf(String caminho) {
		super(caminho);
	}
	
	@Override
	public void lerArquivo()  throws IOException, FileNotFoundException {

		try {
			PDDocument pdfDocument = PDDocument.load(new File(caminho));
			String linha = new PDFTextStripper().getText(pdfDocument);
			System.out.println("Texto: " + linha);
			this.processarPalavras(linha);
			
			pdfDocument.close();
			
		}catch(IOException e) {
			System.out.println("Erro ao ler arquivo PDF");
			throw new RuntimeException(e);
		}

	}

}

