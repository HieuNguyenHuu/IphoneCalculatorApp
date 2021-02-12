package sample;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import com.sun.glass.ui.Window;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.jeasy.states.api.*;
import org.jeasy.states.core.FiniteStateMachineBuilder;
import org.jeasy.states.core.TransitionBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/*class equal extends AbstractEvent {
    public equal(){
        super("equal");
    }
}
class hd extends AbstractEvent{
    public hd(){
        super("hd");
    }
}
class reset implements EventHandler<equal>{
    @Override
    public void handleEvent(equal equal) throws Exception {
        Controller.b_temp = "09";
    }
}
class h implements EventHandler<hd>{

    @Override
    public void handleEvent(hd hd) throws Exception {
        System.out.println("ngu");
    }
}*/
class RES_clear extends AbstractEvent{
    public RES_clear(){ super("res_clear");}
}
class RES_allclear extends AbstractEvent{
    public RES_allclear() {super("res_allclear");}
}
class EQUAL extends AbstractEvent{
    public EQUAL(){ super("eq"); }
}
class NUM extends AbstractEvent{
    public NUM(){
        super("num");
    }
}
class RES extends AbstractEvent{
    public RES(){
        super("res");
    }
}
class OPER_C extends AbstractEvent{
    public OPER_C(){
        super("oper_c");
    }
}
class OPER_S extends AbstractEvent{
    public OPER_S(){
        super("oper_s");
    }
}
class OPER extends AbstractEvent{
    public OPER(){
        super("oper");
    }
}
class itoop1 implements EventHandler<OPER>{
    @Override
    public void handleEvent(OPER oper) throws Exception {
        Controller.s_op1 = Controller.s_op;
        Controller.s_display2 += " " + Controller.s_op;
    }
}

class itoa1 implements EventHandler<NUM>{
    @Override
    public void handleEvent(NUM num) throws Exception {
        Controller.s_f = Controller.s_num;
        Controller.s_display = Controller.s_f;
        Controller.s_display2 = Controller.s_f;
    }
}
class resas1 implements EventHandler<RES_clear>{
    @Override
    public void handleEvent(RES_clear res) throws Exception {
        if (Controller.s_f != "0") {
            Controller.s_f = "";
            Controller.s_display = "0";
            Controller.s_display2 = "";
        }
    }
}
class resas2 implements EventHandler<RES_clear>{
    @Override
    public void handleEvent(RES_clear res) throws Exception {
        if (Controller.s_s != "0") {
            Controller.s_s = "";
            Controller.s_display = "0";
        }
    }
}
class as1toin implements EventHandler<RES_allclear>{
    @Override
    public void handleEvent(RES_allclear res) throws Exception {
        if (Controller.s_f == "0") {
            Controller.s_f = "";
            Controller.s_op1 = "+";
            Controller.s_op2 = "+";
            Controller.s_s = "";
            Controller.s_display = "0";
            Controller.s_display2 = "";
            Controller.s_t = "";
        }
    }
}
class resint implements EventHandler<RES_allclear>{
    @Override
    public void handleEvent(RES_allclear res) throws Exception {
        Controller.s_f = "";
        Controller.s_op1 = "+";
        Controller.s_op2 = "+";
        Controller.s_s = "";
        Controller.s_display = "0";
        Controller.s_display2 = "";
        Controller.s_t = "";
    }
}
class resop1 implements EventHandler<RES>{

