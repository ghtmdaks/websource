package book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookListService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BookListAction implements BookAction {
	
	private String path; ///veiw/all.jsp

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception{
		
		BookListService service = new BookListService();
		List<BookDTO> list = service.getList();
		
		request.setAttribute("list", list);
		
		
		//setAttribute 에 담으면 무조건 false 외우라고 했지?
		return new BookActionForward(path, false);
	}

}
