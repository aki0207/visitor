package visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor{
	private String currentDir = "";

	@Override
	public void visit(File file) {
		System.out.println(currentDir + "/" + file);
	}

	public void visit(Directory directory) {
		System.out.println(currentDir + "/" + directory);
		String savedDir = currentDir;
		currentDir = currentDir + "/" + directory.getName();
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			entry.accept(this);
		}
		currentDir = savedDir;
	}

}
