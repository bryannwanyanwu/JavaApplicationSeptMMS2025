import java.util.Scanner;

public class GlobalWarmingQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
            "1. What gas is the primary driver of recent climate change?\n   1) Oxygen  2) CO2  3) Nitrogen  4) Argon",
            "2. Which year was the hottest on record (as of 2023)?\n   1) 2005  2) 2010  3) 2016  4) 2023",
            "3. The IPCC shared the 2007 Nobel Peace Prize with whom?\n   1) Barack Obama  2) Al Gore  3) Greta Thunberg  4) Elon Musk",
            "4. What percentage of scientists agree humans cause climate change?\n   1) 50%  2) 70%  3) 85%  4) 97%",
            "5. Which sector is the largest source of global CO2 emissions?\n   1) Agriculture  2) Energy  3) Transport  4) Industry"
        };
        int[] answers = {2, 4, 2, 4, 2};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            if (sc.nextInt() == answers[i]) score++;
        }

        System.out.println("\nYou scored: " + score + "/5");
        if (score == 5)
            System.out.println("Excellent!");
        else if (score == 4)
            System.out.println("Very good!");
        else
            System.out.println("Time to brush up on your knowledge of global warming.\n" +
                "Resources: https://climate.nasa.gov | https://www.ipcc.ch");
    }
}