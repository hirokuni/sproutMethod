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

	public TransactionGate(List list) {
		mBundleList.add(list);
	}

	// public List uniqueEntries(List entries){
	// List result = new ArrayList()
	// }

	public void postEntries(List entries) {
		List entriesToAdd = uniqueEntries(entries);
		for (Iterator it = entriesToAdd.iterator(); it.hasNext();) {
			Entry entry = (Entry) it.next();
			entry.postDate();
		}
		mBundleList.add(entriesToAdd);
	}

	public void addEntry(Entry entry) {

	}

	public class TransactionBundle {
		List mList;

		public void add(List list) {
			mList = list;
		}

		public boolean hasEntry(Entry entry) {

			for (Iterator it = mList.iterator(); it.hasNext();) {
				Entry existingEntry = (Entry) it.next();
				if (existingEntry.mkey == entry.mkey) {
					return true;
				}
			}

			return false;
		}
	}

	public List uniqueEntries(List entries) {

		List result = new ArrayList();
		for (Iterator it = entries.iterator(); it.hasNext();) {
			Entry entry = (Entry) it.next();
			if (!mBundleList.hasEntry(entry)) {
				result.add(entry);
			}
		}

		return result;
	}

}
