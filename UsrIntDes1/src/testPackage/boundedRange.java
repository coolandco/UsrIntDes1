package testPackage;

import java.awt.BorderLayout;

import javax.swing.BoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class boundedRange extends JFrame{

	String[] items = {"0","1","2","3","4","5","6","7","8","9"};
	JList<String> list;
	
	 public boundedRange() {
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		    JScrollBar jsb = new JScrollBar(JScrollBar.HORIZONTAL,0,1,0,10);
		    BoundedRangeModel model = jsb.getModel();
		    JSlider slider = new JSlider(model);
		    

		    list = new JList<String>(items);
		    ListSelectionModel sModel = list.getSelectionModel();
		    
		    sModel.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if(!e.getValueIsAdjusting()) {
						System.out.println("section Changed: " +
								e.getFirstIndex() );
					}
					
				}
			});
		    
		    
		    model.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				BoundedRangeModel m = (BoundedRangeModel) e.getSource();
		        System.out.println("Slider position changed to " + m.getValue());
		        
		        list.setSelectedIndex(m.getValue());
			}
		    });
		   

		    
		    getContentPane().add(slider,BorderLayout.SOUTH);
		    getContentPane().add(list,BorderLayout.CENTER);
		    getContentPane().add(jsb,BorderLayout.NORTH);
		    
		    
		    pack();
		  }

		  public static void main(String[] args) {
			boundedRange br = new boundedRange();
		    br.setVisible(true);
		  }

}
