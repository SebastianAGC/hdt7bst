
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
static BinaryTree<Association<String, String>> diccionario = new BinaryTree();
static Diccionario dictionary = new Diccionario();
static String oracion="";

    public static void leerDiccionario(){                   
        /*
        int i=0;
        ArrayList<String> linea= new ArrayList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\diccionario.txt"));
            while(i<linea.size()){
                linea.add(br.readLine());
                String tmp = linea.get(i);
                arbol.insert(tmp);
                String[] inglesespanol = tmp.split(", ");
                dictionary.put(inglesespanol[0], inglesespanol[1]);
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
        }*/
    }
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
                if (dictionary.searchWord(palabras[i],diccionario)==null){
                    oracion=oracion+"*"+palabras[i]+"* ";
                }
                else
                {
                    oracion = oracion +dictionary.searchWord(palabras[i],diccionario)+" ";
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
    /*
    public static String prueba(){
        String prueba = "";
        Association<String, String> probando = new Association("woman", "mujer");
        prueba = prueba + probando.getValue();
        return prueba;
    }*/
    
    public static void main(String[] args){
        BufferedReader br = null;
        ArrayList<String> pruebas=new ArrayList();
        ArrayList<Association<String, String>> prueba1 = new ArrayList();
        String read;
        BinarySearchTree<Association<String, String>> arbolprueba = new BinarySearchTree();
        try{
              br =   new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\diccionario.txt"));
              while ((read = br.readLine())!=null){
                  String[] separar=read.split(", ");
                  pruebas.add(separar[0]+" = "+separar[1]);
                  Association<String, String> asoc = new Association(separar[0], separar[1]);
                  prueba1.add(asoc);
                  arbolprueba.insert(asoc);
                //read=read+br.readLine();
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
        crearDiccionario();
        //BinaryTree<Association<String, String>> prueba = new BinaryTree();
        //prueba = diccionario.left();
        Node<Association> nodoprueba = new Node(prueba1.get(3));
        //String pruebaread = 
        //oracion=""+(prueba.value(prueba.root)).getValue();
        //traducir();
        //System.out.println(prueba());
        //System.out.println(oracion);
        System.out.println(pruebas.get(2));
        //System.out.println((dictionary.search("dogs", nodoprueba)).getValue()+"");
        System.out.println(arbolprueba.find(prueba1.get(3)));
        System.out.println(arbolprueba.display(arbolprueba.root.right));
        System.out.println(arbolprueba.find("town"));
        System.out.println("house".compareTo("dogs"));
    }
}
