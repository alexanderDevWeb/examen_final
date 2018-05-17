package com.ipartek.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.ipartek.pojo.Usuario;

public class PruebaDAO {
	
	
	// Patron Singleton --------------------------------------------
	
	private static PruebaDAO INSTANCE = null;
	
	private PruebaDAO() {
	}

	// creador synchronized para protegerse de posibles problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PruebaDAO();
		}
	}

	public static PruebaDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}
	
	// Fin Patron Singleton --------------------------------------------
	
	
	public ArrayList<Usuario> getAll(String nombre) {
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		String sql = "SELECT id, nombre, password FROM usuario WHERE nombre NOT LIKE ? LIMIT 20";
		
		/*
		 * CONSULTA NO PREPARADA
		 */
		/*
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
		 *
		 */
		
		/**
		 * CONSULTA PREPARADA
		 */
		try (Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);) {
			
			// Se da un valor a los valores pendientes, en orden de aparición
			pst.setString(1, "%" + nombre + "%");	
			System.out.println(nombre);
			
			ResultSet rs = pst.executeQuery();
			
			// inicializo un usuario
			Usuario u = null;
			
			while (rs.next()) {
				u = mapper(rs);
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public boolean save(Usuario pojo) {
		boolean resul = false;		
		// Dpendiendo de si el objeto tiene id -1 o no, realiza una operación
		if (pojo != null) {
			if (pojo.getId() == -1) {
				resul = crear(pojo);
			} else {
				resul = modificar(pojo);
			}
		}

		return resul;
	}

	private boolean modificar(Usuario pojo) {
		boolean resul = false;
		String sql = "UPDATE `material` SET `nombre`= ? , `precio`= ? WHERE  `id`= ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getNombre());
			pst.setString(3, pojo.getNombre());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private boolean crear(Usuario pojo) {
		boolean resul = false;
		
		String sql = "INSERT INTO `material` (`nombre`, `precio`) VALUES ( ? , ? );";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getNombre());

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

	private Usuario mapper(ResultSet rs) throws SQLException {
		
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setPass(rs.getString("password"));	

		return u;
	}
	
	
	

}
