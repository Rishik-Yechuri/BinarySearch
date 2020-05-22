import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    int values[];

    int searchValue;
    int low;
    int high;
    int midpoint;
    public BinarySearch(){
    }
    public void fillSample(){
        values = new int[]{0, 1, 1, 2, 3, 4, 5, 6, 8, 9};
    }
    public void fillRandom(){
        values = new int[100];
        for(int x=0;x<100;x++){
            int randomNumber = (int) (Math.random()*99+1);
            values[x] = randomNumber;
        }
        Arrays.sort(values);
    }
    public void runSearch(int key){
        int iteration = 1;
        System.out.println("Searching for " + key);
        System.out.println();
        boolean run = true;
        int index =0;
        int lowIndex =0;
        int highIndex = values.length - 1;
        boolean quitBecauseOfNotFinding = false;
        while(run){
            if(Math.abs(highIndex-lowIndex)<2){
                run=false;
                quitBecauseOfNotFinding = true;
            }
            if(lowIndex>=0&&lowIndex<=99) {
                low = values[lowIndex];
            }
            if(highIndex>=0&&highIndex<=99) {
                high = values[highIndex];
            }
            midpoint = (int)(lowIndex+highIndex)/2;
            int backupLowIndex = lowIndex;
            int backupHighIndex = highIndex;
            midpoint = values[midpoint];
            if(key<midpoint){
                highIndex = (int)(lowIndex+highIndex)/2-1;
            }else if(key>midpoint){
                lowIndex = (int)(lowIndex+highIndex)/2+1;
            }else{
                run = false;
                index =(int)(lowIndex+highIndex)/2;
            }
            System.out.println("Iteration #" + iteration);
            System.out.println("low: index " + lowIndex+ ", value " + low);
            System.out.println("high: index " + highIndex+ ", value " + high);
            System.out.println("midpoint: index " + (int)(backupLowIndex+backupHighIndex)/2 + ", value " + midpoint);
            if(!run){
                if(!quitBecauseOfNotFinding){
                    System.out.println(key + " found at index " + index);
                }else{
                    System.out.println("Could Not Find " + key);
                }
            }
            System.out.println();
            iteration++;
        }
    }
}