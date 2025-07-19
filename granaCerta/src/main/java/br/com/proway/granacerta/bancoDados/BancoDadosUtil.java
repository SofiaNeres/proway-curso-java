/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.proway.granacerta.bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BancoDadosUtil {
    private static final String ARQUIVO_PROPRIEDADE = "/db.properties";
    
    public static Connection getConnection() throws SQLException{
        try(var in = BancoDadosUtil.class.getResourceAsStream(ARQUIVO_PROPRIEDADE)){
            Properties propriedades = new Properties ();
            propriedades.load(in);
            
            String url = propriedades.getProperty("jdbc.url");
            String usuario = propriedades.getProperty("jdbc.user");
            String password = propriedades.getProperty("jdbc.password");
            return DriverManager.getConnection(url, usuario, password);           
        } catch (Exception e){
            e.printStackTrace();
            throw new SQLException ("Não foi possível carregar as propriedades do Banco de Dados");
        }
    }
}
