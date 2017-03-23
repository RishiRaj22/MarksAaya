package coding.quizzaciously.nitpchanakyaunofficial.datahandler.processors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;

import coding.quizzaciously.nitpchanakyaunofficial.datahandler.AttendanceValue;
import coding.quizzaciously.nitpchanakyaunofficial.datahandler.SubjectAttendanceValue;
import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.MarksError;

/**
 * Created by Raj on 20-12-2016.
 * Parses attendance using JSoup
 */
public class AttendanceTableProcessor {
    public ArrayList fetchFromTable(String fileText) throws MarksError {
        ArrayList<SubjectAttendanceValue> subjectAttendanceValues = new ArrayList<SubjectAttendanceValue>();

        Document doc = Jsoup.parse(fileText);
        Element parent = doc.select("table[class=Grid]").first();
        if (parent != null) {
            Elements children=null;
            try {
                children = doc.select("table[class=Grid]").first().select("table[class=ChildGrid]");
            }
            catch (Exception ex)
            {
                throw new MarksError(MarksError.WRONG_SESSION_ERROR);
            }
            parent.select("table[class=ChildGrid").remove();

            Iterator<Element> tdIterator = null;
            tdIterator = parent.select("td").iterator();
            tdIterator.next();
            int i = 0, tot = 0, att = 0, j = 0;
            String ccode = null;


            while (tdIterator.hasNext()) {
                if (i == 0)
                    ccode = tdIterator.next().text();
                if (i == 1 || i == 3) {
                    try {
                        tot += Integer.parseInt(tdIterator.next().text());
                    } catch (Exception ex) {
                        tot += 0;
                    }
                }
                if (i == 2 || i == 4) {
                    try {
                        att += Integer.parseInt(tdIterator.next().text());
                        if (!tdIterator.hasNext())
                            i++;
                    } catch (Exception ex) {
                        att += 0;
                    }
                }
                if (i == 5) {
                    SubjectAttendanceValue sub = new SubjectAttendanceValue(ccode, tot, att);
                    subjectAttendanceValues.add(sub);
                    i -= 6;
                    if (tdIterator.hasNext())
                        tdIterator.next();
                    tot = 0;
                    att = 0;
                    ccode = null;
                }
                i++;
            }

            i = 0;
            tot = 0;
            att = 0;
            ccode = null;

            for (Element e : children) {
                tdIterator = e.select("td").iterator();
                int m = e.select("td").size();
                do {
                    if (i == 0)
                        ccode = tdIterator.next().text();
                    if (i == 1 || i == 3) {
                        try {
                            tot += Integer.parseInt(tdIterator.next().text());
                        } catch (Exception ex) {
                            tot += 0;
                        }
                    }
                    if (i == 2 || i == 4) {
                        try {
                            att += Integer.parseInt(tdIterator.next().text());
                            if (!tdIterator.hasNext()) {
                                i++;
                            }
                        } catch (Exception ex) {
                            att += 0;
                        }
                    }
                    if (i == 5) {
                        AttendanceValue sub = new AttendanceValue(ccode, tot, att);
                        subjectAttendanceValues.get(j).addChild(sub);
                        i -= 6;

                        tot = 0;
                        att = 0;
                        ccode = null;
                    }
                    i++;
                }
                while (tdIterator.hasNext());

                j++;
            }
            return subjectAttendanceValues;
        }

        else
        {
            throw new MarksError(MarksError.WRONG_SESSION_ERROR);
        }
    }




}
