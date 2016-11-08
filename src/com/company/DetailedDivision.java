package com.company;


/**
 * Created by Alexander on 24.07.2016.
 */
public class DetailedDivision {

    public static void executeOperation(Integer operands[]) {
        Integer dividend = operands[0];
        Integer divider = operands[1];

        System.out.println("Dividend = " + dividend);
        System.out.println("Divider = " + divider);
        System.out.println(Main.LINE);

        // Если делимое меньше делителя...
        if (dividend < divider) {
            System.err.println("Dividend < Divider");
            return;
        }

        String dvdnd = dividend.toString(); // Делимое
        Integer currentDividend; // "Отсекаемое" делимое
        String crntDvdnd = ""; // "Отсекаемое" делимое в текстовом формате
        Integer currentRes = null; // Результат деления "отсекаемого" делимого на делитель на текущей итерации
        String res = ""; // Частное
        int i = 0; // Номер итерации


        for (char numericOfDividend: dvdnd.toCharArray()) {
            crntDvdnd = crntDvdnd + numericOfDividend;
            currentDividend = Integer.valueOf(crntDvdnd);
            if (currentDividend < divider) {
                if (!res.isEmpty())
                    res = res + "0";
            } else {
                currentRes = currentDividend/divider;
                res = res + String.valueOf(currentRes);
                crntDvdnd = String.valueOf(currentDividend - divider*currentRes);
            }
            if (!res.isEmpty()) {
                // Вывод информации о делении на текущей итерации
                System.out.println("Iteration №" + ++i);
                System.out.println("Current operation: " + currentDividend + "/" + divider + " = " + currentRes);
                System.out.println("Remainder of the division: " + crntDvdnd);
                System.out.println("Intermediate result: " + res + "\n");
            }
        }
        System.out.println(Main.LINE + "\nOutcome: " + res + "\n" + Main.LINE);
    }
}
