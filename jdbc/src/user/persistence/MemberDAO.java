package user.persistence;

import static user.persistence.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import user.domain.MemberDTO;

@AllArgsConstructor
public class MemberDAO {
	private Connection con;
		
	//insert
	public boolean insert(MemberDTO dto) {
		boolean insertFlag = false;
		PreparedStatement pstmt = null;
				
		try {
			String sql = "insert into member(userid, password, name, gender, email) values(?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getEmail());
			
			int result = pstmt.executeUpdate();
			
			if (result>0) {
				insertFlag=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//connection은 이제부터 여기서는 닫지 않을거야
			//JdbcUtil.close(pstmt);
			close(pstmt);
		}
		
		
		return insertFlag;
	}
	
	//제일 첫번째는 sql 구문 결정하는 거야!
	//update
	public boolean update(MemberDTO dto) {
							//updateProcess에서 사용자의 입력값을 MemberDTO dto에 담았잖아
		String sql = "update MEMBER set password=? where userid=? and password=?";
		
		PreparedStatement pstmt = null;
		boolean updateFlag = false;
		
		try {
			//? 해결하기
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getChangePasswored());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getPassword());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) updateFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return updateFlag;
	}
	
	
	//delete
	public boolean delete(String userid, String password) {
		boolean deleteFlag = false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from member where userid =? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			int result = pstmt.executeUpdate();
			if (result>0) {
				deleteFlag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteFlag;
	}
	
	//select - 개별 조회
	public MemberDTO getRow(MemberDTO dto) {
		MemberDTO dto1 = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from MEMBER where userid=? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto1 = new MemberDTO();
				dto1.setUserid(rs.getString("userid"));
				dto1.setName(rs.getString("name"));
				dto1.setGender(rs.getString("gender"));
				dto1.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return dto1;
	}
	
	
	//select - 전체 조회
	public List<MemberDTO> getRows() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			String sql = "select * from member";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				MemberDTO dto = new MemberDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setEmail(rs.getString("email"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
