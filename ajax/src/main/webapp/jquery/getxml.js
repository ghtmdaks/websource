/**
 * getxml.html 에서 메뉴4번을 누르면 동작
 */
//메뉴4와 이벤트를 연결
$(function(){
	$(".container div:last-child").click(function(){
		$.get({
			url:"/data/school.xml",
			success:function(data){
				console.log(data);
				let title = $(data).find("title").text();
				let time = $(data).find("time").text();
				let teacher = $(data).find("teacher").text();
				
				let res = "<ul><li>title : "+title+"</li>";
				res += "<li>time : "+time+"</li>";
				res += "<li>teacher : "+teacher+"</li></ul>";
				
				
				$('#contents').html(res);
			},
			error:function(xhr,textStatus,error){
				$('#contents').html("데이터 없음");
			}
		})
	})
})



/*//자바스크립트로 이벤트를 여는 방법은 html에서 태그에 이벤트리스너를 다는 방법이 있어
//예를 들어 온클릭을 하면 펑셩을 해 이렇게 직접적으로하는 방법이 있고
//그런데 이렇게 건드리는 방법은 원래소스를 직접 건드리는 부분이 있어서 얘를 건드리지 말고 움직이는 동장에 대한 js를 따로 작성을 할거니까
//이 방법으로 하는거야
				//메뉴 4번을 찾아오는 코드 이 찾아온 코드에다가
/*let last_div = document.querySelector(".container div:last-child").addEventListener('click', makeRequest);
						//이벤트를 하나 달거야 클릭이라는 일이 일어나면 makeRequest라는 코드를 호출해줘

	
						
let xhr = new XMLHttpRequest();

function makeRequest(){
	xhr.onreadystatechange = getJson;
	xhr.open("get","/data/school.xml");
	xhr.send();
}

//서버가 응답하는 경우 호출
function getJson(){
	//서버가 보내준 데이터를 contents 영역에 보여주기
	let contents = document.querySelector("#contents");
	
	if(xhr.readyState == 4){
		if(xhr.status == 200){
			//json 데이터르를 자바스크립트 객체로 파싱
			let response = xhr.responseXML;
			console.log(response);
			
			/* xml 자체 형태로 그대로 보여줄 때
			let school = response.getElementsByTagName("school");
			contents.innerText = school[0].innerHTML;
			*/
			
			/*let title = response.getElementsByTagName("title");
			let time = response.getElementsByTagName("time");
			let teacher = response.getElementsByTagName("teacher");
			
			let data = "<ul><li>title : "+title[0].innerHTML+"</li>";
			data += "<li> time : "+time[0].innerHTML+"</li>";
			data += "<li> teacher : "+teacher[0].innerHTML+"</li></ul>";
			
			contents.innerHTML = data;
			
			
			
		}else{
			contents.innerHTML = "가져온 데이터 없음";
			}
	}
}*/