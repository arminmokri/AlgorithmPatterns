package dfs_bfs.word_search;

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

        assertTrue(
                solution.exist(
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'}
                        }, "ABCCED"
                )
        );

        assertTrue(
                solution.exist(
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'}
                        }, "SEE"
                )
        );

        assertFalse(
                solution.exist(
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'}
                        }, "ABCB"
                )
        );
    }

    @Test
    public void testSingleCellMatch() {
        assertTrue(solution.exist(new char[][]{{'A'}}, "A"));
    }

    @Test
    public void testSingleCellNoMatch() {
        assertFalse(solution.exist(new char[][]{{'A'}}, "B"));
    }

    @Test
    public void testWordLongerThanTotalCells() {
        assertFalse(solution.exist(
                new char[][]{
                        {'A', 'B'},
                        {'C', 'D'}
                },
                "ABCDE"
        ));
    }

    @Test
    public void testCannotReuseSameCell() {
        // Would only be possible if reusing the same cell
        assertFalse(solution.exist(new char[][]{{'A'}}, "AA"));
    }

    @Test
    public void testHorizontalLeftToRight() {
        assertTrue(solution.exist(
                new char[][]{
                        {'A', 'B', 'C', 'D'}
                },
                "ABCD"
        ));
    }

    @Test
    public void testHorizontalRightToLeft() {
        assertTrue(solution.exist(
                new char[][]{
                        {'A', 'B', 'C', 'D'}
                },
                "DCBA"
        ));
    }

    @Test
    public void testVerticalTopToBottom() {
        assertTrue(solution.exist(
                new char[][]{
                        {'A'},
                        {'B'},
                        {'C'},
                        {'D'}
                },
                "ABCD"
        ));
    }

    @Test
    public void testVerticalBottomToTop() {
        assertTrue(solution.exist(
                new char[][]{
                        {'A'},
                        {'B'},
                        {'C'},
                        {'D'}
                },
                "DCBA"
        ));
    }

    @Test
    public void testDiagonalNotAllowed() {
        assertFalse(solution.exist(
                new char[][]{
                        {'A', 'X'},
                        {'X', 'B'}
                },
                "AB"
        ));
    }

    @Test
    public void testMultipleStartsOnlyOneValidPath() {
        assertTrue(solution.exist(
                new char[][]{
                        {'A', 'A', 'A'},
                        {'B', 'C', 'D'},
                        {'E', 'F', 'G'}
                },
                "ACD"
        ));
    }

    @Test
    public void testNeedsBacktrackingToSucceedClassic() {
        // Common tricky board requiring correct backtracking
        assertTrue(solution.exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'E', 'S'},
                        {'A', 'D', 'E', 'E'}
                },
                "ABCESEEEFS"
        ));
    }

    @Test
    public void testAllSameLettersEnoughCells() {
        assertTrue(solution.exist(
                new char[][]{
                        {'A', 'A'},
                        {'A', 'A'}
                },
                "AAAA"
        ));
    }

    @Test
    public void testAllSameLettersNotEnoughCells() {
        assertTrue(solution.exist(
                new char[][]{
                        {'A', 'A'},
                        {'A', 'A'}
                },
                "AAAA"
        ));
    }

    @Test
    public void testWordNotPresentAtAll() {
        assertFalse(solution.exist(
                new char[][]{
                        {'A', 'B', 'C'},
                        {'D', 'E', 'F'}
                },
                "Z"
        ));
    }

    @Test
    public void testEmptyWordReturnsTrue() {
        // Many Word Search solutions treat empty word as trivially found
        assertTrue(solution.exist(
                new char[][]{
                        {'A', 'B'},
                        {'C', 'D'}
                },
                ""
        ));
    }


}
