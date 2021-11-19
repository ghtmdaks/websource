package board.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 이동경로, 이동방식 저장 클래스

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardActionForward {
	private String path;
	private boolean redirect;
}
