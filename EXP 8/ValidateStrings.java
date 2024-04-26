public class ValidateStrings {
    public static void main(String[] args) {
        String[] strings = {"100", "10.2", "5.hello", "100hello"};

        for (String str : strings) {
            try {
                int intValue = Integer.parseInt(str);
                System.out.println(intValue + " is a valid integer.");
            } catch (NumberFormatException e1) {
                try {
                    double doubleValue = Double.parseDouble(str);
                    System.out.println(doubleValue + " is a valid double.");
                } catch (NumberFormatException e2) {
                    System.out.println(str + " is neither a valid integer nor a valid double.");
                }
            }
        }
    }
}
