/*
 * Created on May 9, 2018
 *
 */
package test;


import java.util.Scanner;

import music.FirstFlag;
import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

    public static final Scanner IN = new Scanner(System.in);
    
    private Singer pattiSmith;
    private Singer bruceSpringsteen;
    private Singer choir;
    private Singer guitarSolo;
    
    private void initializeSingingInThreads() {
        boolean stopIt = false;
        Synchronizer synch = new Synchronizer(FirstFlag.guitarSolo);
        
        Performance[] firstVoicePerformance = {new Performance("Patti:     "+"Take me now, baby, here as I am", 3500),
        		new Performance("Patti:     "+"Pull me close, try and understand", 4000),
        		new Performance("Patti:     "+"Desire is hunger is the fire I breathe", 5000),
        		new Performance("Patti:     "+"Love is a banquet on which we feed", 4000),
        		new Performance("Patti:     "+"Come on now try and understand", 5000),
        		new Performance("Patti:     "+"The way I feel when I'm in your hands",3500),
        		new Performance("Patti:     "+"Take my hand come undercover", 3500),
        		new Performance("Patti:     "+"They can't hurt you now", 3500),
        		new Performance("Patti:     "+"Can't hurt you now, can't hurt you now", 5000),
        		new Performance("Patti:     "+"Because the night", 2000),new Performance("Patti:     "+"Because the night", 2000),
        		new Performance("Patti:     "+"Because the night", 2000),new Performance("Patti:     "+"Because the night", 2000),
        		new Performance("Patti:     "+"With love we sleep", 1500),
        		new Performance("Patti:     "+"With doubt the vicious circle", 2500),
        		new Performance("Patti:     "+"Turn and burns", 2500),
        		new Performance("Patti:     "+"Without you I cannot live", 2500),
        		new Performance("Patti:     "+"Forgive, the yearning burning", 3000),
        		new Performance("Patti:     "+"I believe it's time, too real to feel", 4000),
        		new Performance("Patti:     "+"So touch me now, touch me now, touch me now", 7000),
        		new Performance("Patti:     "+"Because the night belongs to lovers", 3500),
        		new Performance("Patti:     "+"Because tonight there are two lovers", 4200),
        		new Performance("Patti:     "+"If we believe in the night we trust", 3000),
        		new Performance("Patti:     "+"Because the night belongs to lovers", 4000),
        		new Performance("Patti:     "+"Because the night belongs to lust", 4000),
        		new Performance("Patti:     "+"Because the night belongs to lovers", 4000),
        		new Performance("Patti:     "+"Because the night belongs to lust", 4000)};

        Performance[] secondVoicePerformance = {new Performance("Bruce:     "+"belongs to lovers", 2000),
        		new Performance("Bruce:     "+"belongs to lovers", 2000),
        		new Performance("Bruce:     "+"Have I doubt when I'm alone", 3000),
        		new Performance("Bruce:     "+"Love is a ring, the telephone", 4000),
        		new Performance("Bruce:     "+"Love is an angel disguised as lust", 4000),
        		new Performance("Bruce:     "+"Here in our bed until the morning comes", 4000),
        		new Performance("Bruce:     "+"Come on now try and understand", 4000),
        		new Performance("Bruce:     "+"The way I feel under your command", 3000),
        		new Performance("Bruce:     "+"Take my hand as the sun descends", 4000),
        		new Performance("Bruce:     "+"They can't touch you now", 4000),
        		new Performance("Bruce:     "+"Can't touch you now, can't touch you now", 5000),
        		new Performance("Bruce:     "+"belongs to lovers", 2000),
        		new Performance("Bruce:     "+"belongs to lovers", 2000),
        		new Performance("Bruce:     "+"Because the night belongs to lovers", 4000),
        		};
        Performance[] choirPerformance = { new Performance("Choir:     "+"Because the night belongs to lust", 3800),
        		new Performance("Choir:     "+"Because the night belongs to us", 3800)
        		};
        
        Performance[] guitarSoloPerformance = { new Performance("Instrumental...", 8000),new Performance("Instrumental...", 15500)};
        
        pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
        bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
        choir = new Singer("Choir", Voice.BACKGROUND, choirPerformance, stopIt, synch);
        guitarSolo = new Singer("Guitar Solo", Voice.GUITAR, guitarSoloPerformance, stopIt, synch);
    }
    
    public void testSingInThreads() {
        
        initializeSingingInThreads();
        
        pattiSmith.start();
        bruceSpringsteen.start();
        choir.start();
        guitarSolo.start();
        
        IN.nextLine();
        pattiSmith.setStopIt(true);
        bruceSpringsteen.setStopIt(true);
        choir.setStopIt(true);
        guitarSolo.setStopIt(true);
        
    }
    
    public void simpleDelay() {
        long l1 = System.currentTimeMillis();
        System.out.println("Wait 2sec...");
        while (System.currentTimeMillis() < (l1 + 2000)) {
        }
        System.out.println("Done.");
    }
    
    public synchronized void waitDelay() {
        System.out.println("Wait 2sec...");
        try {
            wait(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Done.");
    }
    
    public synchronized void loopDelay() {
        System.out.println("Wait 5 times 2sec...");
        for (int i = 0; i < 4; i++) {
            try {
                wait(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            System.out.println(i + 1);
        }
        System.out.println("Done.");
    }
    
    public synchronized void threadWaitDelay() {
        WaitThread w1 = new WaitThread("t1");
        WaitThread w2 = new WaitThread("t2");
        System.out.println("Two threads...");
        w1.start();
        try {
            wait(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w2.start();
    }
    
}

