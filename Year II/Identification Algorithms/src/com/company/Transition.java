package com.company;

public class Transition
{
    FSM.State startState;
    FSM.State endState;
    FSM.Event trigger;

    public Transition(FSM.State start, FSM.State end, FSM.Event trig)
    {
        startState = start;
        endState = end;
        trigger = trig;
    }
}
