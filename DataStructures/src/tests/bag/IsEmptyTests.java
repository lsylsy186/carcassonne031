package tests.bag;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Bag;


public class IsEmptyTests{

	private Bag<String> _bag;
	private String _item;

	@Before
	public void setUp() {
		_bag = new Bag<String>();
		_item = "Fred";
	}
	
	@After
	public void tearDown() throws Exception {
		_bag = null;
		_item = null;
	}

	@Test
	public void testIsEmptyWithEmpty() {
		boolean expected = true;
		boolean actual = _bag.isEmpty();
		assertTrue("I called isEmpty() on an empty Bag<String> expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testIsEmptyWithNonEmpty() {
		boolean expected = false;
		_bag.add(_item);
		boolean actual = _bag.isEmpty();
		assertTrue("I called isEmpty() on a non-empty Bag<String> expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}
}
