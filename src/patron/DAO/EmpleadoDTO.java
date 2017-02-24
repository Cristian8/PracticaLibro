package patron.DAO;

public class EmpleadoDTO {
	
	private int id;
	private String nombre;
	private int salario;
	private int dpto;
	
	
	
	//Constructor(para crear el objeto)
	
	public EmpleadoDTO(int id, String nombre, int salario, int dpto) {
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
		this.dpto = dpto;
		
	}

	//set and get
	
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