import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 * The video class which can play videos.
 * @author  Jingxuan Wang
 * @version 2.1
 */ 
public class Video {

	// Declaration of instance variables to set the video player
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
    
    private JPanel videoP = new JPanel();
    private JPanel operationP = new JPanel();
    
    private JButton pauseB = new JButton("Pause");
    private JButton rewindB = new JButton("Rewind");
    private JButton skipB = new JButton("Skip");

    /**The constructor for the system to play videos.
     * @param videoName	The file name of video for playing
	 */
    public Video(String videoName) {
    	
    	// Make the frame.
    	JFrame jf = new JFrame();

    	jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
            }
        });

    	//Set the layout of the video part
        videoP.setLayout(new BorderLayout());
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        videoP.add(mediaPlayerComponent, BorderLayout.CENTER);

        //Set the layout of the operation part
        operationP.add(rewindB);
        operationP.add(pauseB);
        operationP.add(skipB);
        videoP.add(operationP, BorderLayout.SOUTH);

        //Rewind for 10s
        rewindB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().skipTime(-10000);
            }
        });
        
        //Pause
        pauseB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().pause();
            }
        });

        //Skip for 10s
        skipB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().skipTime(10000);
            }
        });

        // Set status for the frame
        jf.setTitle("Video Player");
        jf.setSize(750, 450);
        GUI.toCenter(jf);
        jf.setContentPane(videoP);
    	jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setVisible(true);
        
        //Play the video by its name
        mediaPlayerComponent.mediaPlayer().media().play(videoName);
    }
}