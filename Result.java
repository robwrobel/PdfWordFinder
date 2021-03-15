
public class Result implements Comparable<Result>{
	public Result(String filename, int no_found) {
		// TODO Auto-generated constructor stub
		this.filename=filename;
		this.no_found=no_found;
	}
	int no_found;
	String filename;

	@Override
	public int compareTo(Result o) {
		// TODO Auto-generated method stub
		return (no_found<o.no_found ? 1 : no_found==o.no_found? 0 : -1);
	}
}
