/*
Job Sequencing Problem
Given an array of jobs where every job has a deadline and profit if the job is finished before the deadline.
It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1.
Maximize the total profit if only one job can be scheduled at a time.

Job A = 4, 20  
Job B = 1, 10  
Job C = 1, 40  
Job D = 1, 30  

ans = C, A
*/

import java.util.*;
public class jobSequencing {
    static class Job{
        int deadline;
        int profit;
        int id; // 0 = A  1 = B   ....

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int[][] jobsInfo = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); //descending order on basis of profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println(seq.size());
        System.out.println(seq);
    }
}