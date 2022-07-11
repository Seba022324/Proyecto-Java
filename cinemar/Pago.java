package cinemar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Pago {
	private int idPago;
	private int idDescuento;
	private int cantidad;
	private String descripDescuento;
	private double precio;
	private double total;
	private boolean confPago;
	private double descuento;
	private int option;
	Scanner teclado=new Scanner(System.in);
	public Pago() {
		
		this.option=option;
		
	}
	
	public Pago(int idPago, int cant, double precio, double total, boolean confPago, double descuento) {
		
		this.idPago = idPago;
		this.idDescuento=idDescuento;
		this.cantidad = cant;
		this.precio = precio;
		this.total = total;
		this.confPago = false;
		this.descuento = descuento;
	
	}
	
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public int getCantida() {
		return cantidad;
	}
	public void setCantida(int cantida) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isConfPago() {
		return confPago;
	}
	public void setConfPago(boolean confPago) {
		this.confPago = confPago;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	
	public void modificarDescuento() throws SQLException {
		
		System.out.println("Selecciona una opcion:\n\t1_Agregar descuentos\n\t"
				+ "2_Modificar descuentos");
		this.option=teclado.nextInt();
		
		if(this.option==1) {
			
			String consulta=" INSERT INTO Descuento VALUES(null,"+"'"+this.descripDescuento+"',"+"'"+this.descuento+"')";
			Conexion conn=new Conexion();
			conn.realizaConsulta(consulta);
			}
		else {
		
		Conexion conn=new Conexion();
		String consulta=" UPDATE Descuento SET porcentaje ="+"'"+this.descuento+"'"+" where="+ "'"+this.idDescuento+"'";
		conn.realizaConsulta(consulta);
	}}
	public void modificarPrecio() throws SQLException {
		
		
		System.out.println("Selecciona una opcion:\n\t1_Agregar precios\n\t"
				+ "2_Modificar precios");
		this.option=teclado.nextInt();
		
		if(this.option==1) {
		
		
		String consulta=" INSERT INTO Descuento VALUES(null"+"'"+this.descuento+"'"+"'"+this.idDescuento+")";
		Conexion conn=new Conexion();
		conn.realizaConsulta(consulta);
		
		}else {
			
		String consulta=" UPDATE Descuento SET porcentaje ="+"'"+this.precio+"'"+" where="+ "'"+this.idPago+"'";
		Conexion conn=new Conexion();
		conn.realizaConsulta(consulta);
			
		}
		
		
	}
	public boolean confirmarPago() throws SQLException {
		
		Scanner teclado=new Scanner(System.in); 
		System.out.println("Por favor, Ingrese su dni para validar la compra");
		int dni=teclado.nextInt();
		Conexion conn=new Conexion();
		String consulta=" SELECT* FROM usuario where DNI="+ "'"+dni+"'";
	
		ResultSet rs=conn.devuelveConsulta(consulta); 
		
		while(rs.next()) { //valida correctamente
			
			int	dn=rs.getInt("DNI");
		System.out.println("Usted ha ingresado: "+dn);
		System.out.println("Ingreso exitoso");
		this.confPago=true;}  

		return confPago;}
		
	public void calcularTotal() throws SQLException {
		
		Conexion conn=new Conexion();
		
		String consulta=" SELECT idDescuentos,"
				+ "PorcentajeDes FROM Descuento";
		ResultSet rs=conn.devuelveConsulta(consulta);
		while(rs.next()) {
			double descuento=rs.getDouble("Descuento");
			double precio=rs.getDouble("precio");
			this.total=descuento*precio;}
		this.total=this.descuento*this.cantidad*this.precio;
		}
		
	
	
	public void mostrarComp() throws SQLException {
		
		Reserva reserva=new Reserva();
		System.out.println("CINEMAK");
		System.out.println("PELICULA :");
//		System.out.println("BUTACAS"+Reserva.devuelveReserva());
		String sql;
		Calendar fecha=new GregorianCalendar();
		int anio=fecha.get(Calendar.YEAR);
		int mes=fecha.get(Calendar.MONTH);
		int dia=fecha.get(Calendar.DAY_OF_MONTH);
		String fechaActual=anio+"-"+mes+"-"+dia;
		System.out.println(fechaActual);
		System.out.println(total);
		System.out.println(descuento);
		
		
		System.out.println("DISFRUTE LA FUNCION");
		
		
		
	}
		
	}
	
	
