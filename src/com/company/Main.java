package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private enum Operations {DIVISION, MULTIPLICATION, SUMMATION, SUBSTRACTION}

    public final static String LINE = "________________________________________________";
    private final static String HEADER = LINE +
            "\nPlease, input expression for division, multiplication, summation, substraction. \n" +
            "Delimiter for division should be \"/\", \":\", \"_\". \n" +
            "Delimiter for multiplication should be \"*\". \n" +
            "Delimiter for summation should be \"+\". \n" +
            "Delimiter for substraction should be \"-\". \n" +
            LINE;

    public static void main(String[] args) throws Exception {
        System.out.println(HEADER);
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next().trim();
        System.out.println("Input expression: " + expression + "\n" + LINE);

        char delimiter = getDelimiter(expression);
        Operations currentOperation = getMathOperation(delimiter);
        Integer operands[] = parsingAndValidationExpression(expression, delimiter);
        executeMathOperation(currentOperation, operands);

        //DetailedDivision.executeOperation(result);
    }

    private static void executeMathOperation (Operations operation, Integer operands[]) {
        switch (operation) {
            case DIVISION:
                DetailedDivision.executeOperation(operands);
                break;
            case MULTIPLICATION:
                DetailedMultiplication.executeOperation(operands);
                break;
            case SUMMATION:
                DetailedSummation.executeOperation(operands);
                break;
            case SUBSTRACTION:
                DetailedSubstraction.executeOperation(operands);
                break;
        }
    }

    private static Operations getMathOperation (char delimiter) {
        switch (delimiter) {
            case '/':
                return Operations.DIVISION;
            case '_':
                return Operations.DIVISION;
            case ':':
                return Operations.DIVISION;
            case '*':
                return Operations.MULTIPLICATION;
            case '+':
                return Operations.SUMMATION;
            case '-':
                return Operations.SUBSTRACTION;
            default:
                return null;
        }
    }

    private static char getDelimiter (String expression) throws Exception {
        char delimiter = ' ';
        for (char character: expression.toCharArray()) {
            if (isDelimiter(character)) {
                // Если более одного разделителя...
                if (delimiter != ' ')
                    throw new Exception("Expression " + expression + " has more one delimiter. Please, input correct expression.");
                delimiter = character;
            }
        }
        // Если разделитель отсутствует...
        if (delimiter == ' ')
            throw new Exception("Expression " + expression + " hasn't delimiter or incorrect delimiter. Please, input correct expression.");
        return delimiter;
    }

    private static boolean isDelimiter (char character) {
        // Возможные разделители: "/", ":", "_", "*", "+".
        return character == '/' || character == ':' || character == '_' || character == '*' || character == '+' || character == '-';
    }


    private static Integer[] parsingAndValidationExpression(String expression, char delimiter) throws Exception {

        Integer firstOperand, secondOperand;

        // Если первый операнд не является числом или пустое значение...
        try {
            firstOperand = Integer.valueOf(expression.substring(0, expression.indexOf(delimiter)));
        } catch (Exception e) {
            throw new Exception("First operand isn't numeric or empty. Please, input correct expression." , e);
        }

        // Если второй операнд не является числом или пустое значение...
        try {
            secondOperand = Integer.valueOf(expression.substring(expression.indexOf(delimiter) + 1, expression.length()));
        } catch (Exception e) {
            throw new Exception("Divider isn't numeric or empty. Please, input correct expression." , e);
        }

        // Если деление на ноль...
        if (getMathOperation(delimiter).equals(Operations.DIVISION) && secondOperand == 0)
            throw new ArithmeticException("Divider = 0. Division on 0 is impossible. Please, input correct expression.");

        Integer result [] = {firstOperand, secondOperand};

        return result;
    }

    public static Stack<Integer> putNumericsOfTheOperandInStack (Integer operand) {
        // Разбить число на цифры
        int mod = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Integer> numericsOfTheOperand = new Stack<Integer>();

        while (operand > 0) {
            mod = operand % 10;
            operand = operand / 10;
            res.add(mod);
        }

        if (operand != 0)
            res.add(operand);

        for (int i = (res.size() - 1); i>=0; i--)
            numericsOfTheOperand.push(res.get(i));

        return numericsOfTheOperand;
    }
}
