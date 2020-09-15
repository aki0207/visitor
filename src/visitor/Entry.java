package visitor;

import java.util.Iterator;

public abstract class Entry implements Element{
	public abstract String getName();
	public abstract int getSize();

	public Entry add(Entry entry) throws FileThreatmentException {
		throw new FileThreatmentException();
	}

	public Iterator<Entry> iterator() throws FileThreatmentException {
		throw new FileThreatmentException();
	}

	@Override
	public String toString() {
		return getName() + "(" + getSize() + ")";
	}

}
