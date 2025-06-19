package com.javaex.guestbookController;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@WebServlet("/guestbook")
public class Guestbookcontroller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("Guestbookcontroller");
        String action = request.getParameter("action");
        System.out.println("action: " + action);

        GuestbookDAO guestbookDAO = new GuestbookDAO();

        if ("list".equals(action)) {
            System.out.println("리스트 요청");
            List<GuestbookVO> guestbookList = guestbookDAO.guestbookSelect();
            request.setAttribute("gList", guestbookList);
            RequestDispatcher rd = request.getRequestDispatcher("/guestbook/list.jsp");
            rd.forward(request, response);

        } else if ("wform".equals(action)) {
            System.out.println("등록폼 요청");
            RequestDispatcher rd = request.getRequestDispatcher("/writeForm.jsp");
            rd.forward(request, response);

        } else if ("write".equals(action)) {
            System.out.println("등록");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String content = request.getParameter("content");

            GuestbookVO guestbookVO = new GuestbookVO();
            guestbookVO.setName(name);
            guestbookVO.setPassword(password);
            guestbookVO.setContent(content);

            guestbookDAO.insert(guestbookVO);
            response.sendRedirect("http://localhost:8080/guestbook2/guestbook?action=list");

        } else if ("delete".equals(action)) {
            System.out.println("삭제");
            int no = Integer.parseInt(request.getParameter("no"));
            guestbookDAO.delete(no);
            response.sendRedirect("http://localhost:8080/guestbook2/guestbook?action=list");

        } else if ("updateForm".equals(action)) {
            System.out.println("수정폼");
            int no = Integer.parseInt(request.getParameter("no"));
            GuestbookVO guestbook =  guestbookDAO.personSelectOne(no); 
            request.setAttribute("guestbookVO", guestbook);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateForm.jsp");
            rd.forward(request, response);

        } else if ("update".equals(action)) {
            System.out.println("수정");
            int no = Integer.parseInt(request.getParameter("no"));
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String content = request.getParameter("content");

            GuestbookVO guestbookVO = new GuestbookVO(no, name, password, content, null);
            guestbookDAO.update(guestbookVO); 
            response.sendRedirect("http://localhost:8080/guestbook2/guestbook?action=list");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
} 
