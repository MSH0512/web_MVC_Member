package com.example.jdbcex.dao;

import com.example.w2.dto.TodoDTO;
import com.example.w2.dao.ConnectionUtil;
import com.example.w2.dao.TodoDao;
import com.example.w2.domain.TodoVo;
import lombok.Cleanup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class TodoDAOTests {
    private TodoDao todoDao;

    @BeforeEach
    public void ready() {
        todoDao = new TodoDao();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDao.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        TodoDTO dto = new TodoDTO();
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement("insert into tbl_todo(title, dueDate, finished) values (?,?,?)");
        pstmt.setString(1, "test123");
        pstmt.setDate(2, Date.valueOf(dto.getDueDate()));
        pstmt.setBoolean(3, true);
        pstmt.execute();
    }

    //    @Test
//    public void testInsert() throws Exception{
//        TodoVo vo = TodoVo.builder().title("Sample_Todo_VO_TEST").dueDate(LocalDate.of(2024,03,01)).finished(true).build();
//        todoDao.insert(vo);
//    }
    @Test
    public void testList() throws Exception {
        List<TodoVo> list = todoDao.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }
}

//    @Test
//    public void selectOne() throws Exception {
//        Long tno = 1L;
//        TodoVo vo = todoDao.selectOne(tno);
//        System.out.println(vo);
//    }
//    @Test
//    public void updateOne() throws Exception {
//        Long tno = 1L;
//        TodoVo vo = todoDao.updateOne(tno);
//        System.out.println(vo);
//    }
//    @Test
//    public void deleteOne() throws Exception {
//        Long tno = 1L;
//        TodoVo vo = todoDao.deleteOne(tno);
//        System.out.println(vo);
//    }
//}
