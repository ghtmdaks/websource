/**
 * 영화진흥위원회 일일박스 오피스 오픈 api -json 데이터
 */
$(function(){
   init();
   $(":button").click(function(){
      let url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
      url += $("#txtYear").val() + $("#selMon").val() + $("#selDay").val();
      console.log(url);
		//getJSON으로 받으면 편해
      $.getJSON({
         url:url,
         success:function(data){
            console.log(data);
			
			//.으로 접근하면 돼            
            if(data.boxOfficeResult.dailyBoxOfficeList === ""){
               alert("데이터가 없습니다.");               
            }else{
               let resData = "";         
               $(data.boxOfficeResult.dailyBoxOfficeList).each(function(idx,item){					
                  // 순위
                  resData += item.rank+"위";
                  // 증감
                  let rankInten = item.rankInten;
                  
                  if(rankInten >0) resData += "( ▲ ";
                  else if(rankInten<0) resData += "( ▼ ";
                  else resData+="( ";
                  
                  resData += rankInten+" )";   

				  //영화 코드
				  let movieCd = item.movieCd;
                  
                  //영화 이름 
                  let movieNm = item.movieNm;

				  resData += "<a href='#' onclick='javascript:show("+movieCd+")'>"+movieNm+"</a><br>";
               })
		
               $("#msg").html(resData);

            }
         }
      })
   }) //$(button()) end
}) //$(function()) end            

function show(movieCd){
	//영화상세정보 요청
	let url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=";
	url += movieCd;
	
	console.log(url);
	
	let movieInfo = data.movieInfoResult.movieInfo;
	
	$. get({
		url:url,
		success:function(data){
			console.log(data);
			
			//영화제목(한글)
			let movieNm = movieInfo.movieNm;
			//영화제목(영어)
			let movieNmEn = movieInfo.movieNmEn;
			//상영시간
			let showTm = movieInfo.showTm;
			//감독명 =>디렉터스 안에 디렉터 안에 피플nm을 차장야해
			let directorNm = movieInfo.directors[0].peopleNm;
			//출연배우명 => 엑터를 찾아서 엑트스들을 파인드하고 포문을 돌려야해
			let peopleNm = "";
			//출연배우의 수
			let length = movieInfo.actor.length;
						
			$(movieInfo.actor).each(function(idx,item){
												//idx는 for(var i=0;i<actor.length)의 i를 의미해
												
				if(idx == length - 1){
				peopleNm += item.peopleNm;
				}else{
				peopleNm += item.peopleNm+ ", ";
					
				}
			})
			
			//보여주기
			let resData = "<ul>";
			resData += "<li>영화제목(국문) : "+movieNm+"</li>";	
			resData += "<li>영화제목(영문) : "+movieNmEn+"</li>";	
			resData += "<li>상영시간 : "+showTm+" 분</li>";	
			resData += "<li>감독 : "+directorNm+"</li>";	
			resData += "<li>출연배우 : "+peopleNm+"</li></ul>";
			
			$(".box3").html(resData);	
			
		}
	})
} //show() end

function init(){
   // 어제 날짜 추출
   let newDate = new Date();
   let year = newDate.getFullYear();
   let month = newDate.getMonth()+1;
   let day = newDate.getDate()-1;
   $("#txtYear").val(year);
   
   if(month <10){
      month = "0"+month;
      
   }
   if(day<10){
      day = "0"+day;
   }
   $("#selMon").val(month);
   $("#selDay").val(day);
}
