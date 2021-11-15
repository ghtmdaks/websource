package book.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import book.domain.BookDTO;

import static book.persistence.JdbcUtil.*;

public class BookDAO {
   private Connection con;
   
   public BookDAO(Connection con) {
      this.con = con;
   }
   
   //INSERT
   public boolean insert(BookDTO dto) {
      String sql = "insert into bookTBL values(?,?,?,?)";
      boolean insertFlag = false;

      PreparedStatement pstmt = null;
      
      try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, dto.getCode()); 
         pstmt.setString(2, dto.getTitle());
         pstmt.setString(3, dto.getWriter());
         pstmt.setInt(4, dto.getPrice());
         
         int result = pstmt.executeUpdate();
         
         if(result>0) insertFlag =true;
         
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            close(pstmt);
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return insertFlag;
   }
   //DELETE
   public boolean delete(String code) {
      boolean deleteFlag = false;
      PreparedStatement pstmt = null;
      
      try {
    	  String sql = "delete from bookTBL where code =?";
    	  pstmt =  con.prepareStatement(sql);
    	  pstmt.setString(1, code);
          int result = pstmt.executeUpdate();
         
         if(result>0) deleteFlag = true; 
         
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
           close(pstmt);
      }
      return deleteFlag;
   }
   
   //UPDATE
   public boolean update(String code, int price) {
      boolean updateFlag = false;
      PreparedStatement pstmt = null;
      
      try {
         String sql = "update bookTBL set price=? where code=?";
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, price);
         pstmt.setString(2, code);
         
         int result = pstmt.executeUpdate();
  
         if(result>0) updateFlag=true;
      	  
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
    	  close(pstmt);
      }
      
      return updateFlag;
   }
   
   //SELECT
   public List<BookDTO> list(){
	   List<BookDTO> booklist = new ArrayList<BookDTO>();
	   
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   try {
		   String sql = "select * from bookTBL";
		   pstmt = con.prepareStatement(sql);
		   rs = pstmt.executeQuery();
			
			while(rs.next()){
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				
				booklist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
	   return booklist;
   }
   
   //검색
   public List<BookDTO> search(String criteria, String keyword) {
	   List<BookDTO> booklist = new ArrayList<BookDTO>();
	   
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   try {
		   String sql = "select * from bookTBL where "+criteria+" = ?";
		   pstmt = con.prepareStatement(sql);
		   pstmt.setString(1, keyword);
		   rs = pstmt.executeQuery();
			
			while(rs.next()){
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				
				booklist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
	   return booklist;
   }
}