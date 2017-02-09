package cn.hkfdt.xiaot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {

	static DateFormat formatDate=new SimpleDateFormat("yyyyMMdd");
	static DateFormat fadeLoginFormatDate=new SimpleDateFormat("yyyy/MM/dd");//"yyyy/MM/dd HH:mm"
	static DateFormat formatYear=new SimpleDateFormat("yyyy");
	static DateFormat formatDate2 = new SimpleDateFormat("yyyy-MM-dd");
	static DateFormat formatTime=new SimpleDateFormat("HH:mm:ss");
	static DateFormat formatTime2=new SimpleDateFormat("HHmmss");
	static DateFormat xiaoTFormat=new SimpleDateFormat("yyyy.MM.dd");
	/**
	 * @param args
	 * author:xumin 
	 * 2016-4-22 下午8:01:21
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String time = "2016-12-23";
		System.err.println(time.replace("-", "."));
		
	}
	public static String getYear() {
		Date date=new Date();
		String time=formatYear.format(date);
		return time;
	}
	public static String getToday() {
		Date date=new Date();
		String time=formatDate.format(date);
		return time;
	}

	public static String getTodayTime() {
		Date date=new Date();
		String time=formatTime.format(date);
		return time;
	}
	/**
	 * 之前或者之后的日子
	 * @param days
	 * @return
	 * author:xumin 
	 * 2016-5-25 上午10:36:42
	 */
	public static String getDay(int days) {
		Date dat = null;
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, days);
		dat = cd.getTime();
		String time = formatDate.format(dat);
		return time;
	}
	/**
	 * 获取之前或者之后的时间
	 * @param days 负数就是之前
	 * @return
	 * author:xumin 
	 * 2016-12-6 上午10:23:38
	 */
	public static long getDayTime(int days) {
		Date dat = null;
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, days);
		dat = cd.getTime();
		return dat.getTime();
	}

	/**
	 * 今天是否是周末
	 * @return
	 * author:xumin 
	 * 2016-8-3 下午2:44:43
	 */
	public static boolean isWeekDayCTP() {
		Date bdate=new Date();
		int timeNow = TimeUtil.getTodayTimeInt();
		boolean flag = (0<=timeNow && timeNow<=23000);
		Calendar cal = Calendar.getInstance();
		cal.setTime(bdate);
		if((cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY && !flag) || cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
		   return true; 
		return false;
	}

	public static int getTodayTimeInt() {
		Date date=new Date();
		String time=formatTime2.format(date);
		return Integer.parseInt(time);
	}
	public static String getDayNow() {
		Date date=new Date();
		String day=formatDate2.format(date);
		return day;
	}
	public static String getDayAndTimeNow() {
		Date date=new Date();
		String day=formatDate2.format(date);
		String time=formatTime.format(date);//211451
		return day+" "+time;
	}
	/**
	 * 到某天后的0点0时0分
	 * @param day 正数或者负数
	 * @return
	 * author:xumin 
	 * 2016-12-7 下午2:19:46
	 */
	public static long getBorATime(int day) {
		Calendar curDate = Calendar.getInstance();
		Calendar tommorowDate = new GregorianCalendar(curDate
				.get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate
				.get(Calendar.DATE) + day, 0, 0, 0);
//		Date date = tommorowDate.getTime();
//		String days=formatDate2.format(date);
//		String times=formatTime.format(date);//211451
//		System.err.println(days+times);
		return tommorowDate.getTimeInMillis();
	}
	public static String tradeTimeXiaoT(Long tradeTime) {
		Date date = new Date(tradeTime);
		return xiaoTFormat.format(date);
	}
	


}
