package edu.uniandes.ecos.Programa;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

/**
 * <h1>Program</h1> 
 * Clase para el calculo de la integral de la distribución
 * 
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since 20170402
 */
public class App 
{
    /***
     * Metodo principal del programa
     * @param args argumentos para ejecución del calculo
     */
    public static void main( String[] args )
    {         
        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        get("/numericalIntegration",  "application/json", (req, res) -> {
            double intervaloValue =   Double.parseDouble(req.queryParams("intervalo").toString());
            int DOFValue =  Integer.parseInt(req.queryParams("DOF").toString());
            double errorValue = Double.parseDouble(req.queryParams("error").toString());
            
            return String.valueOf(calculoDistribucion(intervaloValue, DOFValue, errorValue));
        });
    }
    
    
    /***
     * Calculo de la integral e iteración de numero de segmentos según el error 
     * @param intervalo valor del intervalo de la función
     * @param DOF grados de libertad del calculo
     * @param error error aceptable
     * @return resultado del calculo
     */
    public static double calculoDistribucion(double intervalo, int DOF, double error)
    {
        int numeroSegmentos = 10;
        DistribucionT distribucionT = new DistribucionT(numeroSegmentos, intervalo, DOF);
        double valorAnterior = distribucionT.calculoDistribucion();
        numeroSegmentos = 15;
        distribucionT = new DistribucionT(numeroSegmentos, intervalo, DOF);;
        double valorNuevo = distribucionT.calculoDistribucion();
        
        while(Math.abs(valorNuevo - valorAnterior) >  error)
        {
            numeroSegmentos =+ 5;
            valorAnterior = valorNuevo;
            distribucionT = new DistribucionT(numeroSegmentos, intervalo, DOF);
            valorNuevo = distribucionT.calculoDistribucion();
        }
        
        return valorNuevo;
    }
}
