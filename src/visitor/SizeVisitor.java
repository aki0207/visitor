package visitor;

import java.util.Iterator;

public class SizeVisitor extends Visitor {
	int size;

	@Override
	public void visit(File file) {
		this.size += file.getSize();
	}

	@Override
	public void visit(Directory directory) {
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			size += entry.getSize();
		}
	}

	public int getSize() {
		return size;
	}
}
