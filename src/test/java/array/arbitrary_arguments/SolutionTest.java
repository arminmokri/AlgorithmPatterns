package array.arbitrary_arguments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertEquals(
                "str1.str2.str3",
                solution.arbitraryArguments("str1", "str2", "str3")
        );

        assertEquals(
                "str1.str2.str3.str4.str5",
                solution.arbitraryArguments("str1", "str2", "str3", "str4", "str5")
        );
    }

    @Test
    public void testSingleArgument() {
        assertEquals("only", solution.arbitraryArguments("only"));
    }

    @Test
    public void testNoArgument() {
        assertEquals("", solution.arbitraryArguments());
    }

    @Test
    public void testWithEmptyStrings() {
        assertEquals(".a.", solution.arbitraryArguments("", "a", ""));
    }

    @Test
    public void testWithSpecialCharacters() {
        assertEquals(
                "a!.@b#.$c%",
                solution.arbitraryArguments("a!", "@b#", "$c%")
        );
    }
}
