import java.util.Date;

public class NextDayCalculator {
    int day;
    int month;
    int year;
    int [] arrMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    NextDayCalculator(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public String getNextDay(){

        int nowDay = (int) day, nowMonth = (int)month, nowYear = (int) year;
        if(nowMonth == 12 && nowDay == 31) {
            return "1/1/" + (nowYear+1);
        }

        if(nowDay == arrMonth[nowMonth] || (nowMonth == 2) && (nowDay == 28 || nowDay == 29)){

            return "1/" + (nowMonth + 1) + "/" + nowYear;
        }

        return (nowDay+1) + "/" + nowMonth + "/" + nowYear;

    }
}
