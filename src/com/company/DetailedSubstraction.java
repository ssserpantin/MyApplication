package com.company;

import java.util.Stack;

/**
 * Created by Alexander on 25.07.2016.
 */
public class DetailedSubstraction {

    public static void executeOperation (Integer operands[]) {
        Integer operand1 = operands[0];
        Integer operand2 = operands[1];

        String result = "";
        Stack<Integer> firstOperand, secondOperand;
        int theCurrentNumericOfFirstOperand = 0;
        int theCurrentNumericOfSecondOperand = 0;
        int intermediateSubstraction = 0;
        int iteration = 0;
        boolean isDischarge = false;

        // Если операнд 1 < операнда 2, то ответ будет отрицательным. И операнд, из которого будем вычитать, поменяется.
        if (operand1 < operand2) {
            firstOperand = Main.putNumericsOfTheOperandInStack(operands[1]);
            secondOperand = Main.putNumericsOfTheOperandInStack(operands[0]);
        } else {
            firstOperand = Main.putNumericsOfTheOperandInStack(operands[0]);
            secondOperand = Main.putNumericsOfTheOperandInStack(operands[1]);
        }

        while(!firstOperand.isEmpty()) {
            theCurrentNumericOfFirstOperand = firstOperand.pop();
            if(!secondOperand.isEmpty()) {
                theCurrentNumericOfSecondOperand = secondOperand.pop();
                if (isDischarge) {
                    if (theCurrentNumericOfFirstOperand != 0)
                        theCurrentNumericOfFirstOperand -=1;
                    else
                        theCurrentNumericOfFirstOperand = 9;
                    isDischarge = false;
                }
                if (theCurrentNumericOfFirstOperand < theCurrentNumericOfSecondOperand) {
                    intermediateSubstraction = (theCurrentNumericOfFirstOperand + 10) - theCurrentNumericOfSecondOperand;
                    result = intermediateSubstraction + result;
                    isDischarge = true;
                } else {
                    intermediateSubstraction = theCurrentNumericOfFirstOperand - theCurrentNumericOfSecondOperand;
                    result = intermediateSubstraction + result;
                }
                System.out.println("\nIteration №" + ++iteration);
                System.out.println("First operand = " + theCurrentNumericOfFirstOperand);
                System.out.println("Second operand = " + theCurrentNumericOfSecondOperand);
                System.out.println("Intermediate substraction: " + intermediateSubstraction);
                System.out.println("Result of the curent iteration: " + result);
                System.out.println("isDischarge: " + isDischarge);
            } else if (secondOperand.isEmpty() && isDischarge) {
                if (theCurrentNumericOfFirstOperand != 0)
                    theCurrentNumericOfFirstOperand -=1;
                else
                    theCurrentNumericOfFirstOperand = 9;
                result = theCurrentNumericOfFirstOperand + result;
                isDischarge = false;
                System.out.println("\nIteration №" + ++iteration);
                System.out.println("Second operand is empty.");
                System.out.println("First operand = " + theCurrentNumericOfFirstOperand);
                System.out.println("Result of the curent iteration: " + result);
                System.out.println("isDischarge: " + isDischarge);
            } else if (secondOperand.isEmpty() && isDischarge == false) {
                result = theCurrentNumericOfFirstOperand + result;
                System.out.println("\nIteration №" + ++iteration);
                System.out.println("Second operand is empty. And isDischarge = " + isDischarge + ".");
                System.out.println("First operand = " + theCurrentNumericOfFirstOperand);
                System.out.println("Result of the curent iteration: " + result);
                System.out.println("isDischarge: " + isDischarge);
            }
        }

        if (operand1 < operand2)
            result = "-" + result;

        System.out.println(Main.LINE + "\nOutcome: " + result + "\n" + Main.LINE);
    }
}
