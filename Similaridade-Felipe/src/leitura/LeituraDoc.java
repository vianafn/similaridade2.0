/*package leitura;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class LeituraDoc extends Leitura {

	public LeituraDoc(String caminho) {
		super(caminho);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void lerArquivo() throws IOException, FileNotFoundException {
		
		try {

			if (caminho.endsWith(".doc")) {
				System.out.println("Lendo arquivo .doc");
				FileInputStream fis = new FileInputStream(caminho);
				HWPFDocument doc = new HWPFDocument(fis);

				WordExtractor extractor = new WordExtractor(doc);

				String[] fileData = extractor.getParagraphText();

				for (String linha : fileData) {
					System.out.println(linha);
					this.processarPalavras(linha);
					extractor.close();
				}
			}

			else if (caminho.endsWith(".docx")) {
				System.out.println("Lendo arquivo .docx");
				XWPFDocument docx = new XWPFDocument(new FileInputStream(caminho));

				XWPFWordExtractor docDocumento = new XWPFWordExtractor(docx);
				String linha = docDocumento.getText();
				this.processarPalavras(linha);
				System.out.println(linha);
				docDocumento.close();
			}

			/*
			  XWPFDocument docx = new XWPFDocument(new FileInputStream(caminho));
			  
			  List<XWPFParagraph> paragraphList = docx.getParagraphs();
			  
			  for(XWPFParagraph paragraph : paragraphList) {
			  System.out.println(paragraph.getText()); String linha = paragraph.getText();
			  this.processarPalavras(linha); }
			  
			  docx.close();
			

		} catch (FileNotFoundException e) {
			System.out.println("Erro ao ler arquivo DOC");
			throw new RuntimeException(e);
		}

		catch (IOException e) {
			System.out.println("Erro ao ler arquivo DOC");
			throw new RuntimeException(e);
		}

	}


	
	

}
*/
