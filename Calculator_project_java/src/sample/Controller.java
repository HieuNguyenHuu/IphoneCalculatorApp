package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.jeasy.states.api.*;
import org.jeasy.states.core.FiniteStateMachineBuilder;
import org.jeasy.states.core.TransitionBuilder;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Controller implements Event {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    @FXML
    public Label output;
    public Label output2;
    public Button b_ac;
    public static String b_temp;
    public StateMachine sm = new StateMachine();
    public static String s_f = "0", s_s = "", s_op1 = "+", s_op2 = "+", s_t = "", s_display = s_f, s_display2 = "";
    public static String s_num, s_op, s_d;

    public Controller() throws FiniteStateMachineException {
    }

    public void processInput(ActionEvent event) throws FiniteStateMachineException {
        String value = ((Button) event.getSource()).getText();
        if (isNumeric(value) == true) {
            if (s_num != "0") {
                b_ac.setText("C");
            }
            else b_ac.setText("AC");
                s_num = value;
                sm.calstatemachine.fire(new NUM());
        }
        else {
            switch (value){
                case "AC":
                    if (s_display != "0") {
                        //sm.calstatemachine.fire(new RES_clear());
                        b_ac.setText("C");

                    }
                    sm.calstatemachine.fire(new RES_allclear());
                    sm.calstatemachine.fire(new RES());
                    break;
                case "C":
                        sm.calstatemachine.fire(new RES_clear());
                       // sm.calstatemachine.fire(new RES_allclear());
                    sm.calstatemachine.fire(new RES());
                    if (s_display == "0") {
                        b_ac.setText("AC");
                    }
                    break;
                case "=":
                    sm.calstatemachine.fire(new EQUAL());
                    //System.out.println("j");
                   // output.setText(s_display);
                    break;
                case "+":
                    s_op = value;
                    sm.calstatemachine.fire(new OPER_S());
                    sm.calstatemachine.fire(new OPER());

                    break;
                case "-":
                    s_op = value;
                    sm.calstatemachine.fire(new OPER_S());
                    sm.calstatemachine.fire(new OPER());

                    break;
                case "÷":
                    s_op = value;
                    sm.calstatemachine.fire(new OPER_C());
                    sm.calstatemachine.fire(new OPER());
                    //sm.calstatemachine.fire(new OPER_C());
                    break;
                case "x":
                    s_op = value;
                    sm.calstatemachine.fire(new OPER_C());
                    sm.calstatemachine.fire(new OPER());

                    break;
                case "⁺⁄₋":
                    sm.calstatemachine.fire(new PLM());
                    break;
                case "%":
                    sm.calstatemachine.fire(new PC());
                    break;
                case ",":
                    sm.calstatemachine.fire(new POINT());
                    break;
            }
        }
        output.setText(s_display);
        output2.setText(s_display2);
        System.out.println(sm.calstatemachine.getCurrentState().getName().toString());
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public long getTimestamp() {
        return 0;
    }
}


