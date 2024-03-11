package service;

import com.example.w2.TodoService.TodoService;
import com.example.w2.dto.TodoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalTime.now;

public class TodoServiceTests {
    //1. TodoService 객체 선언
    private TodoService todoService;
    //2. @BeforeEach 통해서 ready를 메소드를 이용하여 TodoService 객체생성
    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }
    //3. @Test : testRegister메소드를 통해서 TodoDTO를 하나 빌더를 통해서(TITLE, Duedate)를 생성한 후 서비스 등록을 수행한다.
@Test
    public void testRegister() throws Exception{
    TodoDTO todoDTO = TodoDTO.builder()
            .title("title123")
            .dueDate(LocalDate.now())
            .build();
    todoService.register(todoDTO);
}
    //4. testRegister 실행한 후 정상적으로 TodoVo의 내용이 출력되는지 확인
    public void testRegister(TodoDTO todoDTO) throws Exception{

    }
    //5. tbl_todo테이블에 insert가 정상적으로 입력되었는지 확인
}
