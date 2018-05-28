package cn.com.vector.play.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author OrderDong
 * @since 20170525
 * @description 时间转化
 */
public class DateUtils {
	
	public static String _FormatTimeMS = "yyyy-MM-dd HH:mm:ss SSS";
	public static SimpleDateFormat _defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	public static SimpleDateFormat _defaultFormat1 = new SimpleDateFormat("ss SSS");

	/**
	 * 计算两日期相隔天数，精确到毫秒
	 * 返回格式：31天 4时3分2秒 1毫秒  （天 时 分 秒 毫秒） 
	 * 
	 * @param s_date 格式 yyyy-MM-dd HH:mm:ss SSS
	 * @param e_date 格式 yyyy-MM-dd HH:mm:ss SSS
	 * @return
	 */
	public static String calculateDays(String s_date, String e_date) {
		String result = "";
		try {
			Date s_date_ = _defaultFormat.parse(s_date);
			Date e_date_ = _defaultFormat.parse(e_date);
			long time1 = s_date_.getTime();
			long time2 = e_date_.getTime();
			long between = Math.abs(time2 - time1);

			long millimetre = between % 1000;
			between = between / 1000;
			long second = between % 60;
			between = between / 60;
			long minute = between % 60;
			between = between / 60;
			long hour = between % 24;
			long day = between / 24;
			result = day + "天 " + hour + "时" + minute + "分" + second + "秒 "
					+ millimetre + "毫秒";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 计算两日期相隔天数，精确到毫秒
	 * 返回格式：01 04:03:02 001  （天 时：分：秒 毫秒） 
	 * 此方法通过SimpleDateFormat方法格式化日期返回值，不适用于对日期间隔天数超过一个月处理
	 * @param s_date 格式 yyyy-MM-dd HH:mm:ss SSS
	 * @param e_date 格式 yyyy-MM-dd HH:mm:ss SSS
	 * @return
	 */
	public static String calculateTimes(String s_date, String e_date) {
		String result = "";
		try {
			Date s_date_ = _defaultFormat.parse(s_date);
			Date e_date_ = _defaultFormat.parse(e_date);
			long time1 = s_date_.getTime();
			long time2 = e_date_.getTime();
			long between = Math.abs(time2 - time1);
			between = between-8*60*60*1000;
			Date b_date = new Date();
			b_date.setTime(between);
			result = _defaultFormat1.format(b_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 计算两日期相隔天数，精确到毫秒
	 * 返回格式：01 04:03:02 001  （天 时：分：秒 毫秒） 
	 * 此方法通过SimpleDateFormat方法格式化日期返回值，不适用于对日期间隔天数超过一个月处理
	 * @param startTime 格式 yyyy-MM-dd HH:mm:ss SSS
	 * @param endTime 格式 yyyy-MM-dd HH:mm:ss SSS
	 * @return
	 */
	public static String calculateTimes(long startTime, long endTime) {
		String result = "";
		try {

			long between = Math.abs(endTime - startTime);
			between = between-8*60*60*1000;
			Date b_date = new Date();
			b_date.setTime(between);
			result = _defaultFormat1.format(b_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 根据格式化的字符串获取日期格式化工具 
	 * @param format
	 * @return
	 */
	public static SimpleDateFormat getSimpleDateFormat(String format){
		if(format==null || "".equals(format)){
			return _defaultFormat;
		}
		return new SimpleDateFormat(format);
	}
	
	
	/**
     * 将时间字串转化成date
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static final Date strToDate(final String dateStr, final String format) throws ParseException {
        Date date = null;
        date = new SimpleDateFormat(format).parse(dateStr);
        return date;
    }
    
    /**
     * 将日期字符串转化为需要格式的日期
     * 
     * @param date 日期字符串
     * @param format 格式字符串
     * @return 转换后的日期对象
     */
    public static Date strToFormatDate(final String date, final String format) {
        if (date == null) { return null; }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date, new ParsePosition(0));
    }
    
    /**
     * 将字符串转换为yyyy-MM-dd格式的日期
     * 
     * @param date
     * @return 转换后的日期对象
     */
    public static Date strToDate(final String date) {
        return DateUtils.strToFormatDate(date, "yyyy-MM-dd");
    }
    
    /**
     * 将字符串转换为yyyy-MM-dd HH:mm:ss格式的日期
     * 
     * @param date
     * @return 转换后的日期对象
     */
    public static Date strToDateTime(final String date) {
        return DateUtils.strToFormatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 将date型日期转换成yyyy-MM-dd HH:mm:ss格式的时间字符串
     * 
     * @param date 日期
     * @return 返回yyyy-MM-dd HH:mm格式的时间字符串
     */
    public static String dateTimeToStr(final Date date) {
        return DateUtils.dateToFormatStr(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 将date型日期转换成yyyy-MM-dd格式的日期字符串
     * 
     * @param date 日期
     * @return 返回yyyy-MM-dd格式的日期字符串
     */
    public static String dateToStr(final Date date) {
        return DateUtils.dateToFormatStr(date, "yyyy-MM-dd");
    }
    
    /**
     * 将date型日期转换成特定格式的时间字符串
     * 
     * @param date
     * @param format
     * @return 转换后的日期对象
     */
    public static String dateToFormatStr(final Date date, final String format) {
        if (date == null) { return null; }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

	/**
	 * 时间增加指定的毫秒数
	 *
	 * @param milliseconds 待增加的毫秒数,此值可为负数
	 * @return
	 */
	public static Date addMillisecond(Date date, int milliseconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MILLISECOND, milliseconds);
		return calendar.getTime();
	}

	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, +1);//+1今天的时间加一天
		date = calendar.getTime();
		return date;
	}

	public static Date getEndTime(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		calendar.set(Calendar.MILLISECOND,999);
		date = calendar.getTime();
		return date;
	}

	public static void main(String[] args)
	{
		Long now = System.currentTimeMillis();
		Long endTime = DateUtils.getEndTime(new Date()).getTime();
		int age = (int)(endTime-now)/1000/60/60;
		System.out.println(age);
	}
}
