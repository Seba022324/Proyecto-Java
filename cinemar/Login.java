package cinemar;
import java.sql.ResultSet;
import java.sql.SQLException;


	public class Login {
		
		private String email;
		private String pass;
		
		public Login(String email, String pass) {
			this.email = email;
			this.pass = pass;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		
		public Usuario ingresar() throws SQLException {
			
			Usuario user = null;
			Conexion conexion = new Conexion();
			
			String consulta = "select * from usuario where email="+"'"+this.email+"'"+
					" and contrasenia ="+"'"+this.pass+"'";
			ResultSet rs = conexion.devuelveConsulta(consulta);
			
			while(rs.next()) {
				System.out.println("Ingreso exitoso!");
				
				int id_user = rs.getInt("idUsuario");
				String nombreyApellido = rs.getString("apellidoNombre");
				String dni=rs.getString("dni");
				String email=rs.getString("email");
				String pass = rs.getString("contrasenia");
				boolean tieneTarj = rs.getBoolean("tieneTarj");
				int tipo = rs.getInt("idTipo_usuario");
				user = new Usuario(id_user,nombreyApellido,dni,email,pass, pass, tipo, tieneTarj);
			}
			
			return user;
			//144444154 ana@gmal.com
		}

	}


