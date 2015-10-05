package tests.bag;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Bag;

public class SizeTests{

	private Bag<String> _bag;
	private String _item;

	@Before
	public void setUp() {
		_bag = new Bag<String>();
		_item = new String();
	}
	
	@After
	public void tearDown() throws Exception {
		_bag = null;
		_item = null;
	}

	@Test
	public void testFlexibleSize() {
		int totalItems = 12;
		for (int i=0; i< totalItems; i++) {
			_bag.add(_item);
		}
		assertTrue("Bag should contain "+totalItems + ", but size is "+_bag.size(),
				totalItems == _bag.size());
	}

	@Test
	public void testFlexibleReSize() {
		int totalItems = 12;
		for (int i=0; i< totalItems; i++) {
			_bag.add(_item);
		}
		for (int i=0; i< totalItems; i++) {
			_bag.remove(_item);
		}
		for (int i=0; i< totalItems; i++) {
			_bag.add(_item);
		}
		assertTrue("Bag should contain "+totalItems + ", but size is "+_bag.size(),
				totalItems == _bag.size());
	}

	@Test
	public void testSizeOfFourOfSame() {
		_bag.add(_item);
		_bag.add(_item);
		_bag.add(_item);
		_bag.add(_item);
		int expectedSize = 4;
		int finalSize = _bag.size();
		assertTrue("I expected the final size to be " + expectedSize + " but it was " + finalSize,
				   finalSize == expectedSize);
	}

	@Test
	public void testSizeOfEmpty() {
		int expectedSize = 0;
		int finalSize = _bag.size();
		assertTrue("I expected the final size to be " + expectedSize + " but it was " + finalSize,
				   finalSize == expectedSize);
	}
}
