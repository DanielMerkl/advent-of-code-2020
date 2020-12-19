package day19;

public class Input {
    public static final String input = """
            3: 7 45 | 10 39
            120: 109 45 | 16 39
            84: 96 39 | 104 45
            6: 120 39 | 113 45
            111: 45 93 | 39 45
            13: 17 45 | 96 39
            74: 122 45 | 17 39
            94: 66 45 | 119 39
            127: 39 84 | 45 132
            129: 45 128 | 39 35
            112: 39 35 | 45 58
            24: 45 76 | 39 112
            43: 39 17 | 45 96
            2: 45 5 | 39 77
            71: 100 45
            11: 42 31
            51: 77 45
            4: 124 39 | 85 45
            45: "a"
            78: 111 39 | 128 45
            8: 42
            104: 45 39 | 39 93
            29: 122 39 | 66 45
            42: 63 45 | 20 39
            41: 73 45 | 19 39
            110: 39 98 | 45 114
            55: 45 104 | 39 122
            0: 8 11
            53: 39 34 | 45 89
            39: "b"
            61: 77 45 | 104 39
            121: 45 65 | 39 1
            105: 45 44 | 39 99
            113: 9 39 | 103 45
            117: 96 93
            125: 39 108 | 45 43
            69: 45 39
            56: 50 45 | 12 39
            73: 39 35 | 45 100
            87: 39 100 | 45 111
            10: 45 13 | 39 73
            19: 39 69 | 45 58
            100: 39 45
            66: 93 93
            46: 45 82 | 39 74
            76: 66 45 | 111 39
            103: 45 52 | 39 115
            77: 45 39 | 45 45
            52: 82 39 | 112 45
            15: 45 47 | 39 132
            68: 39 77 | 45 17
            1: 45 47 | 39 61
            65: 37 45 | 51 39
            98: 45 2 | 39 80
            35: 39 45 | 45 45
            93: 39 | 45
            126: 111 39 | 77 45
            32: 45 36 | 39 37
            37: 45 69 | 39 119
            90: 39 17 | 45 69
            21: 39 66 | 45 58
            22: 39 56 | 45 64
            7: 123 39 | 48 45
            60: 45 102 | 39 26
            107: 45 29 | 39 71
            58: 39 45 | 39 39
            70: 128 39 | 111 45
            81: 27 45 | 129 39
            67: 5 39 | 100 45
            96: 45 45 | 39 39
            116: 39 87 | 45 55
            106: 39 51 | 45 92
            14: 45 128 | 39 58
            48: 39 104 | 45 5
            72: 45 35 | 39 111
            130: 118 45 | 28 39
            115: 45 91 | 39 87
            31: 39 6 | 45 22
            30: 79 45 | 57 39
            9: 125 39 | 49 45
            122: 39 39 | 45 93
            23: 101 45 | 78 39
            47: 39 100 | 45 58
            28: 45 111 | 39 122
            101: 45 77 | 39 66
            33: 39 5 | 45 111
            95: 39 5
            27: 58 45 | 17 39
            16: 15 39 | 116 45
            80: 45 119 | 39 66
            92: 45 111 | 39 58
            57: 39 73 | 45 86
            123: 45 58 | 39 77
            5: 39 39
            128: 45 45
            124: 101 39 | 126 45
            108: 45 122 | 39 119
            119: 45 39 | 39 39
            50: 81 45 | 106 39
            99: 130 45 | 46 39
            132: 17 45 | 119 39
            49: 70 45 | 117 39
            63: 131 39 | 83 45
            85: 39 33 | 45 97
            18: 45 60 | 39 25
            83: 39 54 | 45 4
            38: 62 45 | 21 39
            64: 39 30 | 45 121
            118: 45 17
            91: 39 17 | 45 100
            82: 39 100 | 45 119
            86: 119 39 | 111 45
            89: 39 119 | 45 77
            44: 39 127 | 45 107
            88: 45 95 | 39 89
            17: 39 45 | 45 39
            131: 39 3 | 45 110
            12: 39 24 | 45 23
            26: 39 108 | 45 90
            36: 58 45 | 100 39
            97: 45 111
            25: 39 88 | 45 32
            62: 96 39 | 111 45
            59: 39 119 | 45 96
            34: 45 35 | 39 100
            79: 68 39 | 94 45
            40: 39 72 | 45 14
            20: 39 105 | 45 18
            75: 111 45 | 69 39
            114: 67 45 | 59 39
            54: 38 39 | 53 45
            102: 39 75 | 45 80
            109: 39 40 | 45 41
                        
            aaaabbaabbaaabaaabbaaaaa
            aaababaabaaaabaaabababbabbbbaabbabbbbaababbaaabaababababababbabbabbaaabb
            bbbbbbbaabbaabaaaaabbaababbbaaabbababbabaababbaa
            bbbbbbabbabaababbababababbbabbabbbabaabaabbaaaba
            abbbbbaabaabbaabbabaaaba
            aaaabbaaabbbbbabaaabaabaaaaaaaab
            bbabbababaababaabababaaaaabbbbbabbbbabbbabbbaabbbbabbbbb
            aaabaaaaaaaabbaaabaaabbb
            abbabaaabbaaabbabbbabbba
            bababbaaaaaabbababbabaaa
            aaaaabaaaababbbabbaabaaa
            babaabbaaababbbabbaaaaaaaabbbabbbabbbaaabbabaabbaababbaabaabbbbb
            baaaabbbbaaabaababaaaaaabbabaaaabbbaabbabbabaabbabbbbbabbaabbbabaaababba
            aaaaabbbaabbbbbbbbabaaaababaaaab
            abaabaaabaabbbabaaabbbaaabaabbbabbaaaaaabaaabababbaaabbabbbbabaa
            abbbbbbabbaabbababaabaabbabaaabaabbbaaaa
            babbbaaabaaaababababbbba
            babbbabbbaaaababaaabaababbaababbababbaabaabaaababaabbbaaaabbababaaabaabbaababbaabbabbaab
            bbaabaabaabababbbaabaabb
            baaaaabbabbbabbabbbababbbabababb
            baaabbbbaababbabbababababbbbbaabbabbabba
            aaaaabbbaabaaabbbbbbabbbbbaaaaaaabbaaaab
            bbaababababbbbbaabaaabbb
            abaabbababaabaaabaababab
            abbabbabababbababaababaababbababbbababaaabbbbbbaaaababaa
            bbaaaabababbbbaabaaaaaabbabbabbbbabbabbbbaabbaab
            aabaaabbbabaabbabbabbbbb
            baaabbabaabbabbbbaaababb
            ababaababbaabbbbbbbaaabaaaabbbbb
            aaaaabbaaaababbbabaaabab
            abbbaaabbaaabbbaababbabbbbbababbbbbbabba
            aaaabaaabbbbbbabbaaabaaababbbabb
            bbaabbabbababaabaaaabbaaaaaababbabbbaabaaabbaabaabaaaabaaaabbbbbbaabbabb
            bbaabbaabbabaaabababbbaaaababbababbbabbbbaaaabbabaabbbaabaabbabbaabbabba
            aaabbbbabbbbbbaabaabbbbb
            ababbbaaabaaaaaaabaaaaab
            aabaaabbbaaabbabbbbbbabababaaabbbabbabbaaaabbbbb
            abababbaaaabaaaaabbaaaab
            bbbaabaaaabbbbabbbaaaabababbbaaaaaaaabbbbabbbbbaabaaabbaabbababbaaaaababbbababbbaabaabba
            bbbbbbabaabaaababaaabbabbbaabbbbababbaaaaaabbaaabbabaabb
            aaaaaabaaaaabababaaababa
            abaaabaabbaaaaabaaabbbabaabbbaabbaababbbbbbbaaab
            aabbbbbabbbbbabbabbbbbab
            bbabaabaaababbabbaababab
            aabbaaababaaaaaabbabbabababbabbb
            bbabbabbaaaaabbaabbbaaaa
            aabababaaaabbaabbbbbbabb
            aababbabaaabbaababaaaaba
            aabbaaababbbaabaaabaabbb
            bbbbaaaaabaababbabbaabaa
            abaabbabbbbbabbababbbabb
            baaabbbabaaabaaaabaaaaab
            aaababbbaabbabaababbaabaabaabababaabbabbababbaaaaaaaababbaabbaba
            aaaaaabbaababbbabbababbb
            aabaabaaaaaaaabbbbbaababaabbabab
            abbbbbbbaabbbababaaaaabbbababbba
            babbbbaaabbbbabbaabbbbaa
            baaabbabbbaabaabaabbabab
            aaaabbabaabababbbbabbaab
            babaabbbbbbbaabaababaabaabaaaaba
            babbbaabbbababbabaabbbbb
            bbaabababaaabbbbaabbbabbbbbaabbbbbbbbaba
            bbbbabbbbaaaababbbabbbba
            aabaaabbabbbaaababbaabab
            abaababbbbbaabbaaaaabbaabbbaabaababaaabb
            bbaabbbbaaabaaaaabaaaaba
            aaaabaabbbaaababaababaaa
            abaabaaaaabbaabbaababaab
            bbaaabaabbabbbaaabaaabba
            aabbbbbbabaabbabbbaababb
            bbbbaaaaabbbbabaababbbab
            babbbaaaaaaaaabbbabbaaab
            aabbbabbaaaabbabbaabbaaa
            abbbaabaaabaaabbababbaba
            baaabbbaabbbbabbbabaabbbbbbbaabaabbabbbb
            babbbbabbbaabbaaabaabaaabaaaababaababaab
            abbbaabbbabbbabaababbaba
            babbbbabbbbbabaabababbba
            aaababbbababaaaaaababaaa
            baaaabaababaabaaabaababbbbaaaaaabbbbbbaaaabaabba
            bbababbaaababababababbbabbbbbbabbbbbaaaabaaaaabaaaabaabaababaaba
            abbbbabaabaabbabbbbaaababaaabaaaabbbaabb
            bababbbbbabbbababbbbbbba
            baaaaaaabbaabababbaababb
            bbabbaaabbabbbbaabbaaaab
            bbaabbabbbbbbabbaaaaaaba
            abbbbaaaabbbaaabbabbabbb
            bbbabbababbbbaaababaaaab
            aabbbbbbababbbbbaabbbaaa
            babaabbaabaababbbbaababb
            ababaaaabbaababaaabbbbab
            bbbabbaabaaaabbbaabbabab
            aabaaabbaaaabbabbababaababaaabbbabababab
            baaabaaaabbbbaaaaabbabbbbaaaabba
            bbbaabbaabbabbbabbabbbba
            babaababbaaabbabbbbaabbb
            babbbaabbbabbababbbbaabb
            babbbabababbbbbabbaaaaab
            baaabaaabaaaabaabbabaabaababaabbaaababbbabbabbabbabaaaaaabbaaaabbbaabaaa
            bbabbaabbbabbabaaaababababbabbbaaaababaaaabbbbaaababaabb
            baababaabbbbbbabababbaab
            aaabbaababaabbabaaaaabab
            aaabbbaabbbbbabbaaaaabaabbaaaabb
            abbbbabaaaaababbaaabbaaa
            abbbbbbaabbbbbaabaaabbbbaababaaa
            baabbaabbbbabbabbabbabaa
            ababbbaaaabbaaabbaabbbba
            babbbbbaabbbababbbbabababbaababbababababababbbba
            aabbbbbbbbabaaaababababb
            aababbbabbbbabbbbbaabbba
            aababbabbbbababbbabbaaab
            abbabbaabaaaaaabbaabaaab
            bababaaabbabababaabbabaaabbabbbbbaabaaaa
            bababababbaabbaabababbba
            aaaabbababbbaaaaabbaaabaababbabb
            aaaabbbbaaaaaabbbaabbbbb
            aaabbbbabbbaaabaaabaabba
            babaababbbbbabaaabaaaaba
            bbbaaabaabbaabbaabbbbbab
            aaaabbababbbbaaaabbbbabababbbbbbababbaaabaabaaaa
            aaabbaabbabbbbababaaaaba
            abbabbaabbabbbaaaaaaaaba
            abaabbaaaaaaabaaababaababaabbaaa
            babbbaabbbbaaabbaaaaaaab
            aaaabbbbaaaabbbbbaabaaba
            ababbbaaaaaabaaaaabaabaa
            abababaaaabbbbbbbaaaaaba
            babbbaabaaaabaababaaaaba
            bbaaabaaaaabbaababaaaaab
            babbbaaabbbaaabaaababbbabbbbabbbbabaaabbabababab
            bbbaaabaababbabbaabaabbb
            bababaaaaabbbabaababbaba
            baabababbbbaabbbabaabbbbbabbbaababbabbbaabbaabbbbbbbabbabbbbaaabbababbba
            abbbabbabaaabaabbaaaabaaabbabaabbaabaabb
            bbbabbbbbaaaaabbabbbabaa
            bbaaabbbbbbbabaaabababab
            bbababbabbbabbabbbaaaaab
            aababbbabbbbabbbbbbbabab
            bbbbabbabbbbbabbaabbaaba
            aabbbbbaaabbabaaaaaabbaaababbbaaabbbaabbbaabbbbabbaababb
            aabbabbbaabbbbabbbbaabbbabaabaabbaaaaaaaaaaababbabbaaaabaabbaabb
            aabaaaaaaabaabbabababbbabaababbb
            bbbbbbbbbabbababbababaabbaabababababbbbbaaababaa
            aaabaaabbaaaabababbabbaaabbababaababbaab
            bababaaaabbabbaabbbabaab
            ababbabbbbabaabaabaababa
            aabbbabbaabaaabbabbaaaab
            bbaaabaaaabbaabbbbbabaaa
            aabababbbaaabbabbbaabaabaaaaaaaaaaaabaabbaabaaabaaabaaba
            aabaaabaaaaababbabaaabab
            bbabbababbaabaabbaabaaba
            aaababababababbababababb
            aaaaabbbaaaabbabaabbabab
            babaababbbbbaabababababb
            babbbbaabbaabbbabaabaabb
            aaaabbaaababbbaabbabbbba
            bbbbaabbbababbbbaaabaaabbbbbaaababaaabbababaabbbbaabaabbbabbaaab
            abbbbbaabaaabbbbabababaabbabaaaaababbaba
            bbbbabbabbabaabaabbbabab
            baaaababbbbbabbabaabaaab
            aabbbbbabaaaabbbbbabbaab
            bbabbabbaaaabbbbbbbabbbbabababab
            aaaababbaabababbbbaabbbbbaaaaaaaabaaaaba
            aaabaaaababaabbababbbbaabbababaa
            baaabbabbaababbaabbbbaab
            babbbbaaababaabaabbababb
            baabbabaabaaaabaaaabbaaabaabaaaaaaababbaabbaabaaaabbbaaaaaaababbaaaabaabaaaabbaaabbabbbaaabbaaaa
            aaaaaabbbababbbbaaaaabab
            abbbabbabbaaabbbababbbbbbbbbaaabbaabbbba
            aaababaabbbbabaaaabababa
            babbabababaaaaaababbbbaabbabbabbbbabbbbb
            bbabaaababaabaabaaaababa
            aabbaabbbbbbabbababbababbabbaabbabaaaabbbaaabbaa
            baaabaaaaaaaabbababbbabababbbabb
            aabbbabbabbaabbaaabaaaaa
            bbaaabaaabbbabbabbbbabab
            abaaaaaaaabbbbbbbbbaabbb
            babbbbabbabbaababaabaaab
            ababaabbaabaaababaaaaaba
            baababaabababbbbbbbbaabb
            bbbbbaabbaababaaaaabbaaaabaaaabaaaaabbbaaaaababbbaabbbba
            bababbbbaabbbabababbbbaabaabbbbbababbaaaabbabababaabaabb
            abababaaaabbbababaaaabba
            bbaaaaaaabaaaaaabbbbbbbb
            abaabbbbaabbaaabbbbbaaabaabbabbaaabbbababbbbbbaaaabaaaaabbbbaaba
            abbbabbabaaaaaabaabaabba
            aabababbbaababaaabaabbbb
            baababbababbbbbabbabbabbbbbbaabb
            bababbaaaabbbabbaaaabbaaabaababaabbabbab
            abbbbabbabbbbaaaabaaabaa
            abababbaaaabaaababaaabaa
            babbababbbabaaaaabbbaabbaaaaaaab
            abbbbaaaabbbbbbaaabaaaab
            baaaabaaaabaabaaabbaaabb
            bbbbbbabbbaaabababbaabbaaabbbbba
            aaaabbaaaabaabaabbaabbaaabbbabaaaabaabab
            babaabababbbbababbababaa
            baabbbabbaabbbaaaababbaa
            bbbabbbbabbbaabaabaabbabbaaabbaa
            bbaaabbbaabbbababaaaabaabaababab
            babbaabaaaaaaaaaaaabaaba
            bbabbabaaabaaabbabbaabab
            babaababaaabbbbaabbaaabb
            aaaabbabaabbbbbabbbabbba
            bbbbbbabaaabbaababbaababbaabbbbbabbbabbb
            aaabbbbabbbbbabbaabbbaab
            bbbbaabaaaaabaababbabaab
            abbbaabbbbbbabaaaabaabba
            aabbbbaaabababbbaaaabababbaabbbaaabaabbb
            aaaaabbaaaaabbababbbaaaa
            aaababbbabaaaabbbbabbaaaababaaabaabaaaab
            aaabaaabbbaaabbbbbbaaaab
            abaabaabbbbaababbbbaabaa
            aaaabaaaaababbababababab
            aabababbbabbbbbbabbbbabb
            abbabbaababaabbbabbaaaaa
            babbbaabababaabbbbbaababbaaaaabbbbbbbbbaaabbaaaa
            baaabbbbaaabababaaabaabb
            baaabbbabbbaaabaaabaaaaa
            ababaababbbbabaaabaababa
            ababbbaaaaabbbbabbababbb
            abbbbabaabbbbbaabbaaaaab
            baaabbbbababbabbaaabbaaa
            babaabaaaaabbbbabbbbbbaaabaabbabbbbbabbaabaabbbaabaaabbb
            bbbababbabbbbbbabbbbabaaaabaaaabbaababbb
            bbabbabbbbbaaabaaabbabaabaaaabba
            baaabaaabbaaabbbaaaaaababbabbbab
            aaaabbabaaaabaababaaabbb
            abbbbbbaabbaaabbabbbaaaaabbbabab
            abaabaaabbbbbbaaaababaaa
            aaabbaabbabbbaaaabbaaaba
            baaaaaabaaababaaababaaaabbbbaabb
            baaabaabbbaabbaaabbbabababbbbaab
            aaabbbaabbbbabbababbbabb
            baaaababbaababaaaaaababa
            babbbbbababbbaabbabbaaab
            babbaabbbbabbaaabbbaabababaababbbabbbbbbbbbabaabbaaaaabaababaaba
            ababbaaaabbabaabbabbabbbbbbaaaab
            bbaaaaaabbbabbaaaaaaaaba
            bababaaabaaabbbabbbbbbbb
            bbabaaaabbbababbbabbaaaa
            bbaabbbbbaaabaaaababaaab
            babbabababaababbbbbbbaaa
            aabbaabbabbabbbaaaaaabaaabbaabbaaabaaabbbbabbababaabaabb
            aabababbbaaaabbbaaaaabab
            aabbbbbbabbbbabbaababbbababaabbbabbabbbbbaabbabaabababbb
            bbbbaaaaabaabbaaaababbaa
            baaabbababbbaaabaaabbaba
            aaababbbbabbbbbaaaabaaba
            babaabaaabababaaaaaababbabbbabab
            bbaaaaaaaabbabbbaaababba
            bbbabbbbbaaaaaaabababbaaabababbaaabbbbbabaababaabbaaaaab
            bbabbbaaababaaaaabaaabbb
            ababbbaaababbbbbaabaaaaa
            abaababbbabbbaaaababbaaa
            bbbbabbbaaaaaaaababaaaba
            bbbbaabaabababaabbbbaabb
            bbaabaababbbbbabaaaaabababbabbababababbbabbababbbbaababb
            aaaaabbaabababbabaaaaaba
            aabbbabbbbabbabaaaabbabb
            babbbaabaaabaaabbbaabbabbaaabbbbbbbbbabbbabbbabbbaabaababbabbaaa
            babbbaabbaaaabbbbaabbaba
            bbbababbbaaabbbbabbbbbaaababbbbb
            bbbbabbbbbabbabaaaaaaaaaabaaabaaaababaaa
            ababaabbaaaaabbaabbababb
            bababaaaabababaaababbaaa
            bbaabababaaabbbbabbaaabb
            babbbbaabaaabbbaababaaababaaababbbbbbbbbbaaababb
            baaaabbbaaabbaabbabbbabb
            ababbbbbbbbbaaaaaabaabab
            abaabbaabaaaababbaabbabb
            aaaabbababaabaaababaaaab
            baaabaabaaaabaababbbbbbbbabbaaaa
            bbabaaaabaaabbbbaababbbb
            ababbbaaaabbaabbababbbbbaababbaaaaababba
            abbaabbaaaaaaabbbabaaaaa
            aaabababababbabbbabaabbabbabbaababbbbabbbabaaabbaaababab
            bbaababaaaaabaaaabaaaaab
            bbbaababbabbbbbabbbbaabb
            ababaaaabbbbbabbaaabaabb
            babaabbabbbbabaabbbaaaaa
            bbbbbabbabaabaaaabbbabaa
            baaaaaaaaabababbbbbaaabaaabbbabbabbababa
            baaabbbabbaabaabbabbababbaaaabbbbbbbbbbabababbab
            abbbabbabababababaabaaab
            babaababbbaabababbabaabb
            bbabababaabababbbaabbabb
            abaabaabbabaabaaabbaabaa
            aaaaabaaabbaabaaaabbaaababaaabbababbbabbabaabbbbbabbbbbabbaaabababbabbaa
            bbabbbabaababababbbbabbbabaaaabbabbbabbaaabaaaaaababbaba
            babbbbaababbbbaaabbbaaabababbbababaaaabb
            bbbabbbabbabbbababbabaab
            aababbabaaabbbbaaabababa
            abbbbababbabababbababbab
            aaabbaabaabaabaaaabaabab
            bbabbaabbabbbbbbabaaaaaa
            bbabbbaabaabbaabbaabbbbb
            bbbbbabaaabaaabaababbbbababbbbaabaaaabbaababaaaabbababaabbaaabbababbbbbb
            bbaabaaaababbabbababbbaaaaabbabbaabbbabaaaabaaabbabbbbbabaababbbabbbbbbbbabbbbba
            aaabbbbaabaabbaaabbaabbb
            ababbbaaaabbbaaabbbbbaaabbbbabbbbabbabbaababbaabaaababba
            bbaaaaaaababaaaabbaaaaaabbaaabaabbbabaaaababbabaaabaabba
            abbabbaaaaaaaaaaaaaababa
            abbbbabbbaaabbabbbaabaaa
            bbbbaaaabaaabaaabbbabbbaabbabaab
            bbaaababbbbabbbbbbbabaab
            abbaaabbbbaaaaababaaaabaabbaaaaabaabaaab
            aaabaaaababbbbaaaababbaa
            aabbabbbbbbaabbabbabbbab
            aabaabbbabaababaaabaaaaa
            abbbbbbbaaabaaabaaabbaab
            babbaabababbbaababababab
            babbbaaabbababbabaabbbaa
            abbaabbaabbbaabbaababaaa
            ababbbbbbbbbbbaabaaababb
            ababaaaabbbbabaabbaaaaaabbbaabaababababb
            baababaaaaababbbbaaaabbbbabbababbaabbbaaaabbaaaa
            baaaababbbbbbabbbabaaaab
            bbabbabaabaababbababbbab
            abbbbabaabaabbbaabbabbbbbaabbbab
            ababaaaabbaabbbbbabaaaba
            aabaaababaababbaabbaabab
            babaabaaabaababbabbaabbb
            aabbbbbaababaabaabbaabaa
            baaaaabbbababbaaabbbbbbbbbabbaabaaabaabbaaaaaaabaaabbabb
            babababaaaaaaaabbbabaabaaaabbaaaaabaaabbbbababbbababaabbaaaabbbababbbaab
            babbaababbbbaababaabbaba
            baabbabaaaabbbbbbababbabbaabaaab
            abaabaaabaaabbbbbabbabba
            ababbbaaaabaaabbabbbbbab
            aaaaabbbabbaabbaaabaaaab
            aaaaaaaaabbbbbabbaaabbabbaaabbaabaaabbabaaabaaaa
            aaaabbbbbbaabaabbababbab
            babababaabbbbaaaaaaaabbabbbbbababababbab
            aaaabbaaabbbaaabbaabaaab
            aabaabaaabbabbbbaababbaa
            abaabbabbabbbababbbbaabaabbbbbaabaaabbbbabbaaaaa
            bababbbbbbbbabbbbbbaababbabbbbaaaabbababaababbbb
            aaabbbaabbaabbbbabaaabbb
            abbbbbbbbbbaaabbababbabbbaababbb
            aaaabbbbaabbabaaaaabbabb
            aaaaaaaababbbaaaabbaaabb
            babbaabababbaababbbabbbbbbbbbbababbbababbaabbbab
            bbbbabbbbbbabbaabaabbbaa
            aaaabbbbbaaaaaaabaaaaabbabaababaabbbbbab
            aabaaaabbbabbbaaabbabbaaabaabbbaaabbbbbaababbabbabaaabbabbabaaab
            aaaaabbbbbabaaaaabaabbbb
            abaabbaabbbbbbaabaaabbaaababaaababbaabababbbbbbbbaabbbbbbabbaaabbabbbbaaaaaaaaaaaaaabbaa
            abaabaabbbaaabbbabbaabaa
            babbaababaabbbaabbabbaaa
            ababaaabbababbaabaaaaababaabbababbabaabbabbbbaaa
            aaababaabbbbbabbbbabaaaaaabaaaaaaabaabab
            aaaababbbbbbaababababaabaababaaaababbaba
            bbabababababbbaaaababaaa
            bbbabbabaabbbabbabbaabaa
            bbaaababbaaabaaabaaaaababbabaabb
            abbbbbbabaababaaaabbabab
            aaaaaaaaaaaabbaabbabbaab
            bbaaabaaabbabbbaaababaab
            aabaabbbbbbbbbbbbbbabbabaabaabbbabbbbbbbbbbbababbbbbabbbaabbbbbabaaaabba
            abbabbbababbbbbaaabbbaaa
            baaaaaaabbabaaabbaaabaabbbabaabbabbbaabbabbababbaaabababbabaabbaaabbbbabbababbab
            bbbaabaaabaabbabaabaabbabbbbaaaa
            baaabaaabaababaaabbbbaab
            bbbabbaababbbbababaaaaab
            aabbabbbaaabaaaabbbaaaab
            aabbabbbaabbaabbabaabaaabaaabbbb
            bababbbbaaaaabbbaabababbabaabbaababbbaabbabbababaaaaaaabbaabbabbbaabaabb
            bababbaaababbabbbbbbbbba
            aabababbaabaabaabbabbbbb
            bbbbaaaaabbbaababbbbbbba
            bababbbbaabbbbbbabbabaaa
            aaabbbaaaaaaaaaabaabbbab
            baaaabaaaaababbabbbbababbbbaaaab
            abbbaabbbabbbaaabbbabbba
            baaaabbbbabababaabbbabab
            aaaabbabbbababbababbbbaa
            aabbabaabababaabaababbbb
            bbaabbbbbaabbaababbabbbaaaaabbabbbaabbba
            abbbaaabbaaaabbbaabbbaab
            abaaababbaabbbabababaaabbbbaabbbbbaaaaabaaabaaabbabbbabaabaaababbabaabbbaaaabaaa
            aaaaabbbbababaababbaaabb
            bbbbabbbbbabaabaaabaabab
            aababbbababaabbbbbaabbabaabaaabbbabbaaabaaababba
            abaaababababbbbbbbababbabbbabbbbbbaabbbabaaabbbbabaababb
            babbbbbababaabaabbbaabaa
            bbbbabaaaabbbabaaaabaaaaabaaaaaabbababaa
            baaaabaabaaaabbbbabaabbaaabaaababbababbabaababab
            babbbbababbbbaaaabaaaabb
            abaabaaaabbaabbabaaaabbbbaaaaaababbaaabb
            abbaabbabababbaaaaababba
            abbbbbbababaabbabbbbbaab
            bbaabaabaababbbabaaabbabbbaaaaaababaabbbbbbbabbaababbababaabbaaa
            bbaaababbbbababbbbbbaaaaaabaabbb
            bbbbbbaaabbbaabaabbbabbabbbbbbaaabbababbabbbabbbbbabaabb
            aabbaababbaababbbbbababbaabaababbbaaabbaababbbbbbbbaaaaabbabaaaababbabbaaaababbbaababbbb
            babbbaabbbabbabbbbbabbaaabbaaaab
            abbbaabbbbabababaaaababa
            ababbbbbbbaaabaabbbabaaa
            ababaaaabaaaabababbaaaba
            ababbbbbbababababbbbbabbbbbbbbba
            bbbbabaabaaabaaabaabaaaa
            baaabaaaabbbbabbababaababbbbbbbbababbbababaaaaabbbbbabababbbbbaaaabbbbababbaaaaaaabaaababaaaabbb
            bbabababaaaabaaaababbbba
            bbaaababaaaabaabaabababa
            bbbaababaaabbaabbbaabbba
            aabbabbabaaaabbabbaaaaabaabaabaababbbbabbaabaaba
            abbabaabbbbabbbabbaabbaabbabbaabbababbbb
            abbbabbaabbbbabbbbbbbaab
            aabababbabaababbbaaabbbbaabaaababbaabaaa
            bbbbaababbbabbababbbabbb
            aaabaaabbbaabbbbbababbba
            bbbbaabaaaabbabababaaaaabaaaaabaabaaabab
            baabbaabababbbaababbaaaa
            aababbabaaababbbbaaabbaa
            babbbaaaababbbbbabababbb
            baaaaaaabbbaababababbbba
            bbabaaabaaaababbbaabaabb
            abbbbabaabbbabbabbaaaabb
            bbaabbbbbabbbaabbaaabbaa
            aaabbbaaabbababbbbbbabab
            babbbaaaaabbabbbabbaababbbaaababaabababbabbababaaaabbbbbaaabaabb
            bbbababbbbbbbbbaabbabbababaabbbb
            baaaabaabaaabbabbbbbaaab
            babababaabbbbaaabbbababbaaabaabb
            babaaaabbabbabbbbbbabbaaababbaaabaabaaaabaaaabaabbabbbaabaabaaabababbbbb
            bbabbbaababbbbbaaaaaaaaaaabbabab
            bbaabaaaaababaabaabbababaaaabbababaabbbabbbaaababbababbb
            abaabaabbbbbbbabaabbabab
            aabbbababbaaababababbbab
            bbbabbaabbbababbbaabaabb
            babbbabaaabbbbbaaaaaabbaababbbbbabaaabbb
            aaaabaaabbaaabbbababbabbbaaabaaabbbaababaabbbbaa
            abbabbbbbaaaababbaabbaba
            bbaaabbbbbbabbabababaabaabbbbbbbababbbba
            bbbbabbaaabaaabbaaabaaabaabaaaab
            babaababbabaabbbaaababba
            ababaababaaaaaabbbbabbabaabbbaaa
            babaababbbbbabababaaabbaabaaaaaaabbabbababbabaaaabbbabbbaaababaabbbbabaaababbbba
            abbabbaaaaaaabbabbbbaaaaaaaaabbb
            aaabbbbabbaaabbbaababbabbabababb
            bbaabbbbababbaaababaabaabbbbabaaaaabaabbaaabbbaaaaaabbba
            ababaabaaabbababbbbabbabaabaaabbabaabbab
            baaabbbabbbbabbababbbbabaaabaabaaaaabbab
            baaabbbbaabababbbaaaaaba
            abbabbbbbaaaaabbaabaaaaa
            bbabbabbaaaaabbabbabbbaabaabbbaa
            bbbaaabbaaaababbbabbbbaababaabbbabbbaaababababbb
            babbaabbbbbbaaaaababbaba
            abbaabbaabababbaaababbbb
            abbbbaaabaabaabbaabbabbabaaabaabbbabbaabaaabababaabbaabababaaaaabbbbabbaaabbbbaaaaaaabba
            abbbaabaabbbbbbbbabaaabb
            baaaabaabaaaaaabbaaaababaaabbbaabbbabbabbaabbaaa
            baaabbabbbabaaaaaabaabba
            babbaabaaaababbbbaaaabaabaababab
            bbbaabbababaabbbbaaaaaba
            aaaabbbbaabbabaaabaaaabb
            aabbaaabbbbaabbaaaabbaab
            babbbaaaababaaaabbababbb
            abbabbaabbabaaabbbaaaabb
            aaaabaaababbbbbbaababbbb
            bbbababbbbaaaaaaabbbbbab
            bbbabababaabaaabbaaabaaabbabaababbabbaabbbaababbaaaabaababbbabab
            aaaababbbaaabbababababbb
            abaabbabbbaaabaabbaaaaabbbaabbbbbbabaaaabbaaaaabaaaabbabbbababaa
            bbaabbaaaabaabaabbaababb
            aaababbbbaaaaabbbbaaababaabaaaaaabbabaab
            bbbabbbbbaaaaaababaabbbaaaababbbbaabbbaaabbbabaa
            babbbbbbaaababbbbaaabbaa
            bbbbabbaabaaaabbaabbabaababbbbaabbabaabbbbbabbbbabbabaab
            baaaabbbaaaaabbbaababbaa""";
}
