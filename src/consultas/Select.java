package consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {
	final static String URL_CONEXION = "jdbc:mysql://localhost:3306/clase?useSSL=false";
	final static String USUARIO = "root";
	final static String PASSWORD = "root";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Listado de Alumnos");

		try {

			// Cargar el driver

			Class.forName("com.mysql.cj.jdbc.Driver");

			// obtener conexion a la bbdd

			Connection conexion = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD);

			String sql = "SELECT * FROM clase.alumno;";
			
			// prepara la sql justo antes de ejecutarla
			
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Ejecuta la consulta con executeQuery.
			
			ResultSet rs = pst.executeQuery();
			
			// recorriendo una a una cada fila
			
			while (rs.next()) {

				int id = rs.getInt("id_alumno");
				String nombre = rs.getString("nombre");
				//double poblacion = rs.getDouble("poblacion");

				System.out.println("ID: " + id);
				System.out.println("NOMBRE: " + nombre);
				
				System.out.println("--------------------------------------");

			}

			// las excepciones van de la mas detallada a la mas general
		} catch (ClassNotFoundException e2) {

			// gestion errores

			e2.printStackTrace();
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}

	}

}

