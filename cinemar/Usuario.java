package cinemar;
public class Usuario {
	private int id_user;
	private String nomApell;
	private String dni;
	private String nombreUsuario;
	private String email;
	private String password;
	private int tipo;
	private boolean tieneTarj;
//	private String tel;
	
	public Usuario(int id_user,String nomApell,String dni,String nombreUsuario, String email, String password, int tipo, boolean tieneTarj) {

		this.id_user = id_user;
		this.nomApell = nomApell;
		this.dni=dni;
		this.nombreUsuario=nombreUsuario;
		this.email = email;
		this.password = password;
		this.tipo = tipo;
		this.tieneTarj = tieneTarj;
		}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNombre() {
		return nomApell;
	}

	public void setNombre(String nombre) {
		this.nomApell = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean isTieneTraj() {
		return tieneTarj;
	}
	
	public void setTieneTraj(boolean tieneTraj) {
		this.tieneTarj = tieneTraj;}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

//	public String getTel() {
//		return tel;
//	}
//
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
	}