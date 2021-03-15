import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public abstract class Document {
	
	File file;
	String text="ERROR";
	public abstract void load();
	public int find(String pattern)
	{
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		
		int no_found=0;
		while (m.find())
		{
			no_found++;
		}
		return no_found;
		
	}

}
