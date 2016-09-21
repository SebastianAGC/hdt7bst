
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Arriaza;
 */
public class Diccionario {
    private BinaryTree<String> arbolito = new BinaryTree();
    protected ArrayList<String> palabras = new ArrayList();
    String palabra;
    protected Association<String,String> asociar;
    
    public void llenarArbol(String[] words){
        int i=0;
        while (words[i]!=null){
            arbolito.insert(words[i]);
            i++;
        }
    }
    
    public void translate(){
        //crear asociaciones new Association(ingles, espanol)
        String english;
        String spanish;
        
    }         

    
}
