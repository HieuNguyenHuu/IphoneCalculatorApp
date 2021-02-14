
[![LinkedIn][linkedin-shield]][linkedin-url]

<p align="center">
  <h3 align="center">IPHONE CALCULATOR APP</h3>
  <p align="center">
    Iphone calculator application in INTELLIJ IDEA with Java Native Language, JAVAFX library (https://openjfx.io/) for GUI and EASY-STATE
(https://github.com/j-easy/easy-states) for event driven.
  </p>
</p>

## Demo

![](/demo/demo.gif)

<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
	<li><a href="#gui-design">GUI Design</a></li>
	<li><a href="#finite-state-machine">Finite State Machine</a></li>
	<li><a href="#how-to-run">How To Run</a></li>
	<li><a href="#contact">Contact</a></li>
  </ol>
</details>


## About The Project

In this project, I decided to make simulation the iPhones Calculator app to be the example product for all state in my calculator state machine. Calculator without using state machine is very simple to process. However, simple also deal with error, Calculatorwithout state machine can sold multiple operation exactly, such as 2 + 3 * 4 which reality is 2 + (3 * 4) = 14 or
erroneously evaluate in this way (2 + 4) * 2 = 12. So in the backend of this project, i using the FSM - Finite State Machine

![pp1](/images/Untitled.png)

## GUI Design

![pp1](/images/1.png)

With javafx library in intellij idea, i create
java application to easy to describe interface for user. GUI is learning on the concept of default iPhone’s Calculator.
However, Calculator State Machine has the 2 second screen in top of result screen, which display hold all context of calculation (can hold 3 digits and 2 operation - The purpose of this is check the 2 operation which will evaluate first). Additionally, intellij idea support for building this appliaction to .jar and .exe file


## Finite State Machine

![fsm](/images/UntitledDiagram.png)

With easy-state library, that are to easy to describe state of
machine

![2](/images/2.png)

one transition has a name, source State, target State, event
Type (trigger event change state) and event Handler (handle
event with will be call when app enter target State.
Additionally, Coming from the state machine diagram there
are 7 state with a lot of transition between them.
Symbol in this diagram with be solve like:
F = First Number ← input number event
OP = Operation ← input operation event
Res = AC/C ← input All clear/clear event
S = Second Number ← input number event
T = Third number ← input number event
OPS = simple operation ← (+ or -) event
OPC = complex operation ← (* or /) event

I using 7 variable for remember separate number and operation and output :

![3](/images/3.png)

s_f ← first number← input from button has number text
s_s ← second number← input from button has number text
s_t ← third number ← input from button has number text
s_op1 ← first operation ← input from button has operation
text
s_op2 ← second operation ← input from button has operation text
s_display ← first display ← output the result equation
s_display2 ← first display ← output of hold the equation

for full report can see in fullreport.pdf

## How To Run

Run project file "Calculator_project_java.jar" in java supported to in cmp to run this project in java environment

## Contact

Hieu Nguyen - [Linkedin](https://www.linkedin.com/in/hieunguyen-dev/)

Linkedin: https://www.linkedin.com/in/hieunguyen-dev/
Email: hnhieu979@gmail.com
Phone: 0927931496
Facebook: https://www.facebook.com/hieu.nguyenmixed

Project Link: [https://github.com/HieuNguyenHuu/IphoneCalculatorApp](https://github.com/HieuNguyenHuu/IphoneCalculatorApp)


[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/hieunguyen-dev/


