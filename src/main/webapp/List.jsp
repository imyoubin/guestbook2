<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.GuestbookVO"%>

<%
    List<GuestbookVO> gList = (List<GuestbookVO>) request.getAttribute("gList");
    System.out.println("여기는 jsp 방명록 목록");
    System.out.println(gList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>방명록 목록</h1>

	<h1>주소록</h1>

	<h2>주소록 리스트</h2>
	<p>주소록 리스트 입니다.</p>

	<%
      if (gList != null && !gList.isEmpty()) {
          for (int i = 0; i < gList.size(); i++) {
               GuestbookVO vo = gList.get(i);
    %>
	<table border="1">
		<tbody>
			<tr>
				<td>번호(guest_id)</td>
				<td><%= vo.getGuest_id() %></td>
			</tr>
			<tr>
				<td>이름(name)</td>
				<td><%= vo.getName() %></td>
			</tr>
			<tr>
				<td>내용(content)</td>
				<td><%= vo.getContent() %></td>
			</tr>
			<tr>
				<td>등록일(reg_date)</td>
				<td><%= vo.getReg_date() %></td>
			</tr>
			<tr>
				<td>[삭제]</td>
				<td><a
					href="guestbook?action=delete&guest_id=<%= vo.getGuest_id() %>">삭제</a>
				</td>
			</tr>
		</tbody>
	</table>
	<br>
	<%
            }
        } else {
    %>
	<p>등록된 방명록이 없습니다.</p>
	<%
        }
    %>

	<a href="guestbook?action=writeForm">방명록 작성폼 이동</a>

</body>
</html>