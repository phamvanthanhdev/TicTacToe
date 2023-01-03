import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL SoundURL[] = new URL[30];

    public Sound(){
        SoundURL[0] = getClass().getResource("/Sound/loop1.wav");
        SoundURL[1] = getClass().getResource("/Sound/tick.wav");
        SoundURL[2] = getClass().getResource("/Sound/win.wav");
        SoundURL[3] = getClass().getResource("/Sound/click.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ias = AudioSystem.getAudioInputStream(SoundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ias);
        } catch (Exception e) {
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }


    public void musicStart(int i){
        this.setFile(i);
        this.play();
        this.loop();
    }

    public void musicStop(){
        this.stop();
    }

    public void playSE(int i){
        this.setFile(i);
        this.play();
    }

    public void musicStop1(int i){
        this.setFile(i);
        this.stop();
    }
}
