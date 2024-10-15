package entity;

public class Answer {

    private String answer;

    private boolean isRight;

    public Answer(String answer,boolean isRight){
        this.answer=answer;
        this.isRight=isRight;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isRight() {
        return isRight;
    }



}
