package transformer;

public class StringTransformer {

    private static boolean loggingEnabled = true;

    public static boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public static void setLoggingEnabled(boolean enabled) {
        loggingEnabled = enabled;
    }

    public String transformString(String input) {

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Введено порожній рядок");
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) {
                if (i % 2 == 0) {
                    result.append(Character.toUpperCase(currentChar));
                } else {
                    result.append(Character.toLowerCase(currentChar));
                }
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}