package member.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//이동경로와 이동방식을 저장한다.
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ActionForward {
	private String path;
	private boolean redirect;
	//리다이렉트 샌드리다이렉트랑 포워드 결정하는거야 
	//포워드는 트루
}
