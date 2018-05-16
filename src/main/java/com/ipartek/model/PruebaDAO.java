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

	private Usuario mapper(ResultSet rs) throws SQLException {
		
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setPass(rs.getString("password"));	

		return u;
	}
	
	
	

}
