import java.util.*;

/**
 * @author Denis Krusko
 * @author e-mail: kruskod@gmail.com
 */

public class State {

    protected final Rule rule;
    protected final int i;
    protected final int dot;

    public State(Rule rule, int i, int dot) {
        this.rule = rule;
        this.i = i;
        this.dot = dot;
    }

    public boolean isNextSymbolTerminal() {
        return rule.isTerminal(dot);
    }

    public boolean isNextSymbolNonterminal() {
        return rule.isNonterminal(dot);
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
                dot == state.dot &&
                Objects.equals(rule, state.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rule, i, dot);
    }

    @Override
    public String toString() {
        return toString("..");
    }

    public String toString(String j) {
        return String.format("[%d:%s] %s %s %s", i, j, rule.lhs.symbol, SimpleGrammar.LHS_RHS_DELIM, rule.toStringWithDot(dot));
    }
}
