<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.GuestbookVO" %>

<%
    List<GuestbookVO> gList = (List<GuestbookVO>) request.getAttribute("gList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 목록</title>
</head>
<body>
    <h1>방명록 목록</h1>

    <c:if test="${not empty gList}">
        <%
            if (gList != null && !gList.isEmpty()) {
                for (GuestbookVO vo : gList) {
        %>
        <table border="1" style="margin-bottom:20px;">
            <tr><td>번호</td><td><%= vo.getGuest_id() %></td></tr>
            <tr><td>이름</td><td><%= vo.getName() %></td></tr>
            <tr><td>내용</td><td><%= vo.getContent() %></td></tr>
            <tr><td>등록일</td><td><%= vo.getReg_date() %></td></tr>
            <tr><td>삭제</td>
                <td><a href="guestbook?action=delete&no=<%= vo.getGuest_id() %>">삭제</a></td>
            </tr>
        </table>
        <%
                }
            } else {
        %>
            <p>등록된 방명록이 없습니다.</p>
        <%
            }
        %>
    </c:if>

    <a href="guestbook?action=wform">글쓰기 폼</a>
</body>
</html>