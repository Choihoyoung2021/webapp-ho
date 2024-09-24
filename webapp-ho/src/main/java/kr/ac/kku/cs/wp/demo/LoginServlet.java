package kr.ac.kku.cs.wp.demo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 인증 로직 추가 (예: 데이터베이스와 비교)
        if (isValidUser(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username); // 세션에 사용자 정보 저장
            resp.sendRedirect("welcome.jsp");
        } else {
            req.setAttribute("errorMessage", "로그인에 실패했습니다.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    private boolean isValidUser(String username, String password) {
        // 여기에 실제 인증 로직을 추가하세요 (예: 데이터베이스와 비교)
        return "user".equals(username) && "pass".equals(password); // 예시: 사용자명과 비밀번호
    }
}
