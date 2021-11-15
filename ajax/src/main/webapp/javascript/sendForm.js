/**
 *  sendForm.html
 */
//body가 로드가 되면
//위도우가 로드가 되면 펑션하고 연결을 할거야
window.onload = function(){
	document.getElementById("get").onclick =function(){
		let userid = document.getElementById("userid").value;
		let age = document.getElementById("age").value;
		
		//데이터 전송 (비동기)
		let xhr = new XMLHttpRequest();
		//무슨방식으로 보낼거야? 어디로보낼거야?
		xhr.open("get","sendForm.jsp?userid="+userid+"&age="+age);
		xhr.send();
	}
	document.getElementById("post").onclick =function(){
		let userid = document.getElementById("userid").value;
		let age = document.getElementById("age").value;
		
		//데이터 전송 (비동기)
		let xhr = new XMLHttpRequest();
		xhr.open("post","sendForm.jsp");
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("userid="+userid+"&age="+age);
	}
}