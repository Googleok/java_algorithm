package programmers.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    public static void main(String[] args) throws ParseException {
        Test01 sol = new Test01();
        String[] deposits = { "01/01 2 50000", "01/03 1 999", "01/31 9 10000", "02/05 5 6547", "02/05 6 1",
                "06/30 5 5000", "10/15 5 2529", "12/30 4 10000" };
        System.out.println(sol.solution(deposits));
    }

    public int solution(String[] deposits) throws ParseException {
        int answer = 0;
        for (int i = 0; i < deposits.length; i++) {
            String[] splitDepoStrings = deposits[i].split(" ");
            int interest = 0;
            int remainDays = getRemainDays(splitDepoStrings[0]);
            Double interestRate = (double) (Integer.parseInt(splitDepoStrings[1]) / (double) 100);
            Double principal = Double.parseDouble(splitDepoStrings[2]);
            interest = (int) ((principal * interestRate) * (remainDays / (double) 365));
            answer += principal + interest;
        }
        return answer;
    }

    private int getRemainDays(String date) throws ParseException {
        String lastDate = "2021/12/31";
        String paramDate = "2021/" + date;

        Date format1 = new SimpleDateFormat("yyyy/MM/dd").parse(lastDate);
        Date format2 = new SimpleDateFormat("yyyy/MM/dd").parse(paramDate);

        long diffSec = (format1.getTime() - format2.getTime()) / 1000;
        long diffDays = diffSec / (24 * 60 * 60);

        return (int) (diffDays);
    }
}
