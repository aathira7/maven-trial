package com.lti.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Captcha
 * line changed for git check history
 * line changed for conflict check s
 */
@WebServlet("/Captcha")
public class Captcha extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String captchaText="";
		for (int i = 0; i <5; i++) {
			int rno=(int)(Math.random()*str.length());
			captchaText+=str.charAt(rno);
			
		}
		//code for gen captcha image
		BufferedImage img=new  BufferedImage(100, 75, BufferedImage.TYPE_INT_RGB);
		Graphics g=img.getGraphics();
		g.setColor(Color.RED);
		g.fillRect(0, 0, 190, 90);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Harrington", Font.BOLD, 26));
		g.drawString(captchaText,10,50);
		
		ImageIO.write(img, "jpeg", out);
		
		
		
	}



}
