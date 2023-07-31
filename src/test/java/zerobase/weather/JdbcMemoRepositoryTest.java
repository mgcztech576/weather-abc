package zerobase.weather;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest //@Transactional
public class JdbcMemoRepositoryTest {
    @Autowired JdbcMemoRepository jdbcMemoRepository;
    @Test void insertMemoTest() {//given
        Memo newMemo = new Memo(1, "this is new memo~");
        jdbcMemoRepository.save(newMemo);//when
        //then
        Optional<Memo> result=jdbcMemoRepository.findById(1);
        assertTrue(result.get().getText()=="this is new memo");
    }
    @Test void findAllMemoTest(){
        List<Memo> memoList=jdbcMemoRepository.findAll();
        System.out.println(memoList);
        assertNotNull(memoList);}}