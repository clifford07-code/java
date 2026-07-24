package exp7;

import java.util.*;

class MediaPlayer {
    MediaPlayer() {}
    MediaPlayer(String type) {}

    void play() {
        System.out.println("Playing media...");
    }

    public String toString() {
        return "Media Player";
    }
}

class AudioPlayer extends MediaPlayer {
    void play() {
        System.out.println("Playing Audio...");
    }
}

class VideoPlayer extends MediaPlayer {
    void play() {
        System.out.println("Playing Video...");
    }
}

public class Player {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Player: 1.Audio 2.Video");
        int choice = sc.nextInt();

        MediaPlayer m;

        if (choice == 1)
            m = new AudioPlayer();
        else
            m = new VideoPlayer();

        m.play(); 
    }
}