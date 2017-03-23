package coding.quizzaciously.nitpchanakyaunofficial;

import org.junit.Test;

import java.util.ArrayList;

import coding.quizzaciously.nitpchanakyaunofficial.datahandler.SubjectAttendanceValue;
import coding.quizzaciously.nitpchanakyaunofficial.datahandler.processors.AttendanceTableProcessor;
import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.MarksError;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void checkMarks()
    {
        AttendanceTableProcessor attendanceTableProcessor=new AttendanceTableProcessor();
        String str="\n" +
                "\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head><title>\n" +
                "\tChanakya :: Marks Entry Details\n" +
                "</title><link href=\"CSS/StyleSheet2.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
                "\n" +
                "    <script language=\"Javascript\">\n" +
                "    function E()\n" +
                "    { \n" +
                "        if(event.keyCode==13)  \n" +
                "        {\n" +
                "            event.keyCode=9; \n" +
                "        }\n" +
                "    }\n" +
                "    \n" +
                "   function SetBg(txt)\n" +
                "   {\n" +
                "        txt.style.backgroundColor='#ffff99';\n" +
                "    }\n" +
                "   function UnSetBg(txt)\n" +
                "   {\n" +
                "        txt.style.backgroundColor='white';\n" +
                "   }\n" +
                "\n" +
                "   \n" +
                "   \n" +
                "//   function Close()\n" +
                "//   {\n" +
                "//   \n" +
                "//    spyWin = open('WindowClose.aspx','WindowClose','width=100,height=100,left=100,top=0,status=0');\n" +
                "//    WindowClose.blur();\n" +
                "//  }\n" +
                "\n" +
                "    \n" +
                "    </script>\n" +
                "<style type=\"text/css\">\n" +
                ".cellpad{\n" +
                "color:blue;\n" +
                "padding:5px;\n" +
                "}\n" +
                "\n" +
                ".gv{\n" +
                "MARGIN:auto; BACKGROUND-COLOR: #d3f0d3; \n" +
                "}\n" +
                "</style>\n" +
                "    <style type=\"text/css\">\n" +
                ".Grid td\n" +
                "        {\n" +
                "            background-color: #A1DCF2;\n" +
                "            color: black;\n" +
                "            font-size: 10pt;\n" +
                "            line-height:200%\n" +
                "        }\n" +
                "        .Grid th\n" +
                "        {\n" +
                "            background-color: #3AC0F2;\n" +
                "            color: White;\n" +
                "            font-size: 10pt;\n" +
                "            line-height:200%\n" +
                "        }\n" +
                "        .ChildGrid td\n" +
                "        {\n" +
                "            background-color: #eee !important;\n" +
                "            color: black;\n" +
                "            font-size: 10pt;\n" +
                "            line-height:200%\n" +
                "        }\n" +
                "        .ChildGrid th\n" +
                "        {\n" +
                "            background-color: #6C6C6C !important;\n" +
                "            color: White;\n" +
                "            font-size: 10pt;\n" +
                "            line-height:200%\n" +
                "        }\n" +
                "</style>\n" +
                "\n" +
                "    <script language=\"Javascript\">\n" +
                "\n" +
                "function closeSession()\n" +
                "{\n" +
                "\n" +
                "//alert(\"abc\");\n" +
                " //capturing ALT + F4\n" +
                " if (event.altKey==true && event.keyCode==0 )\n" +
                "    {\n" +
                "  //alert(\"closed1 Alt+F4\")\n" +
                "  spyWin = open('WindowClose.aspx','WindowClose','width=100,height=100,left=100,top=0,status=0');\n" +
                "  WindowClose.blur();\n" +
                "   //    document.location.href=\"SessionEndFile.asp\";\n" +
                "     //  window.close();\n" +
                "    }\n" +
                "\n" +
                "//alert(window.document.body.offsetWidth);\n" +
                "//alert(window.event.clientX);\n" +
                "//alert(window.event.clientY);\n" +
                "\n" +
                "var Xwidth=window.document.body.offsetWidth+window.event.clientX\n" +
                "var YHeight=window.event.clientY\n" +
                "   \n" +
                "//alert (Xwidth); \n" +
                "//alert(YHeight);\n" +
                "\n" +
                "   if(Xwidth<=30&&YHeight<0)\n" +
                "    {\n" +
                "    //   alert(\"closed2 By X\")\n" +
                "    \n" +
                "    spyWin = open('WindowClose.aspx','WindowClose','width=100,height=100,left=100,top=0,status=0');\n" +
                "    WindowClose.blur();\n" +
                "      //document.location.href=\"SessionEndFile.asp\";\n" +
                "      //window.close();\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "}\n" +
                "//window.onbeforeunload=closeSession\n" +
                "\n" +
                "//or we can use body(unload) method\n" +
                "\n" +
                "\n" +
                "\n" +
                "    </script>\n" +
                "\n" +
                "<style type=\"text/css\">\n" +
                "\t.ctl00_studentMenu_0 { font-size:Small;font-weight:normal;text-decoration:none; }\n" +
                "\t.ctl00_studentMenu_1 { color:Black;font-family:Verdana;font-size:Small;font-weight:normal; }\n" +
                "\t.ctl00_studentMenu_2 { padding:0px 5px 0px 5px; }\n" +
                "\t.ctl00_studentMenu_3 { color:Blue;font-size:Medium;font-weight:bold; }\n" +
                "\t.ctl00_studentMenu_4 {  }\n" +
                "\t.ctl00_studentMenu_5 { color:#FF8000;font-family:Tahoma;font-weight:bold; }\n" +
                "\t.ctl00_studentMenu_6 {  }\n" +
                "\t.ctl00_studentMenu_7 { color:Maroon;font-family:Tahoma;font-weight:normal;font-style:normal; }\n" +
                "\t.ctl00_studentMenu_8 {  }\n" +
                "\t.ctl00_studentMenu_9 { color:#5555DD;text-decoration:underline; }\n" +
                "\t.ctl00_studentMenu_10 { padding:0px 0px 0px 0px; }\n" +
                "\t.ctl00_studentMenu_11 { color:#5555DD;text-decoration:underline; }\n" +
                "\t.ctl00_studentMenu_12 { color:#5555DD;text-decoration:underline; }\n" +
                "\n" +
                "</style></head>\n" +
                "<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" onunload=\"closeSession()\">\n" +
                "    <form name=\"aspnetForm\" method=\"post\" action=\"AttendanceStatus.aspx\" id=\"aspnetForm\">\n" +
                "<div>\n" +
                "<input type=\"hidden\" name=\"__EVENTTARGET\" id=\"__EVENTTARGET\" value=\"\" />\n" +
                "<input type=\"hidden\" name=\"__EVENTARGUMENT\" id=\"__EVENTARGUMENT\" value=\"\" />\n" +
                "<input type=\"hidden\" name=\"ctl00_studentMenu_ExpandState\" id=\"ctl00_studentMenu_ExpandState\" value=\"eenennnenennnen\" />\n" +
                "<input type=\"hidden\" name=\"ctl00_studentMenu_SelectedNode\" id=\"ctl00_studentMenu_SelectedNode\" value=\"\" />\n" +
                "<input type=\"hidden\" name=\"ctl00_studentMenu_PopulateLog\" id=\"ctl00_studentMenu_PopulateLog\" value=\"\" />\n" +
                "<input type=\"hidden\" name=\"__LASTFOCUS\" id=\"__LASTFOCUS\" value=\"\" />\n" +
                "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"VHI+uoVQfFqv5M9wUDvfDkOLKluQBZI59mr7doD0VImZ8S8hOoY6gvUejwRiyYUcu+gJ+TdC6oHDbi/flFybfLVPklCJkEdKM4N8G8JDMWA+cBdbtq3cKNDDZD1yfZgJfliDeE4VM/oST4fbwH5PybwMZmAYcH/I8fRNfldUK7wvdppZMXexrt2tOi3LammUo/Q1DWnn6uiyc2ENK9WiWjwdOestnOQEBmRu6OrE7xzxy5RmxNerGeuhHHQ8vkY3szs+wmWLSdudquEHxfGKGBkQzCNYGybo4v70D9PX0FRhb4m/fVkg9xppNS2FswUJaphgLpbXvqArr08NVUYHABTyTZft/bpJfRGe1AJnotzJtrLfZ9YarqEwZx30KcZQGWG6w1fxNSy4XpOGd3+G7coGJO0+tafmHi4a8vdXa8MGvEbfoL5EDjqUr5Uf8jPFQr17hrnj2e5aU3oPYgGwTsat03oAMj2Y9WOF48MkK3H4zZNW6Ugu4lot4vVQefO1DiMbbxySGVeOOW31lwb4aLinC5Ug2XmPH1Sh0g5aoTfdKCoN9ED2tCuaCGspUPR0PmZW+dnIUQk4d4ns6gizQUF9qIrIMVDXwruaVa601d6LfA0PaZpYOlXgJtDWoicGkbFLNzIzntlQkK7e+zzsNBMyU3ONzHQSdJnZ4o8Xc1lijbY2ov48HjYYnVflAcQm7tFZ6BPxj7C+oPceuB+y80xmEgNe6XE5XWasDHjlnk0SCC6RBKuvQq6xw02J+pdyUi39w7bumis14X49JMWVuXH4OmP92y9XokqrhcfGRSdMPpt+wJTICoysGOJ3CA54y0iIjAdn4/4OPqNJfVSOiwsy3NnK6uogk4jFKl9bSTO6prcKqxiUKj9lUUcZuNpDnNxIJ3eeAtJ9EZfcmhXa0nvSnUyjBWZOg4P8PD32hp69Y54O1/+w5FVkQvSFIj5azZk76VpOwI2+iPfRLoWRd9SayFvwG5CkIcfyDKV1doPVwrfos9/7trRTNLAWjj6g0ySIZNOOFGFTeqoMIBZ7ic7Ukpbbkecy8Gs4vPyyf2wsOAOHNIrNYgP5yfS+47/UjIfpqPgcf3lbrOTjAaI1wpY8xtio0vhY23l4FTAImRcH1Y6M9Zgt/qWUeQFDfkXE403E67p9LTEl6OrA5Bo09IUSjMbkgk0RwZkfp4B2vQRB+qEVAy6tu0ivEgxWh20RxbrhPbG+E7Q2bMpsK9P5Sg2Kp2RHfIYKAuqR/Nvn37I7sNAxrP7+bseKsr6bRr1HOb9+8u1sJnXKkwXbkrAbmlGHDyw=\" />\n" +
                "</div>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "//<![CDATA[\n" +
                "var theForm = document.forms['aspnetForm'];\n" +
                "if (!theForm) {\n" +
                "    theForm = document.aspnetForm;\n" +
                "}\n" +
                "function __doPostBack(eventTarget, eventArgument) {\n" +
                "    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {\n" +
                "        theForm.__EVENTTARGET.value = eventTarget;\n" +
                "        theForm.__EVENTARGUMENT.value = eventArgument;\n" +
                "        theForm.submit();\n" +
                "    }\n" +
                "}\n" +
                "//]]>\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "<script src=\"/WebResource.axd?d=g8ye8i4wSvH4-urLAc6L6et_in1VC_bMxoCmNTBf4N5MLwPLnsaRR2fVOoxM5F_dfl9dorFVF6rTdBHsRMAsP2XhP_I1&amp;t=634259264644828874\" type=\"text/javascript\"></script>\n" +
                "\n" +
                "\n" +
                "<script src=\"/WebResource.axd?d=UQTKeVye0Mwda_LhBPeGvAS0Ac70Kp4TArLwvpH2YoIGPaXbQvgiQytJOxf1RFHdQyeXUvUuR2etf6Vxte3_vCfgDHo1&amp;t=634259264644828874\" type=\"text/javascript\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "//<![CDATA[\n" +
                "\n" +
                "    function TreeView_PopulateNodeDoCallBack(context,param) {\n" +
                "        WebForm_DoCallback(context.data.treeViewID,param,TreeView_ProcessNodeData,context,TreeView_ProcessNodeData,false);\n" +
                "    }\n" +
                "var ctl00_studentMenu_Data = null;//]]>\n" +
                "</script>\n" +
                "\n" +
                "<div>\n" +
                "\n" +
                "\t<input type=\"hidden\" name=\"__VIEWSTATEENCRYPTED\" id=\"__VIEWSTATEENCRYPTED\" value=\"\" />\n" +
                "</div>\n" +
                "        <div>\n" +
                "            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                <tr bgcolor=\"#ff9900\">\n" +
                "                    <td style=\"width: 107px; height: 19px;\">\n" +
                "                        <span id=\"ctl00_LblUnivName\" style=\"display:inline-block;color:Black;font-family:Verdana;font-size:9pt;font-weight:bold;text-decoration:underline;width:300px;\">National Institute Of Technology, Patna</span></td>\n" +
                "                    <td align=\"left\" style=\"height: 19px; width: 318px;\">\n" +
                "                        <span id=\"ctl00_LblUser\" style=\"display:inline-block;color:White;font-family:Verdana;font-size:8pt;font-weight:bold;width:250px;\">Welcome RITU RAJ [ 160303 - Student ] - 24 December, 2016</span>\n" +
                "                    </td>\n" +
                "                    <td align=\"right\" style=\"height: 19px\" width=\"400\">\n" +
                "                        <a href=\"passwordChange.aspx\">\n" +
                "                            <img src=\"Image/chng_password.jpg\" height=\"22\" align=\"middle\" border=\"0\" title=\"Change Password\"\n" +
                "                                id=\"IMG1\" /></a> &nbsp;<a id=\"ctl00_LinkHome\" href=\"javascript:__doPostBack('ctl00$LinkHome','')\" style=\"color:#804040;font-family:Verdana;font-size:Small;font-weight:bold;\">Home</a>&nbsp;\n" +
                "                        &nbsp; &nbsp;&nbsp; &nbsp;<a id=\"ctl00_SignOut\" href=\"javascript:__doPostBack('ctl00$SignOut','')\" style=\"color:#804040;font-family:Verdana;font-size:Small;font-weight:bold;\">Sign Out</a>&nbsp;\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td valign=\"top\" style=\"height: 491px\">\n" +
                "                        &nbsp; &nbsp;&nbsp;\n" +
                "                        <a href=\"#ctl00_studentMenu_SkipLink\"><img alt=\"Skip Navigation Links.\" src=\"/WebResource.axd?d=TJmXrc_uGOS7lp74if24Q3R5v-xZ9HKwVwnfMJmocuxSyC21B-yuv4PleDJN11VG-RGvEin6XfEd6_Jlg9TcY3_en6Q1&amp;t=634259264644828874\" width=\"0\" height=\"0\" style=\"border-width:0px;\" /></a><div id=\"ctl00_studentMenu\" style=\"background-color:SkyBlue;font-size:Small;font-weight:normal;\">\n" +
                "\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td><a id=\"ctl00_studentMenun0\" href=\"javascript:TreeView_ToggleNode(ctl00_studentMenu_Data,0,document.getElementById('ctl00_studentMenun0'),' ',document.getElementById('ctl00_studentMenun0Nodes'))\"><img src=\"/WebResource.axd?d=NWv76NVClh2F5bM2jeXWrdQwZJKL-jhc-eAfveYivhibCx7rOTt4sGei_N5sCiusbzP8kdSpvy2IENzMcmDPiwNbTeQJhFcrQ30lxjY5B-3AJ_HA0&amp;t=634259264644828874\" alt=\"Collapse Activities\" style=\"border-width:0;\" /></a></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_4\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_3\" href=\"javascript:__doPostBack('ctl00$studentMenu','sActivities')\" onclick=\"TreeView_SelectNode(ctl00_studentMenu_Data, this,'ctl00_studentMenut0');\" id=\"ctl00_studentMenut0\">Activities</a></td>\n" +
                "\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t<td></td>\n" +
                "\t\t</tr>\n" +
                "\t</table><div id=\"ctl00_studentMenun0Nodes\" style=\"display:block;\">\n" +
                "\t\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr><tr>\n" +
                "\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><a id=\"ctl00_studentMenun1\" href=\"javascript:TreeView_ToggleNode(ctl00_studentMenu_Data,1,document.getElementById('ctl00_studentMenun1'),' ',document.getElementById('ctl00_studentMenun1Nodes'))\"><img src=\"/WebResource.axd?d=NWv76NVClh2F5bM2jeXWrdQwZJKL-jhc-eAfveYivhibCx7rOTt4sGei_N5sCiusbzP8kdSpvy2IENzMcmDPiwNbTeQJhFcrQ30lxjY5B-3AJ_HA0&amp;t=634259264644828874\" alt=\"Collapse Registration\" style=\"border-width:0;\" /></a></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_6\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_5\" href=\"javascript:__doPostBack('ctl00$studentMenu','sActivities\\\\Registration')\" onclick=\"TreeView_SelectNode(ctl00_studentMenu_Data, this,'ctl00_studentMenut1');\" id=\"ctl00_studentMenut1\">Registration</a></td>\n" +
                "\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</table><div id=\"ctl00_studentMenun1Nodes\" style=\"display:block;\">\n" +
                "\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr><tr>\n" +
                "\t\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><div style=\"width:20px;height:1px\"></div></td><td><img src=\"/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&amp;t=634259264644828874\" alt=\"\" /></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_8\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_7\" href=\"RegistrationEntry.aspx\" id=\"ctl00_studentMenut2\">Admission Form</a></td>\n" +
                "\t\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t</div><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr><tr>\n" +
                "\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><a id=\"ctl00_studentMenun3\" href=\"javascript:TreeView_ToggleNode(ctl00_studentMenu_Data,3,document.getElementById('ctl00_studentMenun3'),' ',document.getElementById('ctl00_studentMenun3Nodes'))\"><img src=\"/WebResource.axd?d=NWv76NVClh2F5bM2jeXWrdQwZJKL-jhc-eAfveYivhibCx7rOTt4sGei_N5sCiusbzP8kdSpvy2IENzMcmDPiwNbTeQJhFcrQ30lxjY5B-3AJ_HA0&amp;t=634259264644828874\" alt=\"Collapse Examination\" style=\"border-width:0;\" /></a></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_6\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_5\" href=\"javascript:__doPostBack('ctl00$studentMenu','sActivities\\\\Examination')\" onclick=\"TreeView_SelectNode(ctl00_studentMenu_Data, this,'ctl00_studentMenut3');\" id=\"ctl00_studentMenut3\">Examination</a></td>\n" +
                "\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</table><div id=\"ctl00_studentMenun3Nodes\" style=\"display:block;\">\n" +
                "\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr><tr>\n" +
                "\t\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><div style=\"width:20px;height:1px\"></div></td><td><img src=\"/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&amp;t=634259264644828874\" alt=\"\" /></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_8\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_7\" href=\"ExamFormEntry.aspx\" id=\"ctl00_studentMenut4\">Registration Form Entry</a></td>\n" +
                "\t\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr><tr>\n" +
                "\t\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><div style=\"width:20px;height:1px\"></div></td><td><img src=\"/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&amp;t=634259264644828874\" alt=\"\" /></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_8\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_7\" href=\"paymenthistory.aspx\" id=\"ctl00_studentMenut5\">Payment History</a></td>\n" +
                "\t\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr><tr>\n" +
                "\t\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><div style=\"width:20px;height:1px\"></div></td><td><img src=\"/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&amp;t=634259264644828874\" alt=\"\" /></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_8\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_7\" href=\"AttendanceStatus.aspx\" id=\"ctl00_studentMenut6\">Attendance Status</a></td>\n" +
                "\t\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t</div><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr><tr>\n" +
                "\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><a id=\"ctl00_studentMenun7\" href=\"javascript:TreeView_ToggleNode(ctl00_studentMenu_Data,7,document.getElementById('ctl00_studentMenun7'),' ',document.getElementById('ctl00_studentMenun7Nodes'))\"><img src=\"/WebResource.axd?d=NWv76NVClh2F5bM2jeXWrdQwZJKL-jhc-eAfveYivhibCx7rOTt4sGei_N5sCiusbzP8kdSpvy2IENzMcmDPiwNbTeQJhFcrQ30lxjY5B-3AJ_HA0&amp;t=634259264644828874\" alt=\"Collapse Admit Card\" style=\"border-width:0;\" /></a></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_6\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_5\" href=\"javascript:__doPostBack('ctl00$studentMenu','sActivities\\\\Result')\" onclick=\"TreeView_SelectNode(ctl00_studentMenu_Data, this,'ctl00_studentMenut7');\" id=\"ctl00_studentMenut7\">Admit Card</a></td>\n" +
                "\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</table><div id=\"ctl00_studentMenun7Nodes\" style=\"display:block;\">\n" +
                "\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr><tr>\n" +
                "\t\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><div style=\"width:20px;height:1px\"></div></td><td><img src=\"/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&amp;t=634259264644828874\" alt=\"\" /></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_8\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_7\" href=\"AdmitCardPrin.aspx\" id=\"ctl00_studentMenut8\">Admit Card</a></td>\n" +
                "\t\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t</div><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr><tr>\n" +
                "\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><a id=\"ctl00_studentMenun9\" href=\"javascript:TreeView_ToggleNode(ctl00_studentMenu_Data,9,document.getElementById('ctl00_studentMenun9'),' ',document.getElementById('ctl00_studentMenun9Nodes'))\"><img src=\"/WebResource.axd?d=NWv76NVClh2F5bM2jeXWrdQwZJKL-jhc-eAfveYivhibCx7rOTt4sGei_N5sCiusbzP8kdSpvy2IENzMcmDPiwNbTeQJhFcrQ30lxjY5B-3AJ_HA0&amp;t=634259264644828874\" alt=\"Collapse Result\" style=\"border-width:0;\" /></a></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_6\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_5\" href=\"javascript:__doPostBack('ctl00$studentMenu','sActivities\\\\Result')\" onclick=\"TreeView_SelectNode(ctl00_studentMenu_Data, this,'ctl00_studentMenut9');\" id=\"ctl00_studentMenut9\">Result</a></td>\n" +
                "\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</table><div id=\"ctl00_studentMenun9Nodes\" style=\"display:block;\">\n" +
                "\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr><tr>\n" +
                "\t\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><div style=\"width:20px;height:1px\"></div></td><td><img src=\"/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&amp;t=634259264644828874\" alt=\"\" /></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_8\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_7\" href=\"gradeCardPrint.aspx\" id=\"ctl00_studentMenut10\">Provisional Grade Card</a></td>\n" +
                "\t\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr><tr>\n" +
                "\t\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><div style=\"width:20px;height:1px\"></div></td><td><img src=\"/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&amp;t=634259264644828874\" alt=\"\" /></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_8\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_7\" href=\"marksstatus.aspx\" id=\"ctl00_studentMenut11\">Verify Latest Marks</a></td>\n" +
                "\t\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr><tr>\n" +
                "\t\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><div style=\"width:20px;height:1px\"></div></td><td><img src=\"/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&amp;t=634259264644828874\" alt=\"\" /></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_8\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_7\" href=\"trmarksstatus.aspx\" id=\"ctl00_studentMenut12\">Academic Details</a></td>\n" +
                "\t\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t</div><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr><tr>\n" +
                "\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><a id=\"ctl00_studentMenun13\" href=\"javascript:TreeView_ToggleNode(ctl00_studentMenu_Data,13,document.getElementById('ctl00_studentMenun13'),' ',document.getElementById('ctl00_studentMenun13Nodes'))\"><img src=\"/WebResource.axd?d=NWv76NVClh2F5bM2jeXWrdQwZJKL-jhc-eAfveYivhibCx7rOTt4sGei_N5sCiusbzP8kdSpvy2IENzMcmDPiwNbTeQJhFcrQ30lxjY5B-3AJ_HA0&amp;t=634259264644828874\" alt=\"Collapse Feedback\" style=\"border-width:0;\" /></a></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_6\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_5\" href=\"javascript:__doPostBack('ctl00$studentMenu','sActivities\\\\Feedback')\" onclick=\"TreeView_SelectNode(ctl00_studentMenu_Data, this,'ctl00_studentMenut13');\" id=\"ctl00_studentMenut13\">Feedback</a></td>\n" +
                "\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t<td></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</table><div id=\"ctl00_studentMenun13Nodes\" style=\"display:block;\">\n" +
                "\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"border-width:0;\">\n" +
                "\t\t\t\t<tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr><tr>\n" +
                "\t\t\t\t\t<td><div style=\"width:20px;height:1px\"></div></td><td><div style=\"width:20px;height:1px\"></div></td><td><img src=\"/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&amp;t=634259264644828874\" alt=\"\" /></td><td class=\"ctl00_studentMenu_2 ctl00_studentMenu_8\" onmouseover=\"TreeView_HoverNode(ctl00_studentMenu_Data, this)\" onmouseout=\"TreeView_UnhoverNode(this)\" style=\"white-space:nowrap;\"><a class=\"ctl00_studentMenu_0 ctl00_studentMenu_1 ctl00_studentMenu_7\" href=\"StudentFeedback.aspx\" id=\"ctl00_studentMenut14\">Student Feedback Form</a></td>\n" +
                "\t\t\t\t</tr><tr style=\"height:0px;\">\n" +
                "\t\t\t\t\t<td></td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div><a id=\"ctl00_studentMenu_SkipLink\"></a>\n" +
                "                        &nbsp; &nbsp;&nbsp; &nbsp;\n" +
                "                        \n" +
                "                        \n" +
                "                        \n" +
                "                        <br />\n" +
                "                        <br />\n" +
                "                        <img id=\"ctl00_Studentdp\" tabindex=\"1\" src=\"\" align=\"bottom\" style=\"border-color:#669999;border-width:1px;border-style:Solid;height:104px;width:107px;\" /></td>\n" +
                "                    <td width=\"690\" align=\"left\" valign=\"top\" colspan=\"2\" style=\"height: 491px\">\n" +
                "                        \n" +
                "\n" +
                "    <script type=\"text/javascript\">\n" +
                "    function clickEnter(obj, event) {\n" +
                "        var keyCode;\n" +
                "        if (event.keyCode > 0) {\n" +
                "            keyCode = event.keyCode;\n" +
                "        }\n" +
                "        else if (event.which > 0) {\n" +
                "            keyCode = event.which;\n" +
                "        }\n" +
                "        else {\n" +
                "            keycode = event.charCode;\n" +
                "        }\n" +
                "        if (keyCode == 9) {\n" +
                "            document.getElementById(obj).focus();\n" +
                "            return false;\n" +
                "        }\n" +
                "        else {\n" +
                "            return true;\n" +
                "        }\n" +
                "    }\n" +
                "    </script>\n" +
                "  <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "    $(\"[src*=plus]\").live(\"click\", function () {\n" +
                "        $(this).closest(\"tr\").after(\"<tr><td></td><td colspan = '999'>\" + $(this).next().html() + \"</td></tr>\")\n" +
                "        $(this).attr(\"src\", \"Image/minus.gif\");\n" +
                "    });\n" +
                "    $(\"[src*=minus]\").live(\"click\", function () {\n" +
                "        $(this).attr(\"src\", \"Image/plus.gif\");\n" +
                "        $(this).closest(\"tr\").next().remove();\n" +
                "    });\n" +
                "</script>\n" +
                "    \n" +
                "    \n" +
                "    <table class=\"main_form\" style=\"width: 100%\">\n" +
                "        <tr>\n" +
                "            <td align=\"left\" valign=\"top\" style=\"height: 1096px\">\n" +
                "                <table width=\"100%\">\n" +
                "                    <tr class=\"block1\">\n" +
                "                        <td align=\"left\" style=\"height: 26px\">\n" +
                "                            <strong>Exam-Session:</strong>\n" +
                "                            <select name=\"ctl00$ContentPlaceHolder2$ddlexamsession\" onchange=\"javascript:setTimeout('__doPostBack(\\'ctl00$ContentPlaceHolder2$ddlexamsession\\',\\'\\')', 0)\" id=\"ctl00_ContentPlaceHolder2_ddlexamsession\" onblur=\"UnSetBg(this)\" onkeydown=\"E();\" onfocus=\"SetBg(this)\" style=\"color:#0000C0;background-color:White;border-color:#004000;border-width:1px;border-style:Solid;font-family:verdana;font-size:Small;width:150px;\">\n" +
                "\t<option value=\"00\">--Select--</option>\n" +
                "\t<option value=\"JUL-DEC_2016\">JUL-DEC_2016</option>\n" +
                "\t<option value=\"ADT-SEP_2016\">ADT-SEP_2016</option>\n" +
                "\t<option selected=\"selected\" value=\"JAN-JUN_2016\">JAN-JUN_2016</option>\n" +
                "\t<option value=\"JUL-DEC_2015\">JUL-DEC_2015</option>\n" +
                "\t<option value=\"JUL-DEC_2014\">JUL-DEC_2014</option>\n" +
                "\n" +
                "</select>\n" +
                "                        </td>\n" +
                "                        <td colspan=\"2\" align=\"left\" style=\"height: 26px\">\n" +
                "                            <strong>Semester:</strong>\n" +
                "                            <select name=\"ctl00$ContentPlaceHolder2$Streampart\" onchange=\"javascript:setTimeout('__doPostBack(\\'ctl00$ContentPlaceHolder2$Streampart\\',\\'\\')', 0)\" id=\"ctl00_ContentPlaceHolder2_Streampart\" onblur=\"UnSetBg(this)\" onkeydown=\"E();\" onfocus=\"SetBg(this)\" style=\"color:#0000C0;background-color:White;border-color:#004000;border-width:1px;border-style:Solid;font-family:verdana;font-size:Small;width:150px;\">\n" +
                "\t<option selected=\"selected\" value=\"00\">--Select--</option>\n" +
                "\n" +
                "</select>\n" +
                "                            <input type=\"submit\" name=\"ctl00$ContentPlaceHolder2$btnsumit\" value=\"Submit\" id=\"ctl00_ContentPlaceHolder2_btnsumit\" style=\"width:71px;\" />\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"block1\">\n" +
                "                        <td>\n" +
                "                        </td>\n" +
                "                        <td colspan=\"2\">\n" +
                "                            &nbsp;\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"block1\">\n" +
                "                        <td colspan=\"3\">\n" +
                "                            <div>\n" +
                "                                <div>\n" +
                "\n" +
                "</div>\n" +
                "                            </div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 100%\" align=\"center\" colspan=\"3\">\n" +
                "                        <strong><span style=\"color: #ffffff\">\n" +
                "                            <img src=\"image/footer.jpg\" width=\"990\" /></span></strong></td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "    \n" +
                "<script type=\"text/javascript\">\n" +
                "//<![CDATA[\n" +
                "var ctl00_studentMenu_ImageArray =  new Array('', '', '', '/WebResource.axd?d=AiZAn6kqBo4q0NEKTBIYTiAtnZEesERJ2j07iKlDmgWxY1YzTy9vAkoINCfy08jkkWnBfWGNLWJy8Mqxrc507IFihGsnGQoHEmlNDy03tIeWC6wI0&t=634259264644828874', '/WebResource.axd?d=qJn5FtxHWAGQPEFEBaf3BKrX-uwkexc0Jz4Aui_NfqEvmAr4xSg5J_J6rTogvI757ZnUKbrxZZrCMLieOVKr2nhSZMDDL3-eTy-FDov8--K2LDKQ0&t=634259264644828874', '/WebResource.axd?d=NWv76NVClh2F5bM2jeXWrdQwZJKL-jhc-eAfveYivhibCx7rOTt4sGei_N5sCiusbzP8kdSpvy2IENzMcmDPiwNbTeQJhFcrQ30lxjY5B-3AJ_HA0&t=634259264644828874');\n" +
                "//]]>\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "//<![CDATA[\n" +
                "\n" +
                "WebForm_InitCallback();var ctl00_studentMenu_Data = new Object();\n" +
                "ctl00_studentMenu_Data.images = ctl00_studentMenu_ImageArray;\n" +
                "ctl00_studentMenu_Data.collapseToolTip = \"Collapse {0}\";\n" +
                "ctl00_studentMenu_Data.expandToolTip = \"Expand {0}\";\n" +
                "ctl00_studentMenu_Data.expandState = theForm.elements['ctl00_studentMenu_ExpandState'];\n" +
                "ctl00_studentMenu_Data.selectedNodeID = theForm.elements['ctl00_studentMenu_SelectedNode'];\n" +
                "ctl00_studentMenu_Data.hoverClass = 'ctl00_studentMenu_12';\n" +
                "ctl00_studentMenu_Data.hoverHyperLinkClass = 'ctl00_studentMenu_11';\n" +
                "for (var i=0;i<6;i++) {\n" +
                "var preLoad = new Image();\n" +
                "if (ctl00_studentMenu_ImageArray[i].length > 0)\n" +
                "preLoad.src = ctl00_studentMenu_ImageArray[i];\n" +
                "}\n" +
                "ctl00_studentMenu_Data.lastIndex = 15;\n" +
                "ctl00_studentMenu_Data.populateLog = theForm.elements['ctl00_studentMenu_PopulateLog'];\n" +
                "ctl00_studentMenu_Data.treeViewID = 'ctl00$studentMenu';\n" +
                "ctl00_studentMenu_Data.name = 'ctl00_studentMenu_Data';\n" +
                "//]]>\n" +
                "</script>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n";
        ArrayList<SubjectAttendanceValue> subjectAttendanceValues= null;
        try {
            subjectAttendanceValues = attendanceTableProcessor.fetchFromTable(str);
        } catch (MarksError marksError) {
            System.out.println(marksError.getType());
        }
        for(SubjectAttendanceValue sub: subjectAttendanceValues)
        {
            for(int i=0;i<2;i++) {
                for(int j=0;j<2;j++) {
                    System.out.println(subjectAttendanceValues.get(i).getChildAt(j).getName()+" was name and is "+subjectAttendanceValues.get(i).getChildAt(j).getAttendedClasses());
                }
            }
        }
    }
}