    @Override
    public void handleEvent(RES res) throws Exception {
        Controller.s_f = "";
        Controller.s_display = "0";
        Controller.s_display2 = "";
        Controller.s_op1 = "";
    }
}
class astoas1 implements EventHandler<NUM>{
    @Override
    public void handleEvent(NUM num) throws Exception {
        Controller.s_f += Controller.s_num;
        Controller.s_display = Controller.s_f;
        Controller.s_display2 = Controller.s_f;
    }
}
class astoas2 implements EventHandler<NUM>{
    @Override
    public void handleEvent(NUM num) throws Exception {
        Controller.s_s += Controller.s_num;
        Controller.s_display = Controller.s_s;
        Controller.s_display2 =Controller.s_f + " " + Controller.s_op1 + " " + Controller.s_s;
    }
}
class astoas3 implements EventHandler<NUM>{
    @Override
    public void handleEvent(NUM num) throws Exception {
        Controller.s_t += Controller.s_num;
        Controller.s_display = Controller.s_t;
        Controller.s_display2 += Controller.s_t;
    }
}
class op1toas2 implements EventHandler<NUM>{
    @Override
    public void handleEvent(NUM num) throws Exception {
        Controller.s_display = "0";
        Controller.s_s += Controller.s_num;
        Controller.s_display = Controller.s_s;
        Controller.s_display2 += " " + Controller.s_s;
    }
}
class op2toas3 implements EventHandler<NUM>{
    @Override
    public void handleEvent(NUM num) throws Exception {
        Controller.s_t = "";
        Controller.s_op2 = Controller.s_op;
        Controller.s_display = "";
        Controller.s_t += Controller.s_num;
        Controller.s_display = Controller.s_t;
        Controller.s_display2 +=  " " + Controller.s_op2 + " " + Controller.s_t;
    }
}
class op2toop1 implements EventHandler<OPER_S>{
    @Override
    public void handleEvent(OPER_S oper_s) throws Exception {
        Double l_f = Double.parseDouble(Controller.s_f.toString());
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_temp;
        switch (Controller.s_op1.toString()) {
            case "+":
                l_temp = l_f + l_s;
                break;
            case "-":
                l_temp = l_f - l_s;
                break;
            case "÷":
                if (l_s != 0)
                    l_temp = l_f / l_s;
                else
                    l_temp = 0d;
                break;
            case "x":
                l_temp = l_f * l_s;
                break;
            default:
                throw new IllegalStateException();
        }
        String s_temp = String.valueOf(l_temp);
        Controller.s_display = s_temp;
        Controller.s_f =  s_temp;
        Controller.s_s = "";
        Controller.s_op1 = Controller.s_op;
        Controller.s_display2 = Controller.s_f + " " + Controller.s_op1;
    }
}
class op1toeq implements EventHandler<EQUAL>{
    @Override
    public void handleEvent(EQUAL equal) throws Exception {
        Controller.s_s = Controller.s_f;
        Double l_f = Double.parseDouble(Controller.s_f.toString());
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_temp;
        switch (Controller.s_op1.toString()) {
            case "+":
                l_temp = l_f + l_s;
                break;
            case "-":
                l_temp = l_f - l_s;
                break;
            case "÷":
                if (l_s != 0)
                    l_temp = l_f / l_s;
                else
                    l_temp = 0d;
                break;
            case "x":
                l_temp = l_f * l_s;
                break;
            default:
                throw new IllegalStateException();
        }
        String s_temp = String.valueOf(l_temp);
        Controller.s_display = s_temp;
        Controller.s_f = String.valueOf(l_temp);
    }
}
class op2toeq implements EventHandler<EQUAL>{
    @Override
    public void handleEvent(EQUAL equal) throws Exception {
        Controller.s_op2 = Controller.s_op;
        Controller.s_t = Controller.s_s;
        Double l_t = Double.parseDouble(Controller.s_t.toString());
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_temp1;
        switch (Controller.s_op2.toString()) {
            case "÷":
                if (l_s != 0)
                    l_temp1 = l_t / l_s;
                else
                    l_temp1 = 0d;
                break;
            case "x":
                l_temp1 = l_t * l_s;
                break;
            default:
                throw new IllegalStateException();
        }
        String s_temp1 = String.valueOf(l_temp1);
        //Controller.s_s = s_temp1;
        l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_f = Double.parseDouble(Controller.s_f.toString());
        Double l_temp2;
        switch (Controller.s_op1.toString()) {
            case "+":
                l_temp2 = l_f + l_temp1;
                break;
            case "-":
                l_temp2 = l_f - l_temp1;
                break;
            default:
                throw new IllegalStateException();
        }
        String s_temp2 = String.valueOf(l_temp2);
        Controller.s_f = s_temp2;
        Controller.s_display = s_temp2;
        Controller.s_display2 = Controller.s_f + " " + Controller.s_op2 + " " + Controller.s_s;
    }
}
class op1toop1 implements EventHandler<OPER>{

