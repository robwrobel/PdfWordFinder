import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class WordXMLDocument extends Document {

	public WordXMLDocument(File f) {
		
		file = f;
	}
	
	public void load()
	{
		InputStream is;
		try {
			is = new FileInputStream(file);
			XWPFDocument doc=new XWPFDocument(is);
			XWPFWordExtractor extr = new XWPFWordExtractor(doc);
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

