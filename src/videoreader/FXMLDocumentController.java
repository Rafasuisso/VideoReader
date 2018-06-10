/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoreader;

import OCR.Main;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author e.rafael.medeiros
 */
public class FXMLDocumentController implements Initializable {
    Media media;
    String VUrl;
    MediaPlayer mediaPlayer;
  //  public  VideoCapture capture = new VideoCapture();
    @FXML
    private MediaView mv;
    @FXML
    private Button btn_open;
    @FXML
    private Button btn_play;
    @FXML
    private Button btn_OCR;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void onClick_btn_open(ActionEvent event){
       FileChooser fc = new FileChooser();
       fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video Files", "*.mp4"));
       File file =fc.showOpenDialog(null);
       if(file!= null){
           VUrl = file.getAbsolutePath();
       // this.capture.open(file.getAbsolutePath());
           media = new Media(file.toURI().toString());
           mediaPlayer = new MediaPlayer(media); // 2
           mv.setFitHeight(800); 
           mv.setFitWidth(600);
           mv.setMediaPlayer(mediaPlayer);
       }
    }
     @FXML
    private void onClick_btn_play(){
       if(mediaPlayer != null){
            if(mediaPlayer.getStatus()==PLAYING){
                mediaPlayer.stop();    
                mediaPlayer.play();
            }else{
                mediaPlayer.play();
            }
       }else{
           JOptionPane.showMessageDialog(null, "Please choose a video first!");
       }
    }
     @FXML
    private void onClick_btn_OCR(){
     Main main = new Main(VUrl);// capture);
       
    }
}