package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class FabricaObjetos {
    
     public static List<Livro> carregaLivros(){
         
         Livraria livraria = new Livraria();
         livraria.setId(300);
         livraria.setNome("Rush");
         livraria.setSite("www.rushpaperstore.com.br");
         
        Catalogo catalogo = new Catalogo();
        catalogo.setId(109);
        catalogo.setNome("Vulgo Malvadão");
        catalogo.setLivraria(livraria);
        
        Idioma idioma = new Idioma();
        idioma.setId(9090);
        idioma.setNome("Coreano");
        idioma.setSigla("KO");
        
        Formato formato = new Formato();
        formato.setId(894309);
        formato.setNome("Edição Limitada.");
        
        List<Livro> lista = new ArrayList<>();
        Livro liv = new Livro();
        liv.setISBN("40028922");
        liv.setCodigoBarras("123719823718293");
        liv.setTitulo("Dom Casmurro");
        liv.setResumo("Capitu passa o rodo.");
        liv.setEditora("Brasil");
        liv.setDataPuclicacao(Calendar.getInstance());
        liv.setNumeroPaginas(300);
        liv.setAtivo(true);
        liv.setValor(30.00);
        
        liv.setFormato(formato);
        liv.setIdioma(idioma);
        liv.setCatalogo(catalogo);
        
        
        lista.add(liv);
        return lista;
     }
    
}
