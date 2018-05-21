/*
 * Created on May 9, 2018
 *
 */
package music;

public class Singer extends Thread {
    
    private String singerName;
    private Voice voice;
    private Performance performance;
    private Performance[] performanceArray;
    
    private boolean stopIt;
    private Synchronizer synch;
    
    public Singer(String singerName, Voice voice, Performance performance, boolean stopIt, Synchronizer synch) {
        super();
        this.singerName = singerName;
        this.voice = voice;
        this.performance = performance;
        this.stopIt = stopIt;
        this.synch = synch;
    }
    public Singer(String singerName, Voice voice, Performance[] performance, boolean stopIt, Synchronizer synch) {
    	super();
    	this.singerName = singerName;
    	this.voice = voice;
    	this.performanceArray = performance;
    	this.stopIt = stopIt;
    	this.synch = synch;
    }

    public Singer(String singerName, Voice voice, Performance performance, boolean stopIt) {
        super();
        this.singerName = singerName;
        this.voice = voice;
        this.performance = performance;
        this.stopIt = stopIt;
    }
    
    public Singer() {
        super();
    }
    
    @Override
    public void run() {
        sing();
    }
    
    private synchronized void sing() {
        while (!stopIt) {
            if (this.voice == Voice.FIRST) {
                this.synch.singFirstVoice(performanceArray[Synchronizer.pattiLyrics].getLyrics(), performanceArray[Synchronizer.pattiLyrics].getDelay());
            } else if (this.voice == Voice.SECOND){
                this.synch.singSecondVoice(performanceArray[Synchronizer.bruceLyrics].getLyrics(), performanceArray[Synchronizer.bruceLyrics].getDelay());
            }else if(this.voice == Voice.BACKGROUND) {
            	this.synch.singChoir(performanceArray[Synchronizer.choirLyrics].getLyrics(), performanceArray[Synchronizer.choirLyrics].getDelay());
            }else {
            	this.synch.playGuitarSolo(performanceArray[Synchronizer.instrumental].getLyrics(),performanceArray[Synchronizer.instrumental].getDelay());
            }
        }
    }
    
    public String getSingerName() {
        return singerName;
    }
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
    public Voice getVoice() {
        return voice;
    }
    public void setVoice(Voice voice) {
        this.voice = voice;
    }
    public Performance getPerformance() {
        return performance;
    }
    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
    public boolean isStopIt() {
        return stopIt;
    }
    public void setStopIt(boolean stopIt) {
        this.stopIt = stopIt;
    }

    public Synchronizer getSynch() {
        return synch;
    }

    public void setSynch(Synchronizer synch) {
        this.synch = synch;
    }

}

