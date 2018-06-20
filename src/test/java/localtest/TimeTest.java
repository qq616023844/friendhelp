package localtest;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

public class TimeTest {

	public static void main(String[] args) throws ParseException {
		long t = new Date(00,00,01).getTime();
		System.out.println(t);
		long t1 = new Date(00,00,02).getTime();
		System.out.println(t1);
		long t2 = new Date(11,11,11).getTime();
		System.out.println(t2);
		long t3 = new Date(11,22,00).getTime();
		System.out.println(t3);
		long t4 = new Date(22,22,00).getTime();
		System.out.println(t4);
	}
}
