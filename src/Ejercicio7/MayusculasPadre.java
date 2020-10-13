package Ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MayusculasPadre {

    public static void main(String[] args) {           
       
        try
        {       
            Scanner entrada = new Scanner(System.in);                           
            String textoPantalla = "";
            System.out.println("Introducir linea:");           
                       
            do
            {
                textoPantalla = entrada.nextLine();   
               
                if( textoPantalla != null){
                    llamarProcesoHijo( textoPantalla);
                }
            }
            while(!textoPantalla.equals("fin"));
           
            System.out.println("Proceso finalizado");       
        }
        catch(Exception ex)
        {       
            ex.printStackTrace();
        }       
    }

    /**
     * @param pw
     * @param textoPantalla
     * @param br
     * @throws IOException
     */
    private static void llamarProcesoHijo( String textoPantalla) throws IOException {
       
        Process proceso = Runtime.getRuntime().exec("java -jar HolaMundo.jar");
        OutputStream stdin = proceso.getOutputStream ();
        InputStream stdout = proceso.getInputStream ();

        BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(stdin));
       
        pw.println(textoPantalla);
        pw.flush();               
       
        // Se lee la primera linea
        String lineaHijo = reader.readLine();
       
        if( lineaHijo != null){
            System.out.println(lineaHijo);
        }
    }   

}


