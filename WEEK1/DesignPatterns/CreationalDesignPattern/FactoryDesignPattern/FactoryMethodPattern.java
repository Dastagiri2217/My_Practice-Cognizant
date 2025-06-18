interface Document {
	void open();
}
class WordDocument implements Document {

	public void open() {
		System.out.println("Word Document is Opening");
	}
}
class ExcelDocument implements Document {

	public void open() {
		System.out.println("Excel Document is Opening");
	}
}
class PDFDocument implements Document {

	public void open() {

		System.out.println("Opeing PDF Document");
	}

}
class DocumentFactory {
	public static Document CreateDocument(String type) {
		if(type.equals("word")) {
			return new WordDocument();
		}
		else if(type.equals("pdf")) {
			return new PDFDocument();
		}
		else if(type.equals("excel")) {
			return new ExcelDocument();
		}
		else {
// 			System.out.println("Unknown Document Type");
			throw new IllegalArgumentException("Unknown Document Type");
		}
	}
}
public class FactoryMethodPattern {
	public static void main(String args[]) {
		Document doc1 = DocumentFactory.CreateDocument("word");
		doc1.open();

		Document doc2 = DocumentFactory.CreateDocument("pdf");
		doc2.open();

		Document doc3 = DocumentFactory.CreateDocument("excel");
		doc3.open();
// 		Document doc4 = DocumentFactory.CreateDocument("avl");
// 		doc4.open();
	}
}

