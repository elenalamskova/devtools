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
- Сценарий ручной проверки DVT-6
## Сценарий ручной проверки DVT-6

### Запуск приложения
1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window:
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

### Запуск тестов
1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

### Отладка через Debug
1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)

### Что делать при ошибках
- Если вывод некорректен: проверьте логику цикла через Debug
- Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
- Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)

## Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование методов: camelCase

До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    if(condition) {
После: if (condition) {

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 120 символов

До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {

Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов

До:    import java.util.List; import java.util.ArrayList; import java.io.File;
После: import java.io.File; import java.util.ArrayList; import java.util.List;

Почему: алфавитный порядок упрощает поиск импортов.
Источник: IntelliJ IDEA → Code → Optimize Imports

### 5. Фигурные скобки для if

До:    if (condition) doSomething();
После: if (condition) { doSomething(); }

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used

# CI-пайплайн настроен"
new workflow file создан по образцу:

name: <Ваше_название>

on:
push:
branches:
- <ветка_1>
- '<паттерн_feature>'
pull_request:
branches:
- <ветка_master>

jobs:
<имя_job>:
runs-on: <операционная_система>

       steps:
         - name: <Описание_шага_1>
           uses: actions/checkout@v4

         - name: <Описание_шага_2>
           uses: actions/setup-java@v4
           with:
             distribution: '<дистрибутив>'
             java-version: '<версия>'

         - name: <Описание_шага_3>
           run: <команда_checkstyle>

         - name: <Описание_шага_4>
           run: <команда_тесты>

         - name: <Описание_шага_5>
           run: <команда_сборка>