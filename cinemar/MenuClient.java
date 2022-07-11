package cinemar;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Date;
import java.sql.ResultSet;

public class MenuClient {
	private Usuario user;
	private int opcion;
	private Conexion conexion;
	
public MenuClient(Usuario user) {
this.opcion=0;
this.user=user;}

public void menu()throws SQLException{
	
	Scanner teclado=new Scanner(System.in);
	
	System.out.println("Bienvenido/a usuario "+this.user.getNombre());
	System.out.println("Elige una opcion :");
	System.out.println(  "1_Ver cartelera.\r\n"
						+"2_Crear una reserva.\r\n"
						+"3_Mi historial.\r\n"
						+"4_SALIR");
	
	this.opcion=teclado.nextInt();
	switch(this.opcion) 
	{
	case 1:
		Peliculas pelicula=new Peliculas();
		pelicula.cartelera();
		
		break;
		
	case 2:
		System.out.println("Has seleccionado hacer una reserva.");
	System.out.println("1_Continuar.\r\n"
			+ "2_Regresar al menu principal.");
	
this.opcion=teclado.nextInt();
if(this.opcion==1) {
	
	Peliculas pelicula1=new Peliculas();
		pelicula1.peliculaUser();
		Butacas but= new Butacas();
		but.seleccionButaca();
		but.validarButaca();
		Reserva reserva= new Reserva();
		reserva.UserReserva();
		
	System.out.println("Obteniendo comprobante");}
		else { MenuClient ini = new MenuClient(user);
		ini.menu();}
		
	break;
	
	case 3:
		System.out.println("Observar tu historial");
		
		break;
	case 4: 
		
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
				
				if(user != null) {
	
					MenuClient ini = new MenuClient(user);
					ini.menu();
				}
				
				else {
					
					System.err.println("Ingreso no exitoso!!");}}
		
		
		break;
		
		default:
			System.out.println("Oops,algo salio mal . . .");}
			
	
	
	
	}}