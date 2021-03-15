import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;


public class WordDocument extends Document {

	public WordDocument(File f) {
		
		file = f;
	}
	
	public void load()
	{
		InputStream is;
		try {
			is = new FileInputStream(file);
			WordExtractor extr = new WordExtractor(is);
			text = extr.getText();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}