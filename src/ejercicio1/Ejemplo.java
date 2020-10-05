package ejercicio1;

public class Ejemplo {
	private static void abrirPrograma(String programa) {
		try 
        { 
              
            // create a new process 
            System.out.println("Creating Process"); 
              
            ProcessBuilder builder = new ProcessBuilder(programa); 
            Process pro = builder.start(); 
      
            // wait 10 seconds 
            System.out.println("Waiting"); 
            Thread.sleep(10000); 
      
            // kill the process 
            pro.destroy(); 
            System.out.println("Process destroyed"); 
      
        }  
            catch (Exception ex)  
        { 
            ex.printStackTrace(); 
        } 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		abrirPrograma("notepad.exe");
	}

}
