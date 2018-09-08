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
<style>
	.hl{color: red; font-weight: bold;}
</style>
<script type="text/javascript">
var timeout	= 500;
var closetimer	= 0;
var ddmenuitem	= 0;

$(document).ready(function(){
	$(".type_tab").click(function (){
		var type_id = $(this).next().val();
		$("[name='goods_type_id']").val(type_id);
		$("#s_search form").submit();
	});
	
	$(".page1").click(function (){
		var page = $(this).next().val();
		$("[name='pageNum']").val(page);
		$("#s_search form").submit();
	});
	
	$(".page2").click(function (){
		var page = $(this).text();
		$("[name='pageNum']").val(page);
		$("#s_search form").submit();
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
	
	<link type="text/css" href="css/list.css" rel="stylesheet" />
	
	<div id="s_bdw">
		<div id="s_bd">
			<div class="zadv"><a href="#"><img src="images/3215wa.jpg" width="980" height="62" alt="" /></a></div>
			
			<div class="breadcrumbs">
				<div class="f-l"><a href="#">全部结果</a><span>»</span><a href="#">食品、饮料、酒水</a><span>»</span><a href="#">进口食品</a><span>»</span>进口米</div>
				<div class="f-r">搜索结果(<b class="red">19</b>)</div>
			</div>
			
			<div class="f-l leftlist">
				<div class="sort">
					<h2>筛选分类</h2>
					<h3><a href="#">大家电、生活电器(3890)</a></h3>
					<dl>
						<dt><a href="#">厨房电器(1001)</a></dt>
						<dd>
							<span>豆浆机(85)</span>
							<a href="#">微波炉(35)</a>
							<a href="#">电压力锅(181)</a>
							<a href="#">电水壶/热水瓶(144)</a>
							<a href="#">电磁炉(53)</a>
							<a href="#">多用途锅(78)</a>
							<a href="#">电饼铛/煎拷机(3)</a>
							<a href="#">煮蛋器(34)</a>
						</dd>
					</dl>
					<h3><a href="#">大家电、生活电器(3890)</a></h3>
					<dl>
						<dt><span>厨房电器(1001)</span></dt>
						<dd>
							<a href="#">豆浆机(85)</a>
							<a href="#">微波炉(35)</a>
							<a href="#">电压力锅(181)</a>
							<a href="#">电水壶/热水瓶(144)</a>
							<a href="#">电磁炉(53)</a>
							<a href="#">多用途锅(78)</a>
							<a href="#">电饼铛/煎拷机(3)</a>
							<a href="#">煮蛋器(34)</a>
						</dd>
					</dl>
				</div><!--sort end-->
				
				<div class="ladv"><a href="#"><img src="images/2asd.jpg" width="205" height="72" alt="" /></a></div>
				
				<div class="ladv"><a href="#"><img src="images/12ad.jpg" width="205" height="72" alt="" /></a></div>
				
				<div class="ladv"><a href="#"><img src="images/21af.jpg" width="205" height="72" alt="" /></a></div>
				
				<div class="Toplist">
					<div class="Ttitle"><h2 class="f-l">热销商品排行榜</h2></div>
					<div class="Topcon">
						<ul>
							<li>
								<a href="#"><img src="images/124ad.jpg" width="58" height="58" alt="" /></a>
								<p><a href="#">心相印优选装200抽2层塑装面巾纸</a><br /><strong class="red">￥10.9</strong></p>
							</li>
							<li>
								<a href="#"><img src="images/124ad.jpg" width="58" height="58" alt="" /></a>
								<p><a href="#">心相印优选装200抽2层塑装面巾纸</a><br /><strong class="red">￥10.9</strong></p>
							</li>
							<li>
								<a href="#"><img src="images/124ad.jpg" width="58" height="58" alt="" /></a>
								<p><a href="#">心相印优选装200抽2层塑装面巾纸</a><br /><strong class="red">￥10.9</strong></p>
							</li>
							<li>
								<a href="#"><img src="images/124ad.jpg" width="58" height="58" alt="" /></a>
								<p><a href="#">心相印优选装200抽2层塑装面巾纸</a><br /><strong class="red">￥10.9</strong></p>
							</li>
							<li class="last">
								<a href="#"><img src="images/124ad.jpg" width="58" height="58" alt="" /></a>
								<p><a href="#">心相印优选装200抽2层塑装面巾纸</a><br /><strong class="red">￥10.9</strong></p>
							</li>
						</ul>
					</div>
				</div><!--Toplist end-->
				
				<div class="Toplist">
					<div class="Ttitle"><h2 class="f-l">浏览记录</h2><a style="color:#4484db;" class="f-r" href="#"><b>清除</b></a></div>
					<div class="browselist">
						<ul class="cf">
							<li><a href="#"><img src="images/21da.jpg" width="58" height="58" alt="" /></a></li>
							<li><a href="#"><img src="images/21da.jpg" width="58" height="58" alt="" /></a></li>
							<li><a href="#"><img src="images/21da.jpg" width="58" height="58" alt="" /></a></li>
							<li><a href="#"><img src="images/21da.jpg" width="58" height="58" alt="" /></a></li>
							<li><a href="#"><img src="images/21da.jpg" width="58" height="58" alt="" /></a></li>
							<li><a href="#"><img src="images/21da.jpg" width="58" height="58" alt="" /></a></li>
						</ul>
					</div>
				</div><!--Toplist end-->
				
			</div><!--leftlist end-->
			
			<div class="f-r rightlist">
				
				<div class="hotbox cf">
					<div class="f-l hotcon">
						<h2>热卖推荐</h2>
						<ul class="cf">
							<li>
								<a href="#"><img src="images/21ad.jpg" width="115" height="115" alt="" /></a>
								<dl>
									<dt><a href="#">凌仕魅动男士香氛-契合</a></dt>
									<dd>特价：<strong class="red">￥52.9</strong></dd>
									<dd><span class="startotal"></span></dd>
									<dd><a class="addcat" href="#">加入购物车</a></dd>
								</dl>
							</li>
							<li>
								<a href="#"><img src="images/214ad.jpg" width="115" height="115" alt="" /></a>
								<dl>
									<dt><a href="#">凌仕魅动男士香氛-契合</a></dt>
									<dd>特价：<strong class="red">￥52.9</strong></dd>
									<dd><span class="startotal"></span></dd>
									<dd><a class="addcat" href="#">加入购物车</a></dd>
								</dl>
							</li>
						</ul>
					</div>
					<div class="f-l promotion">
						<h2>促销活动</h2>
						<p>指定冰洗买就送插座!液晶电视清仓大放价，小家电惠战十月，最低三大合资空调疯狂抢购</p>
					</div>
				</div><!--hotbox end-->
				
				<div class="retrieve">
					<dl class="cf">
						<dt>类型：</dt>
						<dd><span>
							<#if goods.goods_type_id??>
								<span><a class="type_tab" href="javascript:void(0)">全部</a></span>
								<#list page.typeList as goodsType>
									<#if goodsType.goods_type_id==goods.goods_type_id>
										<a href="#" class="current">${goodsType.goods_type_name}</a></span>
										<#else>
										<span><a class="type_tab" href="javascript:void(0)">${goodsType.goods_type_name}</a><input type="hidden" value="${goodsType.goods_type_id}"/></span>
									</#if>
								</#list>
								<#else>
								<a href="#" class="current">全部</a></span>
								<#list page.typeList as goodsType>
									<span><a class="type_tab" href="javascript:void(0)">${goodsType.goods_type_name}</a><input type="hidden" value="${goodsType.goods_type_id}"/></span>
								</#list>
							</#if>
						</dd>
					</dl>
					<dl class="cf">
						<dt>品牌：</dt>
						<dd><span><a href="#" class="current">全部</a></span>
							<#list page.brandList as goodsBrand>
							<span><a href="#">${goodsBrand.goods_brand_name}</a></span>
							</#list>
						</dd>
					</dl>
					<dl class="cf">
						<dt>产地：</dt>
						<dd><span><a href="#" class="current">全部</a></span><span><a href="#">全部其他国家和地区(12)</a></span></dd>
					</dl>
					<div class="clear"></div>
				</div><!--retrieve end-->
				
				<div class="product">
					<div class="productsreach">
						<dl>
							<dt>显示：</dt><dd><a class="current" id="imgicon" href="#">图片</a><a id="listicon" href="#">列表</a></dd>
						</dl>
						<dl style="margin:0;">
							<dt>排列：</dt>
							<dd>
								<div id="rankmenu">
									<a href="#">默认排序</a>
									<ul class="cf">
										<li><a href="#">价格高低</a></li>
										<li><a href="#">上架时间</a></li>
									</ul>
								</div>
								<div class="iconsreach"><a class="current" id="price" href="#">价格</a><a id="sales" href="#">销量</a><a id="discuss" href="#">评论</a></div>
							</dd>
						</dl>
						<dl class="last">
							<dt>筛选：</dt>
							<dd>
								<input type="checkbox" name="" id="cx" /><label for="cx">促销</label>
								<input type="checkbox" name="" id="zp" /><label for="zp">有赠品</label>
								<input type="checkbox" name="" id="xp" /><label for="xp">新品</label>
							</dd>
						</dl>
					</div>
				</div><!--product end-->
				
				<script type="text/javascript">
				$(document).ready(function(){
					$("#rankmenu").hoverClass("current");
				});
				</script>
				
				<div class="productlist">
					<ul>
						<#list page.data as goods>
						<li>
							<a href="#"><img src="images/21asfa.jpg" width="170" height="160" alt="" /></a>
							<dl>
								<dt><a href="#">${goods.goods_name}</a></dt>
								<dd>特价：<strong class="red">￥${goods.goods_price/100}</strong></dd>
								<dd><span class="startotal"></span></dd>
								<dd><a class="addcat" href="#">加入购物车</a></dd>
							</dl>
						</li>
						</#list>
					</ul>
				</div>
				
				<div class="clear"></div>
				
				<div class="pagecon">
					<div class="f-r pagination">
						<#if page.current==page.first>
							<span class="disabled">&lt; 上一页</span>
							<#else>
							<a class="page1" href="javascript:void(0)"> &lt; 上一页 </a><input type="hidden" value="${page.prev}"/>
						</#if>
						
						<#list page.btnList as num>
							<#if num==page.current>
								<span class="current">${num}</span>
								<#else>
								<a class="page2" href="javascript:void(0)">${num}</a>
							</#if>
						</#list>
						
						<#if page.current==page.last>
							<span class="disabled">下一页 &gt; </span>
							<#else>
							<a class="page1" href="javascript:void(0)">下一页 &gt; </a><input type="hidden" value="${page.next}"/>
						</#if>
						<div class="yepage">到第<input class="stext" type="text" name="" id="" value="${page.next}" />页&nbsp;
						<a style="float: right" href="javascript:void(0)">跳转</a></div>
					</div><!--pagination end-->
				</div>
				
			</div><!--rightlist end-->
			
			<div class="clear"></div>
			
		</div><!--s_bd end-->
	</div><!--s_bdw end-->	
	
	<#include "common/foot.html"/>

</div>
</body>
</html>
