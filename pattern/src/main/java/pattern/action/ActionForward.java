package pattern.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActionForward {
	//이동경로와 
	private String path;
	//이동방식 저장
	private boolean redirect; //true로 지정을하면 sendRedirect 
							  //false로 지정을 하면 forward 로 갈거야
}
