package vladimir;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        input();
    }

    public static String calc(String input) {
        String[] splitInput = parseInput(input);

        int firstOperandInt = parseNumber(splitInput[0]);
        int secondOperandInt = parseNumber(splitInput[2]);
        String operation = splitInput[1];

        validateNumbers(firstOperandInt, secondOperandInt);
        int result = makeOperation(firstOperandInt, secondOperandInt, operation);
        return String.valueOf(result);

    }

    private static String[] parseInput(String input) {
        String[] splitInput = input.trim().split("\\s+");
        if (splitInput.length != 3) {
            throw new IllegalArgumentException("Invalid number format");
        }
        return splitInput;
    }

    private static int parseNumber(String numberFromString) {
        try {
            return Integer.parseInt(numberFromString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid number format");
        }
    }

    private static void validateNumbers(int firstNumber, int secondNumber) {
        if (firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) {
            throw new IllegalArgumentException("Number out of range");
        }
    }

    private static int makeOperation(int firstNumber, int secondNumber, String operator) {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                yield firstNumber / secondNumber;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical expression: ");

        while (true) {
            try {
                String userInput = scanner.nextLine();
                String result = calc(userInput);
                System.out.println("Result: " + result);
                break;
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }
}


