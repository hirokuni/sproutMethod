
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;





public class TransactionGate {
	private TransactionBundle mBundleList = new TransactionBundle();
	public void postEntries(List entries){
		for (Iterator it = entries.iterator(); it.hasNext();){
			Entry entry = (Entry)it.next();
			entry.postDate();
		}
		
		mBundleList.add(entries);
		
		
	}
	
	public class TransactionBundle{
		List mList;
		public void add(List list){
			mList = list;
		}
	}
	
	public class Entry {
		private Date mDate;
		public void postDate(){
			//set current date
			mDate = new Date();
		}
	}
	
}
