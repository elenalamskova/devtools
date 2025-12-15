Gradle-проект ProgressDemo
- Quick Start:
  JDK25; Gradle 9.2.0
  ./gradlew run (запустить приложение)
  ./gradlew test (запустить все тесты)
- Описание пакета
  package ru.mentee.power пакет в репозитории devtools. в этом пакете хранится класс ProgressDemo.java и record-class MenteeProgress.java + тестовый класс MenteeProgressTest.java вынесен отдельно, но тоже имеет отношение в этому пакету.
  Основные классы и тестовые хранятся в папке build, но первые - в папке main, а вторые - в папке test.
  Пакет позволяет четко ориентироваться в именах переменных и их описанных связях.
- таблица полей MenteeProgress
  record MenteeProgress(String menteeName, int sprintNumber, int plannedHoursPerWeek)

| название            | тип переменной | наполнение    |
| ------------------- | -------------- | ------------- |
| menteeName          | String         | имя студента  |
| sprintNumber        | int            | номер спринта |
| plannedHoursPerWeek | int            | время спринта |
- ссылка на урок https://mentee-power.xl.ru/learn/MCIneBj4KkyH-GIRCspFvA/theory
- Git-локальный цикл
    git init
    создание шаблонов (templates)+.gitignore+README.md
    git add (имя файла или несколько через пробел)
    git commit -m "message"
    git status
    git push -u origin (название ветки нововведения)

- Правило веток: feature/DVT‑X - называем ветки по номеру урока; шаблон записи в названии