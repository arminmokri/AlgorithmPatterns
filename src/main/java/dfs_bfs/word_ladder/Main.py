from typing import List, Tuple
import unittest
from collections import deque

debug = True
test_long_chain_words = None


class Solution:
    def martixToString(self, myMatrix: List[List] | Tuple[Tuple]) -> str:
        if myMatrix == []:
            return "[]"
        elif myMatrix == [[]]:
            return "[[]]"

        str_matrix = [[str(val) for val in row] for row in myMatrix]
        max_width = max(len(val) for row in str_matrix for val in row)

        return "\n".join(
            "[ " + ", ".join(f"{val:>{max_width}}" for val in row) + " ]"
            for row in str_matrix
        )

    def listToString(self, myList: List | Tuple) -> str:
        if myList == []:
            return "[]"

        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if debug:
            print()

        def isOneCharDiff(wordA, WordB):
            if not len(wordA) == len(WordB):
                return False
            counter = 0
            for i in range(len(wordA)):
                if wordA[i] == WordB[i]:
                    continue
                else:
                    counter = counter + 1
            return counter == 1

        def getOneCharDiffList(word, wordList: List[str]):
            oneCharDiffList = list()

            for newWord in wordList:
                if isOneCharDiff(newWord, word):
                    oneCharDiffList.append(newWord)

            return oneCharDiffList

        if debug:
            print(
                "beginWord='"
                + beginWord
                + "' endWord='"
                + endWord
                + "' wordList="
                + str(wordList)
            )

        queue = deque()
        visited = set()

        queue.append([beginWord, 0])
        visited.add(beginWord)

        path = list()

        minSteps = 0
        while len(queue) > 0:
            word, steps = queue.popleft()

            if len(path) <= steps:
                path.append(word)
            else:
                path[steps] = word

            if steps > 0 and word == endWord:
                steps = steps + 1
                minSteps = steps
                break

            neighbors = getOneCharDiffList(word, wordList)

            if debug:
                print("word='" + word + "' neighbors=" + str(neighbors))

            for neighbor in neighbors:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append([neighbor, steps + 1])

        if minSteps == 0:
            path.clear()

        if debug:
            print("minSteps=" + str(minSteps) + " path=" + str(path))

        return minSteps


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.ladderLength(
                "hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]
            ),
            5,
        )
        self.assertEqual(
            self.solution.ladderLength(
                "hit", "cog", ["hot", "dot", "dog", "lot", "log"]
            ),
            0,
        )

    def test_begin_equals_end(self):
        self.assertEqual(self.solution.ladderLength("hit", "hit", ["hot", "dot"]), 0)

    def test_two_step_path(self):
        self.assertEqual(self.solution.ladderLength("hit", "hot", ["hot"]), 2)

    def test_multiple_paths(self):
        self.assertEqual(
            self.solution.ladderLength(
                "hit", "cog", ["hot", "dot", "lot", "dog", "log", "cog"]
            ),
            5,
        )

    def test_single_letter_words(self):
        self.assertEqual(self.solution.ladderLength("a", "c", ["a", "b", "c"]), 2)

    def test_long_chain_with_single_letter_variations(self):
        global test_long_chain_words
        self.assertEqual(
            self.solution.ladderLength("aaaaa", "ggggg", test_long_chain_words), 25
        )


def main():
    unittest.main()


