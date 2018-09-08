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

$(document).ready(function(){
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
					<h2 class="f_l">用户登录</h2>
					<div class="rt_bg f_r"></div>
				</div>
				<div class="dl-con cf" id="entry">
					<form action="/login" method="post">
		
						<div class="form" style="width:600px;">
							<div class="item">
								<span class="label">用户名：</span>
		
								<div class="fl">
									<input type="text" name="username" class="text" tabindex="1" value=""/>
									<label id="loginname_succeed" class="blank invisible"></label>
									<span class="clear"></span>
									<label id="loginname_error">${info!}</label>
		
								</div>
							</div>
							<!--item end-->
							<div class="item">
								<span class="label">密码：</span>
		
								<div class="fl">
									<input type="password" name="password" class="text" tabindex="2"/>
									<label id="loginpwd_succeed" class="blank invisible"></label>
		
									<label><a href="forgot-password.html" class="blue">忘记密码?</a></label>
									<span class="clear"></span>
									<label id="loginpwd_error"></label>
								</div>
							</div>
							<!--item end-->
							<div class="item">
								<span class="label">&nbsp;</span>
								<div class="fl">
									<input type="checkbox" name="dl" id="jz" value="" /><label for="jz">记住用户名</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="dl" id="zd" value="" /><label for="zd">自动登录</label>
								</div>
							</div><!--item end-->
							<div class="item">
								<span class="label">&nbsp;</span>
								<input type="submit" class="btnimg" id="loginsubmit" value="" tabindex="8"/>
								<a href="http://openapi.baidu.com/oauth/2.0/authorize?client_id=${api_key}&response_type=code&redirect_uri=http://localhost/baidu">百度</a>
							</div>
		
							<!--item end-->
						</div>
						<!--form end-->
						<div id="guide">
							<h5>还不是京东商城用户？</h5>
		
							<div class="content">现在免费注册成为京东商城用户，便能立刻享受便宜又放心的购物乐趣。</div>
							<a href="/register" class="btn-personal">注册新用户</a>
		
						</div>
						<!--guide end-->
						<div class="clear"></div>
					</form>
				</div><!--regist end-->
			</div> <!--dl_zc end-->
			
			<script type="text/javascript" src="js/Validate.js"></script>
			<script type="text/javascript" src="js/Validate.entry.js"></script>

		</div><!--s_bd end-->
	</div><!--s_bdw end-->	
	
	<#include "common/foot.html"/>
	

</div>
</body>
</html>
