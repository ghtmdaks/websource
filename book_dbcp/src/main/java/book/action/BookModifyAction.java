package book.action;

import javax.servlet.http.HttpServletRequest;

import book.service.BookModifyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookModifyAction implements BookAction {
	
	private String path;
	
	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception{
		// modify.jsp 에서 넘긴 값 가져오기
		String code = request.getParameter("code");
		int price = Integer.parseInt(request.getParameter("price"));

		//서비스한테 db작업 시키기
		BookModifyService service = new BookModifyService();
		boolean updateFlag = service.bookUpdate(code, price);
		
		if (!updateFlag) {
			path = "/index.jsp?tab=modify";
		}
		return new BookActionForward(path, true);
	}

}
