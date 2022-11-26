package kakaoBankIntern;

import java.io.*;
import java.util.*;                                                   

public class Solution {

	public static void main(String[] args) {
		int [] answer = solution("2021:12:30:23:59:59" , new String[] {"00:00:00:01"});
		System.out.println(answer[0] + " " + answer[1]);
//		solution(10, 10 , new int [][] {{10,15,2,1,2},{20,20,3,3,4}});
//		solution(0, 0 , new int[][] {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}});
	}
	
	public static int[] solution(String s, String[] stringTimes) {
        int[] answer = new int[2];

        String[] start = s.split(":");

        List<Time> times = new LinkedList<>();

        Time first = new Time();

        first.year = Integer.parseInt(start[0]);
        first.month = Integer.parseInt(start[1]);
        first.day = Integer.parseInt(start[2]);
        first.hour = Integer.parseInt(start[3]);
        first.minute = Integer.parseInt(start[4]);
        first.second = Integer.parseInt(start[5]);

        times.add(first);
        
        Time before = new Time(first.year, first.month, first.day, first.hour, first.minute, first.second);
        Time plus = new Time();

        for(String time : stringTimes){
            String [] t = time.split(":");
            plus.day = Integer.parseInt(t[0]);
            plus.hour = Integer.parseInt(t[1]);
            plus.minute = Integer.parseInt(t[2]);
            plus.second = Integer.parseInt(t[3]);
            
            before = plusDate(before, plus);
            
            // System.out.println(before.year + ":" + before.month + ":" + before.day + ":" + before.hour + ":" + before.minute + ":" + before.second);

            times.add(before);
        }

        int size = times.size();
        
        Time last = times.get(size-1);
        
        answer[1] = calc(first, last) + 1;

        boolean chk = true;

        int beforeDiff = 0;
        int cnt = 1;

        for(int i = 1; i < size ; i++){
            // System.out.println(times.get(i).year + ":" + times.get(i).month + ":" + times.get(i).day + ":" + times.get(i).hour + ":" + times.get(i).minute + ":" + times.get(i).second);
            int diff = calc( first, times.get(i));
            // System.out.println(" beforeDiff : " + beforeDiff + ", diff : " + diff);
            if(beforeDiff == diff - 1) {
                beforeDiff = diff;
                cnt+=1;
            }else if(beforeDiff + 1 < diff){
                chk = false;
                break;
            }
        }

        answer[0] = 1;
        if(!chk) answer[0] = 0;
        else if(cnt != answer[1]) answer[0] = 0;

        return answer;
    }
    public static int calc(Time time1, Time time2){
        Time tmp1 = new Time(time1.year, time1.month, time1.day, time1.hour, time1.minute, time1.second);
        Time tmp2 = new Time(time2.year, time2.month, time2.day, time2.hour, time2.minute, time2.second);
        if(tmp1.day > tmp2.day) {
            tmp2.day += 30;
            tmp2.month -= 1;
        }

        if(tmp1.day > tmp2.month){
            tmp2.month += 12;
            tmp2.year -= 1;
        }

        return (tmp2.year - tmp1.year) * 12 * 30 + (tmp2.month - tmp1.month) * 30 + (tmp2.day - tmp1.day) ;
    }
    public static Time plusDate (Time time1, Time time2){
        Time resultTime = new Time();
        // Time resultTime = new Time(time1.year, time1.month, time1.day, time1.hour, time1.minute, time1.second);
        
        int sum = (time1.second + time2.second);
        resultTime.second = sum % 60;
        sum = ((sum) / 60 + time1.minute + time2.minute);
        resultTime.minute = sum % 60;
        sum = ((sum) / 60) + time1.hour + time2.hour;
        resultTime.hour = sum % 24;
        sum = ((sum) / 24) + time1.day + time2.day;
        resultTime.day = sum % 30;
        sum = ((sum) / 30) + time1.month + time2.month;
        resultTime.month = sum % 12;
        sum = ((sum) / 12) + time1.year + time2.year;
        resultTime.year = sum;
        
        return resultTime;
    }

    public static class Time {
        int year;
        int month;
        int day;
        int hour;
        int minute;
        int second;

        public Time(){}

        public Time(int year, int month, int day, int hour, int minute, int second){
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.second = second; 
        }

        public Time(int hour, int minute, int second){
            this.hour = hour;
            this.minute = minute;
            this.second = second; 
        }
    }
}
