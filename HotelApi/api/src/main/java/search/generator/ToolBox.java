/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: generator
 */

package search.generator;

public class ToolBox {
	private static final int dayInMs = 86400000;

	public static long formatToMidnight(long date) { return (date / dayInMs) * dayInMs; }
}

