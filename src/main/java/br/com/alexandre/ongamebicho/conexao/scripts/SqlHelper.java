/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.conexao.scripts;

/**
 *
 * @author Alexandre
 */
public class SqlHelper {
    public static String insertUsuario = "INSERT INTO WEB_USUARIO "
            + "(ID,"
            + "USU_LOGIN,"
            + "USU_SENHA)"
            + " values (?,?,?)";
    
    
    public static String buscaUsuario = "SELECT * FROM WEB_USUARIO";
    public static String selectMaxIdUsuario = "SELECT MAX(ID)+1 as id FROM web_usuario";
    public static String deleteUsuario = "DELETE FROM WEB_USUARIO WHERE id = ?";
    public static String updateUsuario = "UPDATE WEB_USUARIO SET USU_LOGIN = ?, USU_SENHA = ? WHERE id = ?";
    public static String verificaLogin = "SELECT * FROM WEB_USUARIO WHERE USU_LOGIN = ? and USU_SENHA = ?";
    public static String buscaAniamis = "SELECT * FROM ANIMAL";
    
    public static String insertOcorrencia = "INSERT INTO WEB_OCORRENCIA "
            + "(ID,"
            + "OCO_RACA,"
            + "OCO_ESPECIE,"
            + "OCO_OBSERVACAO)"
            + " values (?,?,?,?)";
    
    public static String selectMaxIdOcorrencia = "SELECT MAX(ID)+1 as id FROM WEB_OCORRENCIA";
    public static String buscaOcorrencia = "SELECT * FROM WEB_OCORRENCIA";
    public static String deleteOcorrencia = "DELETE FROM WEB_OCORRENCIA WHERE id = ?";
    
    
     public static String insertAnimal = "INSERT INTO animal "
            + "(ID,"
            + "nome,"
            + "raca,"
            + "tipodoAnimal,"
             + "descricao)"
            + " values (?,?,?,?,?)";
     
     public static String updateAnimal = "UPDATE animal SET nome = ?, raca = ?, tipodoAnimal = ?, descricao = ? WHERE id = ?";
}


