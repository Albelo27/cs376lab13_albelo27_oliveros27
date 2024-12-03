import java.awt.*; // import OS agnostic swing libraries
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.text.SimpleDateFormat;

// Driver
public class WindowExample extends JFrame{
	static Image img;
	JButton buttonHappy, buttonSad, buttonOK, buttonNOT;
	JPanel areaPanel, topPanel, leftPanel;
	JLayeredPane bottomPanel; 

	public static void main(String[] args){
		WindowExample w = new WindowExample();
		w.make();
	}

	public void make(){
        this.setTitle("CS376: Example Window ");
        this.setSize(800,800);

        areaPanel = new JPanel();
        areaPanel.setLayout(new BorderLayout());

        topPanel = new JPanel();
        JLabel labelTop = new JLabel("You are a CS376 rockstar! Today:");
	JLabel labelTop = new;
	JLabel labelTop = new Jlabel();

        //1. left panel creation here
	leftPanel = new JPanel();
	leftPanel.setLayout(new BoxLayout(leftPanel,0));
        //2. bottom pane creation here
	bottomPanel= new JLayeredPane();
	bottomPanel.setPreferredSize(new Dimension(600, 600));
        //3. happy and sad image buttons
	buttonHappy = new JButton(new HappyAction());
	buttonSad = new JButton(new SadAction());
        //4. happy and sad button change image

        //5. happy sad images creation here
	ImageIcon imgHappy = new ImageIcon("images/smiley.png");
	JLabel imgLabelHappy = new JLabel(imgHappy);
	JScrollPane scrollPaneHappy = new JScrollPane(imgLabelHappy);
	scrollPaneHappy.setBounds(10, 50, imgHappy.getIconWidth()+10, imgHappy.getIconHeight()+10);

	ImageIcon imgSad = new ImageIcon("images/frowny.png");
	JLabel imgLabelSad = new JLabel(imgSad);
	JScrollPane scrollPaneSad = new JScrollPane(imgLabelSad);
	scrollPaneSad.setBounds(10, 50, imgSad.getIconWidth()+10, imgSad.getIconHeight()+10);

        //6. OK and NOT button listeners to chanage images

        //7. labels with image signature 
        //JLabel labelBottom = new JLabel("Image Signature ");
        JLabel labelBottom = new JLabel("Image Signature " + imgSignature(imgHappy));
        labelBottom.setBounds(10,0,300,50);f
        //8. add top panels to frame
	frameopPanel.add(labelTop);
        areaPanel.add(BorderLayout.PAGE_START,topPanel);

        //9. add buttons Happy and Sad to left panel
	leftPanel.add(buttonHappy);
	leftPanel.add(buttonSad);
        //10. add buttons OK and NOT to left panel

        //11. add left panel to frame
	areaPanel.add(BorderLayout.LINE_START,leftPanel);
        //12. add images to bottom panel

	bottomPanel.add(labelBottom);
	bottomPanel.add(scrollPaneHappy);
	bottomPanel.add(scrollPaneSad);

        //13. add bottom panel to frame
 
	areaPanel.add(BorderLayout.PAGE_END,bottomPanel);

        this.add(areaPanel);
        this.pack();
        this.setVisible(true);
   	}

    // 14. addTime method imoplementation
	private String addTime(){
 		 String date = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss zzz yyyy").format(Calendar.getInstance().getTime());
  		return date;
	}

    // 15. imgSignature method imoplementation
	private String imgSignature(ImageIcon img){
 	 	int hash = System.identityHashCode(img);
 		return String.valueOf(hash);
	}	

}

//16. Happy and Sad Action listeners implemetation 
class HappyAction extends AbstractAction{
  HappyAction(){ super("Good"); }
  @Override
  public void actionPerformed(ActionEvent arg0) {
    System.out.println("Good");
  }
}

class SadAction extends AbstractAction{
  SadAction(){ super("Sad"); }
  @Override
  public void actionPerformed(ActionEvent arg0) {
    System.out.println("Noooot Good");
  }
}
