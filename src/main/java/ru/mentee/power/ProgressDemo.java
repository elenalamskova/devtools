package ru.mentee.power;

public class ProgressDemo {
    public static void main(String[] args) {
        MenteeProgress elena_Lamskova = new MenteeProgress(//нейминг
                "ElenaLamskova",
                2,
                40
        );
        var progress = elena_Lamskova;

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
        System.out.println("This is the feature/DVT-3 branch");
    }
}