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
