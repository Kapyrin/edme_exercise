package vladimir;

class Main {

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
}

