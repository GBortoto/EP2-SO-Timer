package Timer;

/*
Nota:
O arquivo gerado vai para a pasta raiz do projeto no eclipse
*/

import java.io.IOException;
import java.io.PrintWriter;

public class Timer {

	public static void rodaPrograma(int NumeroDeEscritores) throws InterruptedException{
		Process theProcess = null;
		try
		{
			theProcess = Runtime.getRuntime().exec("java C:/Users/Administrator/workspace/EP2-SO/src/Base/Main.java " + NumeroDeEscritores + ":1");
			theProcess.waitFor();
		}
		catch(IOException e)
		{
			System.err.println("Error on exec() method");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		PrintWriter writer = null;
		
		int NumeroDeRepeticoes = 20;
		long somaDosElementos[] = new long [100];  
		
		try{
			writer = new PrintWriter("medias.txt", "UTF-8");
		} catch (Exception e){
			System.out.println("Problema ao abrir o arquivo");
		}
		
		
		for(int n_arquivo=1; n_arquivo<(NumeroDeRepeticoes+1); n_arquivo++){
			//try{
				//writer = new PrintWriter("data" + n_arquivo + ".txt", "UTF-8");
			//} catch (Exception e){
				//System.out.println("Problema ao abrir o arquivo");
			//}
			
			for(int i=1; i<100; i++){
				double timerInicio = System.nanoTime();
				
				try{
					rodaPrograma(i);
				} catch (Exception e){
					System.out.println("Deu ruim");
				}
					
				double timerFinal = System.nanoTime();
				double tempoDecorrido = Math.round( (timerFinal - timerInicio) / 100);
				//System.out.println("Argumento 1: " + i + "\tModo: 1\t" + "Tempo Decorrido: " + tempoDecorrido);
			
				//try{
				somaDosElementos[i-1] += (int)(tempoDecorrido);
				    //writer.println((int)(tempoDecorrido) + "\n");
				//} catch (Exception e) {
					//System.out.println("Problema com o writer");
				//}
			}
			System.out.println("Repetição " + n_arquivo + " finalizada");
			/*
			try{
				writer.close();
				System.out.println("Final do arquivo " + n_arquivo);
			} catch (Exception e){
				System.out.println("Problema ao fechar o writer");
			}
			*/
		}
		for(int i=0; i<100; i++){
			try{
				//System.out.println((somaDosElementos[i]/NumeroDeRepeticoes));
				writer.println( (somaDosElementos[i]/NumeroDeRepeticoes) + "\n");
			} catch (Exception e) {
				System.out.println("Problema com o writer");
			}
		}
		writer.close();
	}
}