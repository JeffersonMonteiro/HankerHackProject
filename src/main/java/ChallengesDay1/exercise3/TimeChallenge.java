package ChallengesDay1.exercise3;

public class TimeChallenge {

    public static void main(String[] args) {
        TimeChallenge t = new TimeChallenge();
        System.out.println(timeConversion("12:00:00AM"));
    }

    public static String timeConversion(String s) {
        // Write your code here

        String[] hourTime = s.split(":");
        
        int hour = Integer.parseInt(hourTime[0]);
        int minute = Integer.parseInt(hourTime[1]);
        int seconds = Integer.parseInt(hourTime[2].substring(0,2));
        String type = "";

        if(s.contains("PM")){
        type = "PM";
            if(!(hour >= 12 && minute > 0)){
                hour = hour+12;
            }
        }else{
            type = "AM";
            if((hour >= 12 && minute > 0) || (hour == 12 && minute == 0)){
                hour = hour - 12;
            }
        }
        return String.format("%02d",hour)+":"+ String.format("%02d", minute)+":"+String.format("%02d",seconds);
    }
}
