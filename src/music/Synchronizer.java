/*
 * Created on May 10, 2018
 *
 */
package music;

import javax.swing.JTextArea;

public class Synchronizer {
	public static int flag = 0;
    public static int pattiLyrics=0;
    public static int bruceLyrics=0;
    public static int choirLyrics=0;
    public static int instrumental=0;
    private JTextArea textArea;
	private FirstFlag firstFlag;
    public Synchronizer(FirstFlag firstFlag, JTextArea textArea) {
        super();
        this.firstFlag = firstFlag;
        this.textArea = textArea;
    }
    
    public synchronized void singFirstVoice(String lyrics, int delay) {
        while (firstFlag!=FirstFlag.patti) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
        pattiLyrics =(pattiLyrics + 1)%27;
        
    }
    
    public synchronized void singSecondVoice(String lyrics, int delay) {
        while (firstFlag!=FirstFlag.bruce) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
        bruceLyrics= (bruceLyrics+1)%14;
    }
    public synchronized void singChoir(String lyrics, int delay) {
    	while (firstFlag!=FirstFlag.choir) {
    		try {
    			wait();
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	sing(lyrics, delay);
    	choirLyrics = (choirLyrics +1)%2;
    }
    public synchronized void playGuitarSolo(String lyrics, int delay) {
    	while (firstFlag!=FirstFlag.guitarSolo) {
    		try {
    			wait();
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	sing(lyrics, delay);
    	instrumental = (instrumental+1)%2;
    }
    
    private void sing(String lyrics, int delay) {
        textArea.append(lyrics + "\n");
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        flag = (flag+1)%49;
        if((flag >=1 && flag<=10) || flag == 13 || flag==25 || flag == 28 || (flag>=32&&flag<=39)||(flag>=43 && flag<=48))
        	firstFlag =FirstFlag.patti;
        else if(flag == 11 || flag==14 || (flag>=16 && flag <=24) || flag == 26 || flag ==29 ||flag == 41 ||flag == 43)
        	firstFlag = FirstFlag.bruce;
        else if(flag == 12 || flag== 15 || flag==27 || flag==30 || flag == 40 || flag == 42)
        	firstFlag = FirstFlag.choir;
        else firstFlag = FirstFlag.guitarSolo;
        notifyAll();
    }

}

