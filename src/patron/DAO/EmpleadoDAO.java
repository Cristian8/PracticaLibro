package patron.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadoDAO {

	/**
	 * Método que recupera los datos de los empleados que hay en un departamento.
	 * @param id_dpto Id del departamento cuyos empleados quiero obtener
	 * @return Lista de empleados del departamento de id id_dpto
	 */
	public ArrayList<EmpleadoDTO> consultarAllEmpleados (int id_dpto)
	{
		ArrayList<EmpleadoDTO> lista_empleados = null;
		lista_empleados = new ArrayList<EmpleadoDTO>();	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		int id = 0;
		String nombre = null;
		int salario = 0;
		int dpto = 0;
		
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password"); 
	  	        stmt = conn.createStatement(); 
	  	        rset = stmt.executeQuery(Consulta.CONSULTA_EMPLEADOS_DEPARTAMENTO+id_dpto);
	  	        while (rset.next()) 
				{	
			   		 	 id = rset.getInt(1);
				   		 nombre = rset.getString("FIRST_NAME");
				   		 salario = rset.getInt("SALARY");
				   		 dpto = rset.getInt("DEPARTMENT_ID");
				   	
				   		 lista_empleados.add(new EmpleadoDTO(id, nombre, salario, dpto));//se añade al array q hemos creado
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
				if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
				if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
			  	   
			}   
		
		return lista_empleados;
	}
}
