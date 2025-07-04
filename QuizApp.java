import java.util.*;

class Question {
    String questionText;
    String[] options;
    char correctOption;

    public Question(String questionText, String[] options, char correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        char optionChar = 'A';
        for (String option : options) {
            System.out.println(optionChar + ". " + option);
            optionChar++;
        }
    }

    public boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == Character.toUpperCase(correctOption);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Add quiz questions
        questions.add(new Question("What is the capital of India?",
                new String[]{"Mumbai", "New Delhi", "Bangalore", "Chennai"}, 'B'));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 'B'));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?",
                new String[]{"Shakespeare", "Charles Dickens", "Mark Twain", "Leo Tolstoy"}, 'A'));
        questions.add(new Question("What is the chemical symbol for water?",
                new String[]{"O2", "H2O", "CO2", "NaCl"}, 'B'));
        questions.add(new Question("Which language is used to develop Android apps?",
                new String[]{"Swift", "Python", "Java", "C#"}, 'C'));

        int score = 0;

        System.out.println("==== Welcome to the Java Quiz ====\n");

        int qNo = 1;
        for (Question q : questions) {
            System.out.println("Question " + qNo + ":");
            q.displayQuestion();
            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = scanner.next().charAt(0);

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Incorrect! The correct answer is: " + q.correctOption + "\n");
            }
            qNo++;
        }

        // Final score
        System.out.println("==== Quiz Finished ====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        // Feedback
        if (score == questions.size()) {
            System.out.println("🎉 Excellent! You got all answers correct!");
        } else if (score >= questions.size() / 2) {
            System.out.println("😊 Good job! Try for a perfect score.");
        } else {
            System.out.println("📘 Keep practicing to improve!");
        }

        scanner.close();
    }
}