    @Override
    public void handleEvent(OPER oper) throws Exception {
        Controller.s_op1 = Controller.s_op;
    }
}
class optoop2 implements EventHandler<OPER_C>{
    @Override
    public void handleEvent(OPER_C oper) throws Exception {
        Controller.s_op2 = Controller.s_op;
    }
}
class as2toop1 implements EventHandler<OPER>{
    @Override
    public void handleEvent(OPER opers) throws Exception {
        //System.out.println("ngu");
        //if (((Controller.s_op1 =="+") || ((Controller.s_op1 =="-"))) || (((Controller.s_op1 == "÷") || (Controller.s_op1 == "x")) && ((Controller.s_op == "÷") || (Controller.s_op == "x"))) ){

            Double l_f = Double.parseDouble(Controller.s_f.toString());
            Double l_s = Double.parseDouble(Controller.s_s.toString());
            Double l_temp;
            switch (Controller.s_op1.toString()) {
                case "+":
                    l_temp = l_f + l_s;
                    break;
                case "-":
                    l_temp = l_f - l_s;
                    break;
                case "÷":
                    if (l_s != 0)
                        l_temp = l_f / l_s;
                    else
                        l_temp = 0d;
                    break;
                case "x":
                    l_temp = l_f * l_s;
                    break;
                default:
                    throw new IllegalStateException();
            }
            String s_temp = String.valueOf(l_temp);
            Controller.s_display = s_temp;
            Controller.s_f = String.valueOf(l_temp);
            Controller.s_op1 = Controller.s_op;
            Controller.s_display2 = s_temp + " " + Controller.s_op;
            Controller.s_s = "";
    }
}
class as2toop2 implements EventHandler<OPER_C>{
    @Override
    public void handleEvent(OPER_C operc) throws Exception {
        if ((Controller.s_op1 == "+") || (Controller.s_op1 == "-")){
           if (Controller.s_op != Controller.s_op1) {
               //System.out.println("wdw");
                /*long l_f = Long.parseLong(Controller.s_f.toString());
                long l_s = Long.parseLong(Controller.s_s.toString());
                long l_temp;
                switch (Controller.s_op1.toString()) {
                    case "+":
                        l_temp = l_f + l_s;
                        break;
                    case "-":
                        l_temp = l_f - l_s;
                        break;
                    case "÷":
                        if (l_s != 0)
                            l_temp = l_f / l_s;
                        else
                            l_temp = 0;
                        break;
                    case "x":
                        l_temp = l_f * l_s;
                        break;
                    default:
                        throw new IllegalStateException();
                }
                String s_temp = String.valueOf(l_temp);*/
                Controller.s_display = Controller.s_s;
                //Controller.s_s = String.valueOf(l_temp);
                Controller.s_t = Controller.s_s;
                Controller.s_op2 = Controller.s_op;
                //Controller.s_display2 = + " " + Controller.s_op;
          }
       }
    }
}
class as2toin implements  EventHandler<RES_allclear>{
    @Override
    public void handleEvent(RES_allclear res) throws Exception {
        if (Controller.s_s == "0"){
            Controller.s_f = "";
            Controller.s_op1 = "+";
            Controller.s_op2 = "+";
            Controller.s_s = "";
            Controller.s_display = "0";
            Controller.s_display2 = "";
            Controller.s_t = "";
        }
    }
}
class op2toas3_res implements EventHandler<RES_clear>{
    @Override
    public void handleEvent(RES_clear res) throws Exception {
        Controller.s_t = "";
    }
}
class as2toeq implements EventHandler<EQUAL>{
    @Override
    public void handleEvent(EQUAL equal) throws Exception {
        Double l_f = Double.parseDouble(Controller.s_f.toString());
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_temp;
        switch (Controller.s_op1.toString()) {
            case "+":
                l_temp = l_f + l_s;
                break;
            case "-":
                l_temp = l_f - l_s;
                break;
            case "÷":
                if (l_s != 0)
                    l_temp = l_f / l_s;
                else
                    l_temp = 0d;
                break;
            case "x":
                l_temp = l_f * l_s;
                break;
            default:
                throw new IllegalStateException();
        }
        String s_temp = String.valueOf(l_temp);
        Controller.s_display = s_temp;
        Controller.s_f = String.valueOf(l_temp);
    }
}
class as3toop2 implements EventHandler<OPER_C>{

    @Override
    public void handleEvent(OPER_C oper_c) throws Exception {
        Double l_t = Double.parseDouble(Controller.s_t.toString());
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_temp;
        switch (Controller.s_op2.toString()) {
            case "+":
                l_temp = l_t + l_s;
                break;
            case "-":
                l_temp = l_s - l_t;
                break;
            case "÷":
                if (l_s != 0)
                    l_temp = l_t / l_s;
                else
                    l_temp = 0d;
                break;
            case "x":
                l_temp = l_t * l_s;
                break;
            default:
                throw new IllegalStateException();
        }
        Controller.s_display2 = Controller.s_s + " " + Controller.s_op2 + " " + Controller.s_t;
        String s_temp = String.valueOf(l_temp);
        Controller.s_t = s_temp;
        Controller.s_s = s_temp;
        Controller.s_op2 = Controller.s_op;
        Controller.s_display = Controller.s_s;

    }
}
class as3toop1 implements EventHandler<OPER_S>{

