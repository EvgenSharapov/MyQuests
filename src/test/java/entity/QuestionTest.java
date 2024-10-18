package entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class QuestionTest {
    Answer answerOne=new Answer("Куница", false);
    Answer answerTwo=new Answer("Волк", false);
    Answer answerThree=new Answer("Лиса", true);
    Answer answerFour=new Answer("Пантера", false);
    Question question=new Question(1,answerOne,answerTwo,answerThree,answerFour);



    @Test
    void getAnswerOne() {
        assertThat(answerOne).isEqualTo( question.getAnswerOne());
    }

    @Test
    void getAnswerTwo() {
        assertThat(answerTwo).isEqualTo( question.getAnswerTwo());
    }

    @Test
    void getAnswerThree() {
        assertThat(answerThree).isEqualTo( question.getAnswerThree());
    }

    @Test
    void getAnswerFour() {
        assertThat(answerFour).isEqualTo( question.getAnswerFour());
    }
}