/**
 * getjson.html 에서 메뉴4번을 누르면 동작
 */
//메뉴4와 이벤트를 연결
$(function(){
	$(".container div:last-child").click(function(){
		$.getJSON({
			url:"/data/dataArray.json",
			success:function(data){
				
				let resText = "<ul>";
				
				$(data).each(function(indx, item){
				resText += "<li>version : " + item.version + "</li>";
				resText += "<li>codename : " + item.codename + "</li>";
				})
				
				resText += "</ul>";
				
				$("#contents").html(resText);
			},
			error:function(xhr,textStatus,error){
				$("#contents").html("데이터 없음");
			}
		})
	})
	
})


//자바스크립트로 이벤트를 여는 방법은 html에서 태그에 이벤트리스너를 다는 방법이 있어
//예를 들어 온클릭을 하면 펑셩을 해 이렇게 직접적으로하는 방법이 있고
//그런데 이렇게 건드리는 방법은 원래소스를 직접 건드리는 부분이 있어서 얘를 건드리지 말고 움직이는 동작에 대한 js를 따로 작성을 할거니까
//이 방법으로 하는거야
				//메뉴 4번을 찾아오는 코드 이 찾아온 코드에다가
/*let last_div = document.querySelector(".container div:last-child").addEventListener('click', makeRequest);
						//이벤트를 하나 달거야 클릭이라는 일이 일어나면 makeRequest라는 코드를 호출해줘

	
						
let xhr = new XMLHttpRequest();

function makeRequest(){
	xhr.onreadystatechange = getJson;
	xhr.open("get","/data/dataArray.json");
	xhr.send();
}

//서버가 응답하는 경우 호출
function getJson(){
	//서버가 보내준 데이터를 contents 영역에 보여주기
	let contents = document.querySelector("#contents");
	
	if(xhr.readyState == 4){
		if(xhr.status == 200){
			//json 데이터르를 자바스크립트 객체로 파싱
			let response = JSON.parse(xhr.responseText);
			
			console.log(response);
			
			let resText = "<ul>";
			
			response.forEach((item)=>{
				resText += "<li>version : " + item.version + "</li>";
				resText += "<li>codename : " + item.codename + "</li>";
			})
			contents.innerHTML = resText + "</ul>";
		}else{
			contents.innerHTML = "가져온 데이터 없음";
		}
	}
}*/