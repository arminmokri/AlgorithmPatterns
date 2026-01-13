package array.generate_and_write_primes_below_n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() throws IOException {
        Path tmpFile = Files.createTempFile("primes_", ".txt");
        try {
            List<Integer> expected = Arrays.asList(
                    2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                    31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                    73, 79, 83, 89, 97
            );

            List<Integer> result = solution.generatePrimesBelowN(100, tmpFile.toString());
            assertEquals(expected, result);

            String fileContent = Files.readString(tmpFile, StandardCharsets.UTF_8);
            assertTrue(fileContent.contains("2"));
            assertTrue(fileContent.contains("7"));
            assertTrue(fileContent.startsWith("["));
        } finally {
            Files.deleteIfExists(tmpFile);
        }
    }

    @Test
    public void testPrimesBelow10() throws IOException {
        Path tmpFile = Files.createTempFile("primes_", ".txt");
        try {
            List<Integer> expected = Arrays.asList(2, 3, 5, 7);

            List<Integer> result = solution.generatePrimesBelowN(10, tmpFile.toString());
            assertEquals(expected, result);

            String fileContent = Files.readString(tmpFile, StandardCharsets.UTF_8);
            assertTrue(fileContent.contains("2"));
            assertTrue(fileContent.contains("7"));
            assertTrue(fileContent.startsWith("["));
        } finally {
            Files.deleteIfExists(tmpFile);
        }
    }

    @Test
    public void testPrimesBelow2() throws IOException {
        Path tmpFile = Files.createTempFile("primes_", ".txt");
        try {
            List<Integer> expected = List.of();

            List<Integer> result = solution.generatePrimesBelowN(2, tmpFile.toString());
            assertEquals(expected, result);

            String fileContent = Files.readString(tmpFile, StandardCharsets.UTF_8);
            assertEquals("[]", fileContent.strip());
        } finally {
            Files.deleteIfExists(tmpFile);
        }
    }

    @Test
    public void testFileWritten() throws IOException {
        Path tmpFile = Files.createTempFile("primes_", ".txt");
        try {
            solution.generatePrimesBelowN(20, tmpFile.toString());

            String content = Files.readString(tmpFile, StandardCharsets.UTF_8);
            assertTrue(content.contains("13"));
            assertTrue(content.contains("19"));
        } finally {
            Files.deleteIfExists(tmpFile);
        }
    }
}