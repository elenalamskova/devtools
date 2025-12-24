package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


    @DisplayName("Тестирование ProgressTracker")
    class ProgressLoopTest {

        @Test
        @DisplayName("Должен корректно вычислить суммарный прогресс когда передан массив mentee")
        void shouldCalculateTotalProgressWhenMultipleMentees() {
            ProgressTracker tracker = new ProgressTracker();
            Mentee[] mentees = {
                    new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                    new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                    new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
            };

            String result = tracker.calculateTotalProgress(mentees);

            assertThat(result)
                    .contains("пройдено 25 из 36 уроков")
                    .contains("осталось 11 уроков");
        }

        @Test
        @DisplayName("Должен корректно обработать массив когда все mentee завершили курс")
        void shouldCalculateTotalProgressWhenAllMenteesCompleted() {
            ProgressTracker tracker = new ProgressTracker();
            Mentee[] mentees = {
                    new Mentee("Иван", "Москва", "Backend", 12, 12),
                    new Mentee("Мария", "СПб", "Fullstack", 12, 12)
            };

            String result = tracker.calculateTotalProgress(mentees);
            assertThat(result)
                    .contains("пройдено 24 из 24 уроков")
                    .contains("осталось 0 уроков");
        }
        @Test
        @DisplayName("Должен выбросить исключение когда массив mentee равен null")
        void shouldThrowExceptionWhenMenteesArrayIsNull() {
            ProgressTracker tracker = new ProgressTracker();

            assertThatThrownBy(() -> tracker.calculateTotalProgress(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Array mentees is null or empty");
        }

        @Test
        @DisplayName("Должен выбросить исключение когда массив mentee пустой")
        void shouldThrowExceptionWhenMenteesArrayIsEmpty() {
            ProgressTracker tracker = new ProgressTracker();
            Mentee[] mentees = {};

            assertThatThrownBy(() -> tracker.calculateTotalProgress(mentees))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Array mentees is null or empty");
        }

                @Test
        @DisplayName("Должен выбросить IllegalArgumentException при некорректном прогрессе mentee")
        void shouldThrowExceptionWhenMenteeProgressIsInvalid() {
            assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", -1, 10))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Некорректные значения прогресса");

            assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", 5, 0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Некорректные значения прогресса");

            assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", 15, 10))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Некорректные значения прогресса");
        }
        @Test
        @DisplayName("main должен выполняться без ошибок и печатать прогресс")
        void mainShouldRunWithoutExceptions() {
            String[] args = {};
            ProgressTracker.main(args);
        }
    }