    @Override
    public void handleEvent(OPER_S oper_s) throws Exception {
        Double l_t = Double.parseDouble(Controller.s_t.toString());
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_temp;
        switch (Controller.s_op2.toString()) {
            case "+":
                l_temp = l_t + l_s;
                break;
            case "-":
                l_temp = l_s - l_t;
                break;
            case "÷":
                if (l_s != 0)
                    l_temp = l_t / l_s;
                else
                    l_temp = 0d;
                break;
            case "x":
                l_temp = l_t * l_s;
                break;
            default:
                throw new IllegalStateException();
        }
        Controller.s_display2 =Controller.s_s + " " + Controller.s_op2 + " " + Controller.s_t;
        String s_temp = String.valueOf(l_temp);
        Controller.s_t = s_temp;
        Controller.s_s = s_temp;
        Controller.s_op2 = Controller.s_op;
        Controller.s_display = Controller.s_s;

    }
}
class astoas3_res implements EventHandler<RES_clear>{

    @Override
    public void handleEvent(RES_clear res) throws Exception {
        if (Controller.s_t != "0"){
            Controller.s_t = "";
            Controller.s_display = "0";
        }
    }
}
class as3toeq implements EventHandler<EQUAL>{

    @Override
    public void handleEvent(EQUAL equal) throws Exception {
        Double l_t = Double.parseDouble(Controller.s_t.toString());
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_temp1;
        switch (Controller.s_op2.toString()) {
            case "÷":
                if (l_s != 0)
                    l_temp1 = l_t / l_s;
                else
                    l_temp1 = 0d;
                break;
            case "x":
                l_temp1 = l_t * l_s;
                break;
            default:
                throw new IllegalStateException();
        }
        String s_temp1 = String.valueOf(l_temp1);
        //System.out.println(s_temp1);
        //Controller.s_s = s_temp1;
        l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_f = Double.parseDouble(Controller.s_f.toString());
        Double l_temp2;
        switch (Controller.s_op1.toString()) {
            case "+":
                l_temp2 = l_f + l_temp1;
                break;
            case "-":
                l_temp2 = l_f - l_temp1;
                break;
            default:
                throw new IllegalStateException();
        }
        String s_temp2 = String.valueOf(l_temp2);
        Controller.s_f = s_temp2;
        Controller.s_display = s_temp2;
        Controller.s_display2 = Controller.s_f + " " + Controller.s_op2 + " " + Controller.s_t;
        Controller.s_s = Controller.s_t;
        Controller.s_op1 = Controller.s_op2;
    }
}
class as3toin implements EventHandler<RES_allclear>{
    @Override
    public void handleEvent(RES_allclear res) throws Exception {
        if (Controller.s_t == "0"){
            Controller.s_f = "";
            Controller.s_op1 = "+";
            Controller.s_op2 = "+";
            Controller.s_s = "";
            Controller.s_display = "0";
            Controller.s_display2 = "";
            Controller.s_t = "";
        }
    }
}
class equad implements EventHandler<EQUAL>{
    @Override
    public void handleEvent(EQUAL equal) throws Exception {
        Controller.s_display2 = "0 + 0";
        Controller.s_display = "0";
    }
}
class eqtoop1 implements EventHandler<OPER>{
    @Override
    public void handleEvent(OPER oper) throws Exception {
        Controller.s_s = Controller.s_f;
        Controller.s_op1 = Controller.s_op;
    }
}
class eqtoas1 implements EventHandler<NUM>{

    @Override
    public void handleEvent(NUM num) throws Exception {
        Controller.s_f += Controller.s_num;
    }
}
class eqtoas1_res implements EventHandler<RES_clear>{

    @Override
    public void handleEvent(RES_clear res) throws Exception {
        Controller.s_f = "";
        Controller.s_display = "0";
        Controller.s_s = "";
    }
}
class eqtoeq implements EventHandler<EQUAL>{

