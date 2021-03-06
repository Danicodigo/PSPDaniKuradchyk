package ejercicio1;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class UnixInteractor {

	public static void main(String[] command) {
		// TODO Auto-generated method stub
		String line;
		
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.redirectErrorStream(true);
		try {
			Process shell = pb.start();
			InputStream is = shell.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "850"));

			System.out.println("La salida del proceso hijo " + Arrays.toString(command) + ":");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			is.close();
			
		} catch (IOException e) {
			System.out.println("Error ocurri� ejecutando el comando. Descripci�n: "+e.getMessage());
		}
	}

}
