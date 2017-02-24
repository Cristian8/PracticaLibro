package modifi.consul.base.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Date;

import javax.print.attribute.SetOfIntegerSyntax;




public class BaseDatosUpdate {

	private static void liberarRecursos (Statement st, ResultSet rs)
	{
		
		if (rs != null) 	{ try { rs.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (st != null)	{ try {	st.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		
	}
	
	
	private static void liberarRecursos (Statement st)
	{
		
		if (st != null)	{ try {	st.close(); } catch (Exception e2) { e2.printStackTrace(); }}
	  	
		
	}
	
	private static void liberarRecursos (Connection conn)
	{
		
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	  	
		
	}
	
	private static void subeSueldo (Connection conn)
	{
		Statement st = null;
		
		try
		{
			st = conn.createStatement();
			st.execute(Consulta.ACTUALIZAR_EMPLEADOS_SALARIO_ADMON_E_IT);//UPDATE
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			liberarRecursos(st);
			
		}
	}
	
	private static void consultaEmpleados (Connection conn)
	{
		Statement st = null;
		ResultSet rs = null;
		
		try{
			
			st = conn.createStatement();
			rs = st.executeQuery(Consulta.CONSULTA_EMPLEADOS_SALARIO_ADMON_E_IT);
			String nombre = null;
			Integer salario = 0;
			System.out.println("----------------------");
			System.out.println("INICIO DE MOSTRAR");
			System.out.println("----------------------");
			
			
			while (rs.next())
			    {
					nombre = rs.getString(1);
					salario = rs.getInt(2);
					System.out.println("Nombre = "+nombre + " || Salario = " +salario);
				 }
			System.out.println("----------------------");
			System.out.println("FIN DE MOSTRAR");
			System.out.println("----------------------");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			liberarRecursos(st, rs);
			
		}
			
	}
public static void consultaHistoricoSubidaSalarios(Connection conn) throws SQLException{
		
		Statement st = null;
		ResultSet rs = null;
		
		try{
			
			st = conn.createStatement();
			rs = st.executeQuery(Consulta.CONSULTA_HISTORICO_SALARIO );
			Integer id_usuario = 0;
			Integer salario_antiguo = 0;
			Integer salario_nuevo = 0;
			Date fecha = null;
			
			while (rs.next())
			    {
					id_usuario = rs.getInt(5);
					salario_antiguo = rs.getInt(1);
					salario_nuevo = rs.getInt(2);
					fecha = rs.getDate(3);
					System.out.println("ID = "+id_usuario + " salario antiguo = " +salario_antiguo 
							+ " salario nuevo = "+salario_nuevo + " fecha = "+ fecha);
				 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			
		}
		finally 
		{
			liberarRecursos(st, rs);
			
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		//Savepoint sv = null;
		
		try{
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "password");
		    conn.setAutoCommit(false);
		    subeSueldo(conn);//Update
		    //sv = conn.setSavepoint();//GUARDAR
		    consultaHistoricoSubidaSalarios(conn);
		    
			//consultaEmpleados(conn);
		    
		   
		    consultaEmpleados(conn);
		    conn.commit();
		    
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error ejecutando bd");
			conn.rollback();
			/*if(sv != null){
				conn.rollback(sv);
				System.out.println("cambios guardados");
			}else{
				conn.rollback();
				System.out.println("no se a guardado los cambios");
			}*/
			
			
		} finally {
			liberarRecursos(conn);
		}
	}


}
/*
*	try
*  {
*  AUTOCOMMIT <---FALSE
*  (UPDATE
*  SAVEPOINT
*  , TRIGGER, SELECT)
*  COMMIT
*  }catch () {ROLLBACK(SAVEPOINT) }
*  finally (LIBERO RECURSOS)
*
*
*/