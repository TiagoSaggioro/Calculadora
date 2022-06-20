package com.mycompany.API;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import java.lang.reflect.Method;

public class Server {
    
    public void Routes() {
        Javalin app = Javalin.create().start(8080);
        app.get("/{n1}/{operation}/{n2}", getOperations);
    }
    
    public static Handler getOperations = req -> {
        Double valor1 = Double.parseDouble(req.pathParam("n1"));
        String operacao = req.pathParam("operation");
        Double valor2 = Double.parseDouble(req.pathParam("n2"));
        
        // instancia a classe com o nome da operacao
        Object obj = Class.forName("com.mycompany.API."+operacao).newInstance();
        
        // pega o metodo calcular da classe instanciada
        Method metodo = Class.forName("com.mycompany.API."+operacao).getDeclaredMethod("calcular", new Class[] {Double.class, Double.class});
        
        // chama o metodo calcular da classe indicada na operacao
        Object resultado = metodo.invoke(obj, valor1, valor2);
        
        req.json(resultado);
    };
}
