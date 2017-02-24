package conectar.base.datos;

public class Consultas {
	public static final String CONSULTA_EMPLEADOS_SALARIOS_DESC = "SELECT * from EMPLOYEES E, "
			+ "DEPARTMENTS D WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID ORDER BY E.SALARY DESC";
}
