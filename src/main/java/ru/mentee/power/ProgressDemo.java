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
        if(progress.readyForSprint()) { //намеренная ошибка (пункт 6 задания DVT-8)
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
        System.out.println("This is the feature/DVT-3 branch");
    }
}


