package com.icaballero.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.icaballero.amazonviewer.db.IDBConnection;
import com.icaballero.amazonviewer.domain.Movie;
import static com.icaballero.amazonviewer.db.DataBase.*;

public interface MovieDAO extends IDBConnection {
	
	default Movie setMovieViewed(Movie movie){
		try(Connection connection = connecToDB()){
			Statement statement = connection.createStatement();
			String query = "INSERT INTO " + TVIEWED + 
							" ("+TVIEWED_IDMATERIAL+", "+TVIEWED_IDELEMENT+", "+TVIEWED_IDUSER+")"+
							"VALUES("+TMATERIAL_ID[0]+", "+movie.getId()+")";
			
			if (statement.executeUpdate(query) > 0) {
				
				System.out.println("Se marco en visto");
				
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		return movie;
	}
	
	default ArrayList<Movie> read(){
		ArrayList<Movie> movies = new ArrayList<Movie>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		
		try(Connection connection = connecToDB()){
			String query = "SELECT * FROM " +TMOVIE;
			preparedStatement = connection.prepareStatement(query);
			 rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Movie movie = new Movie(rs.getString(TMOVIE_TITLE), rs.getNString(TMOVIE_GENRE), rs.getString(TMOVIE_CREATOR), rs.getInt(TMOVIE_DURATION), (short)rs.getInt(TMOVIE_YEAR));
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setViewed(getMovieViewed(preparedStatement, connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
			}
			
		}catch (SQLException e) {
			
		}finally{
			try{
				if(preparedStatement!= null){
					preparedStatement.close();
				}
				
				if(rs!=null){
					rs.close();
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}

		}
		
		return movies;
		
	}
	
	default boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection,int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM " + TVIEWED + "WHERE " + TVIEWED_IDMATERIAL + "= ?" + "AND " + TVIEWED_IDELEMENT
				+ "= ?" + "AND " + TVIEWED_IDUSER + "= ?";
		
		ResultSet rs = null;
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, TMATERIAL_ID[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, TUSER_ID);
			
			rs = preparedStatement.executeQuery();
			//Si hay un dato devuelve true
			viewed = rs.next();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
