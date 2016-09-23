
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Rodrigo Arriaza;
 */
public class Diccionario extends BinarySearchTree{
    private BinaryTree<String> arbolito = new BinaryTree();
    protected ArrayList<String> palabras = new ArrayList();
    //protected BinarySearchTree<Association<String, String>> arbol = new BinarySearchTree();
    String palabra;
    protected Association<String,String> asociar;
    
    public void llenarArbol(String[] words){
        int i=0;
        while (words[i]!=null){
            arbolito.insert(words[i]);
            i++;
        }
    }
    /*
    public String ordenar(ArrayList<String> words){
        Collections.sort(words);
        String ordenado = "";
        for (int i = 0 ; i < words.size(); i++){
            ordenado = ordenado + asociar.get(words.get(i))+" ";
        }
        return ordenado;
    } */        
public String searchWord(String word, BinaryTree<Association<String, String>> diccionario){
    String traduccion="";
    if ((""+diccionario.root.getValue()).equals(word)){
        traduccion = ""+diccionario.val.getValue();
    } else if((""+diccionario.root.getValue()).compareTo(word)>0 && diccionario.root.getValue()!=null){
        searchWord(word, diccionario.right);
    }
    else if ((""+diccionario.root.getValue()).compareTo(word)<0 && diccionario.root.getValue()!=null){
        searchWord(word, diccionario.left);
    }
        else traduccion="";//falta agregar que revise si no es null
    return traduccion;
}
 public Node search(String name, Node<Association> node){
    if(node != null){
        if(node.getValue().getKey().equals(name)){
           return node;
        } else {
            Node foundNode = search(name, node.left);
            if(foundNode == null) {
                foundNode = search(name, node.right);
            }
            return foundNode;
         }
    } else {
        return null;
    }
}
 public String FindAndDisplay (BinarySearchTree<Association<String, String>> arbol , String palabra){
     String traduccion = "";
     if (arbol.find(palabra)){
         traduccion = ""+(arbol.getCurrent()).getValue();
     }
     return traduccion;
 }
 /*
 public boolean find(String key, BinarySearchTree<Association<String, String>> arbol ){
     
		Node<Association> current = root;
		while(current!=null){
			if(current.data.getKey()==key){
                                //setCurrent(current);
				return true;
			}else if((current.data.toString()).compareTo(key)>0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}*/
    
}
