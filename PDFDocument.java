import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;


public class PDFDocument extends Document {

	public PDFDocument(File f) {
		
		file = f;
	}
	
	public void load()
	{
		PDDocument pdf;
		try {
			pdf = PDDocument.load(file);
		    PDFTextStripper ts= new PDFTextStripper();
		    text = ts.getText(pdf);
		    pdf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
