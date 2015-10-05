package tests.bag;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Bag;


public class ForeachTest {

	@Test
	public void foreach() {
		Bag<String> b = new Bag<String>();
		b.add("Fred");
		b.add("Wilma");
		for (String s : b) {
			if (s != null) {
				s.length();
			}
		}
		assertTrue(true);
	}

}
