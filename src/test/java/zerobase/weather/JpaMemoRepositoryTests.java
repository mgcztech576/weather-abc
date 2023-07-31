package zerobase.weather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class JpaMemoRepositoryTests {
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;
    @Test void insertMemoTest() {//given
        Memo newMemo = new Memo(10, "this is new memo~");
        jdbcMemoRepository.save(newMemo); //when
        //then
        List<Memo> memoList=jdbcMemoRepository.findAll();
        assertTrue(memoList.size()>0);}
    @Test void findByIdTest() {//given
        Memo newMemo = new Memo(11, "jpa");
        //when
        //jdbcMemoRepository.save(newMemo);
        System.out.println(newMemo.getId());
        //then
        Optional<Memo> result=jdbcMemoRepository.findById(1);
        assertEquals(result.get().getText(),"jpa");}}