package tests.bag;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Bag;

public class RemoveTests {
	
	private static int LARGE = 10000;
	
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
	public void addOneRemoveOneSize() {
		_bag = new Bag<String>();
		_item = "";
		_bag.add(_item);
		_bag.remove(_item);
		int expected = 0;
		int actual = _bag.size();
		assertTrue("I added and removed one item from the Bag, expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}

	/* 
	 * Test one aspect of remove functionality: removing an item
	 * which is not in the bag should not change the collection.
	 */
	@Test
	public void testRemoveNonMember() {
		setUp();
		boolean answer = _bag.remove(_item);
		assertFalse("I expected the bag to not change on removal, but it did",
				   answer);
	}

	/* 
	 * Test one aspect of remove functionality: after removing an 
	 * inserted item, it should not be there.
	 */
	@Test
	public void testRemoveMember() {
		_bag.add(_item);
		boolean answer = _bag.remove(_item);
		assertTrue("I expected the bag to change on removal, but it didn't",
				   answer);
	}

	/* 
	 * Test one aspect of remove functionality: after removing an 
	 * inserted item, the size of the bag should be one smaller 
	 * than before.
	 */
	@Test
	public void testRemoveMemberUsingSize() {
		_bag.add(_item);
		int initialSize = _bag.size(); 
		_bag.remove(_item);
		int finalSize = _bag.size(); 
		assertTrue("The bag should have size "+(initialSize-1)+", but its size is "+finalSize,
				   finalSize == initialSize-1);
	}

	/* 
	 * Test one aspect of remove functionality: after inserting
	 * the same item twice, and removing it once, the size of the
	 * bag should be one smaller than before removal and it should
	 * still contain the item.
	 */
	@Test
	public void testRemoveOneOfTwoMembersUsingSize() {
		_bag.add(_item);
		_bag.add(_item);
		int initialSize = _bag.size();
		_bag.remove(_item);
		int finalSize = _bag.size();
		assertTrue("The bag should have size "+(initialSize-1)+" and still contain one copy of the inserted item; its size is "+finalSize+" and contains(item) is "+_bag.contains(_item),
				   _bag.contains(_item) && finalSize == initialSize-1);
	}

	/* 
	 * Test adding and removing a large number of elements.
	 */
	@Test
	public void testAddingAndRemovingMany() {
		for (int i=0; i < LARGE; i++) {
			_bag.add(_item);
		}
		for (int i=0; i < LARGE; i++) {
			_bag.remove(_item);
		}
		int expectedSize = 0;
		int actualSize = _bag.size();
		assertTrue("The bag should have size "+expectedSize+", but its size is "+actualSize, expectedSize == actualSize);
	}

	/* 
	 * Test one aspect of remove functionality: removing null
	 */
	@Test
	public void testRemoveNull() {
		setUp();
		_bag.add("Fred");
		_item = null;
		boolean answer = _bag.remove(_item);
		assertFalse("I expected the bag to not change on removal, but it did",
				   answer);
	}

	/* 
	 * Test one aspect of remove functionality: removing from a bag 
	 * containing
	 */
	@Test
	public void testRemoveFromBagContainingNull() {
		setUp();
		_bag.add(null);
		boolean answer = _bag.remove(_item);
		assertFalse("I expected the bag to not change on removal, but it did",
				   answer);
	}

	/* 
	 * Test one aspect of remove functionality: removing null from a bag 
	 * containing null
	 */
	@Test
	public void testRemoveNullFromBagContainingNull() {
		setUp();
		_bag.add(null);
		_item = null;
		boolean answer = _bag.remove(_item);
		assertTrue("I expected the bag to not change on removal, but it did",
				   answer);
	}
	
	@Test
	public void testAddManyRemoveMany() {
		setUp();
		for (int i=0; i<LARGE; i=i+1) {
			_bag.add(_item);
		}
		for (int i=0; i<LARGE; i=i+1) {
			_bag.remove(_item);
		}
		assertTrue("",true);
	}

}
