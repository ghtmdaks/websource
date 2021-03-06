package member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.domain.MemberDTO;
import member.domain.UpdateDTO;

import static member.persistence.JdbcUtil.*;

public class MemberDAO {

   private Connection con;
   
   public MemberDAO(Connection con) {
      this.con = con;
   }
   
   //login => select
   public MemberDTO isLogin(String userid, String password) {
	   MemberDTO loginDto = null;
	   
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   try {
		   String sql = "select userid, name from member where userid= ? and password = ?";
		   
		   pstmt = con.prepareStatement(sql);
		   pstmt.setString(1, userid);
		   pstmt.setString(2, password);
		   
		   rs = pstmt.executeQuery();
		   //익스큐트 쿼리는 셀렉트 구문에서 받는다.
		   if (rs.next()) {
			loginDto = new MemberDTO();
			loginDto.setUserid(rs.getString(1));
			loginDto.setName(rs.getString(2));
		}
	   } catch (Exception e) {
		   e.printStackTrace();
	   }finally {
		close(rs);
		close(pstmt);
	}
	   return loginDto;
   }   
	   //회원탈퇴
	   public boolean delete(String userid, String password) {
		   boolean deleteFlag = false;
		   PreparedStatement pstmt = null;
		   try {
			   String sql = "delete from member where userid=? and password=?";
			   
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, userid);
			   pstmt.setString(2, password);
			   
			   int result = pstmt.executeUpdate();
			   //result는 sql문에 실행횟수야 그래서 횟수니까 수니까 인트로 받아
			   
			   if (result>0)  deleteFlag=true;
			   
		   } catch (Exception e) {
			   e.printStackTrace();
		   }finally {
			close(pstmt);
		}
		   return deleteFlag;
	   }
		   
		   //비밀번호 변경
		   public boolean update(UpdateDTO updateDto) {
			   boolean updateFlag = false;
			   PreparedStatement pstmt = null;
			   try {
				   String sql = "update member set password = ? where userid=? and password=?";
				   
				   pstmt = con.prepareStatement(sql);
				   pstmt.setString(1, updateDto.getNewPassword());
				   pstmt.setString(2, updateDto.getUserid());
				   pstmt.setString(3, updateDto.getCurrentPassword());
				   
				   int result = pstmt.executeUpdate();
				   
				   if (result>0)  updateFlag=true;
				   
			   } catch (Exception e) {
				   e.printStackTrace();
			   }finally {
				close(pstmt);
			}
			   return updateFlag;
		   }
		   
		   //회원가입
		   public boolean insert(MemberDTO dto) {
			   PreparedStatement pstmt= null;
			   boolean registerFlag = false;
			   try {
				String sql = "insert into member values(?, ?, ?, ?, ?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getUserid());
				pstmt.setString(2, dto.getPassword());
				pstmt.setString(3, dto.getPassword());
				pstmt.setString(4, dto.getGender());
				pstmt.setString(5, dto.getEmail());
				
				int result = pstmt.executeUpdate();
				
				if (result>0) registerFlag = true;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return registerFlag;
			   
		  }
		   //중복 아이디 검사
		   public boolean idCheck(String userid) {
			  
			   PreparedStatement pstmt = null;
			   ResultSet rs = null;
			   boolean dupFlag = true;
			   
			  try {
				  String sql = "select * from member where userid=?";
				  pstmt = con.prepareStatement(sql);
				  pstmt.setString(1, userid);;
				  rs = pstmt.executeQuery();
				  
				  if(rs.next()) {
					  dupFlag = false;
				  }
				  
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return dupFlag;
		}
   }