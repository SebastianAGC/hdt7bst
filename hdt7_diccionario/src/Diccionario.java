
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Rodrigo Arriaza;
 */
public class Diccionario {
    
 public String FindAndDisplay (BinarySearchTree<Association<String, String>> arbol , String palabra){
     String traduccion = "";
     if (arbol.find(palabra))
     {
         traduccion = ""+arbol.getCurrent().getValue();
     }
     return traduccion;
    }
   
}
