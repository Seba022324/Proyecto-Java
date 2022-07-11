package cinemar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion{
	Connection conn=null;
	Statement stmt =null;
	public Conexion() {
		final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/cinemak";
		final String USER="root";
		final String PASS="1234";
		
		try {Class.forName(JDBC_DRIVER);
			System.out.println("Conectando a BDD..");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);}
		
		catch(Exception e) {System.err.println("ERROR DE CONEXION");}}
	
	public ResultSet devuelveConsulta(String sql) throws SQLException {
		System.out.println("Creando Consulta");
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		return rs;}
	
	public void realizaConsulta(String sql) throws SQLException {
		System.out.println("Creando Consulta");
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);}}
