package es.sidelab.VirtualCoach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	private int puerto;
	private String adress;
	private Socket socket;
	private BufferedReader bufReader;
	private PrintWriter pw;
	
	
	public SocketClient(int puerto, String adress){
		this.puerto=puerto;
		this.adress=adress;
		
	}
	
	public void enviarDatos(String linea){
		try {
			socket=new Socket(adress,puerto);
			pw=new PrintWriter(socket.getOutputStream());
			
			pw.println(linea);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pw.close();
		}

	}
	

}
