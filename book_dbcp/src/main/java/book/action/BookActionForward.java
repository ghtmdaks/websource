package book.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookActionForward {
	//경로랑 이동 방법을 담는 클래스얌
	
	private String path;
	private boolean redirect;
}