if __name__ == "__main__":
    test_long_chain_words = [
        "aaaaa",
        "caaaa",
        "cbaaa",
        "daaaa",
        "dbaaa",
        "eaaaa",
        "ebaaa",
        "faaaa",
        "fbaaa",
        "gaaaa",
        "gbaaa",
        "haaaa",
        "hbaaa",
        "iaaaa",
        "ibaaa",
        "jaaaa",
        "jbaaa",
        "kaaaa",
        "kbaaa",
        "laaaa",
        "lbaaa",
        "maaaa",
        "mbaaa",
        "naaaa",
        "nbaaa",
        "oaaaa",
        "obaaa",
        "paaaa",
        "pbaaa",
        "bbaaa",
        "bbcaa",
        "bbcba",
        "bbdaa",
        "bbdba",
        "bbeaa",
        "bbeba",
        "bbfaa",
        "bbfba",
        "bbgaa",
        "bbgba",
        "bbhaa",
        "bbhba",
        "bbiaa",
        "bbiba",
        "bbjaa",
        "bbjba",
        "bbkaa",
        "bbkba",
        "bblaa",
        "bblba",
        "bbmaa",
        "bbmba",
        "bbnaa",
        "bbnba",
        "bboaa",
        "bboba",
        "bbpaa",
        "bbpba",
        "bbbba",
        "abbba",
        "acbba",
        "dbbba",
        "dcbba",
        "ebbba",
        "ecbba",
        "fbbba",
        "fcbba",
        "gbbba",
        "gcbba",
        "hbbba",
        "hcbba",
        "ibbba",
        "icbba",
        "jbbba",
        "jcbba",
        "kbbba",
        "kcbba",
        "lbbba",
        "lcbba",
        "mbbba",
        "mcbba",
        "nbbba",
        "ncbba",
        "obbba",
        "ocbba",
        "pbbba",
        "pcbba",
        "ccbba",
        "ccaba",
        "ccaca",
        "ccdba",
        "ccdca",
        "cceba",
        "cceca",
        "ccfba",
        "ccfca",
        "ccgba",
        "ccgca",
        "cchba",
        "cchca",
        "cciba",
        "ccica",
        "ccjba",
        "ccjca",
        "cckba",
        "cckca",
        "cclba",
        "cclca",
        "ccmba",
        "ccmca",
        "ccnba",
        "ccnca",
        "ccoba",
        "ccoca",
        "ccpba",
        "ccpca",
        "cccca",
        "accca",
        "adcca",
        "bccca",
        "bdcca",
        "eccca",
        "edcca",
        "fccca",
        "fdcca",
        "gccca",
        "gdcca",
        "hccca",
        "hdcca",
        "iccca",
        "idcca",
        "jccca",
        "jdcca",
        "kccca",
        "kdcca",
        "lccca",
        "ldcca",
        "mccca",
        "mdcca",
        "nccca",
        "ndcca",
        "occca",
        "odcca",
        "pccca",
        "pdcca",
        "ddcca",
        "ddaca",
        "ddada",
        "ddbca",
        "ddbda",
        "ddeca",
        "ddeda",
        "ddfca",
        "ddfda",
        "ddgca",
        "ddgda",
        "ddhca",
        "ddhda",
        "ddica",
        "ddida",
        "ddjca",
        "ddjda",
        "ddkca",
        "ddkda",
        "ddlca",
        "ddlda",
        "ddmca",
        "ddmda",
        "ddnca",
        "ddnda",
        "ddoca",
        "ddoda",
        "ddpca",
        "ddpda",
        "dddda",
        "addda",
        "aedda",
        "bddda",
        "bedda",
        "cddda",
        "cedda",
        "fddda",
        "fedda",
        "gddda",
        "gedda",
        "hddda",
        "hedda",
        "iddda",
        "iedda",
        "jddda",
        "jedda",
        "kddda",
        "kedda",
        "lddda",
        "ledda",
        "mddda",
        "medda",
        "nddda",
        "nedda",
        "oddda",
        "oedda",
        "pddda",
        "pedda",
        "eedda",
        "eeada",
        "eeaea",
        "eebda",
        "eebea",
        "eecda",
        "eecea",
        "eefda",
        "eefea",
        "eegda",
        "eegea",
        "eehda",
        "eehea",
        "eeida",
        "eeiea",
        "eejda",
        "eejea",
        "eekda",
        "eekea",
        "eelda",
        "eelea",
        "eemda",
        "eemea",
        "eenda",
        "eenea",
        "eeoda",
        "eeoea",
        "eepda",
        "eepea",
        "eeeea",
        "ggggg",
        "agggg",
        "ahggg",
        "bgggg",
        "bhggg",
        "cgggg",
        "chggg",
        "dgggg",
        "dhggg",
        "egggg",
        "ehggg",
        "fgggg",
        "fhggg",
        "igggg",
        "ihggg",
        "jgggg",
        "jhggg",
        "kgggg",
        "khggg",
        "lgggg",
        "lhggg",
        "mgggg",
        "mhggg",
        "ngggg",
        "nhggg",
        "ogggg",
        "ohggg",
        "pgggg",
        "phggg",
        "hhggg",
        "hhagg",
        "hhahg",
        "hhbgg",
        "hhbhg",
        "hhcgg",
        "hhchg",
        "hhdgg",
        "hhdhg",
        "hhegg",
        "hhehg",
        "hhfgg",
        "hhfhg",
        "hhigg",
        "hhihg",
        "hhjgg",
        "hhjhg",
        "hhkgg",
        "hhkhg",
        "hhlgg",
        "hhlhg",
        "hhmgg",
        "hhmhg",
        "hhngg",
        "hhnhg",
        "hhogg",
        "hhohg",
        "hhpgg",
        "hhphg",
        "hhhhg",
        "ahhhg",
        "aihhg",
        "bhhhg",
        "bihhg",
        "chhhg",
        "cihhg",
        "dhhhg",
        "dihhg",
        "ehhhg",
        "eihhg",
        "fhhhg",
        "fihhg",
        "ghhhg",
        "gihhg",
        "jhhhg",
        "jihhg",
        "khhhg",
        "kihhg",
        "lhhhg",
        "lihhg",
        "mhhhg",
        "mihhg",
        "nhhhg",
        "nihhg",
        "ohhhg",
        "oihhg",
        "phhhg",
        "pihhg",
        "iihhg",
        "iiahg",
        "iiaig",
        "iibhg",
        "iibig",
        "iichg",
        "iicig",
        "iidhg",
        "iidig",
        "iiehg",
        "iieig",
        "iifhg",
        "iifig",
        "iighg",
        "iigig",
        "iijhg",
        "iijig",
        "iikhg",
        "iikig",
        "iilhg",
        "iilig",
        "iimhg",
        "iimig",
        "iinhg",
        "iinig",
        "iiohg",
        "iioig",
        "iiphg",
        "iipig",
        "iiiig",
        "aiiig",
        "ajiig",
        "biiig",
        "bjiig",
        "ciiig",
        "cjiig",
        "diiig",
        "djiig",
        "eiiig",
        "ejiig",
        "fiiig",
        "fjiig",
        "giiig",
        "gjiig",
        "hiiig",
        "hjiig",
        "kiiig",
        "kjiig",
        "liiig",
        "ljiig",
        "miiig",
        "mjiig",
        "niiig",
        "njiig",
        "oiiig",
        "ojiig",
        "piiig",
        "pjiig",
        "jjiig",
        "jjaig",
        "jjajg",
        "jjbig",
        "jjbjg",
        "jjcig",
        "jjcjg",
        "jjdig",
        "jjdjg",
        "jjeig",
        "jjejg",
        "jjfig",
        "jjfjg",
        "jjgig",
        "jjgjg",
        "jjhig",
        "jjhjg",
        "jjkig",
        "jjkjg",
        "jjlig",
        "jjljg",
        "jjmig",
        "jjmjg",
        "jjnig",
        "jjnjg",
        "jjoig",
        "jjojg",
        "jjpig",
        "jjpjg",
        "jjjjg",
        "ajjjg",
        "akjjg",
        "bjjjg",
        "bkjjg",
        "cjjjg",
        "ckjjg",
        "djjjg",
        "dkjjg",
        "ejjjg",
        "ekjjg",
        "fjjjg",
        "fkjjg",
        "gjjjg",
        "gkjjg",
        "hjjjg",
        "hkjjg",
        "ijjjg",
        "ikjjg",
        "ljjjg",
        "lkjjg",
        "mjjjg",
        "mkjjg",
        "njjjg",
        "nkjjg",
        "ojjjg",
        "okjjg",
        "pjjjg",
        "pkjjg",
        "kkjjg",
        "kkajg",
        "kkakg",
        "kkbjg",
        "kkbkg",
        "kkcjg",
        "kkckg",
        "kkdjg",
        "kkdkg",
        "kkejg",
        "kkekg",
        "kkfjg",
        "kkfkg",
        "kkgjg",
        "kkgkg",
        "kkhjg",
        "kkhkg",
        "kkijg",
        "kkikg",
        "kkljg",
        "kklkg",
        "kkmjg",
        "kkmkg",
        "kknjg",
        "kknkg",
        "kkojg",
        "kkokg",
        "kkpjg",
        "kkpkg",
        "kkkkg",
        "ggggx",
        "gggxx",
        "ggxxx",
        "gxxxx",
        "xxxxx",
        "xxxxy",
        "xxxyy",
        "xxyyy",
        "xyyyy",
        "yyyyy",
        "yyyyw",
        "yyyww",
        "yywww",
        "ywwww",
        "wwwww",
        "wwvww",
        "wvvww",
        "vvvww",
        "vvvwz",
        "avvwz",
        "aavwz",
        "aaawz",
        "aaaaz",
    ]
    main()
