package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnswerTest {
    Answer answer=new Answer("Пони",true);
    @Test
    void getAnswer() {
        assertEquals("Пони", answer.getAnswer());

    }

    @Test
    void isRight() {
        assertTrue(answer.isRight());

    }
}