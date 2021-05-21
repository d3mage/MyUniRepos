package com.company;

public class Automat extends FSM {

    public Automat(String text)
    {
        super(text);
    }

    public State getState()
    {
        return state;
    }

    @Override
    public boolean scanner()
    {
        int count = 0;
        do {
            Event event;
            if (count < this.text.length())
            {
                event = recognizeEvent(text.charAt(count));
            } else {
                event = Event.EOS;
            }
            handleEvent(event);
            count++;
        }
        while (state != State.Success && state != State.Error);
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
    protected void handleEvent(Event event) {
        switch (state) {
            case Initial:
                switch (event)
                {
                    case Dollar -> state = State.Q1;
                    case EOS -> state = State.Error;
                    default -> state = State.Error;
                }
                break;
            case Q1:
                switch (event)
                {
                    case UpperLetterAF, Digit -> state = State.Q2;
                    case NonWord -> state = State.Q3;
                    case EOS -> state = State.Error;
                    default -> state = State.Error;
                }
                break;
            case Q2:
                switch (event)
                {
                    case UpperLetterAF -> state = State.Q2;
                    case NonWord -> state = State.Q3;
                    case EOS -> state = State.Error;
                    default -> state = State.Error;
                }
                break;
            case Q3:
                switch (event) {
                    case NonWord -> state = State.Q3;
                    case EOS -> state = State.Success;
                    default -> state = State.Error;
                }
                break;
        }
    }
}

