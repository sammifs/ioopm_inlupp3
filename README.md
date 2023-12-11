# INLUPP3 #
Symbolic calculator, works like a simple interactive programming language. 4 + 36, Sin(-123), 25 = x, etc.


# Run
To run this program simply write "make all" followed by "make run".

# Packages
This program is made up of three packages.

* org.ioopm.calculator.ast
* org.ioopm.calculator.parser
* org.ioopm.calculator

# Types and subtypes

SymbolicExpression/
├─ Binary/
│  ├─ Addition
│  ├─ Subtraction
│  ├─ Multiplication
│  ├─ Division
│  ├─ Assignment
├─ Unary/
│  ├─ Sin
│  ├─ Cos
│  ├─ Exp
│  ├─ Log
│  ├─ Negation
├─ Atom/
│  ├─ Variable
│  ├─ Constant
├─ Command/
│  ├─ Vars
│  ├─ Quit
│  ├─ Clear

