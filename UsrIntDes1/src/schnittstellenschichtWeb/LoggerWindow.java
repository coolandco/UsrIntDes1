package schnittstellenschichtWeb;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class LoggerWindow extends JFrame{
	

		  private JTextArea textArea = null;

		  private JScrollPane pane = null;
		  
		  private static LoggerWindow lw = null;

		  private LoggerWindow(String title, int width, int height) {
		    super(title);
		    setSize(width, height);
		    textArea = new JTextArea();
		    pane = new JScrollPane(textArea);
		    getContentPane().add(pane);
		    setVisible(true);

		  }
		  
		  
		  public static void log(String data) {
			  
			  if(lw == null)
				  lw = new LoggerWindow("logger", 500, 300);
			  
			  lw.newLog(data);
				  
		  }


		private void newLog(String data) {
		    textArea.append(data);
		    this.getContentPane().validate();
			
		}
	
	
}
