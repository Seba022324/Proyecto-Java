package cinemar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Butacas {
	private int idButaca;
	private int idSala;
	private int fila;
	private int columna;
	
	
	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}


	public int getIdButaca() {
		return idButaca;
	}

	public void setIdButaca(int idButaca) {
		this.idButaca = idButaca;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	public void seleccionButaca(){
		Scanner teclado=new Scanner(System.in);
		System.out.println("Escoge una columna");
		this.columna=teclado.nextInt();
		System.out.println("Escoge una fila");
		this.fila=teclado.nextInt();
		System.out.println("Escoge una sala");
		this.idSala=teclado.nextInt();}
	
public int validarButaca() throws SQLException {
	
	System.out.println("Escogiste fila:"+fila+" y columna :"+columna);
		String sql="INSERT INTO Butaca VALUES("+"'"+this.idButaca+"',"+"'"+this.fila+"',"+"'"+this.columna+"',"+"'"+this.idSala+"')";
		Conexion conn = new Conexion(); 
		conn.realizaConsulta(sql);
		System.out.println("EXCELENTE...BUTACA RESERVADA!!");
	return this.idButaca;
	
}}
	
