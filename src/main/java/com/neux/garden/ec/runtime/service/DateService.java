package com.neux.garden.ec.runtime.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Titan
 * Date: 2019/2/21
 * Time: 下午 7:06
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DateService {

    private Date mockDate = null;

    private static List<String> dateFormatList = new ArrayList<String>();
    private static List<String> dayLightList = new ArrayList<String>();
    static{

        dateFormatList.add("MM/dd/yyyy HH:mm:ss");
        dateFormatList.add("MM-dd-yyyy HH:mm:ss");

        dateFormatList.add("MM/dd/yyyy");
        dateFormatList.add("MM-dd-yyyy");

        dateFormatList.add("yyyy/MM/dd HH:mm:ss");
        dateFormatList.add("yyyy/MM/dd HH:mm");
        dateFormatList.add("yyyy/MM/dd");

        dateFormatList.add("yy/MM/dd HH:mm:ss");
        dateFormatList.add("yy/MM/dd HH:mm");
        dateFormatList.add("yy/MM/dd");
        dateFormatList.add("yyyy-MM-dd HH:mm:ss");
        dateFormatList.add("yyyy-MM-dd HH:mm");

        dateFormatList.add("yy-MM-dd HH:mm:ss");
        dateFormatList.add("yy-MM-dd HH:mm");
        dateFormatList.add("yyyy-MM-dd");
        dateFormatList.add("yy-MM-dd");
        dateFormatList.add("yyyy-MM");
        dateFormatList.add("yyyy/MM");

        dateFormatList.add("cy/MM/dd HH:mm:ss");
        dateFormatList.add("cy/MM/dd HH:mm");
        dateFormatList.add("cy/MM/dd");

        dateFormatList.add("cy-MM-dd HH:mm:ss");
        dateFormatList.add("cy-MM-dd HH:mm");
        dateFormatList.add("cy-MM-dd");
        
       //日光節約時間 清單
    	dayLightList.add("19450501");
    	dayLightList.add("19460501"); 
    	dayLightList.add("19470501");
    	dayLightList.add("19480501");
    	dayLightList.add("19490501"); 
    	dayLightList.add("19500501"); 
    	dayLightList.add("19510501"); 
    	dayLightList.add("19520301"); 
    	dayLightList.add("19530401"); 
    	dayLightList.add("19540401"); 
    	dayLightList.add("19550401"); 
    	dayLightList.add("19560401"); 
    	dayLightList.add("19570401"); 
    	dayLightList.add("19580401"); 
    	dayLightList.add("19590401"); 
    	dayLightList.add("19600601"); 
    	dayLightList.add("19610601"); 
    	dayLightList.add("19740401"); 
    	dayLightList.add("19750401"); 
    	dayLightList.add("19800630");
    	dayLightList.add("19790701");
    	dayLightList.add("19470415");
    	
    }

    public String getBetweenMillSecond(Date startTime,Date endTime) {
    	
    	GregorianCalendar gc1 = new GregorianCalendar();
        GregorianCalendar gc2 = new GregorianCalendar();
        gc1.setTime(startTime);
        gc2.setTime(endTime);

        long l = gc2.getTimeInMillis() - gc1.getTimeInMillis();
        
        String remind = StringUtils.leftPad(String.valueOf(l % 1000), 3 ,"0");
        
        return l / 1000 + "." + remind;
    	
    }
    
    public void setMockDate(Date date) {
        this.mockDate = date;
    }

    public void clearMockDate() {
        this.mockDate = null;
    }

    public Date setYear(int year , Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.set(Calendar.YEAR,year);

        return c.getTime();
    }

    public Date setMonth(int month , Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.set(Calendar.MONTH,month-1);

        return c.getTime();
    }

    public Date setDate(int day , Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.set(Calendar.DATE,day);

        return c.getTime();
    }

    public Date setWholeHour(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);

        return c.getTime();
    }

    public int getFullYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);

        return c.get(Calendar.YEAR);
    }

    public int getMonth(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);

        return c.get(Calendar.MONTH) + 1;
    }

    public int getDate(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);

        return c.get(Calendar.DATE);
    }

    public Date getTodayDate() {
        return mockDate == null ? new GregorianCalendar().getTime() : mockDate;
    }

    public Date getDateFormatDate(Date date , String formatString) {
    	Date dateFormat = null;

    	if(date != null) {

    		String dateString = null;

    		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
    		dateString = sdf.format(date);

    		try {
				dateFormat = sdf.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}

    	}
    	return dateFormat;
    }

    public Date getDate(int year , int month , int date) {
        return getDate(year,month,date,0,0,0);
    }

    public Date getDate(int year , int month , int date , int hour , int min , int sec) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month-1);
        c.set(Calendar.DATE,date);
        c.set(Calendar.HOUR_OF_DAY,hour);
        c.set(Calendar.MINUTE,min);
        c.set(Calendar.SECOND,sec);

        return c.getTime();
    }

    public int getCurrentYear() {
        Calendar c = new GregorianCalendar();
        c.setTime(getTodayDate());
        return c.get(Calendar.YEAR);
    }

    public int getCurrentMonth() {
        Calendar c = new GregorianCalendar();
        c.setTime(getTodayDate());
        return c.get(Calendar.MONTH) + 1;
    }

    public int getCurrentDate() {
        Calendar c = new GregorianCalendar();
        c.setTime(getTodayDate());
        return c.get(Calendar.DATE);
    }

    /** example format yyyyMMddHHmmss */
    public String getTodayString() {
        Date now = getTodayDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(now);
    }

    /** example format => yyyyMMddHHmmss */
    public String toDateString(Date date) {
        if(date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        sdf.setLenient(false);
        return sdf.format(date);
    }

    public String toDateString(Date date, String format) {
        if(date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        return sdf.format(date);
    }

    /** example format => yyyy-MM-dd'T'HH:mm:ssZ */
    public String toDateTimeFormatString(Date date) {
        if(date == null) return null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        return format.format(date);
    }

    /** example 0-23hour 0-59minute format=> HH:mm */
    public String get24HourMinuteString(Date date) {
    	if(date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(date);
    }

    /** exmaple Hour in am/pm for 12 hour format (1-12) format => h:mm a */
    public String get24HourMinuteMarkString(Date date) {
    	if(date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        return sdf.format(date);
    }

    /** example format M */
    public String getMonthString(Date date) {
        if(date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("M");
        return sdf.format(date);
    }

    public Date toDateTimeFormatDate(String dateString) {

        Date date = null;

        if(dateString.contains("z") || dateString.contains("Z")) {
            date = Date.from( Instant.parse( dateString ));
        }
        else {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            try{
                date = format.parse(dateString);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return date;
    }

    public Date addDate(Date date, int mode, int interval) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(mode, interval);

        return gc.getTime();

    }



    public Date[] getCurrentWeek() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getTodayDate());

        cal.set(Calendar.HOUR,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);

        Date start = null;
        Date end = null;

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);

        // 所在周开始日期
        start = cal.getTime();

        cal.add(Calendar.DAY_OF_WEEK, 6);

        // 所在周结束日期
        end = cal.getTime();

        return new Date[]{start,end};
    }

    public static void main(String[] args) throws Exception {
        DateService dateService = new DateService();


        System.out.println(dateService.getDateFormatCISL("2020-03-12T09:55:01.704"));
        System.out.println(dateService.getDateFormatCISL("2020-03-12T00:00","yyyy-MM-dd'T'HH:mm"));



//        Date end = dateService.getDate("2020/12/25");
//        System.out.println(dateService.getBetweenTime(start,end,DateType.DAY));

//        System.out.println(dateService.toDateString(dateService.getTodayDate(),"yyyyMM"));
//
//        Date today = dateService.getTodayDate();
//        Date goalSettingDealline = dateService.getDate(2019,12,13);
//        System.out.println(dateService.getBetweenTime(today, goalSettingDealline, DateType.DAY) + 1);

//        int currentDate = dateService.getCurrentDate();
//        int currentMonth = dateService.getCurrentMonth();
//        System.out.println(currentMonth);
//        Date startDate = dateService.getDate(2019,currentMonth,currentDate);
//
//        System.out.println(startDate);
//
//        Date[] week = dateService.getCurrentWeek();
//
//        System.out.println(week[0]);
//        System.out.println(week[1]);

//        System.out.println(dateService.getCurrentWeek()[0]+"  "+dateService.getCurrentWeek()[1]);


//        Date date = dateService.getDate("2019/02/22 11:45:00");
//        System.out.println(date);
//
//        System.out.println(dateService.toDateString(dateService.getTodayDate(),"yyyy-MM-dd"));
//        Date date = dateService.getDate("1990-01-26");
//        System.out.println(date);
//        System.out.println(date.getYear());
//        System.out.println(dateService.toDateTimeFormatDate("1970-01-01T00:00:00.000Z"));
//        System.out.println(dateService.toDateTimeFormatDate("2019-05-04T16:04:32+0800"));
//
//        System.out.println(        dateService.toDateTimeFormatDate(dateService.toDateString(dateService.getTodayDate(), "yyyy-MM-dd'T'00:00:00+0800") ));

//        System.out.println(dateService.toDateTimeFormatString(new Date()));

//        System.out.println(Date.from( Instant.parse( "2019-05-07T06:50:00.000Z" )));
//        System.out.println(Date.from( Instant.parse( "2019-05-04T16:04:32+0800" )));

    }

    public Date getDate(String originalDateString) {

        String format = getDateFormat(originalDateString);
        if(format != null) {
            try{
                return new SimpleDateFormat(format).parse(originalDateString);
            }catch(Exception e) {
                return null;
            }
        }
        return null;

    }

    public Date parseDateString2Date(String dateString) throws Exception{
        Date ret = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        
        dateString = dateString.replaceAll("\\p{Punct}", "");
        dateString = dateString.replaceAll("$0*", "");
        if (dateString.length() == 8) {
            dateString += "000000";
        } else if (dateString.length() == 14) {
            ;
        } else {
            dateString = "";
        }
        if(!isDaylightSaving(dateString)) sdf.setLenient(false);

        return sdf.parse(dateString);
    }

    public Date getDateByTimestamp(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.getTime();
    }

    public String getDateFormat(String originalDateString) {

        for(String format : dateFormatList) {

            boolean isSameFormat = false;
            if(originalDateString.indexOf("-") != -1 && format.indexOf("-") != -1) {
                int firstLength = originalDateString.split("-")[0].length();
                int formatLength = format.split("-")[0].length();
                if(firstLength == formatLength) isSameFormat = true;
            }

            if(originalDateString.indexOf("/") != -1 && format.indexOf("/") != -1) {
                int firstLength = originalDateString.split("/")[0].length();
                int formatLength = format.split("/")[0].length();
                if(firstLength == formatLength) isSameFormat = true;
            }

            if(isSameFormat) {
//                System.out.println("format = " + format);
                try{
                    if(format.startsWith("cy")) {
                        format = format.replaceAll("cy","yyyy");
                    }

                    new SimpleDateFormat(format).parse(originalDateString);
                    return format;
                }catch(Exception e) {
                    ;
                }
            }
        }
        return null;
    }

    public Date getThisWeekFirstDate() {
        Calendar calendar = Calendar.getInstance();
        int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK);
        int current = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DAY_OF_WEEK, (min - current) + 1);
        Date start = calendar.getTime();
        calendar.add(Calendar.DAY_OF_WEEK, 6);

        return start;
    }

    public Date getThisWeekEndDate() {
        Calendar calendar = Calendar.getInstance();
        int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK);
        int current = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DAY_OF_WEEK, (min - current) + 1);

        calendar.add(Calendar.DAY_OF_WEEK, 6);
        Date end = calendar.getTime();

        return end;
    }

    public Date getQurarterStartDate(int Quarter) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.MONTH, (Quarter - 1) * 3);
        Date StartDate = calendar.getTime();

        return StartDate;
    }

    public List<Integer>getForecastDate(int Quarter,int Month) {
        //int month=Month%3;
        List<Integer> timeBaseSeq = new ArrayList<Integer>();
        //timeBaseSeq.add(e);
        for(int a=Month+1;a<=Quarter*3;a++)
        {
            timeBaseSeq.add(a);

        }
        return timeBaseSeq;
    }

    public List<Integer>getForecastQuarter(int Quarter) {

        List<Integer> timeBaseSeq = new ArrayList<Integer>();

        for(int a=Quarter+1;a<=4;a++)
        {
            timeBaseSeq.add(a);
        }
        if(Quarter==4)
            timeBaseSeq.add(0);

        return timeBaseSeq;
    }

    public Date getQurarterEndDate(int Quarter) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        calendar.set(Calendar.MONTH, (Quarter - 1) * 3 + 2);

        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        Date EndDate = calendar.getTime();

        return EndDate;
    }

    public Date getQurarterEndDate(int Quarter,int Month) {
        int remainder=Month%3;
        int month=0;
        if(remainder==1)
            month=-2;
        else if(remainder==2)
            month=-1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        calendar.set(Calendar.MONTH, (Quarter - 1) * 3 + 2+month);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date EndDate = calendar.getTime();

        return EndDate;
    }

    public Date getStartDate(int Month,int Date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DATE, +Date);
        calendar.set(Calendar.MONTH, +Month);
        Date StartDate = calendar.getTime();

        return StartDate;
    }
    
    public Date getMonthStartDate(int Month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.MONTH, +Month-1);
        Date StartDate = calendar.getTime();

        return StartDate;
    }
    
    public Date getMonthEndDate(int Month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        calendar.set(Calendar.MONTH, +Month-1);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date StartDate = calendar.getTime();

        return StartDate;
    }

    public Date getDateFormatCISL(String date,String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        sdf.setLenient(false);
        Date dateTime = null;
        try {
            dateTime = sdf.parse(date);

//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(dateTime);
//            calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR)+8);
//
//            dateTime = calendar.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }

        return dateTime;
    }

    public Date getDateFormatCISL(String date) throws Exception {
        return getDateFormatCISL(date,"yyyy-MM-dd'T'HH:mm:ss");

    }
    
    public int getDaysOfMonth(int month) {
    	
    	Calendar cal = Calendar.getInstance();

    	cal.set(Calendar.MONTH,month-1);

    	return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    private boolean isDaylightSaving(String dateString) {
    	boolean isDaylight = false;
    	
    	for(String dayLight : dayLightList) {
    		if(dayLight.equalsIgnoreCase(dateString.substring(0,8))) isDaylight = true;
    	}
    	
    	return isDaylight;
    	
    }

    
    public Date getConditionDate(Date dateTime , int increaseMonth , int date ) {
    	
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, increaseMonth);
		
		if(date == -1 ) {
			date = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
	        calendar.set(Calendar.MINUTE, 59);
	        calendar.set(Calendar.SECOND, 59);
		}else {
			calendar.set(Calendar.HOUR_OF_DAY,0);
			calendar.set(Calendar.MINUTE,0);
			calendar.set(Calendar.SECOND,0);
		}
		
		calendar.set(Calendar.DATE, date);
		
	
    	
		return calendar.getTime();
    }
    
    public Date getFirstDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 1 - 1;
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }
    
    public Date getLastDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }
    
    public Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }
    
}
