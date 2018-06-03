package org.zwx.enums;


/**
 * if else判断通过子类来实现不同的行为，替换掉ifelse
 */
public class App {

    private static final String WEEKEND = "1";

    public static void main(String[] args) {
//        if (args[0].equals(WEEKEND)){
//            //DO STH
//        }

//M2
//        WeekDay weekEnd = WeekDay.MON;
//
//        if (args[0].equals(weekEnd)) {
//            //DO STH
//        }

//        WeekDay nextDay = weekEnd.nextDay();

    WeekDay weekEnd = new WeekDay() {
        @Override
        protected WeekDay nextDay() {
            return WeekDay.MON;
        }
    };

    }
}
