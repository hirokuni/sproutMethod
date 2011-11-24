import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Test;

public class TransactionGateTest {

	@Test
	public void test_uniqueEntries() {

		//init
		ArrayList testList = new ArrayList();
		Entry entry01 = null;
		Entry entry02 = null;
		Entry entry03 = null;
		try {
			entry01 = new Entry(1, "2000/01/01");
			entry02 = new Entry(2, "2000/01/02");
			entry03 = new Entry(3, "2000/01/03");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		testList.add(entry01);
		testList.add(entry02);
		TransactionGate tGate = new TransactionGate(testList);
		
		//exe
		ArrayList anotherTestList = new ArrayList();
		anotherTestList.add(entry01);
		anotherTestList.add(entry02);
		anotherTestList.add(entry03);
		ArrayList resultList = (ArrayList)tGate.uniqueEntries(anotherTestList);

		//check
		assertEquals(1, resultList.size());
		assertEquals(false, resultList.contains(entry01));
		assertEquals(false, resultList.contains(entry02));
		assertEquals(true, resultList.contains(entry03));
	}


}
