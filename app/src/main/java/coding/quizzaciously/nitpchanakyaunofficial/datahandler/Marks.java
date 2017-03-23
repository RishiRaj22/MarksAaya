package coding.quizzaciously.nitpchanakyaunofficial.datahandler;

import java.util.ArrayList;

/**
 * Created by Raj on 20-12-2016.
 */

public class Marks {
    public int subPos=0;
    private int i=0;
    private ArrayList fieldValues;
    private static ArrayList<String> type=new ArrayList<String>();
    public ArrayList<Integer> whereLiesMarks = new ArrayList<Integer>();

    public Marks(){
        fieldValues=new ArrayList();
    }

    public String getTotal()
    {
        float sum=0;
        int i=0;
        String s=null;
        for(Object o:fieldValues)
        {
            if(o instanceof Integer|| o instanceof Float)
            {
                sum+=(float)o;
                whereLiesMarks.add(i);
            }
            i++;
        }
        return String.valueOf(sum);
    }

    public static ArrayList<String> getType() {
        return type;
    }

    public ArrayList getFieldValues() {
        return fieldValues;
    }


    public static void addExamType(String s)
    {
        if(type==null)
            type=new ArrayList<String>();
        type.add(s);
    }

    public void addEntry(Object o)
    {
        String s;
        if(o instanceof String)
             s=(String)o;
        else return;
        try {
            float marks=Float.parseFloat(s);
            fieldValues.add(marks);
        }
        catch (Exception ex)
        {
            if(s.contains("subject")||(s.contains("Subject"))||(s.contains("code"))||(s.contains("Code"))||(s.contains("course"))||(s.contains("Course")))
                    subPos=i;
                fieldValues.add(s);
        }
        i++;
    }
}
