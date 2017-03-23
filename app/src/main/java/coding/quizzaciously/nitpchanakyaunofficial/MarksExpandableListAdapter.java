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

import coding.quizzaciously.nitpchanakyaunofficial.datahandler.Marks;

import nitpchankyaunofficial.R;


public class MarksExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> titles;
    private List<Marks> markses;

    public MarksExpandableListAdapter(Context context, ArrayList<Marks> marks) {
        this.context = context;
        titles=new ArrayList<String>();
        markses=new ArrayList<Marks>();
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
        Marks tempMark=markses.get(listPosition);
        ArrayList<String> strings=new ArrayList<String>();
        strings.add(Marks.getType().get(expandedListPosition));
        Object tempObj=(tempMark.getFieldValues().get(expandedListPosition));
        if(tempObj instanceof String)
            strings.add((String) tempMark.getFieldValues().get(expandedListPosition));
        if(tempObj instanceof Float)
            strings.add(String.valueOf((Float)tempObj));
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

