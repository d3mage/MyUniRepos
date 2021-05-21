package com.company;

import java.util.ArrayList;

public class TransitTable extends FSM {

    ArrayList<Transition> transitions;
    public TransitTable(String _word)
    {
        super(_word);
        transitions = new ArrayList<Transition>();
    }

    @Override
    public boolean scanner()
    {
        Event event;
        buildTransitionTable();
        int count = 0;
        do
        {
            if(count < text.length())
            {
                event = recognizeEvent(text.charAt(count));
            }
            else
            {
                event = Event.EOS;
            }
            handleEvent(event);
            count++;
        }
        while ((state != State.Success) && (state != State.Error));
        return state == State.Success;
    }

    @Override
    protected Event recognizeEvent(char ch)
    {
        return switch (ch)
                {
                    case 'A', 'B', 'C', 'D', 'E', 'F' -> Event.UpperLetterAF;
                    case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> Event.Digit;
                    case '!', '@', '#', '%', '^', '&', '*', '(', ')', ',', '.',
                            '{', '}', ':', ';', '"', '<', '>', '?', '/' -> Event.NonWord;
                    case '$' -> Event.Dollar;
                    default -> Event.ANY;
                };
    }

    @Override
    public void handleEvent(Event event)
    {
        int length = transitions.size();

        for (Transition transition : transitions)
        {
            if ((state == transition.startState) && (event == transition.trigger)) {
                state = transition.endState;
                return;
            }
        }
    }
    private void buildTransitionTable()
    {
        Transition transit = new Transition(State.Initial, State.Q1, Event.Dollar);
        transitions.add(transit);
        transit = new Transition(State.Initial,State.Error,Event.Digit);
        transitions.add(transit);
        transit = new Transition(State.Initial,State.Error,Event.UpperLetterAF);
        transitions.add(transit);
        transit = new Transition(State.Initial,State.Error,Event.NonWord);
        transitions.add(transit);
        transit = new Transition(State.Initial,State.Error,Event.ANY);
        transitions.add(transit);
        transit = new Transition(State.Initial,State.Error,Event.EOS);
        transitions.add(transit);
        transit = new Transition(State.Q1, State.Error, Event.Dollar);
        transitions.add(transit);
        transit = new Transition(State.Q1,State.Q2,Event.Digit);
        transitions.add(transit);
        transit = new Transition(State.Q1,State.Q2,Event.UpperLetterAF);
        transitions.add(transit);
        transit = new Transition(State.Q1,State.Q3,Event.NonWord);
        transitions.add(transit);
        transit = new Transition(State.Q1,State.Error,Event.ANY);
        transitions.add(transit);
        transit = new Transition(State.Q1,State.Error,Event.EOS);
        transitions.add(transit);
        transit = new Transition(State.Q2, State.Error, Event.Dollar);
        transitions.add(transit);
        transit = new Transition(State.Q2,State.Error,Event.Digit);
        transitions.add(transit);
        transit = new Transition(State.Q2,State.Q2,Event.UpperLetterAF);
        transitions.add(transit);
        transit = new Transition(State.Q2,State.Q3,Event.NonWord);
        transitions.add(transit);
        transit = new Transition(State.Q2,State.Error,Event.ANY);
        transitions.add(transit);
        transit = new Transition(State.Q2,State.Error,Event.EOS);
        transitions.add(transit);
        transit = new Transition(State.Q3, State.Error, Event.Dollar);
        transitions.add(transit);
        transit = new Transition(State.Q3,State.Error,Event.Digit);
        transitions.add(transit);
        transit = new Transition(State.Q3,State.Error,Event.UpperLetterAF);
        transitions.add(transit);
        transit = new Transition(State.Q3,State.Q3,Event.NonWord);
        transitions.add(transit);
        transit = new Transition(State.Q3,State.Error,Event.ANY);
        transitions.add(transit);
        transit = new Transition(State.Q3,State.Success,Event.EOS);
        transitions.add(transit);
    }
}

