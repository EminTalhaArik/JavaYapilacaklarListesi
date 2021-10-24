package Model;

public class List {
	
	private int id;
	private String task;
	private String onem;
	
	public List() {}
	
	public List(int id, String task, String onem) {
		super();
		this.id = id;
		this.task = task;
		this.onem = onem;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getOnem() {
		return onem;
	}
	public void  setOnem(String onem) {
		this.onem = onem;
	}
	
	
}
