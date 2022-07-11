package cinemar;
import java.nio.file.attribute.FileTime;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.Time;

public class Reserva {
	private int idReserva;
	private int idUsuario;
	private int idButaca;
	private String fecha;
	private String hora;
	private int option;
	Scanner teclado=new Scanner(System.in);

		
	public Reserva(int idReserva, int idUsuario, int idButaca, String fecha, String hora, int option, Scanner teclado) {
		this.idReserva = idReserva;
		this.idUsuario = idUsuario;
		this.idButaca = idButaca;
		this.fecha = fecha;
		this.hora = hora;
		this.option = option;}
	
	public Reserva() {}
	
	
	public int getSala() {
		return idUsuario;
	}
	public void setSala(int sala) {
		this.idUsuario = sala;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	public void UserReserva() throws SQLException{
		System.out.println("INGRESA DATOS");
		System.out.println("Numero de butaca");
		this.idButaca=teclado.nextInt();
		System.out.println("Numero de Usuario");
		this.idUsuario=teclado.nextInt();
		System.out.println("Fecha en siguiente formato(22-07-10)");
		this.fecha=teclado.next();
		System.out.println("Horario(12:00)");
		this.hora=teclado.next();
		String sql = "INSERT INTO reserva VALUES(null,"+"'"+this.fecha+"',"+"'"+this.hora+"',"+"'"+idUsuario+"',"+"'"+idButaca+"')";
		Conexion conn=new Conexion();
		conn.realizaConsulta(sql);
		
		}
	
	
	
	public void Adminreservas() throws SQLException {
		
		Reserva reserva=new Reserva();
		System.out.println("1_VER RESERVAS GLOBALES"
				+ "2_VER RESERVAS UNITARIAS");
		this.option=teclado.nextInt();
		
		if(this.option==1) {reserva.devuelveReservaGlobal();}
		if(this.option==2) {reserva.reservaUnitaria();}
		
	}
	
	
	public static void devuelveReservaGlobal() throws SQLException {
		
		Conexion conn=new Conexion();
		System.out.println("\tRESERVAS DE USUARIOS :");
		
		String sql = "SELECT* FROM Reserva";
		ResultSet rs1=conn.devuelveConsulta(sql);
		
		while (rs1.next()) {
			int idReserva=rs1.getInt("idReserva");
			String fecha=rs1.getString("fecha");
			String hora=rs1.getString("hora");
			int idUser=rs1.getInt("idUsuario");
			int idButaca=rs1.getInt("idButaca");
			System.out.print("*Fecha: "+fecha);
			System.out.print("*Hora: "+hora);
			System.out.print("*ID del Usuario: "+idUser);
			System.out.print("*Butaca: "+idButaca);
			
		}}
	
		public void reservaUnitaria() throws SQLException {
			
			System.out.println("\tRESERVAS DE USUARIO ESPECIFICO :");
			
			String sql = "SELECT* FROM Reserva WHERE idUsuario = "+"'"+this.idUsuario+"'";
			Conexion conn=new Conexion();
			ResultSet rs1=conn.devuelveConsulta(sql);
			
			while (rs1.next()) {
				int idReserva=rs1.getInt("idReserva");
				String fecha=rs1.getString("fecha");
				String hora=rs1.getString("hora");
				int idUser=rs1.getInt("idUsuario");
				int idButaca=rs1.getInt("idButaca");
				System.out.print("*Fecha: "+fecha);
				System.out.print("*Hora: "+hora);
				System.out.print("*ID del Usuario: "+idUser);
				System.out.print("*Butaca: "+idButaca);}}}
