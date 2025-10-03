package ENTIDADES;

public class Familia {
    private int idfamilia;
    private String nombre;
    private String descripcion;
	
    public Familia() {
    	
	}

	public Familia(int idfamilia, String nombre, String descripcion) {
		super();
		this.idfamilia = idfamilia;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdfamilia() {
		return idfamilia;
	}

	public void setIdfamilia(int idfamilia) {
		this.idfamilia = idfamilia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}

