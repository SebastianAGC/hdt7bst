
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    
Diccionario eldiccionario = new Diccionario();
BinaryTree dic;

    public void leerDiccionario(){
        int i=0;
        ArrayList<String> linea= new ArrayList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\diccionario.txt"));
            while(i<linea.size()){
                Association<String, String> translation;
                linea.add(br.readLine());
                i++;
                String tmp = linea.get(i);
                String[] inglesespanol = tmp.split(", ");
                translation= new Association(inglesespanol[0], inglesespanol[1]);
                dic.insert(translation);
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
    
}