    @Override
    public void handleEvent(EQUAL equal) throws Exception {
        Double l_f = Double.parseDouble(Controller.s_f.toString());
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        Double l_temp;
        switch (Controller.s_op2.toString()) {
            case "+":
                l_temp = l_f + l_s;
                break;
            case "-":
                l_temp = l_f - l_s;
                break;
            case "÷":
                if (l_s != 0)
                    l_temp = l_f / l_s;
                else
                    l_temp = 0d;
                break;
            case "x":
                l_temp = l_f * l_s;
                break;
            default:
                throw new IllegalStateException();
        }
        String s_temp = String.valueOf(l_temp);
        Controller.s_display = s_temp;
        Controller.s_display2 = Controller.s_f + " " + Controller.s_op1 + " " + Controller.s_s;
        Controller.s_f = String.valueOf(l_temp);

    }
}
class PLM extends AbstractEvent{
    public PLM(){
        super("plusminus");
    }
}
class as1toplm implements EventHandler<PLM>{

    @Override
    public void handleEvent(PLM plm) throws Exception {
        Double l_f = Double.parseDouble(Controller.s_f.toString());
        l_f = l_f*(-1);
        String s_temp = String.valueOf(l_f);
        Controller.s_f = s_temp;
        Controller.s_display = Controller.s_f;
        Controller.s_display2 = Controller.s_display;
    }
}
class as2toplm implements EventHandler<PLM>{

    @Override
    public void handleEvent(PLM plm) throws Exception {
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        l_s = l_s*(-1);
        String s_temp = String.valueOf(l_s);
        Controller.s_s = s_temp;
        Controller.s_display = Controller.s_s;
        Controller.s_display2 =Controller.s_f + " "+ Controller.s_op1 + " " + Controller.s_display;
    }
}
class as3toplm implements EventHandler<PLM>{

    @Override
    public void handleEvent(PLM plm) throws Exception {
        Double l_t = Double.parseDouble(Controller.s_t.toString());
        l_t = l_t*(-1);
        String s_temp = String.valueOf(l_t);
        Controller.s_t = s_temp;
        Controller.s_display = Controller.s_t;
        Controller.s_display2 =Controller.s_f + " "+ Controller.s_op2 + " " + Controller.s_display;
    }
}
class PC extends AbstractEvent{
    public PC() {super("percentage");}
}
class as1topc implements EventHandler<PC>{

    @Override
    public void handleEvent(PC pc) throws Exception {
        Double l_f = Double.parseDouble(Controller.s_f.toString());
        l_f = l_f/100;
        String s_temp = String.valueOf(l_f);
        Controller.s_f = s_temp;
        Controller.s_display = Controller.s_f;
        Controller.s_display2 = Controller.s_display;
    }
}
class as2topc implements EventHandler<PC>{

    @Override
    public void handleEvent(PC pc) throws Exception {
        Double l_s = Double.parseDouble(Controller.s_s.toString());
        l_s = l_s/100;
        String s_temp = String.valueOf(l_s);
        Controller.s_s = s_temp;
        Controller.s_display = Controller.s_s;
        Controller.s_display2 =Controller.s_f + " "+ Controller.s_op1 + " " + Controller.s_display;
    }
}
class as3topc implements EventHandler<PC>{
    @Override
    public void handleEvent(PC pc) throws Exception {
        Double l_t = Double.parseDouble(Controller.s_t.toString());
        l_t = l_t/100;
        String s_temp = String.valueOf(l_t);
        Controller.s_t = s_temp;
        Controller.s_display = Controller.s_t;
        Controller.s_display2 =Controller.s_f + " "+ Controller.s_op2 + " " + Controller.s_display;
    }
}
class POINT extends AbstractEvent{
    public POINT() {super("percentage");}
}
class as1topt implements EventHandler<POINT>{

    @Override
    public void handleEvent(POINT point) throws Exception {
        Controller.s_f = Controller.s_f + ".";
        Controller.s_display = Controller.s_f;
        Controller.s_display2 = Controller.s_display;
    }
}
class as2topt implements EventHandler<POINT>{

    @Override
    public void handleEvent(POINT point) throws Exception {
        Controller.s_s = Controller.s_s + ".";
        Controller.s_display = Controller.s_s;
        Controller.s_display2 =Controller.s_f + " "+ Controller.s_op1 + " " + Controller.s_display;
    }
}
class as3topt implements EventHandler<POINT>{
    @Override
    public void handleEvent(POINT point) throws Exception {
        Controller.s_t = Controller.s_t + ".";
        Controller.s_display = Controller.s_t;
        Controller.s_display2 =Controller.s_f + " "+ Controller.s_op2 + " " + Controller.s_display;
    }
}
public class StateMachine {
    public Text t_display (){
        return null;
    }

    public String result;

    public FiniteStateMachine calstatemachine;

