package coding.quizzaciously.nitpchanakyaunofficial.datahandler.processors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Iterator;

import coding.quizzaciously.nitpchanakyaunofficial.datahandler.Marks;
import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.MarksError;

/**
 * Created by Raj on 20-12-2016.
 */
public class MarksTableProcessor {

    public ArrayList fetchFromTable(String fileText) throws MarksError {
        ArrayList<Marks> marksList = new ArrayList<Marks>();

        Document doc = Jsoup.parse(fileText);
        Element table = doc.select("table[class=Grid]").first(), tempElem,loopElem;
        if(table==null)
            throw new MarksError(MarksError.WRONG_SESSION_ERROR);
        table=table.select("tbody").first();
        Iterator<Element> trIterator=null, tdIterator=null,thIterator=null;
        trIterator = table.select("tr").iterator();
        thIterator=table.select("th").iterator();

        while (thIterator.hasNext())
        {
            String str=(thIterator.next().text());
            Marks.addExamType(str);
        }
        trIterator.next();
        int i;
        do {
            tempElem = trIterator.next();
            tdIterator = tempElem.select("td").iterator();
            String temp;
            System.out.println("dkfj");
            System.out.println(tempElem.select("td").text());
            Marks tempMark = new Marks();


            while (((loopElem = tdIterator.next())!=null)&&((temp = loopElem.text()) != null)) {
                tempMark.addEntry(temp);
                if (!tdIterator.hasNext())
                    break;
            }
            marksList.add(tempMark);

        }
        while (trIterator.hasNext());
        return marksList;
    }

}
