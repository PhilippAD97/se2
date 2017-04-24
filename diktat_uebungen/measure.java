import java.util.List;
import java.util.ArrayList;

/**
 * Measure
 * 
 * @author Daniel Gooss
 * @version 0.1.0
 */
class Measure
{
    private String _what;
    private double _start;
    private static List<String> _allMeasurements = new ArrayList<String>();

    /**
     * @param what
     */
    public Measure (String what)
    {
        _what = what;
        _start = System.nanoTime();
    }

    public void close ()
    {
        long end = System.nanoTime();
        long difference = (long) (end - _start);
        double elapsed = difference / 1000000;
        String unit = "ms";

        if (elapsed >= 10000)
        {
            elapsed = elapsed / 1000;
            unit = "s";
        }

        String nice = String.format("%4d %s (%s)", elapsed, unit, _what);
        _allMeasurements.add(nice);
    }

    public static void printAllMeasurements ()
    {
        for (String partial : _allMeasurements)
        {
            System.out.println(partial);
        }
    }
}