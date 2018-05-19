package OCR;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author e.rafael.medeiros
 */
public class Main {
    VideoCapture capture;
    String caminho;
    public Main (String caminho){
        this.caminho= caminho;
      //teste();  
      frames();
    }
    
    public void teste(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
                System.out.println("mat = " + mat.dump());
    }
    
    public void frames(){
        
        capture = new VideoCapture(caminho);
        Mat frame = new Mat();
        JFrame jframe = new JFrame("MyTitle");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel vidpanel = new JLabel();
        jframe.setContentPane(vidpanel);
        jframe.setVisible(true);

        while (true) {
            if (capture.read(frame)) {

                ImageIcon image = new ImageIcon(Mat2bufferedImage(frame));
                vidpanel.setIcon(image);
                vidpanel.repaint();

            }
        }
    }

    private String Mat2bufferedImage(Mat frame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}