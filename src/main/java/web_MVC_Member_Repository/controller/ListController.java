package web_MVC_Member_Repository.controller;

import web_MVC_Member_Repository.dto.MemberDTO;
import web_MVC_Member_Repository.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/member/listMembers.do")
public class ListController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<MemberDTO> dtolist = new ArrayList<>();
        try {
            dtolist = memberService.printList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("dtolist",dtolist);

        req.getRequestDispatcher("/WEB-INF/member/listMembers.jsp").forward(req,resp);

    }


}
