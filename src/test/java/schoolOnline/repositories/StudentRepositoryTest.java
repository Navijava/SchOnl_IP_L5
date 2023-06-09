package schoolOnline.repositories;

import org.junit.jupiter.api.*;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import schoolOnline.entities.Student;
import schoolOnline.entitiesUtils.StudentRepositoryUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class StudentRepositoryTest {
    StudentRepositoryUtil studentRepositoryUtil;
    @Mock
    StudentRepository studentRepository;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Say hi!");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("Say bye!");
    }

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        this.studentRepositoryUtil = new StudentRepositoryUtil(studentRepository);
    }
    @Test
    void isAvailableTest()throws Exception{
        when(studentRepository.getByLastname("antonenko"))
                .thenReturn(new Student("antonenko"));

       assertTrue(studentRepositoryUtil
               .isAvailable(new Student("antonenko")));

        //verify(studentRepository).getByLastname("antonenko");

    }
    @Test
    void absentTest()throws Exception {
        doReturn(null)
                .when(studentRepository).getByLastname("bobrenko");

        assertFalse(studentRepositoryUtil
                .isAvailable((new Student("bobrenko"))));
    }
    @Test
    void isAvailableExceptionTest() throws Exception {
        given(studentRepository.getByLastname("petrenko"))
                .willThrow(Exception.class);

        assertThrows(Exception.class, () -> {
            studentRepositoryUtil.isAvailable(new Student("petrenko"));
        });
    }
    @Test
    void myExperimentalCaptor() throws Exception {
        given(studentRepository.getByLastname("babenko"))
                .willReturn(new Student("babenko"));

        boolean student = studentRepositoryUtil.isAvailable(new Student("babenko"));

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(studentRepository).getByLastname(captor.capture());

        String result = captor.getValue();

        assertEquals(result, "babenko");
    }
    @DisplayName("additionally1")
    @Test
    void whenAddCalledAnswered() {
        List<Student> myList = mock(List.class);
        doAnswer(invocation -> {
            Integer arg0 = invocation.getArgument(0);
            Student arg1 = invocation.getArgument(1);

            assertEquals(3, arg0);
            assertEquals(new Student("pavlenko"), arg1);
            return null;
        }).when(myList).add(any(Integer.class), any(Student.class));
        myList.add(3, new Student("pavlenko"));
    }
    @DisplayName("additionally2")
    @Test
    void getLastnameTest() {
        Student student = Mockito.mock(Student.class);
        given(student.getLastname()).willReturn("pavlenko");
        when((student).getLastname()).thenReturn("true");
        assertEquals(student.getLastname(), "true");
    }


}
