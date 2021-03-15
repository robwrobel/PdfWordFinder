
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
public class PDFWordFinder {

	private Shell shell;
	private String path;
	private Label label1;
	private Label label12;
	private Label label2;
	private Collection<Document> documents=new ArrayList<Document>();
	private ArrayList<Result> results=new ArrayList<Result>();
	private Table table;
	private Text display;
	
	public PDFWordFinder(Display display) {

	    shell = new Shell(display);
	    initializePath();
	    initUI();
	    shell.open();
	    shell.setText("PDFWordFinder");
	    while (!shell.isDisposed()) { 
	        if (!display.readAndDispatch())
	            display.sleep();
	    }
	}

	private void initializePath() {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("config"));
			path=(String) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			path="c:\\";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Display display = new Display();
	    new PDFWordFinder(display);
	    display.dispose();
	}
	
	private void initUI() {
        GridLayout gridLayout = new GridLayout(2,false);
        gridLayout.marginTop = 10;
        gridLayout.marginBottom = 10;
        gridLayout.marginLeft = 5;
        gridLayout.marginRight = 5;
        
        shell.setLayout(gridLayout);
        shell.setBounds(0,0, 440, 300);


        Button button1 = new Button(shell, SWT.PUSH);
        button1.setText("Change dir");
        button1.setLayoutData(new GridData(80, 30));
        button1.addSelectionListener(new SelectionAdapter() {
            //  @Override
              public void widgetSelected(SelectionEvent e) {
           	      DirectoryDialog dialog = new DirectoryDialog(shell);
           	      dialog.setFilterPath(path); // Windows specific
           	      String path_tmp= dialog.open();
           	      if (path_tmp!=null)
           	      {
           	    	  path=path_tmp;
           	      }
           	      backupPath();
           	      label1.setText(path);
              }

			private void backupPath() {
				// TODO Auto-generated method stub
				try {
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("config"));
					out.writeObject(path);
					out.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
          });

        label1 = new Label(shell, 0);
        label1.setText(path);
        label1.setLayoutData(new GridData(300,30));
        
        Button button2 = new Button(shell, SWT.PUSH);
        button2.setText("Load");
        button2.setLayoutData(new GridData(80, 30));
        button2.addSelectionListener(new SelectionAdapter() {
            //  @Override
              public void widgetSelected(SelectionEvent e) {
            	  //1.get list of all files
            	  documents=ReadDir.getDocuments(ReadDir.getFiles(path));
            	  //2.go through the files and read content
            	  int size=documents.size();
            	  int no_loaded=0;
            	  for (Document doc:documents)
            	  {
            		  
            		  label12.setText(no_loaded+" of "+size+" loaded");
            		  try
            		  {
            			  doc.load();
            		  }
            		  catch (IllegalArgumentException e1)
            		  {
            			  System.out.println(doc.file);
            			  e1.printStackTrace();
            		  }
            		  no_loaded++;
            	  }
            	  label12.setText("Loading complete");
              }
          });
        
        label12 = new Label(shell, 0);
        label12.setText("");
        label12.setLayoutData(new GridData(300,30));
        
        Button button3 = new Button(shell, SWT.PUSH);
        button3.setText("Search");
        button3.setLayoutData(new GridData(80, 30));
        button3.addSelectionListener(new SelectionAdapter() {
            //  @Override
              public void widgetSelected(SelectionEvent e) {
            	  //3.search content for the specified text
            	  search();
              }

			private void search() {
				results.clear();
            	  for(Document doc:documents)
            	  {
            		  String pattern = display.getText();
            		  int no_found = doc.find(pattern);
            		  if (no_found>0)
            		  {
            			  results.add(new Result(doc.file.toString(),no_found));
            		  }
            	  
            	  }
            	  Collections.sort(results);
            	  int no_results=results.size();
            	  table.setItemCount(no_results);
            	  table.clearAll();
			}
          });
        
        
        display = new Text(shell, SWT.SINGLE);
        display.setLayoutData(new GridData(300,30));
        display.setText("");
        
        label2 = new Label(shell, 0);
        label2.setText("");
        label2.setLayoutData(new GridData(80,30));
        
    	table = new Table(shell, SWT.BORDER | SWT.VIRTUAL);
    	table.setLayoutData(new GridData(300,100));
    	
    	table.addListener(SWT.SetData, new Listener() {
    		public void handleEvent(Event e) {
    			TableItem item = (TableItem)e.item;
    			int index = table.indexOf(item);
    			String filename =results.get(index).filename;
    			item.setText(filename);
    		}
    	});
    	table.addMouseListener(new MouseListener() {
    		public void mouseDoubleClick(MouseEvent e)
    		{
    			Point p = new Point(e.x,e.y);
    			TableItem ti = table.getItem(p);
    			File f = new File(ti.getText());
    			try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    		}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
    	}
    	
    			);
    	
	}

}
