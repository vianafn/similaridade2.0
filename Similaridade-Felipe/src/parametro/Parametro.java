package parametro;

import busca.Busca;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Parametro {

		private String documentoAlvo;
		private String arqParametro;

		public String getDocumentoAlvo() {
			return documentoAlvo;
		}

		public Parametro(String arqParametro) {
			this.arqParametro = arqParametro;
			//System.out.println(arqParametro);
		}

		public String arqParametro() {
			return arqParametro;
		}

		public void setDocumentoAlvo(String arqParametro) {
			this.arqParametro = arqParametro;
		}

		
		public List<Busca> lerParametro() {

			List<Busca> pastas = new ArrayList<Busca>();
			try {
				FileReader arq = new FileReader(arqParametro);
				BufferedReader lerArq = new BufferedReader(arq);

				boolean primeiraLinha = true;
				while (lerArq.ready()) {

					String[] linha = lerArq.readLine().split(";"); // lê a primeira linha a variável "linha" recebe o valor
																	// "null" quando o processo de repetição atingir o final
																	// do arquivo texto
					if (primeiraLinha) {
						primeiraLinha = false;
						this.documentoAlvo = linha[0];
						//System.out.println("Documento alvo:" + this.documentoAlvo);
					} else {
						Busca busca = new Busca(linha[0], linha[1].split(","));					
						pastas.add(busca);
					}
				}
				arq.close();

				return pastas;

			} catch (Exception e) {
				System.err.printf("Erro: %s.\n", e.getMessage());
				e.printStackTrace();
				throw new RuntimeException();
			}

		}


}
