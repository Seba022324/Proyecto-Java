package cinemar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Peliculas {
	private int idPelicula;
	private String pelicula;
	private String descripcion;
	private String genero;
	private String clasificacionEdad;
	private int idSala;
	private int option;
	Conexion conn = new Conexion();
	Scanner teclado=new Scanner(System.in);
	public Peliculas(String pelicula, String descripcion, String genero, String clasificacionEdad, int idSala) {
		this.pelicula = pelicula;
		this.descripcion = descripcion;
		this.genero = genero;
		this.clasificacionEdad = clasificacionEdad;
		this.idSala = idSala;
	}
	
	public Peliculas() {
		this.option=option;
		
	}

	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClasificacionEdad() {
		return clasificacionEdad;
	}
	public void setClasificacionEdad(String clasificacionEdad) {
		this.clasificacionEdad = clasificacionEdad;
	}
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	
	
	
	public void elegirPeli() {
		System.out.println("SELECCIONA QUE PELICULA QUIERES VER");
		this.option=teclado.nextInt();
		String sql="SELET pelicula FROM Pelicula";
		
		
		
		
	}
	
	
	public void cartelera() throws SQLException {
		
		Conexion conn=new Conexion();
		String sql = "SELECT* FROM Pelicula";
		ResultSet rs = conn.devuelveConsulta(sql);
		while(rs.next()) {
			
		int idp=rs.getInt("idPelicula");
		String peli=rs.getString("pelicula");
		String desc=rs.getString("descripcion");
		String gen=rs.getString("genero");
		String clasEdad=rs.getString("clasificacionEdad");
			System.out.println("Numero :"+idp);
			System.out.println("Pelicula :"+peli);
			System.out.println("Sinopsis :"+desc);
			System.out.println("Genero :"+gen);
			System.out.println("Clasificacion de edad: "+clasEdad);
			
		}
	}
	public void peliculaUser() throws SQLException {
		Peliculas pelicula = new Peliculas();
		pelicula.cartelera();
		System.out.println("Escoge la pelicula que quieres ver");
		this.idPelicula=teclado.nextInt();
		
		System.out.println("Elige una pelicula");
		String sql1 = "SELECT* FROM Pelicula WHERE( 'idPelicula'="+"'"+this.idPelicula+"')";
		this.conn=new Conexion();
		ResultSet rs1 = conn.devuelveConsulta(sql1);
		while(rs1.next()) {
		int opcionPel=rs1.getInt("idPelicula");
		String nombre=rs1.getString("pelicula");
		System.out.println("Opcion :"+opcionPel+" Nombre :"+nombre);}
		
	
	}
	public void peliculasAdmin() throws SQLException {
		Peliculas peli=new Peliculas();
		System.out.println("Elige una opcion :"
				+ "1_VER CARTELERA.\r\n"
				+ "2_AGREGAR PELICULAS.\r\n"
				+ "3_ELIMINAR PELICULAS.\r\n");
		
		this.option=teclado.nextInt();
		
		if(this.option==1) {peli.cartelera();}
		if(this.option==2) {peli.modificarPeliculas();}
		if(this.option==3) {peli.eliminarPelis();}
	}
	
	public void modificarPeliculas() throws SQLException {
		
			if(this.pelicula!=""&&this.descripcion!=""&& this.genero!=""&&this.clasificacionEdad!="") {
				
				System.out.println("Nombre:");
				this.pelicula=teclado.nextLine();
				
				System.out.println("Sinopsis: ");
				this.descripcion=teclado.nextLine();
				
				System.out.println("Genero: ");
				this.genero=teclado.nextLine();
				
				System.out.println("Clasificacion de edad:");
				this.clasificacionEdad=teclado.nextLine();
				
				String sql = "INSERT INTO Pelicula values(null,"+"'"+this.pelicula+"',"+"'"+this.descripcion+"',"+"'"+this.genero+"',"
				+"'"+this.clasificacionEdad+"')";
				
				conn.realizaConsulta(sql);
				System.out.println("Pelicula cargada a la cartelera");}}
		
	

	public void eliminarPelis() throws SQLException {
		System.out.println("Numero:");
		this.idPelicula=teclado.nextInt();
		
		
	String sql = "DELETE FROM Pelicula WHERE ( 'idPelicula'="+"'"+this.idPelicula+"')";				
	Conexion conn = new Conexion();
	conn.realizaConsulta(sql);
	System.out.println("Pelicula eliminada de la cartelera");}
					
	
		
		
	}