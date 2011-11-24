import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Entry {
		public Date mDate;
		public int mkey;
		// e.g. date = ""2008/02/16""
		public Entry(int key, String date) throws ParseException {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			mDate = df.parse(date);
			mkey = key;
		}

		public void postDate() {
			// do some post procedure
		}
	}