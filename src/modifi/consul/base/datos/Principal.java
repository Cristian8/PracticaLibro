package modifi.consul.base.datos;
//Aplicación que actualice el salario +20% al departamento de Administración.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Principal {
	
	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		ResultSet rset = null;
		int rset2 = 0;
		Statement stmt = null;
		int salario1 = 0;
		int empleado_id = 0;
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "paswword");
		         stmt = conn.createStatement();
		         rset = stmt.executeQuery("select * from EMPLOYEES where JOB_ID like 'AD%'");
		         //rest = stmt.executeQuerry("select department_id from departments where department_name='administration');
		         rset2 = stmt.executeUpdate("UPDATE EMPLOYEES SALARY SET SALARY=round(SALARY*0.20+ SALARY,2) WHERE JOB_ID like 'AD%'");
		         //rset2 = stmt.executeUpdate("UPDATE EMPLOYEES SALARY SET SALARY=round(SALARY*1.2) WHERE DEPARTMENTS_ID=10");
		         //UPDATE EMPLOYEES SALARY SET SALARY=round(SALARY*1.2) WHERE DEPARTMENT_ID=10 OR SALARY.DEPARTMENT_ID=60; CONSULTA ANIDADA
		         conn.setAutoCommit(false);//normalmente esta a true y se hace commit siempre al cerrar la conexion de la db, pero se puede poner a false
		     //conn.commit();//para realizar el commit 
		         while (rset.next())
		{
		// salario1 = rset.getInt("SALARY");
		// salario1 = (int) (salario1+(salario1*0.20));
		empleado_id = rset.getInt("EMPLOYEE_ID");
		conn.setAutoCommit(false);//normalmente esta a true y se hace commit siempre al cerrar la conexion de la db, pero se puede poner a false
		      conn.commit();//para realizar el commit 
		}
		         System.out.println("El departamento Administración: "+empleado_id+" aumenta su salario a "+salario1);
		}
		catch(Exception e)
		{ 
		e.printStackTrace();
		}
		finally 
		{
		if (rset != null) { try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null) { try { stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) { try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		    
		} 

		}

		}
