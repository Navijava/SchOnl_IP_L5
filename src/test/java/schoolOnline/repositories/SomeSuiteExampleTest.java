package schoolOnline.repositories;


import org.junit.platform.suite.api.*;

@Suite
@SelectPackages({"schoolOnline.entitiesUtils"})
@IncludeTags("RUN")
@ExcludeTags("SKIP")
@SuiteDisplayName("A bit of Suite")

public class SomeSuiteExampleTest {
}
