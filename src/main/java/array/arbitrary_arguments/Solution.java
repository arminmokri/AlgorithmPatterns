package array.arbitrary_arguments;

import java.util.stream.Stream;

public class Solution {

    public String arbitraryArguments(String... strings) {
        return Stream.of(strings).reduce((a, b) -> a = a + "." + b).orElse("");
    }
}
