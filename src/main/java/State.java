import java.util.Objects;

/**
 * @author Denis Krusko
 * @author e-mail: kruskod@gmail.com
 */

public class State {

    protected final Rule rule;
    protected final int i, j;
    protected final int dot;
    private State parentState;

    public State(Rule rule, int i, int j, int dot, State parentState) {
        this.rule = rule;
        this.i = i;
        this.j = j;
        this.dot = dot;
        this.parentState = parentState;
    }

    public boolean isNextSymbolTerminal() {
        return rule.isTerminal(dot);
    }

    public CharSequence getNextSymbol() {
        return rule.getSymbol(dot);
    }

    public boolean isFinished() {
        return rule.getRHSLength() == dot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return i == state.i &&
                j == state.j &&
                dot == state.dot &&
                Objects.equals(rule, state.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rule, i, j, dot);
    }

    @Override
    public String toString() {
        return String.format("[%d:%d] %s %s %s", i,j, rule.lhs.symbol, SimpleGrammar.LHS_RHS_DELIM, rule.toStringWithDot(dot));
    }
}