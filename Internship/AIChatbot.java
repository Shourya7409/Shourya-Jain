import java.util.Scanner;

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      AI CHATBOT");
        System.out.println("Type 'bye' to exit.");
        System.out.println("=================================");

        while (true) {

            System.out.print("\nYou: ");
            String input = sc.nextLine().toLowerCase();

            if (input.equals("hello") || input.equals("hi")) {
                System.out.println("Bot: Hello! How can I help you?");

            } else if (input.equals("how are you")) {
                System.out.println("Bot: I am fine. Thank you!");

            } else if (input.equals("what is java")) {
                System.out.println("Bot: Java is an object-oriented programming language.");

            } else if (input.equals("who created java")) {
                System.out.println("Bot: Java was developed by Sun Microsystems and led by James Gosling.");

            } else if (input.equals("what is oops")) {
                System.out.println("Bot: OOPS stands for Object-Oriented Programming System.");

            } else if (input.equals("what is ai")) {
                System.out.println("Bot: AI stands for Artificial Intelligence.");

            } else if (input.equals("help")) {
                System.out.println("Bot: You can ask me about Java, AI, OOPS, or greet me.");

            } else if (input.equals("bye")) {
                System.out.println("Bot: Goodbye! Have a great day.");
                break;

            } else {
                System.out.println("Bot: Sorry, I don't understand that question.");
            }
        }

        sc.close();
    }
}