package com.tenco;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet 클래스를 상속 받아 내가 정의한 클래스가 선언 된다.
 * 상속 받는 이유는 ? HTTP 프로토콜을 통한 request, response 처리를 할 수 있기 때문.
 * 
 * URL 맵핑에 대한 개념을 알아보자.
 * 왜 URL 맵핑이 필요한가?
 * 클라이언트가 특정 URL을 요청했을 때, 해당 URL에 대응하는 서블릿을 실행하도록 설정하는 것을 의미한다.
 * = 서블릿 클래스에 URL을 맵핑한다
 * URL 맵핑 2가지 방법
 */

// @WebServlet("/hello-servlet2") // URL 맵핑 (1)
@WebServlet(urlPatterns = "/example", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 생성자
    public HelloServlet() {
        super();
        System.out.println("생성자 호출 됨");
    }

    // init 메서드 : 해당 서블릿 클래스가 인스턴스화 될 때 단 한 번 실행되는 메서드.
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("init() 메서드 호출 됨");
		
	}

	// 메모리에서 내려가기 직전 호출되는 메서드
	public void destroy() {
		System.out.println("destroy 호출 됨");
	}

	// GET 요청으로 들어올 때 동작한다.
	// 주소 설계 - http://localhost:8080/hello/hello-servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// MIME TYPE - 인터넷 세상에서 데이터의 유형을 나타내는 표준 방식
		
		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");
		// 스트림을 어디에서 뽑아 와야 할까?
		response.getWriter().write("<html><body><h1>HELLO</h1></body></html>");
		
		
		
	}
	
	// POST 요청으로 들어올 때 동작한다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문제 : POST 요청이 들어오는 것을 확인해보고,
		// 응용하여 데이터 또는 html 형식으로 응답처리를 해보세요.
		System.out.println("웅답");
		
	}

}
