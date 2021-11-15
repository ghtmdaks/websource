/**
 * joinForm.jsp 회원가입 유효성 검증
 */

$(function(){
	$("#joinform").validate({
		rules:{
			userid:{
				required:true,
				validId:true,
				remote:{	//ajax
					url:"/dupId.do",
					type:"post",
					data:{
						userid:function(){							
						return $("#userid").val();						
						}
					}
				}
			},
			password:{
				required:true,
				validPwd:true,
			},
			confirm_password:{
				required:true,
				validPwd:true,
				ewqualTo:"#password"
			},
			name:{
				required:true
			},
			gender:{
				required:true
			},
			email:{
				required:true,
				email:true,
			},

		},
		messages:{
			userid:{
				required:"아이디는 필수 정보 입니다.",
				remote:"이 아이디는 사용 중 입니다."
			},
			password:{
				required:"비밀번호는 필수 정보 입니다."
			},
			confirm_password:{
				required:"비밀번호는 필수 정보 입니다.",
				ewqualTo:"이전 비밀번호와 다릅니다."
			},
			name:{
				required:"이름은 필수 정보 입니다."
			},
			gender:{
				required:"성별은 필수 정보 입니다."
			},
			email:{
				required:"이메일은 필수 정보 입니다.",
				email:"이메일 주소를 확인해 주세요."
			},
		},
		errorPlacement:function(error,element){
	/**id랑 똑같은 small id 태그를 찾아서 넣어줘 */
			$(element).closest("form").find("small[id='"+element.attr("id")+"']")
					  .append(error);
		}
		
	})
})
//사이ㅋ트 규칙 추가
$.validator.addMethod("validId", function (value) {
    let regId = /^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z\d]{6,12}$/;
    return regId.test(value); // true or false
  },"아이디는 영대소문자, 숫자의 조합으로 6~12자리로 만들어야 합니다.")

$.validator.addMethod("validPwd", function (value) {
    let regPwd = /^(?=.*[A-Za-z])(?=.*[\d])(?=.*[!@$*])[A-Za-z\d!@$*]{8,15}$/;
    return regPwd.test(value); // true or false
  },"비밀번호는 영대소문자, 숫자의 조합으로 8~15자리로 만들어야 합니다.")