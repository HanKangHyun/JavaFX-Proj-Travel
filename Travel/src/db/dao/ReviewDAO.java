package db.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.dto.ReviewDTO;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ReviewDAO {
	private static ReviewDAO singleton;
	@FXML private ImageView imageView;
	
	
	public static ReviewDAO getInstance() {
		if(singleton == null) {
			singleton = new ReviewDAO();
		}
		return singleton;
	}
	
	public ArrayList<ReviewDTO> select() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReviewDTO> list = new ArrayList<ReviewDTO>();
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/travel","kic12","kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * ");
			sql.append("FROM review ");
			//sql.append("LIMIT 0,4");
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String review_name = rs.getString(1);
				String review_content = rs.getString(2);
				String review_summary = rs.getString(3);
				String review_image = rs.getString(4);
				
				list.add(new ReviewDTO(review_name, review_content, review_summary, review_image));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		
		return list;
	}
	
	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}






