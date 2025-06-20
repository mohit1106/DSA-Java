/*
You are given n activities with their start and end times. Select the maximum number of activities that can 
be performed by a single person, assuming that a person can only work on a single activity at a time. 
Activities are sorted according to end time.

start = [10, 12, 20]
end = [20, 25, 30]

ans = 2 (A0 & A2)
*/
import java.util.*;
public class activitySelection {

    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9}; // already sorted on basis of end time

        int cnt = 1; // first activity always chosen when sorted by end time
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);

        int lastEnd = end[0];
        for (int i = 1; i < start.length; i++) {
            if(start[i] >= lastEnd){
                cnt++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println(cnt);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
// if the array is not sorted on basis of end time then to sort it.
/* 
//sorting  
int activities[][] = new int[start.length][3];  
for(int i=0; i<start.length; i++) {  
    activities[i][0] = i;  
    activities[i][1] = start[i];  
    activities[i][2] = end[i];  
}  

//lambda function -> shortform  
Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));  

//end time basis sorted  
int maxAct = 0;  
ArrayList<Integer> ans = new ArrayList<>();  

//1st activity  
maxAct = 1;  
ans.add(activities[0][0]);  
int lastEnd = activities[0][2];  

for(int i=1; i<end.length; i++) {  
    if(activities[i][1] >= lastEnd) {  
        //activity select  
        maxAct++;  
        ans.add(activities[i][0]);  
        lastEnd = activities[i][2];  
    }  
}  

System.out.println("max activities = " + maxAct);  
for(int i=0; i<ans.size(); i++) {  
    System.out.print("A" + ans.get(i) + " ");  
}  
System.out.println();  
*/