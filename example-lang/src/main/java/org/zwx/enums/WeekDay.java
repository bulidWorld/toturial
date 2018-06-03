package org.zwx.enums;

public abstract class WeekDay {

    private static final String STR_MON = "MON";


    public static final WeekDay MON = new WeekDay(){

        @Override
        protected WeekDay nextDay() {
            return null;
        }
    };

//    public static final WeekDay TUS = new WeekDay();
//    private WeekDay() {
//
//    }

    protected abstract WeekDay nextDay();
}
