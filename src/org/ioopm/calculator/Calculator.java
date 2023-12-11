package org.ioopm.calculator;

import java.io.IOException;

import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.CalculatorParser;
import org.ioopm.calculator.parser.IllegalExpressionException;
import org.ioopm.calculator.parser.SyntaxErrorException;

public class Calculator {
    // Program main
    public static void main(String[] args) throws IOException {
        final CalculatorParser cp = new CalculatorParser();
        final Environment vars = new Environment();

        // Info for print upon system exit.
        int expressions = 0;
        int success = 0;
        int full_evaluations = 0;

        while (true) {
            String input = System.console().readLine();
            try {
                SymbolicExpression se = cp.parse(input, vars);
                expressions++;
                // Handle Command seperately.
                if (se.isCommand()) {
                    if (se instanceof Quit) {
                        break;
                    } else if (se instanceof Vars) {
                        System.out.println(vars);
                    } else {
                        vars.clear();
                    }
                } else {
                    try { 
                        // eval and print
                        SymbolicExpression ans = se.eval(vars);
                        System.out.println(ans);
                        success++;
                        // eval is considered "full" if it produces Constant
                        if (ans.isConstant()) {
                            full_evaluations++;
                        }
                    } catch (IllegalAssignmentException e) {
                        // IllegalAssignment is not fatal, catch and move on.
                        System.out.println(e);
                    }
                }
            } catch (SyntaxErrorException e) {
                // SyntaxError & IllegalExpression have to be caught before eval.
                System.out.println(e);
            } catch (IllegalExpressionException e) {
                System.out.println(e);
            }
        }
        System.out.println("Thank you!\n" + "expressions: " + expressions + "\n"
                            + "successfull evaluations: " + success + "\n"
                            + "full evaluations: " + full_evaluations);  
    }
}
