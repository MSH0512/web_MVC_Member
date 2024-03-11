package web_MVC_Member_Repository.controller;

import web_MVC_Member_Repository.dto.MemberDTO;
import web_MVC_Member_Repository.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/member/addMember.do")
public class AddController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/WEB-INF/member/memberForm.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        LocalDate regdate = LocalDate.now();

        MemberDTO dto = MemberDTO.builder().id(id).password(password).name(name).email(email).regdate(regdate).build();
        try {
            memberService.addMember(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/member/listMembers.do");
    }
}