    public StateMachine() throws FiniteStateMachineException  {
        State init = new State("init");
        State equal = new State("equal");
        State assum1 = new State("assum1");
        State operation1 = new State("operation1");
        State assum2 = new State("assum2");
        State operation2 = new State("operation2");
        State assum3 = new State("assum3");

        Set<State> states = new HashSet<>();
        states.add(init);
        states.add(equal);
        states.add(assum1);
        states.add(operation1);
        states.add(assum2);
        states.add(operation2);
        states.add(assum3);

        //State initial
        Transition resinit = (Transition) new TransitionBuilder()
                .name("resinitstate")
                .sourceState(init)
                .eventType(RES_allclear.class)
                .eventHandler(new resint())
                .targetState(init)
                .build();
        Transition inittoassum1 = (Transition) new TransitionBuilder()
                .name("numassum1")
                .sourceState(init)
                .eventType(NUM.class)
                .targetState(assum1)
                .eventHandler(new itoa1())
                .build();
        Transition inittoequal = (Transition) new TransitionBuilder()
                .name("inittoequal")
                .sourceState(init)
                .eventType(EQUAL.class)
                .targetState(equal)
                .eventHandler(new equad())
                .build();
        Transition inittoop1 = (Transition) new TransitionBuilder()
                .name("inittooperation1")
                .sourceState(init)
                .eventType(OPER.class)
                .targetState(operation1)
                .eventHandler(new itoop1())
                .build();

        //State assume first number
        Transition assum1toplm = (Transition) new TransitionBuilder()
                .name("assum1toplusminus")
                .sourceState(assum1)
                .eventType(PLM.class)
                .targetState(assum1)
                .eventHandler(new as1toplm())
                .build();
        Transition assum1topc = (Transition) new TransitionBuilder()
                .name("assum1topercentage")
                .sourceState(assum1)
                .eventType(PC.class)
                .targetState(assum1)
                .eventHandler(new as1topc())
                .build();
        Transition assum1topt = (Transition) new TransitionBuilder()
                .name("assum1topoint")
                .sourceState(assum1)
                .eventType(POINT.class)
                .targetState(assum1)
                .eventHandler(new as1topt())
                .build();
        Transition resassum1 = (Transition) new TransitionBuilder()
                .name("resassum1")
                .sourceState(assum1)
                .eventType(RES_clear.class)
                .targetState(assum1)
                .eventHandler(new resas1())
                .build();
        Transition assum1toinit = (Transition) new TransitionBuilder()
                .name("resassum1")
                .sourceState(assum1)
                .eventType(RES_allclear.class)
                .targetState(init)
                .eventHandler(new as1toin())
                .build();
        Transition assumtoop1 = (Transition) new TransitionBuilder()
                .name("assumtooperation1")
                .sourceState(assum1)
                .eventType(OPER.class)
                .targetState(operation1)
                .eventHandler(new itoop1())
                .build();
        Transition assumtoassum1 = (Transition) new  TransitionBuilder()
                .name("assumtoassum1")
                .sourceState(assum1)
                .eventType(NUM.class)
                .targetState(assum1)
                .eventHandler(new astoas1())
                .build();
        Transition assum1toequal = (Transition) new  TransitionBuilder()
                .name("assumtoassum1")
                .sourceState(assum1)
                .eventType(EQUAL.class)
                .targetState(equal)
                .eventHandler(new as2toeq())
                .build();

        //State operation 1
        Transition op1toassum2 = (Transition) new TransitionBuilder()
                .name("operation1toassum2")
                .sourceState(operation1)
                .eventType(NUM.class)
                .targetState(assum2)
                .eventHandler(new op1toas2())
                .build();
        Transition op1toassum1 = (Transition) new TransitionBuilder()
                .name("op1toassum1")
                .sourceState(operation1)
                .eventType(RES.class)
                .targetState(assum1)
                .eventHandler(new resop1())
                .build();
        Transition op1toeq = (Transition) new TransitionBuilder()
                .name("op1toequal")
                .sourceState(operation1)
                .eventType(EQUAL.class)
                .targetState(equal)
                .eventHandler(new op1toeq())
                .build();
        Transition op1toop = (Transition) new TransitionBuilder()
                .name("op1toop1")
                .sourceState(operation1)
                .eventType(OPER.class)
                .targetState(operation2)
                .eventHandler(new op1toop1())
                .build();

        //State assume second number
        Transition assum2toplm = (Transition) new TransitionBuilder()
                .name("assum2toplusminus")
                .sourceState(assum2)
                .eventType(PLM.class)
                .targetState(assum2)
                .eventHandler(new as2toplm())
                .build();
        Transition assum2topc = (Transition) new TransitionBuilder()
                .name("assum2topercentage")
                .sourceState(assum2)
                .eventType(PC.class)
                .targetState(assum2)
                .eventHandler(new as2topc())
                .build();
        Transition assum2topt = (Transition) new TransitionBuilder()
                .name("assum2topointd")
                .sourceState(assum2)
                .eventType(POINT.class)
                .targetState(assum2)
                .eventHandler(new as2topt())
                .build();
        Transition assum2toqeual = (Transition) new TransitionBuilder()
                .name("assum2toequal")
                .sourceState(assum2)
                .eventType(EQUAL.class)
                .targetState(equal)
                .eventHandler(new as2toeq())
                .build();
        Transition assum2toop1 = (Transition) new TransitionBuilder()
                .name("assum2toop1_1")
                .sourceState(assum2)
                .eventType(OPER.class)
                .targetState(operation1)
                .eventHandler(new as2toop1())
                .build();
        Transition assumtoassum2 = (Transition) new TransitionBuilder()
                .name("assum2toassum2")
                .sourceState(assum2)
                .eventType(NUM.class)
                .targetState(assum2)
                .eventHandler(new astoas2())
                .build();
        Transition assum2toop2 = (Transition) new TransitionBuilder()
                .name("assum2toop2")
                .sourceState(assum2)
                .eventType(OPER_C.class)
                .targetState(operation2)
                .eventHandler(new as2toop2())
                .build();
        Transition assum2toinit = (Transition) new TransitionBuilder()
                .name("assum2toinit")
                .sourceState(assum2)
                .eventType(RES_allclear.class)
                .targetState(init)
                .eventHandler(new as2toin())
                .build();
        Transition resassum2 = (Transition) new TransitionBuilder()
                .name("resassum2")
                .sourceState(assum2)
                .eventType(RES_clear.class)
                .targetState(assum2)
                .eventHandler(new resas2())
                .build();

        //State operation 2
        Transition optoop2 = (Transition) new TransitionBuilder()
                .name("op2toop2")
                .sourceState(operation2)
                .eventType(OPER_C.class)
                .targetState(operation2)
                .eventHandler(new optoop2())
                .build();
        Transition op2toeq = (Transition) new TransitionBuilder()
                .name("op2toeq")
                .sourceState(operation2)
                .eventType(EQUAL.class)
                .targetState(equal)
                .eventHandler(new op2toeq())
                .build();
        Transition op2toop1 = (Transition) new TransitionBuilder()
                .name("op2toop1")
                .sourceState(operation2)
                .eventType(OPER_S.class)
                .targetState(operation2)
                .eventHandler(new op2toop1())
                .build();
        Transition op2toassum3 = (Transition) new TransitionBuilder()
                .name("op2toassum3")
                .sourceState(operation2)
                .eventType(NUM.class)
                .targetState(assum3)
                .eventHandler(new op2toas3())
                .build();
        Transition op2toassum3_res = (Transition) new TransitionBuilder()
                .name("op2toassum3_res")
                .sourceState(operation2)
                .eventType(RES_clear.class)
                .targetState(assum3)
                .eventHandler(new op2toas3_res())
                .build();

        //State assume third number
        Transition assum3toplm = (Transition) new TransitionBuilder()
                .name("assum3toplusminus")
                .sourceState(assum3)
                .eventType(PLM.class)
                .targetState(assum3)
                .eventHandler(new as3toplm())
                .build();
        Transition assum3topc = (Transition) new TransitionBuilder()
                .name("assum3topercentage")
                .sourceState(assum3)
                .eventType(PC.class)
                .targetState(assum3)
                .eventHandler(new as3topc())
                .build();
        Transition assum3topt = (Transition) new TransitionBuilder()
                .name("assum3topoint")
                .sourceState(assum3)
                .eventType(POINT.class)
                .targetState(assum3)
                .eventHandler(new as3topt())
                .build();
        Transition assum3toop2 = (Transition) new TransitionBuilder()
                .name("assum3toop2")
                .sourceState(assum3)
                .eventType(OPER_C.class)
                .targetState(operation2)
                .eventHandler(new as3toop2())
                .build();
        Transition assum3toop1 = (Transition) new TransitionBuilder()
                .name("assum3toassum1")
                .sourceState(assum3)
                .eventType(OPER_S.class)
                .targetState(operation1)
                .eventHandler(new as3toop1())
                .build();
        Transition assum3toequal = (Transition) new TransitionBuilder()
                .name("assum3toequal")
                .sourceState(assum3)
                .eventType(EQUAL.class)
                .targetState(equal)
                .eventHandler(new as3toeq())
                .build();
        Transition assum3toinit = (Transition) new TransitionBuilder()
                .name("assum3toinit")
                .sourceState(assum3)
                .eventType(RES_allclear.class)
                .targetState(init)
                .eventHandler(new as3toin())
                .build();
        Transition assumtoassum3 = (Transition) new TransitionBuilder()
                .name("assum3toassum3")
                .sourceState(assum3)
                .eventType(NUM.class)
                .targetState(assum3)
                .eventHandler(new astoas3())
                .build();
        Transition assumtoassum3_res = (Transition) new TransitionBuilder()
                .name("assum3toassum3_res")
                .sourceState(assum3)
                .eventType(RES_clear.class)
                .targetState(assum3)
                .eventHandler(new astoas3_res())
                .build();

        //State equal
        Transition equaltoop1 = (Transition) new TransitionBuilder()
                .name("equaltoop1")
                .sourceState(equal)
                .eventType(OPER.class)
                .targetState(operation1)
                .eventHandler(new eqtoop1())
                .build();
        Transition equaltoassum1 = (Transition) new TransitionBuilder()
                .name("equaltoassum1")
                .sourceState(equal)
                .eventType(NUM.class)
                .targetState(assum1)
                .eventHandler(new eqtoas1())
                .build();
        Transition equaltoassum1_res = (Transition) new TransitionBuilder()
                .name("equaltoassum1_res")
                .sourceState(equal)
                .eventType(RES_clear.class)
                .targetState(assum1)
                .eventHandler(new eqtoas1_res())
                .build();
        Transition equaltoequal = (Transition) new TransitionBuilder()
                .name("equaltoequal")
                .sourceState(equal)
                .eventType(EQUAL.class)
                .targetState(equal)
                .eventHandler(new eqtoeq())
                .build();

        calstatemachine = new FiniteStateMachineBuilder(states, init)
                .registerTransition(resinit)
                .registerTransition(resassum1)
                .registerTransition(inittoassum1)
                .registerTransition(assumtoassum1)
                .registerTransition(inittoop1)
                .registerTransition(assumtoop1)
                .registerTransition(op1toassum2)
                .registerTransition(assum2toqeual)
                .registerTransition(inittoequal)
                .registerTransition(assum1toinit)
                .registerTransition(assum1toequal)
                .registerTransition(op1toassum1)
                .registerTransition(op1toeq)
                .registerTransition(op1toop)
                .registerTransition(assum2toop1)
                .registerTransition(assumtoassum2)
                .registerTransition(assum2toop2)
                .registerTransition(assum2toinit)
                .registerTransition(resassum2)
                .registerTransition(optoop2)
                .registerTransition(op2toeq)
                .registerTransition(op2toop1)
                .registerTransition(op2toassum3)
                .registerTransition(op2toassum3_res)
                .registerTransition(assum3toequal)
                .registerTransition(assum3toinit)
                .registerTransition(assum3toop1)
                .registerTransition(assum3toop2)
                .registerTransition(assumtoassum3)
                .registerTransition(assumtoassum3_res)
                .registerTransition(equaltoassum1)
                .registerTransition(equaltoassum1_res)
                .registerTransition(equaltoequal)
                .registerTransition(equaltoop1)
                .registerTransition(assum1toplm)
                .registerTransition(assum1topc)
                .registerTransition(assum2toplm)
                .registerTransition(assum2topc)
                .registerTransition(assum3toplm)
                .registerTransition(assum3topc)
                .registerTransition(assum1topt)
                .registerTransition(assum2topt)
                .registerTransition(assum3topt)
                .build();


        /*Transition resinit = (Transition) new TransitionBuilder()
                .name("resinit")
                .sourceState(init)
                .eventType(equal.class)
                .targetState(init)
                .eventHandler(new reset())
                .build();
        Transition dinit = (Transition) new TransitionBuilder()
                .name("dinit")
                .sourceState(init)
                .eventType(hd.class)
                .targetState(assum)
                .eventHandler(new h())
                .build();

        calstatemachine = new FiniteStateMachineBuilder(states, init)
                .registerTransition(resinit)
                .registerTransition(dinit)
                .build();*/



    }


}

