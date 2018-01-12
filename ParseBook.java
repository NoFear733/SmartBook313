package SmartBook;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import com.sun.org.apache.xml.internal.utils.StringToStringTable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

public class ParseBook {

	public static void Read(String pathName) {

		// Имя файла


		final String srr = new String();
		String fileName = "iii.fb2";
		// fileName = pathName;

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			// Здесь мы определили анонимный класс, расширяющий класс DefaultHandler
			DefaultHandler handler = new DefaultHandler() {
				// Поле для указания, что тэг NAME начался
				boolean name = false;

				// Метод вызывается когда SAXParser "натыкается" на начало тэга
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					// Если тэг имеет имя NAME, то мы этот момент отмечаем - начался тэг NAME
					if (qName.equalsIgnoreCase("p")) {
						name = true;
					}
				}


				// Метод вызывается когда SAXParser считывает текст между тэгами
				@Override
				public void characters(char ch[], int start, int length) throws SAXException {
					// Если перед этим мы отметили, что имя тэга NAME - значит нам надо текст использовать.

					if (name) {


						/**StringBuilder builder = new StringBuilder();
						builder.append(new String(ch, start, length));
						 srr = builder.toString(); */



						name = false;
					}
					else; //System.out.println();

				}
			};

			// Стартуем разбор методом parse, которому передаем наследника от DefaultHandler, который будет вызываться в нужные моменты
			saxParser.parse(fileName, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





