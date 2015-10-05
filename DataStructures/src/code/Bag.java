package code;

import java.util.Collection;
import java.util.Iterator;

public class Bag<E> implements Collection<E> {
	
	/*
	 * INVARIANTS:
	 *	_store refers to an array of E variables
	 *  _store refers to an array of capacity > 0
	 */
	private E[] _store;
	
	/*
	 * INVARIANTS:
	 *  _size denotes the first unoccupied position in _store
	 *  _size denotes the number of elements in the Bag
	 */
	private int _size;
	
	/*
	 * The role of the constructor is not simply to 
	 * ensure that all instance variables are assigned
	 * sensible initial values.  The role of the 
	 * constructor is to establish the INVARIANTS.
	 */
	public Bag() {
		_store = (E[]) (new Object[10]);
		_size = 0;
	}

	@Override public boolean add(E e) {
		// INVARIANTS HOLD HERE
		_store[_size] = e;
		// INVARIANTS ON _size ARE BROKEN HERE
		_size = _size + 1; // <-- RESTORES INVARIANTS
		// INVARIANTS HOLD HERE
		return true;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return _size;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
