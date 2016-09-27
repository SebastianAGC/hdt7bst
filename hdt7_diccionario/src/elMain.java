
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo Arriaza;
 */
public class elMain 
{
    
//static BinaryTree<Association> arbol = new BinaryTree();
static BinarySearchTree<Association<String, String>> diccionario = new BinarySearchTree();
static Diccionario dictionary = new Diccionario();
static String oracion="";

    public static void crearDiccionario(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\diccionario.txt"));
            String linea;
            while((linea = br.readLine()) != null)
            {
                //String tmp = br.readLine();
                String[] palabras = linea.split(", ");
                Association<String, String> traduccion = new Association(palabras[0], palabras[1]);       
                diccionario.insert(traduccion);
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    public static void traducir(){
      int i=0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\datos.txt"));
            oracion = "";
            String tmp = br.readLine();
            String[] palabras = tmp.split(" ");
            while(i<palabras.length){
                if (!diccionario.find(palabras[i])){
                    oracion=oracion+"*"+palabras[i]+"* ";
                }
                else
                {
                    oracion = oracion + dictionary.FindAndDisplay(diccionario, palabras[i]) +" " ;
                }
                i++;               
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
      
    public static void main(String[] args){
        crearDiccionario();
        traducir();
        diccionario.printInorder(); //esto ordena un arraylist 
        System.out.println(diccionario.getTranslations()); //esto imprime el arraylist en orden
        System.out.println(oracion);
    }
}
