package tests.bag;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Bag;

public class ConstructionTests {

	@Test
	public void testEmptyBagHasSizeZero() {
		Bag<String> b = new Bag<String>();
		int expected = 0;
		int actual = b.size();
		assertTrue("I created an new Bag<String>, expecting its size to be "+expected
				   +", but its size was "+actual, expected == actual);
	}

	@Test
	public void testEmptyBagDoesNotContainANonEmptyString() {
		Bag<String> b = new Bag<String>();
		String s = "Fred";
		boolean expected = false;
		boolean actual = b.contains(s);
		assertTrue("I created an new Bag<String>, expecting \""+s+"\" to NOT be in the bag, but it was",
				   expected == actual);
	}

	@Test
	public void testEmptyBagDoesNotContainEmptyString() {
		Bag<String> b = new Bag<String>();
		String s = "";
		boolean expected = false;
		boolean actual = b.contains(s);
		assertTrue("I created an new Bag<String>, expecting \""+s+"\" to NOT be in the bag, but it was",
				   expected == actual);
	}

	@Test
	public void testEmptyBagDoesNotContainNull() {
		Bag<String> b = new Bag<String>();
		String s = null;
		boolean expected = false;
		boolean actual = b.contains(s);
		assertTrue("I created an new Bag<String>, expecting 'null' to NOT be in the bag, but it was",
				   expected == actual);
	}

}
