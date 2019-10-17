package busca;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//import static java.nio.file.FileVisitResult.*;

public class Busca {
       private String raiz;
       private String[] extensoes;
       private List<String> arquivos = new ArrayList<>();
       private List<String> arquivoNome = new ArrayList<>();
       
       public Busca(String raiz, String[] extensoes) {
   			this.raiz = raiz;
   			this.extensoes = extensoes;
   	   }
       public String getRaiz() {
    	   return raiz;
       }
       public String[] getExtensoes() {
    	   return extensoes;
       }
       public List<String> getArquivos(){
    	   return arquivos;
       }
       public void obterArquivos() {
    	   obterArquivos(this.raiz);
       }
       
       public void obterArquivos(String caminho) {
    	  File pai = new File(caminho);

    	  if (pai.listFiles() != null) {
    	  for(File filho : pai.listFiles()) {
    		  
    		  if(filho.isDirectory()) {
    			  obterArquivos(filho.getAbsolutePath());
    		  }
    		  
    		  else if(filho.isFile()) {
    			  
				 for (String extensao : this.extensoes) {
    				 if (filho.getName().endsWith(extensao)) {
    					 this.arquivoNome.add(filho.getName());
    					 this.arquivos.add(filho.getAbsolutePath());
    				 }
    				 //System.out.println(filho.getAbsolutePath());
    			  }
    			  
    		  }
    		  
    	  }
    	   
       }
    }
}

