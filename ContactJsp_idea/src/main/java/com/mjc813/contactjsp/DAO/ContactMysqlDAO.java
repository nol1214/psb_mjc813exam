package com.mjc813.contactjsp.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mjc813.contactjsp.DTO.ContactDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContactMysqlDAO {
	
	Connection conn = null;	/// RDBMS 접속하는 객체
	PreparedStatement ps = null;	/// sql 쿼리를 실행하는 객체
	ResultSet rs = null;	/// SELECT sql 쿼리를 실행하고 결과 값이 리턴되는 것을 읽어오는 객체
	
	/*
	 * RDBMS 접속하기 위한 정적 메소드 이다. 인스턴스 할 필요 없이 ContactDtoDAO 클래스에서는 한개만 선언되는 정적 메소드
	 */
	public static Connection getConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/mjc8132?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8"; // 접속 문자열
        String user = "root"; // 사용자 이름
        String password = "1234"; // 비밀번호
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.printf("getConnection : con=%s\n", con);
		/// 로그가 없으므로 콘솔에 출력했다
		return con;
	}


	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다. 
	 */
	public String selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ContactDto>list = new ArrayList<ContactDto>();
		try {
			conn = getConnection();
			/// 연락처리스트 가져오기
			String sql = " SELECT ";
				   sql+= " id, ";
				   sql+= " name, ";
				   sql+= " phoneNumber, ";
				   sql+= " zipNumber, ";
				   sql+= " email ";
				   sql+= " FROM contact_tbl ";
				   sql+= " ORDER BY id";
			System.out.printf("selectAll : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				/// sql 쿼리가 리턴하는 행 수 만큼 while 문을 반복한다.
				ContactDto dto = new ContactDto();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPhoneNumber(rs.getString(3));
				dto.setZipNumber(rs.getString(4));
				dto.setEmail(rs.getString(5));
				/// 컬럼의 값을 가져온다. 이것은 배열이 아니므로 0 부터 사용하지 않고 1 부터 7개 컬럼의 값을 ContactDto 객체에 가져온다.
				list.add(dto);
				/// dto 객체를 list 배열에 추가한다.
			}		
			request.setAttribute("list",list);
			/// list.jsp  list = (ArrayList<ContactDto>)request.getAttribute("list"); 값으로 치환되어 list 배열에 저장

			conn.close();
			ps.close();
			rs.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "list.jsp";
	}

	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다.
	 */
	public String insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String zipNumber = request.getParameter("zipNumber");
		String email = request.getParameter("email");
		/// Controller 에서 매개변수로 전달한 request 의 getParameter 로 클라이언트 화면에 입력된 값을 저장했다.
		/// 옛날 20년전 소스들은 request, response 를 계속 전달하여 사용하던 형태가 많았었다.
		int result = 0;
		try {
			conn = getConnection();
			/// prepareStatement는 순서에 따라 값이 등록된다.
			String sql = "INSERT INTO contact_tbl(name, phoneNumber, zipNumber, email) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);

			/// sql Insert, Update 쿼리가 실행될때 저장할 값을 1번부터 7번까지 설정하여 sql 쿼리문장을 만든다.
			/// 옛날 20년전 소스들은 이렇게 Java 소스에서 SQL 쿼리 문장을 만들었었는데 순서가 바뀌거나 번호가 꼬이면 에러를 찾기 매우 어려웠다. 
			ps.setString(1, name);
			ps.setString(2, phoneNumber);
			ps.setString(3, zipNumber);
			ps.setString(4, email);
			System.out.printf("insert : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			result = ps.executeUpdate();
			/// sql 쿼리를 실행한다.
			System.out.println(result);
			conn.close();
			ps.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다. 
	 */
	public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String zipNumber = request.getParameter("zipNumber");
		String email = request.getParameter("email");
		int result = 0;
		try {
			conn = getConnection();
			
			String sql = "UPDATE contact_tbl SET";
				   sql+= " name = ? , ";
				   sql+= " phoneNumber = ? , ";
				   sql+= " zipNumber = ? , ";
				   sql+= " email = ?";
				   sql+= " WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phoneNumber);
			ps.setString(3, zipNumber);
			ps.setString(4, email);
			ps.setInt(5, id);

			System.out.printf("update : sql=%s\n", sql);
			result = ps.executeUpdate();
			
			conn.close();
			ps.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ContactDto>list = new ArrayList<ContactDto>();
		try {
			conn = getConnection();
			int id = Integer.parseInt(request.getParameter("id"));

			String sql = "SELECT id, name, phoneNumber, zipNumber, email FROM contact_tbl WHERE id = ?";
			System.out.printf("modify : sql=%s\n", sql);

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				ContactDto ContactDto = new ContactDto();
				ContactDto.setId(id);
				ContactDto.setName(rs.getString(2));
				ContactDto.setPhoneNumber(rs.getString(3));
				ContactDto.setZipNumber(rs.getString(4));
				ContactDto.setEmail(rs.getString(5));
				list.add(ContactDto);
			}

			request.setAttribute("list",list);
			conn.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modify.jsp"; // 수정 폼으로 이동
	}


	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다. 
	 */
	public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		try {
			conn = getConnection();
			String id = request.getParameter("id");
			/// Controller 에서 매개변수로 전달한 request 의 getParameter 로 클라이언트 화면에 입력된 값을 저장했다.
			/// 옛날 20년전 소스들은 request, response 를 계속 전달하여 사용하던 형태가 많았었다.
			String sql = "DELETE FROM contact_tbl WHERE id="+id;
			System.out.printf("delete : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
			/// sql 쿼리를 실행한다.
			
			conn.close();
			ps.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}