//package user;
//
//import lombok.Getter;
//import lombok.Setter;
//
//public class User {
//
//    @Getter
//    private final String name;
//    @Getter
//    private int rushCount = 0;
//    @Getter
//    private boolean endSpaceQuest=false;
//
//
//    public User(String name) {
//        if (name == null) {
//            throw new IllegalArgumentException("User name is null");
//        }
//        if (name.isEmpty() || name.isBlank()) {
//            throw new IllegalArgumentException("User name is empty");
//        }
//        this.name = name;
//    }
//
//    public void incRushCount() {
//        rushCount++;
//    }
//    public void isSpaceQuestEnd(){endSpaceQuest=true;}
//
//}
//
