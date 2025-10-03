package ENTIDADES;

public class Cliente{
	private int idcliente;
	private String nombres;
	private String apellidos;
	private String dni;
	private int edad;
	
	public Cliente() {
	}

	public Cliente(int idcliente, String nombres, String apellidos, String dni, int edad) {
		super();
		this.idcliente = idcliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	
	
}