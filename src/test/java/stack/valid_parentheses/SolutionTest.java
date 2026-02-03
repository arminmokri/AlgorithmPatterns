package stack.valid_parentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("()[]{}"));
        assertFalse(solution.isValid("(]"));
        assertTrue(solution.isValid("([])"));
        assertFalse(solution.isValid("([)]"));

    }

    @Test
    public void testEmptyString() {
        assertTrue(solution.isValid(""));
    }

    @Test
    public void testSingleCharacter() {
        assertFalse(solution.isValid("("));
        assertFalse(solution.isValid(")"));
        assertFalse(solution.isValid("["));
        assertFalse(solution.isValid("]"));
    }

    @Test
    public void testOnlyOneTypeOfBracket() {
        assertTrue(solution.isValid("(((())))"));
        assertTrue(solution.isValid("{{{{}}}}"));
        assertTrue(solution.isValid("[[][]]"));
    }

    @Test
    public void testIncorrectOrder() {
        assertFalse(solution.isValid(")("));
        assertFalse(solution.isValid("}{"));
        assertFalse(solution.isValid("]["));
    }

    @Test
    public void testNestedBrackets() {
        assertTrue(solution.isValid("{[()()]}"));
        assertTrue(solution.isValid("({[]})"));
    }

    @Test
    public void testInterleavedInvalidBrackets() {
        assertFalse(solution.isValid("{[(])}"));
        assertFalse(solution.isValid("((])"));
    }

    @Test
    public void testLongValidSequence() {
        assertTrue(solution.isValid("()()()[][]{{{{}}}}(((())))"));
    }

    @Test
    public void testLongInvalidSequence() {
        assertFalse(solution.isValid("()()()[][]{{{{}}}}(((())"));
    }

    @Test
    public void testStartsWithClosingBracket() {
        assertFalse(solution.isValid(")()"));
        assertFalse(solution.isValid("]{}"));
        assertFalse(solution.isValid("}[]"));
    }
}
