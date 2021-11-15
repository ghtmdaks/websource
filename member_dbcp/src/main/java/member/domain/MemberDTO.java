package member.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
	private String userid;
	private String password;
	private String changePasswored;
	private String name;
	private String gender;
	private String email;
	//내가 원하는 생성자를 이런식으로 추가로 생성할 수 있어
	public MemberDTO(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}
	
}
