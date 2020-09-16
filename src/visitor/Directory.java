package visitor;

import java.util.ArrayList;
import java.util.Iterator;


public class Directory extends Entry{
	private String name;
	private ArrayList<Entry> directory = new ArrayList<>();

	public Directory(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		SizeVisitor sv = new SizeVisitor();
		accept(sv);
		return sv.getSize();
	}

	public Entry add(Entry entry) {
		directory.add(entry);
		return this;
	}

	public Iterator<Entry> iterator() {
		return directory.iterator();
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

}
