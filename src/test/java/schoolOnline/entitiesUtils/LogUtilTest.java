package schoolOnline.entitiesUtils;

import org.junit.jupiter.api.*;
import schoolOnline.entities.Level;
import schoolOnline.entities.Log;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
//mport static org.assertj.core.api.FactoryBasedNavigableIterableAssert.assertThat;

public class LogUtilTest {
    LogUtil target;
    ArrayList<Log> logList = new ArrayList<>();
    static int countBefore = 0;
    static int countAfter = 0;

    @BeforeEach
    void setData() {
        LogUtil.getLogs().clear();
        System.out.println("From BeforeEach " + ++countBefore + " times was called.");
    }

    @AfterEach
    void infoConsole() {
        System.out.println("From AfterEach " + ++countAfter + " times was called.");
    }

    @BeforeAll
    static void console() {
        System.out.println("BeforeAll say hi!");
    }

    @AfterAll
    static void console1() {
        System.out.println("AfterAll say bye!");
    }

    @Tag("RUN")
    @Test
    void getLogsTest() {
        ArrayList<Log> logArr = new ArrayList<>();
        assertThat(logArr)
                .isEqualTo(LogUtil.getLogs());
    }

    @Tag("RUN")
    @Test
    void createNullClassTest() {
        assertThrows(IllegalArgumentException.class,
                () -> LogUtil.create(null, Level.INFO, "test", null));
    }

    @Tag("RUN")
    @Test
    void createTest() {
        Log log = new Log("Lector", Level.DEBUG, "test2", null);
        assertThat(log.dateToWrite().substring(0, 19))
                .isEqualTo(LogUtil.create("Lector", Level.DEBUG, "test2", null)
                        .substring(0, 19));
    }

    @Tag("RUN")
    @Test
    void createCorrectDataTest() {
        Log tempLog;
        for (int i = 0; i < 5; i++) {
            tempLog = new Log("Lector" + (1 + i), Level.DEBUG,
                    "test" + (1 + i), null);
            logList.add(tempLog);

            LogUtil.create("Lector" + (1 + i), Level.DEBUG,
                    "test" + (1 + i), null);
        }
        assertThat(logList)
                .hasSize(target.getLogs().size());
    }

    @Tag("RUN")
    @Test
    void createCorrectListDataTest() {
        Log tempLog;
        for (int i = 0; i < 5; i++) {
            tempLog = new Log("Lector" + (1 + i), Level.DEBUG,
                    "test" + (1 + i), null, "for test");
            logList.add(tempLog);
            LogUtil.create("Lector" + (1 + i), Level.DEBUG,
                    "test" + (1 + i), null, "for test");
        }
        assertThat(logList)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(target.getLogs());
    }

    @Tag("SKIP")
    @Test
    void addNullLogTest(){
        assertThat(LogUtil.outerAddLog(null))
                .isFalse();
    }

    @Tag("SKIP")
    @Test
    void addLogTest(){
        assertThat(LogUtil.outerAddLog(new Log("Lector7",
                Level.DEBUG, "test7", null)))
                .isTrue();
    }
}