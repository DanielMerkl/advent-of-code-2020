package day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    @Test
    void getNumberOfUniqueQuestions_1() {
        String input = "abc";
        Group group = new Group(input);

        int result = group.getNumberOfUniqueQuestions();

        assertEquals(3, result);
    }

    @Test
    void getNumberOfUniqueQuestions_2() {
        String input = """
                a
                b
                c""";
        Group group = new Group(input);

        int result = group.getNumberOfUniqueQuestions();

        assertEquals(3, result);
    }

    @Test
    void getNumberOfUniqueQuestions_3() {
        String input = """
                ab
                ac""";
        Group group = new Group(input);

        int result = group.getNumberOfUniqueQuestions();

        assertEquals(3, result);
    }

    @Test
    void getNumberOfUniqueQuestions_4() {
        String input = """
                a
                a
                a
                a""";
        Group group = new Group(input);

        int result = group.getNumberOfUniqueQuestions();

        assertEquals(1, result);
    }

    @Test
    void getNumberOfUniqueQuestions_5() {
        String input = "b";
        Group group = new Group(input);

        int result = group.getNumberOfUniqueQuestions();

        assertEquals(1, result);
    }

    @Test
    void getNumberQuestionsEveryPersonAnswered_1() {
        String input = "abc";
        Group group = new Group(input);

        int result = group.getNumberQuestionsEveryPersonAnswered();

        assertEquals(3, result);
    }

    @Test
    void getNumberQuestionsEveryPersonAnswered_2() {
        String input = """
                a
                b
                c""";
        Group group = new Group(input);

        int result = group.getNumberQuestionsEveryPersonAnswered();

        assertEquals(0, result);
    }

    @Test
    void getNumberQuestionsEveryPersonAnswered_3() {
        String input = """
                ab
                ac""";
        Group group = new Group(input);

        int result = group.getNumberQuestionsEveryPersonAnswered();

        assertEquals(1, result);
    }

    @Test
    void getNumberQuestionsEveryPersonAnswered_4() {
        String input = """
                a
                a
                a
                a""";
        Group group = new Group(input);

        int result = group.getNumberQuestionsEveryPersonAnswered();

        assertEquals(1, result);
    }

    @Test
    void getNumberQuestionsEveryPersonAnswered_5() {
        String input = "b";
        Group group = new Group(input);

        int result = group.getNumberQuestionsEveryPersonAnswered();

        assertEquals(1, result);
    }
}
