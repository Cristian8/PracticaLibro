package conectar.base.datos;

public class Empleado {
	
	private int id;
	private String nombre;
	private int salario;
	private int dpto;
	private String nombre_dpto;
	//Constructor(para crear el objeto)
	
	public Empleado(int id, String nombre, int salario, int dpto, String nombre_dpto) {
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
		this.dpto = dpto;
		this.nombre_dpto = nombre_dpto;
		
	}
	
	
	public String getNombre_dpto() {
		return nombre_dpto;
	}


	public void setNombre_dpto(String nombre_dpto) {
		this.nombre_dpto = nombre_dpto;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public int getDpto() {
		return dpto;
	}
	public void setDpto(int dpto) {
		this.dpto = dpto;
	}
	
}
