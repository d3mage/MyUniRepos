package com.company;

public abstract class FSM {
    public enum State {Success,Error,Q1,Q2,Q3,Initial}
    public enum Event {Dollar, Digit, UpperLetterAF, NonWord, EOS, ANY}

    protected String text;
    protected State state;

    public FSM(String text)
    {
        this.text = text;
        state = State.Initial;
    }

    public abstract boolean scanner();
    protected abstract Event recognizeEvent(char ev);
    protected abstract void handleEvent(Event ev);
}


