package array.count_frequency_of_elements_in_an_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        Map<String, Long> expected = new HashMap<>();
        expected.put("b", 1L);
        expected.put("a", 2L);
        expected.put("c", 1L);

        Map<String, Long> actual = solution.countFrequencyOfElementsInAnArray(List.of("b", "a", "c", "a"));

        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyList() {
        assertEquals(Map.of(), solution.countFrequencyOfElementsInAnArray(List.of()));
    }

    @Test
    public void testSingleElement() {
        assertEquals(Map.of("x", 1L), solution.countFrequencyOfElementsInAnArray(List.of("x")));
    }

    @Test
    public void testAllSameElements() {
        assertEquals(Map.of("z", 4L), solution.countFrequencyOfElementsInAnArray(List.of("z", "z", "z", "z")));
    }

    @Test
    public void testCaseSensitivity() {
        Map<String, Long> expected = Map.of("A", 1L, "a", 2L);
        assertEquals(expected, solution.countFrequencyOfElementsInAnArray(List.of("a", "A", "a")));
    }

}
