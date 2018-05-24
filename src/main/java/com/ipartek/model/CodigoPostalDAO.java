package com.ipartek.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.pojo.Busqueda;
import com.ipartek.pojo.Usuario;


public class CodigoPostalDAO {

	private static CodigoPostalDAO INSTANCE = null;

	private CodigoPostalDAO() {
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CodigoPostalDAO();
		}
	}

	public static CodigoPostalDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}	
	
	public boolean guardar(Busqueda pojo) {
		boolean resul = false;
		
		String sql = "INSERT INTO codigos (busqueda, id_usuario) VALUES ( ?, ? );";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			// Asigno los valores a la consulta
			pst.setString(1, pojo.getCodigo());
			pst.setInt(2, pojo.getId_usuario());
			
			// EJecuto la insert y recojo el resultado
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// recuperar ID generado de forma automatica
				try (ResultSet rs = pst.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getInt(1));
						resul = true;
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("usuario_id"));
		u.setNombre(rs.getString("usuario_nombre"));
		u.setPass(rs.getString("password"));		

		return u;
	}

}
