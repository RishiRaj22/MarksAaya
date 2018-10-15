package coding.quizzaciously.nitpchanakyaunofficial;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import coding.quizzaciously.nitpchanakyaunofficial.datahandler.Marks;

import nitpchankyaunofficial.R;


public class MarksExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> titles;
    private List<Marks> markses;
    private List<String> oldTitles=null;
    private List<Marks> oldMarkses=null;




    public MarksExpandableListAdapter(Context context, ArrayList<Marks> marks, ArrayList<Marks> old) {
        this.context = context;
        titles=new ArrayList<String>();
        markses=new ArrayList<Marks>();
        if(old!=null)
        {
            oldTitles=new ArrayList<String>();
            oldMarkses=new ArrayList<Marks>();
            for(Marks m: old)
            {
                oldTitles.add((String) m.getFieldValues().get(m.subPos));
                oldTitles.add("Total: "+m.getTotal());
                oldMarkses.add(m);
            }
        }

        for(Marks m: marks)
        {
            titles.add((String) m.getFieldValues().get(m.subPos));
            titles.add("Total: "+m.getTotal());
            markses.add(m);
        }
    }


    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        expandedListPosition=markses.get(listPosition).whereLiesMarks.get(expandedListPosition);

        ArrayList<String> strings=new ArrayList<String>();
        strings.add(Marks.getType().get(expandedListPosition));

        Marks tempMark=markses.get(listPosition);
        Object tempObj=(tempMark.getFieldValues().get(expandedListPosition));
        if(tempObj instanceof String)
            strings.add((String) tempMark.getFieldValues().get(expandedListPosition));
        if(tempObj instanceof Float)
            strings.add(String.valueOf((Float)tempObj));

        if(oldMarkses!=null&&oldTitles!=null&&oldMarkses.size()>listPosition&&oldMarkses.get(listPosition).getFieldValues().size()>expandedListPosition) {
            Marks oldMark = oldMarkses.get(listPosition);
            Object oldTempObj = (oldMark.getFieldValues().get(expandedListPosition));
            if (oldTempObj instanceof String) {
                if (strings.get(1).equals((String) oldMark.getFieldValues().get(expandedListPosition)))
                    strings.add("");
                else
                    strings.add("New");
            }
            if (oldTempObj instanceof Float) {
                if (oldTempObj.equals(tempObj))
                    strings.add("");
                else
                    strings.add("New");
            }
        }
        else
            strings.add("");
        return strings;
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final ArrayList<String> expandedListText = (ArrayList<String>) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView subText = (TextView) convertView
                .findViewById(R.id.itemText);
        TextView marksText = (TextView) convertView
                .findViewById(R.id.marksText);
        TextView redDotText = (TextView) convertView
                .findViewById(R.id.redDot);

        redDotText.setText(expandedListText.get(2));
        subText.setText(expandedListText.get(0));
        marksText.setText(expandedListText.get(1));

        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return markses.get(listPosition).whereLiesMarks.size();
    }

    @Override
    public Object getGroup(int listPosition) {

        ArrayList<String> arrayList= new ArrayList<String>();
        arrayList.add(titles.get(2*listPosition));
        arrayList.add(titles.get(2*listPosition+1));
        if(oldTitles!=null&&oldTitles.size()>2*listPosition+1)
        {
            if(arrayList.get(1).equals(oldTitles.get(2*listPosition+1)))
                arrayList.add("");
            else
                arrayList.add("New");
        }
        else
            arrayList.add("");
        return arrayList;
    }

    @Override
    public int getGroupCount() {
        return markses.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        //This is view
        ArrayList<String> listTitle = (ArrayList<String>) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.itemText);
        TextView marksTextView = (TextView) convertView
                .findViewById(R.id.marksText);
        TextView redDotTitle = (TextView) convertView
                .findViewById(R.id.redDot);
        redDotTitle.setText(listTitle.get(2));
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle.get(0));
        marksTextView.setTypeface(null, Typeface.BOLD);
        marksTextView.setText(listTitle.get(1));

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}

