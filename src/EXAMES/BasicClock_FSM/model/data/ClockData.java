package EXAMES.BasicClock_FSM.model.data;

public class ClockData {
    private int h,m,s;
    private boolean onOff;

    public ClockData(int h, int m, int s){
        this.h=h; 
        this.m=m; 
        this.s=s; 
    }

    public boolean getOnOff(){
        return this.onOff;
    }

    public void setOnOff(boolean b){
        onOff = b;
    }

    public int getH(){ 
        return  this.h; }

    public void setH(int h){
        if( h>0 && h<23)
            this.h=h;
    }

    public int getM(){
        return this.m; 
    }

    public void setM(int m){
        if( m>0 && m<=59)
            this.m=m; 
    }

    public int getS(){
        return this.s;
    }

    public void setS(int s){
        if(s>0 && s<=59)
            this.s=s;
    }

    @Override
    public String toString(){
        return String.format("\n%02d:%02d:%02d", h,m,s) + " Estado:" + onOff + "\n";
    }


}
