import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TransactionGate {
	private TransactionBundle mBundleList = new TransactionBundle();

	public void postEntries(List entries) {
		List entriesToAdd = new LinkedList();
		for (Iterator it = entries.iterator(); it.hasNext();) {
			Entry entry = (Entry) it.next();
			if (!mBundleList.hasEntry(entry)) {
				//if the entry is not included, then the entry is added to temp list "entriesToAdd".
				entry.postDate();
				//This local variable "entriesToAdd" tends to lead other new code into this method "postEntries".
				//For example, when we need to add some procedure before adding entry, the procedure
				//is needed to be added this line.
				entriesToAdd.add(entry);
			}
		}

		mBundleList.add(entriesToAdd);

	}

	public class TransactionBundle {
		List mList;

		public void add(List list) {
			mList = list;
		}

		public boolean hasEntry(Entry entry) {

			for (Iterator it = mList.iterator(); it.hasNext();) {
				Entry existingEntry = (Entry) it.next();
				if (existingEntry.key == entry.key) {
					return true;
				}
			}

			return false;
		}
	}

	public class Entry {
		private Date mDate;
		private int key;

		// e.g. date = ""2008/02/16""
		public Entry(int key, String date) throws ParseException {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			mDate = df.parse(date);
		}

		public void postDate() {
			// do some post procedure
		}
	}

}
