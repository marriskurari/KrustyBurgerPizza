/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: generator
 */

package generator;

import javafx.util.Pair;
import org.json.JSONObject;

import java.util.List;

public abstract class Entity {
	protected Long id;

	public Long getId()        { return id;     }
	public void setId(Long id) { this.id = id;  }


	public abstract List<Pair<String, String>> getParameters();

}
