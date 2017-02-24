package conectar.base.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
///Hacer programa q recupere todos los empleados de la base de datos los introduzca en un array y los muestre ordenados 
//por salario de mayor a menor
//muestra los nombre del departemento al q pertenece cada empleado
public class BaseDatos {
	
	public static void mostrarLista(ArrayList<Empleado>lemp)
	{
		
		for (Empleado emp: lemp)
		{
			System.out.println("Nombre: "+emp.getNombre()+", Departamento: "+emp.getDpto()+", Salario "
		+emp.getSalario()+", ID: "+emp.getId()+", Nombre Departamento: "+emp.getNombre_dpto());
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {

		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		ArrayList<Empleado> lista_empleados = null;
		
		
		lista_empleados = new ArrayList<Empleado>();//Creo lista
		//Empleado empleado = new Empleado(3, "Juanjo", 27000, 5);//introduzco datos de un nuevo empleado
		//lista_empleados.add(empleado);//introduzco en lista
		//mostrarLista(lista_empleados);//muestro lista
		
		try {
			// registro el driver, en realidad, hago que se ejecuten unas pocas
			// líneas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager.registerDriver (new
			// oracle.jdbc.driver.OracleDriver());// método equivalente al
			// anterior
			// Sea como sea, es, <<oye, si te piden una conexión, se la pides a
			// esa clase!>>
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password");
			stmt = conn.createStatement();
			//rset = stmt.executeQuery("SELECT * from EMPLOYEES ORDER BY SALARY DESC");
			//rset = stmt.executeQuery("SELECT department_name  FROM department WHERE department_id = "+e.getDpto()); otra forma de hacerlo(mismo q la linea siguiente.
			//rset = stmt.executeQuery("SELECT * from EMPLOYEES E, DEPARTMENTS D WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID ORDER BY E.SALARY DESC");
			rset = stmt.executeQuery(Consultas.CONSULTA_EMPLEADOS_SALARIOS_DESC);
			String nombre = null;
			Integer id = null;
			int salario = 0;
			int dpto = 0;
			String nombre_dpto = null;
			while (rset.next()){
				//System.out.println(rset.getString(1));
				//System.out.println(rset.getString(2));
				//String nombre = rset.getString("FIRST_NAME");
				//Integer id = rset.getInt(1);
				//System.out.println("Nombre= "+nombre+" ID = "+id);
				nombre = rset.getString("FIRST_NAME");
				id = rset.getInt("EMPLOYEE_ID");
				salario = rset.getInt("SALARY");
				dpto = rset.getInt("DEPARTMENT_ID");
				nombre_dpto = rset.getString("DEPARTMENT_NAME");
				Empleado empleado = new Empleado(id, nombre, salario, dpto, nombre_dpto);
				lista_empleados.add(empleado);
				
			}
			mostrarLista(lista_empleados);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally // libero recursos, de "adentro a fuera" , ResultSet,
					// Statment, Conexion
		{
			if (rset != null) {
				try {
					rset.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}

		}

	}

}