import Pattern;
import Matcher;

/**
 * Parser
 * 
 * @author Daniel Gooss
 * @version 0.1.0
 */
class Parser
{
    private static final Pattern ATOMS = Pattern.compile("[0-9]+|[+*]");
    private Matcher _matcher;

    /**
     * @param top
     * @param below
     */
    private double eval(double top, double below)
    {
        if (!_matcher.find()) {
            return top;
        }

        String atom = _matcher.group();

        switch (atom) {
            case "+":
                return top + below;
                break;

            case "*":
                return top * below;
                break;
        
            default:
                double number = Double.parseDouble(atom);
                double newTop = eval(top, below);

                return eval(newTop, below);
                break;
        }
    }

    /**
     * @param formula
     */
    public double evaluate (String formula)
    {
        _matcher = ATOMS.matcher(formula);
        return eval(Double.NaN, Double.NaN);
    }
}
