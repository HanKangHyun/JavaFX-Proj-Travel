package review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.dao.ReviewDAO;
import db.dto.ReviewDTO;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ReviewDAOImpl implements IReviewDAO{
	private static ReviewDAO singleton;
	@FXML private ImageView imageView;
	
	public ReviewDAOImpl() {
		if(singleton == null) {
			singleton = new ReviewDAO();
		}
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
			sql.append("ORDER BY review_image DESC");
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

	@Override
	public void insertReview(ReviewDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/travel","kic12","kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO review(review_name, review_content, review_summary, review_image) ");
			sql.append("VALUES(?,?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index=1;
			pstmt.setString(index++, dto.getReview_name());
			pstmt.setString(index++, dto.getReview_content());
			pstmt.setString(index++, dto.getReview_summary());
			pstmt.setString(index,   dto.getReview_image());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
		
	}
}
