import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import java.io.*;
import java.util.*;
public class ReadDir {

	public static Collection<File> getFiles(String path)
	{
		File directory = new File(path);
		String [] fileFilter = {"pdf","doc","docx"};
		boolean dirFilter=true;
		Collection<File> files=FileUtils.listFiles(directory, fileFilter, dirFilter);
		
		return files;
		
	}
	public static Collection<Document> getDocuments(Collection<File> files)
	{
		Collection<Document> documents = new ArrayList<Document>();
		for (File f:files)
		{
			Document doc=null;
			String ext = FilenameUtils.getExtension(f.toString());
			if (ext.equals("pdf"))
			{
				doc = new PDFDocument(f);
			}
			else if (ext.equals("doc"))
			{
				doc = new WordDocument(f);
			}
			else if(ext.equals("docx"))
			{
				doc = new WordXMLDocument(f);
			}
			documents.add(doc);
		}
		
		return documents;
		
	}

}
