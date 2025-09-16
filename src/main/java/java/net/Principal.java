
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        try {
            String host = JOptionPane.showInputDialog ("Digite o endereço");
            int porta = Integer.parseInt(JOptionPane.showInputDialog("Digite a porta:"));
            
            Socket sock = new Socket(host, porta);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            
            out.print("GET / HTTP/1.0\r\n");
            out.print("Host: " + host + "\r\n");
            out.print("\r\n");
            out.flush();
            
             String linha;
            while ((linha = in.readLine()) != null) {
                System.out.println("echo: " + linha);
            }

            sock.close();
            in.close();
            out.close();

        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}
