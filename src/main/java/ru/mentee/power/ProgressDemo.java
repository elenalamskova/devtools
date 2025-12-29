package ru.mentee.power;

public class ProgressDemo {
    public static void main(String[] args) {
        MenteeProgress elenaLamskova = new MenteeProgress(
                "ElenaLamskova",
                2,
                40
        );
        var progress = elenaLamskova;

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
        System.out.println("This is the feature/DVT-3 branch");
        System.out.println("Debug: starting loop");
        //добавлена строка для задания DVT-9 - лишний вывод для удаления
        //System.out.println("атолватадьвмдьдьажу");
        //добавлен закомментированный участок кода для задания DVT-9 - нужно удалить
    }
}