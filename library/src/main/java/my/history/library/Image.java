
package my.history.library;


/**
 * @author Greg Turnquist
 */
// tag::code[]
public class Image {

	private int id;
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public Image(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
// end::code[]
