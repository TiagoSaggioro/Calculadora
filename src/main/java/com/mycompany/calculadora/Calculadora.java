package com.mycompany.calculadora;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import com.mycompany.API.Server;
import java.io.InputStream;
import java.net.MalformedURLException;
import org.apache.log4j.BasicConfigurator;

public class Calculadora {
    
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, MalformedURLException, IOException {
        Double valor1 = Double.parseDouble(leitor.nextLine());
        String operacao = leitor.nextLine();
        Double valor2 = Double.parseDouble(leitor.nextLine());
        StringBuilder res = new StringBuilder();
        BasicConfigurator.configure();
        
        Server server = new Server();
        server.Routes();
        
        String requestUrl = "http://localhost:8080/" + String.valueOf(valor1) + "/" + String.valueOf(operacao) + "/" + String.valueOf(valor2);
        
        URL url = new URL(requestUrl);
        URLConnection connection = url.openConnection();
        InputStream inputstream = connection.getInputStream();
        res.append((char) inputstream.read());

        System.out.println("Resposta: " + res.toString());
    }
    
    
}