package com.lhy.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhy.entity.User;
import com.lhy.service.LoginService;
import com.lhy.utils.MD5key;

@Controller
public class LoginController {
	
	@Value("${baidu.api_key}")
	private String api_key;
	
	@Value("${baidu.secret_key}")
	private String secret_key;
	
	@Reference(version="1.0.0")
	private LoginService loginService;
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public String toLogin(HttpServletRequest request) {
		request.setAttribute("api_key", api_key);
		return "login";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String checkLogin(User user, HttpServletRequest request, RedirectAttributes attribute, HttpServletResponse response) {
		MD5key md5 = new MD5key();
		user.setPassword(md5.getkeyBeanofStr(user.getPassword()));
		User u = loginService.checkLogin(user);
		
		if(u==null) {
			//用户不存在
			attribute.addFlashAttribute("info", "用户不存在");
			return "redirect:/login";
		}
		
		if(!u.getPassword().equals(user.getPassword())) {
			//密码错误
			attribute.addFlashAttribute("info", "密码错误");
			return "redirect:/login";
		}
		//request.getSession().setAttribute("userInfo", u);
		
		String token = loginService.createToken(u);
		
		Cookie cookie =  new Cookie("sso_token",token);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		return "redirect:/";
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.POST)
	public String register(User user,String randomCode, HttpServletRequest request) {
		MD5key md5 = new MD5key();
		Object obj = request.getSession().getAttribute("randomCode");
		if(obj!=null&&obj.equals(randomCode)) {
			//处理用户注册
			user.setPassword(md5.getkeyBeanofStr(user.getPassword()));
			loginService.register(user);
			return "redirect:/login";
		}else {
			return "redirect:/register";
		}
	}
	
	@RequestMapping(value= "/checkRegister", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkRegister(String username) {
		Boolean flag = loginService.checkRegister(username);
		return flag;
	}
	
	@RequestMapping(value= "/initRandomCode", method = RequestMethod.GET)
	@ResponseBody
	public void initRandomCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		
		int width = 90;
		int height = 20;
		// 创建具有可访问图像数据缓冲区的Image
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		
		// 创建一个随机数生成器
		Random random = new Random();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		// 创建字体，字体的大小应该根据图片的高度来定
		Font font = new Font("Times New Roman", Font.PLAIN, 22);
		// 设置字体
		g.setFont(font);
		
		// 画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		
		// 随机产生160条干扰线
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x + x1, y + y1);
		}
		
		// randomCode 用于保存随机产生的验证码
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		
		// 随机产生4位数字的验证码
		for (int i = 0; i < 6; i++) {
			// 得到随机产生的验证码数字
			String strRand = String.valueOf(random.nextInt(10));
		
			// 产生随机的颜色分量来构造颜色值
			red = random.nextInt(110);
			green = random.nextInt(50);
			blue = random.nextInt(50);
		
			// 用随机产生的颜色将验证码绘制到图像中
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, 13 * i + 6, 16);
		
			randomCode.append(strRand);
		}
		
		// 将四位数字的验证码保存到session中
		//HttpSession session1 = request.getSession();
		session.setAttribute("randomCode", randomCode.toString());
		
		// 禁止图像缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		response.setContentType("image/jpeg");
		// 将图像输出到servlet输出流中
		
		
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
		//sos = null;
	}
	
	@RequestMapping(value= "/sso", method = RequestMethod.GET)
	@ResponseBody
	public User sso(String token) {
		return loginService.exchangeUserInfo(token);
	}
	
	@RequestMapping(value= "/baidu", method = RequestMethod.GET)
	public String baidu(String code, HttpServletResponse response, HttpServletRequest request) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		//HttpClient:模仿浏览器向服务器发送请求
		HttpClient httpClient = HttpClients.createDefault();
		//第二次握手
		HttpPost post1 = new HttpPost("https://openapi.baidu.com/oauth/2.0/token");
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("grant_type", "authorization_code"));
		list.add(new BasicNameValuePair("code", code));
		list.add(new BasicNameValuePair("client_id", api_key));
		list.add(new BasicNameValuePair("client_secret", secret_key));
		list.add(new BasicNameValuePair("redirect_uri", "http://localhost/baidu"));
		post1.setEntity(new UrlEncodedFormEntity(list));
		HttpResponse response1 = httpClient.execute(post1);
		HttpEntity entity1 = response1.getEntity();
		String result1 = EntityUtils.toString(entity1);
		
		Map map1 = mapper.readValue(result1, Map.class);
		String access_token = (String) map1.get("access_token");
		
		//第三次握手
		HttpPost post2 = new HttpPost("https://openapi.baidu.com/rest/2.0/passport/users/getLoggedInUser");
		List<NameValuePair> list2 = new ArrayList<NameValuePair>();
		list2.add(new BasicNameValuePair("access_token",access_token));
		post2.setEntity(new UrlEncodedFormEntity(list2));
		HttpResponse response2 = httpClient.execute(post2);
		HttpEntity entity2 = response2.getEntity();
		String result2 = EntityUtils.toString(entity2);
		
		Map map2 = mapper.readValue(result2, Map.class);
		String uid = (String) map2.get("uid");
		
		//根据百度id查询用户表
		User user = loginService.checkThirdBind(uid);
		String token = null;
		if(user==null) {
			//如果查询结果为空，说明没有用户和该id进行关联绑定，跳转至绑定页面
				//让用户选的  1.已有账号   2.我是新用户
					//如果用户选的我是新用户，则跳转至注册页面，当用户注册的同时，将百度id和账号信息一起存入用户表中，同时完成注册和绑定
			request.setAttribute("third_id", uid);
			
			return "bind";
		}else {
			//如果查询结果不为空，代表有用户和该id关联，将查出的用户信息传给单点登陆系统，换取sso_token,把sso_token传给浏览器
			token = loginService.createToken(user);
		}
		
		Cookie cookie =  new Cookie("sso_token",token);
		cookie.setPath("/");
		response.addCookie(cookie);
			
		return "redirect:/";
	}
	
	@RequestMapping(value= "/bind", method = RequestMethod.POST)
	public String baidu(HttpServletResponse response, HttpServletRequest request, User user) throws Exception {
		//如果用户选已有账号，需要让用户在页面中输入账号密码，验证账号密码是否正确
		MD5key md5 = new MD5key();
		user.setPassword(md5.getkeyBeanofStr(user.getPassword()));
		User u = loginService.checkLogin(user);
		if(u!=null&&u.getPassword().equals(user.getPassword())) {
			//将百度id修改到该用户的third_id字段中
			u.setThird_id(user.getThird_id());
			loginService.bindThirdAccount(u);
			
			String token = loginService.createToken(u);
			
			Cookie cookie =  new Cookie("sso_token",token);
			cookie.setPath("/");
			response.addCookie(cookie);
				
			return "redirect:/";
		}
		request.setAttribute("third_id", user.getThird_id());
		return "bind";
	}
	
	@RequestMapping(value= "/logout", method = RequestMethod.GET)
	public String logout(HttpServletResponse response, HttpServletRequest request, String token) throws Exception {
		//清Redis
		loginService.logout(token);
		//清cookie
		Cookie cookie =  new Cookie("sso_token","");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:/";
	}

}
