public class Capacity {
    public static void main(String[] args) {
        int w[]={10,20,30};
        int v[]={60,100,120};
        int maxVal=0;
        int capacity=50;
        int ratio[]=new int[w.length];
        for(int i=0;i<w.length;i++){
             int r=v[i]/w[i];
             ratio[i]=r;

        }
        for(int i=0;i<w.length;i++){
             if(capacity>=w[i]){
                capacity-=w[i];
                maxVal+=v[i];
             }else{
                maxVal+=ratio[i]*capacity;
             }
        }
        System.out.println("max value in knapse is"+maxVal);
    }

}
