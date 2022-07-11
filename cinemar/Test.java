package cinemar;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String args[]) throws SQLException {
		

		Scanner teclado=new Scanner(System.in);
		
		System.out.println("CINEMAK");
		System.out.println("INGRESA UNA OPCION");
		System.out.println("1_INGRESAR\r\n"
				+ "2_REGISTRARSE");
		int option=teclado.nextInt();
		
		
		
		switch(option) { 
		case 1 :{
		System.out.println("Ingrese email: ");
		String email=teclado.next();
		System.out.println("Ingrese contraseña");
		String pass=teclado.next();
		Login login = new Login(email,pass);
		Usuario user = login.ingresar();
		
		if(user.getTipo()==1) {MenuAdmin ini=new MenuAdmin(user);
			ini.menu();}
		
		else {MenuClient ini = new MenuClient(user);
				ini.menu();}}
		break;
		
		case 2 : {
			Registro registro=new Registro();
		Usuario user=registro.validaDatos();
		
		if(user.getTipo()==1) {MenuAdmin ini=new MenuAdmin(user);
			ini.menu();}
		
		else {MenuClient ini = new MenuClient(user);
			ini.menu();}}
		break;
		
		default :  System.err.println("Ooops... algo salio mal");}}}
		
				