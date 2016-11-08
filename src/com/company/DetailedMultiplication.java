package com.company;

import java.util.Stack;

/**
 * Created by Alexander on 24.07.2016.
 */
public class DetailedMultiplication {

    public static void executeOperation (Integer operands[]) {
        Integer multiplicand = operands[0];
        Integer secondOperand = operands[1];

        Stack<Integer> multiplier = Main.putNumericsOfTheOperandInStack(secondOperand); // Множитель

        int theLatestNumericOfMultiplier, iteration = 0;
        int result = 0;
        int resultOfTheCurrentIteration = 0;
        int resWithDischargeDisplacement = 0;

        while (!multiplier.isEmpty()) {
            theLatestNumericOfMultiplier = multiplier.pop();
            if (theLatestNumericOfMultiplier != 0) {
                resultOfTheCurrentIteration = multiplicand * theLatestNumericOfMultiplier;
                resWithDischargeDisplacement = dischargeDisplacement(resultOfTheCurrentIteration, iteration);
                result = result + resWithDischargeDisplacement;
                System.out.println("\nIteration №" + (iteration + 1));
                System.out.println("Result of the current iteration: " + multiplicand + "*" +
                        theLatestNumericOfMultiplier + " = " + resultOfTheCurrentIteration);
                System.out.println("Result of the current iteration with discharge displacement: " + resWithDischargeDisplacement);
                System.out.println("Intermediate result: " + result);
                iteration++;
            } else {
                System.out.println("\nIteration №" + (iteration + 1));
                System.out.println("Multiplier is 0.");
                iteration ++;
            }
        }
        System.out.println(Main.LINE + "\nOutcome: " + result + "\n" + Main.LINE);
    }

    private static Integer dischargeDisplacement (Integer res, int countDischarge) {
        int resWithDischargeDisplacement = res;
        while (countDischarge != 0) {
            resWithDischargeDisplacement *= 10;
            countDischarge--;
        }
        return resWithDischargeDisplacement;
    }
}
