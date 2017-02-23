package hashcode.videos;

public class Video implements Comparable {
	private int id;
	private int size;
	private int totalRequests = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setRequest(int req) {
		this.totalRequests = req;
	}

	public int getRequests() {
		return this.totalRequests;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", size=" + size + "]";
	}

	@Override
	public int compareTo(Object o) {
		Video c = (Video) o;

		return Integer.compare(c.getRequests(), this.getRequests());
	}

}
