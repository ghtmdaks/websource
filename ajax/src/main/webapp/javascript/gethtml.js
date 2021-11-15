/**
 * 
 */
function gethtml() {
	//페이지가 로드가 되자마자 서버가 가지고 있는 html페이지를 가져와서 div안에 
	//보여주기 => 비동기식 처리

	//XMLHttpRequest 객체 생성
	let httpRequest = new XMLHttpRequest();

	//생성된 객체를 통해 서버에게 보낼 요청 설정
	httpRequest.open("get", "/data/data.html");

	//서버로 전송 - get방식일 때는 null or 비워두기, post 일때는 전송할 데이터 포함
	httpRequest.send(null);

	//서버가 응답 : 200(성공), 400(404), 500(서버에러)
	httpRequest.onreadystatechange = function() {
				//서버로부터 데이터 전송 여부 확인
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				//성공을 하면 가져와서 div안에 보여줄거야 >gethtml.html 에 아무것도 없는 div
				let div = document.querySelector("div:last-of-type");
				//그안에 내가 가지고온 응답 내용 보여줄 거야
				div.innerHTML = httpRequest.responseText;
			}
		}
	}

}