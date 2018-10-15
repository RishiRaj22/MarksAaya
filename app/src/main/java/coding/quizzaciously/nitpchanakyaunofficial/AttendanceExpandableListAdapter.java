package coding.quizzaciously.nitpchanakyaunofficial;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import nitpchankyaunofficial.R;

import coding.quizzaciously.nitpchanakyaunofficial.datahandler.SubjectAttendanceValue;

/**
 * Created by Raj on 24-12-2016.
 */

public class AttendanceExpandableListAdapter extends BaseExpandableListAdapter {
        private Context context;
        private List<SubjectAttendanceValue> subjects;
        private List<SubjectAttendanceValue> old;


    public AttendanceExpandableListAdapter(Context context, ArrayList<SubjectAttendanceValue> subjectAttendanceValues, ArrayList<SubjectAttendanceValue> oldSubAtt) {
            this.context = context;
            this.subjects=subjectAttendanceValues;
            this.old=oldSubAtt;
        }


        @Override
        public Object getChild(int listPosition, int expandedListPosition) {
            ArrayList<String> strings=new ArrayList<String>();
            String subTemp=displayAttendance(subjects.get(listPosition).getChildAt(expandedListPosition).getAttendedClasses(),subjects.get(listPosition).getChildAt(expandedListPosition).getTotalClasses());
            strings.add(subjects.get(listPosition).getChildAt(expandedListPosition).getName());
            strings.add(subTemp);
            if(old!=null&&old.size()>listPosition&&old.get(listPosition).size()>expandedListPosition)
            {
                String oldTemp=displayAttendance(old.get(listPosition).getChildAt(expandedListPosition).getAttendedClasses(),old.get(listPosition).getChildAt(expandedListPosition).getTotalClasses());
                strings.add(subTemp.equals(oldTemp)?"":"New");
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

            TextView redDot = (TextView) convertView
                    .findViewById(R.id.redDot);

            subText.setText(expandedListText.get(0));
            marksText.setText(expandedListText.get(1));
            redDot.setText(expandedListText.get(2));
            return convertView;
        }

        @Override
        public int getChildrenCount(int listPosition) {
            return subjects.get(listPosition).size();
        }

        @Override
        public Object getGroup(int listPosition) {

            ArrayList<String> arrayList= new ArrayList<String>();
            arrayList.add(subjects.get(listPosition).getName());
            String stemp=displayAttendance(subjects.get(listPosition).getAttendedClasses(),subjects.get(listPosition).getTotalClasses());
            arrayList.add(stemp);
            if(old!=null&&old.size()>listPosition)
            {
                String otemp=displayAttendance(old.get(listPosition).getAttendedClasses(),old.get(listPosition).getTotalClasses());
                arrayList.add(stemp.equals(otemp)?"":"New");
            }
            else
                arrayList.add("");
            return arrayList;
        }

    private String displayAttendance(int attendedClasses, int totalClasses) {
        String string= new DecimalFormat("000.00").format((float)(attendedClasses)/(float)(totalClasses)*100);
        return String.format("%02d/%02d (%s%%)",attendedClasses,totalClasses,string);
    }

    @Override
        public int getGroupCount() {
            return subjects.size();
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
            TextView redDotTextView = (TextView) convertView
                    .findViewById(R.id.redDot);
            listTitleTextView.setTypeface(null, Typeface.BOLD);
            listTitleTextView.setText(listTitle.get(0));
            marksTextView.setTypeface(null, Typeface.BOLD);
            marksTextView.setText(listTitle.get(1));
            redDotTextView.setText(listTitle.get(2));


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
