package com.javaex.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.javaex.vo.GuestbookVO;

public class GuestbookDAO {

    // 필드
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/guestbook_db";
    private final String id = "guestbook";
    private final String pw = "guestbook";

    // DB 연결
    private void connect() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            System.out.println("DB 연결 실패: " + e);
        }
    }

    // 자원 해제
    private void close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("자원 해제 오류: " + e);
        }
    }

    // 전체 목록 조회
    public List<GuestbookVO> guestbookSelect() {
        List<GuestbookVO> guestbookList = new ArrayList<>();
        connect();

        try {
            String query = "";
            query += " SELECT guest_id, ";
            query += "        name, ";
            query += "        password, ";
            query += "        content, ";
            query += "        reg_date ";
            query += " FROM guestbook ";
            query += " ORDER BY guest_id DESC ";

            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                GuestbookVO vo = new GuestbookVO(
                    rs.getInt("guest_id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("content"),
                    rs.getString("reg_date")
                );
                guestbookList.add(vo);
            }

        } catch (SQLException e) {
            System.out.println("guestbookSelect 오류: " + e);
        }

        close();
        return guestbookList;
    }

    //등록
    public int insert(GuestbookVO guestbookVO) {
        int count = 0;
        connect();
        try {
            String query ="";
            query += "INSERT INTO guestbook";
            query += " VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, guestbookVO.getName());
            pstmt.setString(2, guestbookVO.getPassword());
            pstmt.setString(3, guestbookVO.getContent());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert 오류: " + e);
        }
        close();
        return count;
    }

    //삭제
    public int delete(int no) {
        int count = 0;
        connect();
        try {
            String query = "";
            query +="DELETE FROM ";
            query += "guestbook WHERE guest_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, no);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete 오류: " + e);
        }
        close();
        return count;
    }

    // 단일 조회 (삭제 전 비밀번호 확인 등)
    public GuestbookVO getGuestbookById(int no) {
        GuestbookVO vo = null;
        connect();
        try {
           String query = "";
           query += " UPDATE guestbook ";
           query += " SET name = ?, ";
           query += "     password = ?, ";
           query += "     content = ? ";
           query += " WHERE guest_id = ? ";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                vo = new GuestbookVO(
                    rs.getInt("guest_id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("content"),
                    rs.getString("reg_date")
                );
            }

        } catch (SQLException e) {
            System.out.println("getGuestbookById 오류: " + e);
        }

        close();
        return vo;
    }
    
    //업데이트
    public int update(GuestbookVO vo) {
        int count = 0;
        this.connect();
        try {
           String query = "";
           query += " UPDATE guestbook ";
           query += " SET name = ?, ";
           query += "     password = ?, ";
           query += "     content = ? ";
           query += " WHERE guest_id = ? ";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getPassword());
            pstmt.setString(3, vo.getContent());
            pstmt.setInt(4, vo.getGuest_id());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update 오류: " + e);
        }
        this.close();
        return count;
    }

   
    public GuestbookVO personSelectOne(int no) {
       
        GuestbookVO vo = null;
        this.connect();

        try {
            String query = "";
            query += " SELECT guest_id, ";
            query += "        name, ";
            query += "        password, ";
            query += "        content, ";
            query += "        reg_date ";
            query += " FROM guestbook ";
            query += " WHERE guest_id = ? ";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int guestId = rs.getInt("guest_id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String content = rs.getString("content");
                String regDate = rs.getString("reg_date");

                vo = new GuestbookVO(guestId, name, password, content, regDate);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }

        this.close();
        return vo;
    }
}
