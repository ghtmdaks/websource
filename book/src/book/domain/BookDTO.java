package book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class BookDTO {
	
	private String code;
	private String title;
	private String writer;
	private int price;
}
