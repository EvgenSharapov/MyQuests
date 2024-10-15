package entity;



public class Question {
    private Answer answerOne;
    private Answer answerTwo;
    private Answer answerThree;
    private Answer answerFour;
    private int id;

    public Question(int id,Answer answerOne,Answer answerTwo,Answer answerThree,Answer answerFour) {
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.id=id;
    }

    public Answer getAnswerOne() {
        return answerOne;
    }

    public Answer getAnswerTwo() {
        return answerTwo;
    }

    public Answer getAnswerThree() {
        return answerThree;
    }

    public Answer getAnswerFour() {
        return answerFour;
    }


}
