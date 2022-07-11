package cinemar;

	import java.sql.SQLException;
	import java.util.Scanner;

	public class Registro {
		private int idUsuario;
		private String nombre;
		private String nombreUsuario;
		private String dni;
		private String email;
		private String password;
		private boolean tieneTarj;
		private int tipo;
		
		public Registro() {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Ingrese nombre y apellido: ");
			this.nombre = teclado.nextLine();
			
			System.out.println("Ingrese su DNI sin puntos");
			this.dni=teclado.next();
			
			System.out.println("Escoge un nombre de usuario");
			this.nombreUsuario=teclado.next();
			
			System.out.println("Ingrese email: ");
			this.email= teclado.next();
			
			System.out.println("Ingrese password: ");
			this.password= teclado.next();
			
			this.tipo=2;
			
			this.tieneTarj=true;

		}
		public Usuario validaDatos() throws SQLException {
			
			Usuario user=null;
		
		if(this.nombre!=""&&this.dni!=""&& this.email!=""&&this.password!="") {
			
String sql = "INSERT INTO usuario values(null,"+"'"+this.nombre+"',"+"'"+this.nombreUsuario+"',"+"'"+this.dni+"',"
+"'"+this.email+"',"+"'"+this.password+"',"+"true,2)";
			
			Conexion conexion = new Conexion();
			conexion.realizaConsulta(sql);
			System.out.println("Usuario cargado");
			user = new Usuario(this.idUsuario,this.nombre,this.dni,this.nombreUsuario,this.password,this.email, tipo, tieneTarj);
		}
	
		else {
			System.out.println("DATOS MAL INGRESADOS");
		}
		
		return user;
	}}

