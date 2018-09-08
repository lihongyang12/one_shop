<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>一号店</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]> 
<link href="css/main.ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!--[if IE 7]> 
<link href="css/main.ie7.css" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="js/jquery-imgslideshow.js"></script>
<script type="text/javascript" src="js/ks-switch.js"></script>
<script type="text/javascript" src="js/lib.js"></script>
<script type="text/javascript">
var timeout	= 500;
var closetimer	= 0;
var ddmenuitem	= 0;
flag = false;

function checkForm(){
	return flag;
}

$(document).ready(function(){
	
	$("[name='username']").blur(function (){
		var username = $(this).val();
		$.ajax({
			type:"get",
			url:"/checkRegister",
			data:{"username":username},
			dataType:"json",
			success:function (data){
				if(!data){
					alert("此账号被占用");
				}
				flag = data;
			}
		});
	});
	
   	$('.cat_item').mousemove(function(){
		$(this).addClass('cat_item_on');
	});
	$('.cat_item').mouseleave(function(){	
		$(this).removeClass('cat_item_on');
	});
	$('#slideshow').imgSlideShow({itemclass: 'i'})
	$("#slide-qg").switchTab({titCell: "dt a", trigger: "mouseover", delayTime: 0});
	$("#s_cart_nums1").hover(function(){
		mcancelclosetime();
		if(ddmenuitem) ddmenuitem.hide();
		ddmenuitem = $(document).find("#s_cartbox");
		ddmenuitem.fadeIn();
	},function(){
		mclosetime();
	});
	$("#s_cart_nums2").hover(function(){
		mcancelclosetime();
		if(ddmenuitem) ddmenuitem.hide();
		ddmenuitem = $(document).find("#s_cartbox");
		ddmenuitem.fadeIn();
	},function(){
		mclosetime();
	});
	$("#s_cartbox").hover(function(){
		mcancelclosetime();
	},function(){
		mclosetime();
	});
	 var $cur = 1;
    var $i = 4;
    var $len = $('.hot_list>ul>li').length;
    var $pages = Math.ceil($len / $i);
    var $w = $('.hotp').width()-66;
	
    var $showbox = $('.hot_list');
    
    var $pre = $('div.left_icon');
    var $next = $('div.rgt_icon');
 	
    $pre.click(function(){
        if (!$showbox.is(':animated')) { 
            if ($cur == 1) {   
                $showbox.animate({
                    left: '-=' + $w * ($pages - 1)
                }, 500); 
                $cur = $pages; 
            }
            else { 
                $showbox.animate({
                    left: '+=' + $w
                }, 500); 
                $cur--;
            }
           
        }
    });

    $next.click(function(){
        if (!$showbox.is(':animated')) { 
            if ($cur == $pages) {  
                $showbox.animate({
                    left: 0
                }, 500); 
                $cur = 1; 
            }
            else {
                $showbox.animate({
                    left: '-=' + $w
                }, 500);
                $cur++; 
            }
            
        }
    });
    
});
function mclose()
{
	if(ddmenuitem) ddmenuitem.hide();
}
function mclosetime()
{
	closetimer = window.setTimeout(mclose, timeout);
}
function mcancelclosetime()
{
	if(closetimer)
	{
		window.clearTimeout(closetimer);
		closetimer = null;
	}
}
</script>
</head>

<body>
<div id="doc">
	<#include "common/head.html"/>	
	<link type="text/css" href="css/lr.css" rel="stylesheet" />
	
	<div id="s_bdw">
		<div id="s_bd">
			
			<div class="dl_zc">
				<div class="dl_zc_title">
					<h2 class="f_l">注册新用户</h2>
					<div class="rt_bg f_r"></div>
				</div>
				<div class="dl-con" id="regist">
					<form method="post" action="/register" onsubmit="return checkForm()">
						<div class="form">
							<div class="tipinfo">填写账户信息，以下信息均为必填</div>
							<div class="item">
								<span class="label">用户名：</span>
		
								<div class="fl">
									<input type="text" name="username" class="text" tabindex="1"/>
									<label id="username_succeed" class="blank"></label>
									<span class="clear"></span>
									<div id="username_error"></div>
								</div>
							</div>
							<!--item end-->
							<div id="o-password">
								<div class="item">
		
									<span class="label">设置密码：</span>
		
									<div class="fl">
										<input type="password" name="password" class="text" tabindex="2"/>
										<label id="pwd_succeed" class="blank"></label>
										<input type="checkbox" class="checkbox" id="viewpwd"/>
										<label class="ftx23" for="viewpwd">显示密码字符</label>
										<span class="clear"></span>
		
										<label class="hide" id="pwdstrength"><span class="fl">安全程度：</span><b></b></label>
										<label id="pwd_error"></label>
									</div>
								</div>
								<!--item end-->
								
							</div>
							<div class="item">
								<span class="label">邮箱：</span>
		
								<div class="fl">
									<input type="text" name="email" class="text" tabindex="4"/>
									<label id="mail_succeed" class="blank"></label>
									<span class="clear"></span>
		
									<div id="mail_error"></div>
								</div>
							</div>
							<!--item end-->
							
							<div class="item">
								<span class="label">验证码：</span>
		
								<div class="fl">
									<input type="text" name="randomCode" class="text text-1" tabindex="6"
										   autocomplete="off" MaxLength="6"/>
									<label class="img">
										<img src="/initRandomCode"/>
									</label>
									<label>&nbsp;看不清？点击验证码图片更换</label>
									<label id="authcode_succeed" class="blank invisible"></label>
									<span class="clear"></span>
		
									<label id="authcode_error"></label>
								</div>
							</div>
							<!--item end-->
							
							<div class="item">
								<span class="label">&nbsp;</span>
		
								<div class="fl">
									<input type="checkbox" name="" id="xieyi" value="" /><label class="blue" for="xieyi">自愿遵守1号店服务协议</label>
								</div>
							</div>
							<!--item end-->
							
							<div class="item">
								<span class="label">&nbsp;</span>
								<input type="submit" class="btnimg" value="" tabindex="8"/>
							</div>
							<!--item end-->
		
						</div>
					</form>
				</div><!--regist end-->
			</div><!--dl_zc end-->
			
			<script type="text/javascript" src="js/Validate.js"></script>
			<script type="text/javascript" src="js/Validate.personal.js"></script>

		</div><!--s_bd end-->
	</div><!--s_bdw end-->	
	
	<#include "common/foot.html"/>

</div>
</body>
</html>
