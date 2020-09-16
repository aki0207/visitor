package visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class FileFinderVisitor extends Visitor {
	private ArrayList<File> files = new ArrayList<>();
	String fileCategory;

	public FileFinderVisitor(String fileCategory) {
		this.fileCategory = fileCategory;
	}

	@Override
	public void visit(File file) {
		if (file.getName().endsWith(fileCategory)) {
			files.add(file);
		}
	}

	@Override
	public void visit(Directory directory) {
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			entry.accept(this);
		}
	}

	public Iterator<File> getFoundFile() {
		return files.iterator();
	}
}
