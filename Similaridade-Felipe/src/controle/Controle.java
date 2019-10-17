package controle;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import busca.Busca;
import leitura.Leitura;
import parametro.Parametro;
//import calculo.Calcular;
import java.util.regex.*;



@SuppressWarnings("unused")
public class Controle {

	private static List<Busca> pastas;
	private static ArrayList<Leitura> arquivos = new ArrayList<>();
	private static Map<String, Double> totalPalavras = new HashMap<String, Double>();
	private static Map<String, Double> docAlvoPalavras = new HashMap<String, Double>();
	private static Map<String, Double> listaSimilaridade = new HashMap<String, Double>();
	private static String REGEX = "[^(a-z|A-Z)]|\\(|\\)";
	private static String REPLACE = "";
	private static Parametro parametros;

	public static void main(String[] args) throws Exception {

		// Inicializa a classe com o caminho do arquivo de caminhos e Executa funcao que
		// captura as informacoes
		parametros = new Parametro("D:\\Felipe\\Downloads\\new 1.txt");

		// Para cada caminho, cria um objeto Pasta
		pastas = parametros.lerParametro();
		
		//for()
		//Separando o map do documento alvo
		//System.out.println("Documento alvo: " + parametros.getDocumentoAlvo());
		Leitura arquivoMap = Leitura.criaArquivo(parametros.getDocumentoAlvo());
		arquivoMap.lerArquivo();
		docAlvoPalavras = arquivoMap.palavras;
		
		// Para cada pasta, busca os arquivos
		for (Busca p : pastas) {

			p.obterArquivos();
			// Para cada pasta, adiciona os arquivos encontrados na lista de arquivos
			// principal
			for (String x : p.getArquivos()) {
				//System.out.printf("Arquivo::%s\n", x);
				Leitura arquivo = Leitura.criaArquivo(x);
				arquivos.add(arquivo); //Adiciona o arquivo que vai ler, na lista de arquivos do main. 
				arquivo.lerArquivo();
			}
		}
		
		
		
		//Calcular calcular = new Calcular();
		
		for (Leitura arquivo : arquivos) {
			
			System.out.println("Verificando map de palavras");
			/*
			for (String palavra : arquivo.palavras.keySet()) {
				System.out.println(palavra + ": " + arquivo.palavras.get(palavra));
			}*/
			//System.out.println("keyset: " + arquivo.palavras.keySet());
			
			//calculo
			//Double similaridade = calcular.calculaSimilaridade(docAlvoPalavras, arquivo.palavras);
			//listaSimilaridade.put(arquivo.getNome(), similaridade);
			
		}
		for (String key : listaSimilaridade.keySet()) {
			System.out.println(key + ": " + listaSimilaridade.get(key));
		}
		
		//ConectionFactory.getConnection();
		PreparedStatement stmt = null;
				
		//ConectionFactory.inserirDados();
		System.out.println("subindo arquivos");
		for(Leitura arquivo : arquivos ) {
			/*
			for (String key : arquivo.palavras.keySet()) {
				System.out.println(key + ": " + arquivo.palavras.get(key));
			}*/         
			
			//System.out.println("OUTRO FOR");
			                              
			for (String palavra : arquivo.palavras.keySet()) {
				//System.out.println(palavra + ": " + arquivo.palavras.get(palavra));
				//System.out.println(arquivo.getNome());
				//ConectionFactory.inserirTipoDocumento(palavra, arquivo.getNome());
			}
			
			
			
			
		}
		
		
		
		
		
	
	}
	

}


