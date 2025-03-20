import java.util.*;

public class Main {
    private static final Map<String, String> responses = new HashMap<>();
    
    static {
        responses.put("hello", "Hi there! How can I assist you today?");
        responses.put("how are you", "I'm just a bot, but I'm doing great! How about you?");
        responses.put("your name", "I'm an AI chatbot created to help you.");
        responses.put("bye", "Goodbye! Have a great day!");
    }
    
    public static String getResponse(String input) {
        input = input.toLowerCase();
        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                return responses.get(key);
            }
        }
        return "I'm not sure how to respond to that. Can you rephrase?";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("AI Chatbot: Hello! Type 'exit' to end the chat.");
        
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("AI Chatbot: Goodbye!");
                break;
            }
            
            String response = getResponse(userInput);
            System.out.println("AI Chatbot: " + response);
        }
        
        scanner.close();
    }
}