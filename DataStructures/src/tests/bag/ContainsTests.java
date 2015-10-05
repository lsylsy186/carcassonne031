package tests.bag;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import code.Bag;

public class ContainsTests{

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
	public void testEmptyContainsNone() {
		boolean expected = false;
		boolean actual = _bag.contains(_item);
		assertTrue("I checked whether an empty Bag<String> contained \""+_item+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testAddThenContains() {
		_bag.add(_item);
		boolean expected = true;
		boolean actual = _bag.contains(_item);
		assertTrue("I added \""+_item+"\" to an empty Bag<String>, and then check whether it contained \""+_item+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testContainsNonNullNo() {
		String varNull = null;
		_bag.add(_item);
		_bag.add(varNull);
		_bag.add(_item);
		_bag.add(varNull);
		_bag.add(_item);
		_bag.add(varNull);
		String other = _item + "!@#";
		boolean expected = false;
		boolean actual = _bag.contains(other);
		assertTrue("I added \""+_item+"\" and "+varNull+" to an empty Bag<String>, and then check whether it contained \""+other+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testContainsNullYes() {
		_bag.add(_item);
		String varNull = null;
		_bag.add(varNull);
		boolean expected = true;
		boolean actual = _bag.contains(varNull);
		assertTrue("I added \""+_item+"\" and "+varNull+" to an empty Bag<String>, and then check whether it contained \""+varNull+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testContainsNullNo() {
		_bag.add(_item);
		String _item2 = null;
		boolean expected = false;
		boolean actual = _bag.contains(_item2);
		assertTrue("I added \""+_item+"\" to an empty Bag<String>, and then check whether it contained \""+_item2+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test public void testRemoveUsingSize() {
		Bag<String> bag = new Bag<String>();
		String s1 = "Fred1";
		String s2 = "Fred2";
		String s3 = "Fred3";
		bag.add(s1); bag.add(s2); bag.add(s3);
		bag.remove(s2);
		boolean expected = true;
		boolean actual = bag.contains(s3);
		assertTrue("", expected == actual);
	} 

}
