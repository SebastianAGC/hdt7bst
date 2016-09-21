
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    public static String[] leerDiccionario(){
        int i=0;
        String[] linea = new String[41];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\diccionario.txt"));
            while(i<40){
                linea[i] = br.readLine();
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
        return linea;
    }
    
}
