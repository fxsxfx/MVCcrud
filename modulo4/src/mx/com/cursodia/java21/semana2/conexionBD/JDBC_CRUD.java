package mx.com.cursodia.java21.semana2.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JDBC_CRUD
{

	Connection con;
	public static void main(String[] args)
	{
		JDBC_CRUD crud = new JDBC_CRUD();
		crud.conectar();
		crud.insertMarcas();
		crud.leerMarcas();
		crud.deleteMarca();
		crud.cerrarConexion();
	}
	
	private void conectar() 
	{
		
		try {
			con = DriverManager.getConnection(DB_Config.SERVER, DB_Config.USER, DB_Config.PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(con != null)
		{
			System.out.println("Conexion a la BD establecida");
		}
	}
	
	private void leerMarcas()
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT * FROM marcas";
		
		try {
			pstm = con.prepareStatement(query);
			rs = pstm.executeQuery();
			
			System.out.println("Cve\t\tNombre\t\tProveedor");
			while(rs.next())
			{
				System.out.print(rs.getInt("cve_marca")+"\t\t");
				System.out.print(rs.getString("nom_marca")+"\t\t");
				System.out.println(rs.getString("cveprov_marca")+"\t\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void cerrarConexion()
	{
			try {
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void insertMarcas()
	{
		int cve = Integer.parseInt(JOptionPane.showInputDialog("Clave: "));
		String nom = JOptionPane.showInputDialog("Nombre: ");
		int cve_prov = Integer.parseInt(JOptionPane.showInputDialog("Clave de provedor:"));
		
		Statement st = null;
		
		try {
			st = con.createStatement();
			st.executeUpdate("INSERT INTO marcas (cve_marca, nom_marca, cveprov_marca) VALUES ("+cve+", '"+nom+"', "+cve_prov+");");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			
			try {
				if(st != null) st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void insertMarcas2()
	{
		int cve = Integer.parseInt(JOptionPane.showInputDialog("Clave: "));
		String nom = JOptionPane.showInputDialog("Nombre: ");
		int cve_prov = Integer.parseInt(JOptionPane.showInputDialog("Clave de provedor:"));
		
		String query = "INSERT INTO marcas (cve_marca, nom_marca, cveprov_marca) "
				+ "VALUES (?,?,?);";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, cve); //indice comienza en 1
			pstm.setString(2, nom);
			pstm.setInt(3, cve_prov);
			
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			
			try {
				if(pstm != null) pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void deleteMarca() 
	{

		int cve_marca = Integer.parseInt(JOptionPane.showInputDialog("Clave de la marca a eliminar:"));
		    
		String query = "DELETE FROM marcas WHERE cve_marca = ?";
		
		PreparedStatement pstm = null;
		    
		try{
			pstm = con.prepareStatement(query);
			pstm.setInt(1, cve_marca);
		        
			int filasAfectadas = pstm.executeUpdate();
		        
			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "¡Marca eliminada correctamente!");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró la marca con clave: " + cve_marca, 
						"Error", JOptionPane.WARNING_MESSAGE);
			}
		        
		} catch (SQLException e) {
			if (e.getSQLState().equals("23000")) { // Código para violación de FK
				JOptionPane.showMessageDialog(null, 
						"No puedes eliminar esta marca porque tiene productos asociados.", 
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, 
						"Error al eliminar: " + e.getMessage(), 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		finally
		{
			
			try {
				if(pstm != null) pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
