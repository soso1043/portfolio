// JavaScript Document

$(function(){
	
		$(".lang, nav, .widgets").hide();
		
		//네비게이션 열기 닫기
		$(".nav").mouseenter(function(){
				$("nav").stop().slideDown()
			})
		$("nav").mouseleave(function(){
				$("nav").stop().slideUp()
			})
		
			
		
		//배너창 닫기
		$(".close").click(function(){
				$(".banner").slideUp()
			})
			
		
		//언어선택창
		$(".smenu .inner a:nth-child(4)").click(function(){
				$(".lang").toggle();
			})
			
//------------------모바일 네비게이션------------------------------------
$(".m_nav").click(function(){
	$(".nav").toggleClass("sub_nav")
	//$(".nav").slideToggle()
	
	})	
	
$(".nav a").click(function(){
	$(".nav").toggleClass("sub_nav")
	
	})			

		
// 회원가입 모달창 닫기

 var btn = document.getElementsByClassName("close_m")[0] //닫기버튼
 var modal = document.getElementById("member")           //배경창
 var mem = document.getElementsByClassName("join")[0]    //회원가입 버튼

btn.onclick=function(){
	modal.style.display="none"    //종료
	
	}

mem.onclick=function(){
	modal.style.display="block"   //실행
	
	}	
	
	
	// 회원가입 모달창 닫기

 var btn = document.getElementsByClassName("close_l")[0] //닫기버튼
 var modal2 = document.getElementById("login")           //배경창
 var mem = document.getElementsByClassName("login")[0]    //회원가입 버튼

btn.onclick=function(){
	modal2.style.display="none"    //종료
	
	}

mem.onclick=function(){
	modal2.style.display="block"   //실행
	
	}	
		

// 위젯 닫기



$(".ebook").click(function(){
	$(".widgets").css("display","block")
	
	})
$(".close_w").click(function(){
	$(".widgets").css("display","none")
	
	})


		
	
window.onclick = function(e){
	if(e.target==modal||e.target==modal2){
		modal.style.display="none"
		modal2.style.display="none"
		}
	}	
	
	
			
	
	})

//-------------------메인 슬라이더 ---------------------------------
$(function(){
  $('.slider').bxSlider({
    mode: 'fade',
    captions: true,
	auto:true
  });
});


//--------------------ajax메뉴링크----------------------

 
 $(function(){
	//주메뉴 링크
	 $(".nav a").each(function(n) {
       
	   $(".nav a").eq(n).click(function(){
		 $("#container").load("doc/page_"+(n+1)+".html?page=2")
		 $(".sld").hide();//슬라이더 감추기
		 }) 
       }); 

	 $(".inner_nav li").each(function(n){
    
    $(".inner_nav li").eq(n).click(function(){
     $(".col-10").load("doc/a_"+(n+1)+".html")
     
     }) 
     
     });

	 })

   







