import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		//abrindo comunicacao serial 
		SerialInterface si = new SerialInterface("COM6", 9600);
			
		//registrando action de leitura que irá simplesmente printar os dados lidos
		si.read( new SerialReadAction() {
			
			public void read(byte b) {
				System.out.print((char)b);
			}
			
		}); 
			
		//loop infinito para ligar e desligar lampada a cada 1 segundo
		while (true) {
			byte[] data = new byte[1];
			data[0] = 'I';
			try {
				//enviando dados via porta serial
				si.write(data);
				//dormindo por 1 segundo
				Thread.sleep(1000);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
