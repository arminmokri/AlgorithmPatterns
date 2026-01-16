package dfs_bfs.word_ladder;

import common.PrintHelper;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


public class Solution {

    private record Node(String word, int level) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println(
                    "beginWord=" + beginWord
                            + " endWord=" + endWord
                            + " wordList=" + PrintHelper.listToStringWithIndex(wordList)
            );
        }

        return bfsConnected(beginWord, endWord, wordList);
    }

    private int bfsConnected(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        visited.add(beginWord);
        queue.add(new Node(beginWord, 0));

        int minLevel = 0;
        List<String> path = new ArrayList<>();
        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();

            if (path.size() <= currentNode.level) {
                path.add(currentNode.word);
            } else {
                path.set(currentNode.level, currentNode.word);
            }

            if (currentNode.word.equals(endWord)) {
                minLevel = currentNode.level + 1;
                break;
            }

            List<String> neighbors = getOneCharDiffList(currentNode.word, wordList);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new Node(neighbor, currentNode.level + 1));
                }
            }
        }

        if (minLevel == 0) {
            path.clear();
        }

        if (PrintHelper.debug) {
            System.out.println(PrintHelper.listToStringWithIndex(path));
            System.out.println("minLevel=" + minLevel);
        }

        return minLevel;
    }

    private List<String> getOneCharDiffList(String word, List<String> words) {
        List<String> oneCharDiff = new ArrayList<>();
        for (String currentWord : words) {
            if (isOneCharDiff(currentWord, word)) {
                oneCharDiff.add(currentWord);
            }
        }
        return oneCharDiff;
    }

    private boolean isOneCharDiff(String wordA, String wordB) {

        if(wordA.length() != wordB.length()){
            return false;
        }

        AtomicInteger atomicInteger = new AtomicInteger(0);
        IntStream
                .range(0, wordA.length())
                .boxed()
                .forEachOrdered(i -> {
                    if (wordA.charAt(i) != wordB.charAt(i)) {
                        atomicInteger.incrementAndGet();
                    }
                });
        return atomicInteger.get() == 1;
    }

}
