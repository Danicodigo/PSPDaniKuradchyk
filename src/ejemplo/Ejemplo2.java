package ejemplo;

import java.io.IOException;

public class Ejemplo2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length<=0) {
			System.out.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		
		Runtime runtime= Runtime.getRuntime();
		try {
			Process process=runtime.exec(args);
			process.destroy();
		}catch (IOException ex) {
			System.err.println("Exception de E/S");
			System.exit(-1);
		}
	}
}
