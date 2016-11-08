package com.company;

import java.util.Stack;
import java.util.function.IntBinaryOperator;

/**
 * Created by Alexander on 24.07.2016.
 */
public class DetailedSummation {

    public static void executeOperation (Integer operands[]) {
        System.out.println("SUMMATION");

        Stack<Integer> firstOperand = Main.putNumericsOfTheOperandInStack(Integer.max(operands[0], operands[1]));
        Stack<Integer> secondOperand = Main.putNumericsOfTheOperandInStack(Integer.min(operands[0], operands[1]));

        System.out.println("firstOperand " + firstOperand);
        System.out.println("secondOperand " + secondOperand);

        int theCurrentNumericOfFirstOperand = 0;
        int theCurrentNumericOfSecondOperand = 0;
        int intermediateSum = 0;
        String sum = "";
        boolean isDischarge = false;
        int iteration = 0;

        while (!firstOperand.isEmpty()) {

            theCurrentNumericOfFirstOperand = firstOperand.pop();

            if (!secondOperand.isEmpty()) {
                theCurrentNumericOfSecondOperand = secondOperand.pop();
                intermediateSum = theCurrentNumericOfFirstOperand + theCurrentNumericOfSecondOperand;

                if (isDischarge) {
                    intermediateSum = intermediateSum + 1;
                    isDischarge = false;
                }
                if (intermediateSum > 9) {
                    sum = Integer.valueOf(intermediateSum % 10) + sum;
                    isDischarge = true;
                } else {
                    sum = intermediateSum + sum;
                }

                System.out.println("\nIteration №" + ++iteration);
                System.out.println("theCurrentNumericOfFirstOperand = " + theCurrentNumericOfFirstOperand);
                System.out.println("theCurrentNumericOfSecondOperand = " + theCurrentNumericOfSecondOperand);
                System.out.println("Result current iteration: " + intermediateSum);
                System.out.println("isDischarge " + isDischarge);
                System.out.println("Sum on current iteration: " + sum);

            } else if(secondOperand.isEmpty() && isDischarge) {
                intermediateSum = theCurrentNumericOfFirstOperand + 1;
                isDischarge = false;
                if (intermediateSum > 9) {
                    sum = Integer.valueOf(intermediateSum % 10) + sum;
                    isDischarge = true;
                } else {
                    sum = intermediateSum + sum;
                }
                System.out.println("\nIteration №" + ++iteration);
                System.out.println("First operand is empty.");
                System.out.println("Result current iteration: " + intermediateSum);
                System.out.println("isDischarge " + isDischarge);

            } else if(secondOperand.isEmpty() && isDischarge == false) {
                sum = theCurrentNumericOfFirstOperand + sum;
                System.out.println("\nIteration №" + ++iteration);
                System.out.println("First operand is empty. And isDischarge = " + isDischarge);
                System.out.println("Sum on current iteration: " + sum);
            }
        }
        if (firstOperand.isEmpty() && isDischarge) {
            sum = "1" + sum;
            System.out.println("\nIteration №" + ++iteration);
            System.out.println("It's the latest operation.");
            System.out.println("Sum on current iteration: " + sum);
        }
        System.out.println(Main.LINE + "\nOutcome: " + sum + "\n" + Main.LINE);
    }
}
