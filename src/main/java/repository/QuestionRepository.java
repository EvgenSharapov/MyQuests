package repository;

import entity.Answer;
import entity.Question;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
    private static final List<Question> questionsAnimal= new ArrayList<>(){{
        add(new Question(1,new Answer("Куница", false),new Answer("Волк", false),new Answer("Лиса", true),new Answer("Пантера", false)));
        add(new Question(2,new Answer("Енот", true),new Answer("Бобёр", false),new Answer("Харёк", false),new Answer("Ёж", false)));
        add(new Question(3,new Answer("Бегемот", false),new Answer("Жираф", true),new Answer("Зебра", false),new Answer("Олень", false)));
        add(new Question(4,new Answer("Пантера", true),new Answer("Гепард", false),new Answer("Барс", false),new Answer("Лев", false)));
        add(new Question(5,new Answer("Обезьяна", false),new Answer("Лемур", false),new Answer("Бурый медведь", false),new Answer("Коала", true)));
        add(new Question(6,new Answer("Бык", false),new Answer("Носорог", true),new Answer("Лось", false),new Answer("Слон", false)));
        add(new Question(7,new Answer("Волк", true),new Answer("Собака", false),new Answer("Заяц", false),new Answer("Барсук", false)));
        add(new Question(8,new Answer("Мышь", false),new Answer("Крот", false),new Answer("Хомяк", false),new Answer("Белка", true)));
        add(new Question(9,new Answer("Олень", false),new Answer("Лось", true),new Answer("Лошадь", false),new Answer("Единорог", false)));
        add(new Question(10,new Answer("Антилопа", false),new Answer("Осёл", false),new Answer("Пони", false),new Answer("Зебра", true)));
        add(new Question(11,new Answer("Антилопа", false),new Answer("Осёл", false),new Answer("Пони", false),new Answer("Зебра", true)));
        add(new Question(12,new Answer("Антилопа", false),new Answer("Осёл", false),new Answer("Пони", false),new Answer("Зебра", true)));



    }};
    private static final List<Question> questionsBird= new ArrayList<>(){{
        add(new Question(1,new Answer("Лебедь", true),new Answer("Журавль", true),new Answer("Цапля", false),new Answer("Чайка", false)));
        add(new Question(2,new Answer("Снегирь", false),new Answer("Сова", true),new Answer("Воробей", false),new Answer("Глухарь", false)));
        add(new Question(3,new Answer("Попугай", false),new Answer("Голубь", false),new Answer("Ворона", false),new Answer("Утка", true)));
        add(new Question(4,new Answer("Цапля", false),new Answer("Фламинго", true),new Answer("Аист", false),new Answer("Гусь", false)));
        add(new Question(5,new Answer("Иволга", false),new Answer("Коршун", false),new Answer("Глухарь", false),new Answer("Куропатка", true)));
        add(new Question(6,new Answer("Синица", false),new Answer("Голубь", true),new Answer("Филин", false),new Answer("Скворец", false)));
        add(new Question(7,new Answer("Дятел", true),new Answer("Дрозд", false),new Answer("Соловей", false),new Answer("Чиж", false)));
        add(new Question(8,new Answer("Галка", false),new Answer("Сорока", false),new Answer("Глухарь", true),new Answer("Филин", true)));
        add(new Question(9,new Answer("Сойка", false),new Answer("Снегирь", true),new Answer("Синица", false),new Answer("Скворец", false)));
        add(new Question(10,new Answer("Волнистый попугай", false),new Answer("Попугай-какаду", true),new Answer("Орёл", false),new Answer("Коршун", false)));
        add(new Question(11,new Answer("Антилопа", false),new Answer("Осёл", false),new Answer("Пони", false),new Answer("Зебра", true)));
        add(new Question(12,new Answer("Антилопа", false),new Answer("Осёл", false),new Answer("Пони", false),new Answer("Зебра", true)));

    }};


    public Question getQuestAnimal(int id) {
        return questionsAnimal.get(id);

    }
    public Question getQuestBird(int id) {
        return questionsBird.get(id);

    }



}
