package cinemar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuAdmin {
	private Usuario user;
	private int tipo;
	private int opcion;
	private Conexion conexion;
	
public MenuAdmin(Usuario user) {
this.opcion=0;
this.user=user;
this.tipo=0;}

public void menu()throws SQLException{
	
	Scanner teclado=new Scanner(System.in);
	
	System.out.println("Bienvenido/a usuario "+this.user.getNombre());
	System.out.println("Elige una opcion :");
	System.out.println(  "1_Modificar cartelera.\r\n"
						+"2_Ver reservaciones.\r\n"
						+"3_Modificar precios y descuentos.\r\n"
						+"4_SALIR");
	
this.opcion=teclado.nextInt();
switch(this.opcion) {
case 1:	System.out.println(". . . MODIFICAR CARTELERA . . .");
Peliculas pelicula= new Peliculas();
pelicula.peliculasAdmin();

break;
	
case 2:	System.out.println(". . . VER RESERVACIONES . . .");
	Reserva reserva=new Reserva();
	reserva.Adminreservas();
	
	break;

case 3:{System.out.println(". . . PRECIOS Y DESCUENTOS . . .");
Pago pago=new Pago();
pago.modificarDescuento();
pago.modificarPrecio();

	break;}


case 4 :{
	
	System.out.println("CINEMAK");
	System.out.println("Ingresa una opcion");
	System.out.println("1_Ingresar\r\n"
					+ "2_Regristrarse");
	
	int option=teclado.nextInt();

	if (option==1) {
		System.out.println("Ingrese email: ");
		String email=teclado.next();
		System.out.println("Ingrese contraseña");
		String pass=teclado.next();
		Login login = new Login(email,pass);
		Usuario user = login.ingresar();
		
		if(user != null) {MenuClient ini = new MenuClient(user);
			ini.menu();}
		
		else {System.err.println("Ingreso no exitoso!!");
		
	break;}}}
	
	default : System.err.println("Ooops ocurrio un error");}}}