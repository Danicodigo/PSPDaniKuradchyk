package ejercicio5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejecuta {
   
    public static void main(String[] args) {
        String comando = "cmd /c dir";
       
        for(int i=0;i<args.length;i++)
        {
            comando += " " + args[0];
        }
       
        if( comando != "")
            new Ejecuta(comando);
        else
            System.out.println("Introduce los argumentos para ejecutar el proceso.");
    }

    public Ejecuta(String comando){
       
         try
            {
                // Se lanza el ejecutable.
                Process p=Runtime.getRuntime().exec(comando);
                //Esepra a que el proceso finalice
                p.waitFor();
               
                // Se obtiene el stream de salida del programa
                InputStream is = p.getInputStream();
               
                // Se prepara un bufferedReader para poder leer la salida más comodamente.
                BufferedReader br = new BufferedReader (new InputStreamReader (is));
               
                // Lee la primera linea
                String linea = br.readLine();
               
                // Mientras se haya leido alguna linea
                while (linea!=null)
                {
                    // Se escribe la linea en pantalla
                    System.out.println (linea);
                   
                    // Lee la siguiente.
                    linea = br.readLine();
                }
            }
            catch (Exception e)
            {
                // Excepciones
                System.out.println("Error ejecutando el comando:" + e.getMessage());
           
            }
        }
       

    }