package org.apache.jsp.views.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/views/main/../../jspf/header.jspf");
    _jspx_dependants.add("/views/main/../../jspf/footer.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_scope_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setBundle_basename_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setLocale_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setBundle_basename_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setLocale_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_c_set_var_value_scope_nobody.release();
    _jspx_tagPool_fmt_message_key_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_fmt_setBundle_basename_nobody.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_fmt_setLocale_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write(" ");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write('\n');
      out.write('\n');
      if (_jspx_meth_fmt_setLocale_0(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_fmt_setBundle_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE Html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"Author\" content=\"Paul Millar\" />\n");
      out.write("\n");
      out.write("        <title>The Home of Renewable Energy</title>\n");
      out.write("        \t\t        \n");
      out.write("        <script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>           \n");
      out.write("        \n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("favicon.ico\" rel=\"shortcut icon\" type=\"image/x-icon\" >\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.cssPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("default.css\" type=\"text/css\" rel=\"stylesheet\"/>   \n");
      out.write("               \n");
      out.write("    </head>\n");
      out.write("        \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"main_container\">                  \n");
      out.write("            <div id=\"main_header_wrapper\">\n");
      out.write("                \n");
      out.write("                <div id=\"header_title_container\"> \n");
      out.write("                    \n");
      out.write("                    <form class=\"floatright\" onchange=\"submit()\">\n");
      out.write("                        <select id=\"language\" name=\"language\" onchange=\"submit()\" class=\"margin_left\">\n");
      out.write("                            <option value=\"en\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${language == 'en' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">English</option>\n");
      out.write("                            <option value=\"ga\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${language == 'ga' ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Gaeilge</option>\n");
      out.write("                        </select>\n");
      out.write("                    </form>\n");
      out.write("                        \n");
      out.write("                    ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("   \n");
      out.write("\n");
      out.write("                    <div class=\"clearfloat\"></div>\n");
      out.write("                    \n");
      out.write("                    <div id=\"widget_navigation\" class=\"widget_navigation floatright\">\n");
      out.write("                        \n");
      out.write("                        <ul id=\"widget_navigation_list\" class=\"shadow navigation_bar\">                            \n");
      out.write("                            <li>\n");
      out.write("                                ");
      if (_jspx_meth_c_choose_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </li>\n");
      out.write("                            ");
      if (_jspx_meth_c_choose_2(_jspx_page_context))
        return;
      out.write("             \n");
      out.write("                            ");
      if (_jspx_meth_c_choose_3(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("                            ");
      if (_jspx_meth_c_choose_4(_jspx_page_context))
        return;
      out.write("                                \n");
      out.write("                  \n");
      out.write("                        </ul>\n");
      out.write("                    </div>                    \n");
      out.write("                </div> \n");
      out.write("                \n");
      out.write("                <div id=\"main_navigation\" class=\"floatright\">\n");
      out.write("                    <ul id=\"main_navigation_list\" class=\"radius shadow navigation_bar\">\n");
      out.write("                        <li class=\"\" id=\"main_navigation_home\">\n");
      out.write("                            <a target=\"_top\" href=\"index.jsp\" class=\"\" id=\"main_navigation_home_link\">\n");
      out.write("                                <span class=\"\" id=\"main_navigation_home_title\">");
      if (_jspx_meth_fmt_message_7(_jspx_page_context))
        return;
      out.write("</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"\" id=\"main_navigation_products\">\n");
      out.write("                            <a target=\"_top\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.categoriesPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"\" id=\"main_navigation_products_link\">\n");
      out.write("                                <span class=\"\" id=\"main_navigation_products_title\">");
      if (_jspx_meth_fmt_message_8(_jspx_page_context))
        return;
      out.write("</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"\" id=\"main_navigation_services\">\n");
      out.write("                            <a target=\"_top\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.servicesPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&key=14\" class=\"\" id=\"main_navigation_services_link\">\n");
      out.write("                                <span class=\"\" id=\"main_navigation_services_title\">");
      if (_jspx_meth_fmt_message_9(_jspx_page_context))
        return;
      out.write("</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"\" id=\"main_navigation_events\">\n");
      out.write("                            <a target=\"_top\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.eventPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"\" id=\"main_navigation_events_link\">\n");
      out.write("                                <span class=\"\" id=\"main_navigation_events_title\">");
      if (_jspx_meth_fmt_message_10(_jspx_page_context))
        return;
      out.write("</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"\" id=\"main_navigation_information\">\n");
      out.write("                            <a target=\"_top\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.informationPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"\" id=\"main_navigation_information_link\">\n");
      out.write("                                <span class=\"\" id=\"main_navigation_information_title\">");
      if (_jspx_meth_fmt_message_11(_jspx_page_context))
        return;
      out.write("</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"\" id=\"main_navigation_gallery\">\n");
      out.write("                            <a target=\"_top\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.galleryPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"\" id=\"main_navigation_gallery_link\">\n");
      out.write("                                <span class=\"\" id=\"main_navigation_gallery_title\">");
      if (_jspx_meth_fmt_message_12(_jspx_page_context))
        return;
      out.write("</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"\" id=\"main_navigation_aboutus\">\n");
      out.write("                            <a target=\"_top\" href=\"aboutus.jsp\" class=\"\" id=\"main_navigation_aboutus_link\">\n");
      out.write("                                <span class=\"\" id=\"main_navigation_aboutus_title\">");
      if (_jspx_meth_fmt_message_13(_jspx_page_context))
        return;
      out.write("</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"\" id=\"main_navigation_contactus\">\n");
      out.write("                            <a target=\"_top\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.contactusPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"\" id=\"main_navigation_contactus_link\">\n");
      out.write("                                <span class=\"\" id=\"main_navigation_contactus_title\">");
      if (_jspx_meth_fmt_message_14(_jspx_page_context))
        return;
      out.write("</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\t\t\t\n");
      out.write("            </div>            \n");
      out.write("\n");
      out.write("            <div id=\"main_content_wrapper\">\n");
      out.write("\n");
      out.write("\n");
      out.write("     \n");
      out.write("\t\t\t\t\n");
      out.write("    <div id=\"billboard\" class=\"radius shadow\">\t\t\t\t\n");
      out.write("        <ul id=\"slider_Content\">\n");
      out.write("            <li>\n");
      out.write("                <a  href=\"http://www.youtube.com/embed/30ttqGYxoFk\"\n");
      out.write("                    class=\"lytebox\" data-lyte-options=\"width:700 height:500\" style=\"width:300px;\"\n");
      out.write("                    id=\"category_video_link\">\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("billboard_media_04.png\" alt=\"Central Heating\" id=\"index_video_link_img\"/>\n");
      out.write("                </a>\n");
      out.write("                <div>\n");
      out.write("                    <span class=\"slidertopspan\">Welcome To Renew Energy</span>\n");
      out.write("                    <span class=\"sliderbottomspan\">Watch this brief introduction video</span>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.categoriesPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("billboard_media_02.jpg\" alt=\"Products\"/></a>\n");
      out.write("                <div>\n");
      out.write("                    <span class=\"slidertopspan\">Solar Plates, Slates & Wind Turbines</span>\n");
      out.write("                    <span class=\"sliderbottomspan\">Residential, commercial, agricultural and maritime solutions</span>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.informationPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("billboard_media_03.jpg\" alt=\"Child and Globe\"/></a>\n");
      out.write("                <div>\n");
      out.write("                    <span class=\"slidertopspan\">Plan For The Future</span>\n");
      out.write("                    <span class=\"sliderbottomspan\">Want to know where to start ?  We have all the information you need ...</span>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("        </ul>\t\t\t\t\n");
      out.write("    </div>\n");
      out.write("                \n");
      out.write("    <div id=\"products_container\" class=\"floatleft radius shadow content_container content_container_w370 content_container_h360 beige_background\" >\n");
      out.write("        <div class=\"content_container_header\">\n");
      out.write("            <span id=\"product_span\">Products</span>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <div style=\"width:200px; float:left;\">\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.categoryPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&key=2\">\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("products_solar_slates.jpg\" alt=\"Solar Slates\" class=\"margin_top_left radius\"/>\n");
      out.write("                    <div class=\"floatright\">\n");
      out.write("                        <span class=\"more_details \">Solar Slates</span>\t\n");
      out.write("                        <img class=\"floatright\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("more_button.png\" alt=\"more\"/>\t\n");
      out.write("                    </div>\t\t\t\t\t\t\n");
      out.write("                </a>\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.categoryPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&key=1\">\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("products_solar_panels.jpg\" alt=\"Solar Panels\" class=\"margin_top_left radius\"/>\n");
      out.write("                    <div class=\"floatright\">\n");
      out.write("                        <span class=\"more_details \">Solar Panels</span>\t\n");
      out.write("                        <img class=\"floatright\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("more_button.png\" alt=\"more\"/>\t\n");
      out.write("                    </div>\t\t\t\t\t\t\n");
      out.write("                </a>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("            </div>\t\t\t\t\t\t\t\n");
      out.write("            <div style=\"width:160px;\">\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.categoryPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&key=3\">\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("products_turbine.jpg\" alt=\"Wind Turbine\" class=\"margin_top_left radius\"/>\n");
      out.write("                    <div class=\"floatright\">\n");
      out.write("                        <span class=\"more_details \">Wind Turbines</span>\t\n");
      out.write("                        <img class=\"floatright\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("more_button.png\" alt=\"more\"/>\t\n");
      out.write("                    </div>\t\t\t\t\t\t\n");
      out.write("                </a>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"events_container\" class=\"floatleft radius shadow content_container content_container_w370 content_container_h360 beige_background\">\n");
      out.write("        <div class=\"content_container_header\">\n");
      out.write("            <span id=\"events_span\">Events</span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"margin\">\n");
      out.write("            <table style=\"width:100%\">\n");
      out.write("                <tr>\n");
      out.write("                    <td rowspan=\"2\" >\n");
      out.write("                        <a href=\"http://www.seai.ie/News_Events/Energy_Show/\" target=\"_blank\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("seai_energyshow.png\" alt=\"Energy Show 2013\"/>\n");
      out.write("                        </a>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("stylish_sun.png\" alt=\"Style Sun\" style=\"margin-left:30px;\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\t\t\t\t\t\t\t\t\n");
      out.write("                        <div class=\"floatright\">\n");
      out.write("                            <a href=\"http://www.seai.ie/News_Events/Energy_Show/\" target=\"_blank\" >\n");
      out.write("                                <span  class=\"more_details\">More Details</span>\t\t\t\t\t\t\t\t\n");
      out.write("                            </a>\n");
      out.write("                            <a href=\"http://www.seai.ie/News_Events/Energy_Show/\" target=\"_blank\" class=\"floatright\">\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("more_button.png\" alt=\"more\"/>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <div id=\"countdownDisplay\" class=\"center\">\n");
      out.write("                <span class=\"slate_text\" style=\"line-height:30px;\">Date: </strong>Wednesday March 12 - Thursday April 13, 2014 - RDS</span>\n");
      out.write("                <span class=\"slate_text\" style=\"line-height:30px;\">Only </span><span id=\"countdown_monthsdata\" class=\"slate_text\"></span> <span id=\"countdown_monthslabel\" class=\"slate_text\"></span><span class=\"slate_text\"> to go </span><strong><span class=\"orange\">&nbsp;JOIN US !!!</span></strong>\n");
      out.write("            </div>\t\t\t\t\t\t\n");
      out.write("            \n");
      out.write("            <div class=\"divider\"></div>\n");
      out.write("            <table style=\"width:100%; top: 10px;\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.eventPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("calendar.jpg\" alt=\"calendar\" class=\"radius floatleft margin_right\"/></a>\n");
      out.write("                    <span  class=\"slate_text\" style=\"display:block; line-height: 20px;\">Find the latest environmental events for your area and nationwide ...</span>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"news_container\" class=\"floatleft content_container radius shadow content_container_w200 content_container_h360 beige_background\">\n");
      out.write("        <div class=\"content_container_header\">\n");
      out.write("            <span id=\"news_span\">News</span>\n");
      out.write("        </div>\n");
      out.write("        <!--http://www.nidirect.gov.uk/index/information-and-services/environment-and-greener-living/energy-wise/energy-efficiency/energy-efficiency-tips.htm-->\n");
      out.write("        <ul id=\"news_list\">\n");
      out.write("            <li>\n");
      out.write("                <a href=\"http://consciouslifenews.com/world-takes-streets-protest-monsanto-gmo/1166666/\" target=\"_blank\">\n");
      out.write("                    <table class=\"news_item_table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_image\" rowspan=\"2\">\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("news.png\" alt=\"news item\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"news_item_info\">\n");
      out.write("                                <span class=\"slate_text\">Street Protests Against<br/> Monsanto & GMO</span>\n");
      out.write("                            </td>                           \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_date\">\n");
      out.write("                                <span>Sun, 12 Oct 2013</span>\n");
      out.write("                            </td>                             \n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </a>                \n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"http://www.nidirect.gov.uk/index/information-and-services/environment-and-greener-living/energy-wise/energy-efficiency/energy-efficiency-tips.htm\" target=\"_blank\">\n");
      out.write("                    <table id=\"news_item_table\" class=\"news_item_table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_image\" rowspan=\"2\">\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("news.png\" alt=\"news item\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"news_item_info\">\n");
      out.write("                                <span class=\"slate_text\">Being energy wise can save you money</span>\n");
      out.write("                            </td>                           \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_date\">\n");
      out.write("                                <span>Sun, 12 Oct 2013</span>\n");
      out.write("                            </td>                             \n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </a>                \n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"http://www.nidirect.gov.uk/index/information-and-services/environment-and-greener-living/energy-wise/energy-saving-grants/renewable-heat-grants/renewable-heat-incentive.htm\" target=\"_blank\">\n");
      out.write("                    <table id=\"news_item_table\" class=\"news_item_table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_image\" rowspan=\"2\">\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("news.png\" alt=\"news item\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"news_item_info\">\n");
      out.write("                                <span class=\"slate_text\">New Heat Incentive Scheme (NI)</span>\n");
      out.write("                            </td>                           \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_date\">\n");
      out.write("                                <span>Thu, 29 Aug 2013</span>\n");
      out.write("                            </td>                             \n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </a>                \n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"http://www.nidirect.gov.uk/index/information-and-services/environment-and-greener-living/the-wider-environment/being-green-in-the-community-and-at-work.htm\" target=\"_blank\">\n");
      out.write("                    <table id=\"news_item_table\" class=\"news_item_table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_image\" rowspan=\"2\">\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("news.png\" alt=\"news item\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"news_item_info\">\n");
      out.write("                                <span class=\"slate_text\">Being Green In Your Community</span>\n");
      out.write("                            </td>                           \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_date\">\n");
      out.write("                                <span>Wed, 11 Sept 2013</span>\n");
      out.write("                            </td>                             \n");
      out.write("                        </tr>\n");
      out.write("                    </table>                        \n");
      out.write("                </a>                \n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"http://www.seai.ie/Publications/Statistics_Publications/Fuel_Cost_Comparison/\" target=\"_blank\">\n");
      out.write("                    <table id=\"news_item_table\" class=\"news_item_table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_image\" rowspan=\"2\">\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("news.png\" alt=\"news item\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"news_item_info\">\n");
      out.write("                                <span class=\"slate_text\">Fuel Cost Comparisons</span>\n");
      out.write("                            </td>                           \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_date\">\n");
      out.write("                                <span>Thu, 10 Oct 2013</span>\n");
      out.write("                            </td>                             \n");
      out.write("                        </tr>\n");
      out.write("                    </table>   \n");
      out.write("                </a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"http://www.seai.ie/Power_of_One/Heat_Your_Home_For_Less/\" target=\"_blank\">\n");
      out.write("                    <table id=\"news_item_table\" class=\"news_item_table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_image\" rowspan=\"2\">\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("news.png\" alt=\"news item\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"news_item_info\">\n");
      out.write("                                <span class=\"slate_text\">Heat your home for less</span>\n");
      out.write("                            </td>                           \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_date\">\n");
      out.write("                                <span>Fri, 14 Sep 2012</span>\n");
      out.write("                            </td>                             \n");
      out.write("                        </tr>\n");
      out.write("                    </table>                          \n");
      out.write("                </a>                \n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"http://www.nidirect.gov.uk/news-aug13-grant-available-to-replace-old-boilers\" target=\"_blank\">\n");
      out.write("                    <table id=\"news_item_table\" class=\"news_item_table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_image\" rowspan=\"2\">\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("news.png\" alt=\"news item\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"news_item_info\">\n");
      out.write("                                <span class=\"slate_text\">Boiler replacement scheme launched (NI)</span>\n");
      out.write("                            </td>                           \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_date\">\n");
      out.write("                                <span>Mon, 3 Sep 2012</span>\n");
      out.write("                            </td>                             \n");
      out.write("                        </tr>\n");
      out.write("                    </table>                      \n");
      out.write("                </a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"http://www.seai.ie/Power_of_One/Energy_Saving/Electricity_Saving_Tips/\" target=\"_blank\">\n");
      out.write("                    <table id=\"news_item_table\" class=\"news_item_table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_image\" rowspan=\"2\">\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("news.png\" alt=\"news item\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"news_item_info\">\n");
      out.write("                                <span class=\"slate_text\">Electricity Savings Tips</span>\n");
      out.write("                            </td>                           \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"news_item_date\">\n");
      out.write("                                <span>Mon, 5 Nov 2012</span>\n");
      out.write("                            </td>                             \n");
      out.write("                        </tr>\n");
      out.write("                    </table>                          \n");
      out.write("                </a>                \n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\t\t\t                                        \n");
      out.write("\n");
      out.write("            </div>            \n");
      out.write("            <div id=\"main_footer_wrapper\" class=\"radius shadow\">\n");
      out.write("                <div class=\"footer_container\" id=\"footer_Gallery_container\">\n");
      out.write("                    <a target=\"_top\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.galleryPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"footer_header_link\" id=\"footer_Gallery_header_link\">\n");
      out.write("                        <span class=\"footer_link_span\" id=\"footer_Gallery_link_span\">Gallery</span>\n");
      out.write("                    </a><span class=\"footer_content\" id=\"footer_Gallery_content\">\n");
      out.write("                    <a target=\"_top\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.galleryPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"footer_image_link\" id=\"footer_Gallery_image_link\">\n");
      out.write("                        <img alt=\"Gallery\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("gallery_link.png\" class=\"footer_image radius\" id=\"footer_Gallery_image_\">\n");
      out.write("                    </a></span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer_container\" id=\"footer_Contact_container\">\n");
      out.write("                    <a target=\"_top\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.contactusPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"footer_header_link\" id=\"footer_Contact_header_link\">\n");
      out.write("                        <span class=\"footer_link_span\" id=\"footer_Contact_link_span\">Contact</span>\n");
      out.write("                    </a>\n");
      out.write("                    <span class=\"footer_content\" id=\"footer_Contact_content\">\n");
      out.write("                        <table id=\"contact_footer_table\">\n");
      out.write("                            <tr>\n");
      out.write("                                <th>\n");
      out.write("                                    <span class=\"contact_span\">Phone</span>\n");
      out.write("                                    <span class=\"contact_span small_text\">(Rep. of Ireland)</span>\n");
      out.write("                                </th>\n");
      out.write("                                <td>\n");
      out.write("                                    <span class=\"contact_span contact_data\">+353 42-9356789</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>\n");
      out.write("                                    <span class=\"contact_span\">Phone</span>\n");
      out.write("                                    <span class=\"contact_span small_text\">(N. Ireland)</span>\n");
      out.write("                                </th>\n");
      out.write("                                <td>\n");
      out.write("                                    <span class=\"contact_span contact_data\">+048 30-5556789</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>\n");
      out.write("                                    <span class=\"contact_span\">Mobile</span>\n");
      out.write("                                </th>\n");
      out.write("                                <td>\n");
      out.write("                                    <span class=\"contact_span contact_data\">+353 86-6889456</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>\n");
      out.write("                                    <span class=\"contact_span\">Fax</span>\n");
      out.write("                                </th>\n");
      out.write("                                <td>\n");
      out.write("                                    <span class=\"contact_span contact_data\">+353 42-9356788</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>\n");
      out.write("                                    <span class=\"contact_span\">Email</span>\n");
      out.write("                                </th>\n");
      out.write("                                <td>\n");
      out.write("                                    <span class=\"contact_span contact_data\">info@renewireland.ie</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>            \n");
      out.write("                    </span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer_container\" id=\"footer_facebook_container\">\n");
      out.write("                    <a target=\"_blank\" href=\"https://www.facebook.com/groups/168884449977512/\" class=\"floatright\" id=\"footer_facebook_image_link\">\n");
      out.write("                        <img alt=\"facebook\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.generalImagesPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("facebooklogo.png\" class=\"footer_image radius\" id=\"footer_facebook_image_\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">       \n");
      out.write("    document.title = 'The Home Of Renewable Energy';   \n");
      out.write("</script>  \n");
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.jsPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("jsDate.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.jsPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("animation.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.lyteboxPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("lytebox.js\" type=\"text/javascript\"></script>\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.lyteboxPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("lytebox.css\" type=\"text/css\" rel=\"stylesheet\"/>  ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("language");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_0.setScope("session");
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_fmt_setLocale_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setLocale
    org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag _jspx_th_fmt_setLocale_0 = (org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag) _jspx_tagPool_fmt_setLocale_value_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag.class);
    _jspx_th_fmt_setLocale_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_setLocale_0.setParent(null);
    _jspx_th_fmt_setLocale_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${language}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_setLocale_0 = _jspx_th_fmt_setLocale_0.doStartTag();
    if (_jspx_th_fmt_setLocale_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_setLocale_value_nobody.reuse(_jspx_th_fmt_setLocale_0);
      return true;
    }
    _jspx_tagPool_fmt_setLocale_value_nobody.reuse(_jspx_th_fmt_setLocale_0);
    return false;
  }

  private boolean _jspx_meth_fmt_setBundle_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setBundle
    org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag _jspx_th_fmt_setBundle_0 = (org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag) _jspx_tagPool_fmt_setBundle_basename_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag.class);
    _jspx_th_fmt_setBundle_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_setBundle_0.setParent(null);
    _jspx_th_fmt_setBundle_0.setBasename("i18n.locale");
    int _jspx_eval_fmt_setBundle_0 = _jspx_th_fmt_setBundle_0.doStartTag();
    if (_jspx_th_fmt_setBundle_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_setBundle_basename_nobody.reuse(_jspx_th_fmt_setBundle_0);
      return true;
    }
    _jspx_tagPool_fmt_setBundle_basename_nobody.reuse(_jspx_th_fmt_setBundle_0);
    return false;
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                        ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loggedSessionId == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <strong><label id=\"login_status\" class=\"white floatright\">");
        if (_jspx_meth_fmt_message_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("</label></strong>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_fmt_message_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_fmt_message_0.setKey("header.message.notloggedin");
    int _jspx_eval_fmt_message_0 = _jspx_th_fmt_message_0.doStartTag();
    if (_jspx_th_fmt_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_0);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <strong><label id=\"login_status\" class=\"white floatright\">");
        if (_jspx_meth_fmt_message_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_otherwise_0, _jspx_page_context))
          return true;
        out.write(' ');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" !!</label></strong>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_fmt_message_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_1 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_0);
    _jspx_th_fmt_message_1.setKey("header.message.loggedin");
    int _jspx_eval_fmt_message_1 = _jspx_th_fmt_message_1.doStartTag();
    if (_jspx_th_fmt_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_1);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_1);
    return false;
  }

  private boolean _jspx_meth_c_choose_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_1.setParent(null);
    int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
    if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                                    ");
        if (_jspx_meth_c_otherwise_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_choose_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loggedSessionId == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <a href=\"login.jsp\" target=\"_top\">\n");
        out.write("                                            <span id=\"login_widget\">");
        if (_jspx_meth_fmt_message_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_1, _jspx_page_context))
          return true;
        out.write("</span>\n");
        out.write("                                        </a>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }

  private boolean _jspx_meth_fmt_message_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_2 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
    _jspx_th_fmt_message_2.setKey("toolbar.login.login");
    int _jspx_eval_fmt_message_2 = _jspx_th_fmt_message_2.doStartTag();
    if (_jspx_th_fmt_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_2);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_2);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_1.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    int _jspx_eval_c_otherwise_1 = _jspx_th_c_otherwise_1.doStartTag();
    if (_jspx_eval_c_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <form action=\"user\" method=\"post\">\n");
        out.write("                                            <input type=\"hidden\" id=\"cmd\" name=\"cmd\" value=\"logout\" />\n");
        out.write("                                            <input type=\"submit\" value=\"");
        if (_jspx_meth_fmt_message_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_otherwise_1, _jspx_page_context))
          return true;
        out.write("\" />\n");
        out.write("                                        </form>                                         \n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_otherwise_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
    return false;
  }

  private boolean _jspx_meth_fmt_message_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_3 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_3.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_1);
    _jspx_th_fmt_message_3.setKey("toolbar.login.logout");
    int _jspx_eval_fmt_message_3 = _jspx_th_fmt_message_3.doStartTag();
    if (_jspx_th_fmt_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_3);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_3);
    return false;
  }

  private boolean _jspx_meth_c_choose_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_2 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_2.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_2.setParent(null);
    int _jspx_eval_c_choose_2 = _jspx_th_c_choose_2.doStartTag();
    if (_jspx_eval_c_choose_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_when_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_2, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_choose_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
    return false;
  }

  private boolean _jspx_meth_c_when_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_2 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_2.setPageContext(_jspx_page_context);
    _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
    _jspx_th_c_when_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loggedSessionId != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
    if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <li>\n");
        out.write("                                        ");
        out.write("\n");
        out.write("                                        <a href=\"user?cmd=searchKey&key=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" target=\"_top\">\n");
        out.write("                                            <span id=\"login_widget\">");
        if (_jspx_meth_fmt_message_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_2, _jspx_page_context))
          return true;
        out.write("</span>\n");
        out.write("                                        </a>  \n");
        out.write("                                    </li>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_when_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
    return false;
  }

  private boolean _jspx_meth_fmt_message_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_4 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_4.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_2);
    _jspx_th_fmt_message_4.setKey("toolbar.login.manage");
    int _jspx_eval_fmt_message_4 = _jspx_th_fmt_message_4.doStartTag();
    if (_jspx_th_fmt_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_4);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_4);
    return false;
  }

  private boolean _jspx_meth_c_choose_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_3 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_3.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_3.setParent(null);
    int _jspx_eval_c_choose_3 = _jspx_th_c_choose_3.doStartTag();
    if (_jspx_eval_c_choose_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_when_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_3, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_choose_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_3);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_3);
    return false;
  }

  private boolean _jspx_meth_c_when_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_3 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_3.setPageContext(_jspx_page_context);
    _jspx_th_c_when_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_3);
    _jspx_th_c_when_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loggedSessionId != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_3 = _jspx_th_c_when_3.doStartTag();
    if (_jspx_eval_c_when_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <li>\n");
        out.write("                                        <a href=\"user?cmd=getcustomerorders&key=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" target=\"_top\">\n");
        out.write("                                            <span id=\"login_widget\">");
        if (_jspx_meth_fmt_message_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_3, _jspx_page_context))
          return true;
        out.write("</span>\n");
        out.write("                                        </a>  \n");
        out.write("                                    </li>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_when_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_3);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_3);
    return false;
  }

  private boolean _jspx_meth_fmt_message_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_5 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_5.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_3);
    _jspx_th_fmt_message_5.setKey("toolbar.login.orders");
    int _jspx_eval_fmt_message_5 = _jspx_th_fmt_message_5.doStartTag();
    if (_jspx_th_fmt_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_5);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_5);
    return false;
  }

  private boolean _jspx_meth_c_choose_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_4 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_4.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_4.setParent(null);
    int _jspx_eval_c_choose_4 = _jspx_th_c_choose_4.doStartTag();
    if (_jspx_eval_c_choose_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_when_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_4, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_choose_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_4);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_4);
    return false;
  }

  private boolean _jspx_meth_c_when_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_4 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_4.setPageContext(_jspx_page_context);
    _jspx_th_c_when_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_4);
    _jspx_th_c_when_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userType == 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_4 = _jspx_th_c_when_4.doStartTag();
    if (_jspx_eval_c_when_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <li>\n");
        out.write("                                        <a href=\"../admin/category?cmd=searchall\" target=\"_top\">\n");
        out.write("                                            <span id=\"shopping_cart_widget\">");
        if (_jspx_meth_fmt_message_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_4, _jspx_page_context))
          return true;
        out.write("</span>\n");
        out.write("                                        </a>\n");
        out.write("                                    </li>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_when_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_4);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_4);
    return false;
  }

  private boolean _jspx_meth_fmt_message_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_6 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_6.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_4);
    _jspx_th_fmt_message_6.setKey("toolbar.login.admin");
    int _jspx_eval_fmt_message_6 = _jspx_th_fmt_message_6.doStartTag();
    if (_jspx_th_fmt_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_6);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_6);
    return false;
  }

  private boolean _jspx_meth_fmt_message_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_7 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_7.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_7.setParent(null);
    _jspx_th_fmt_message_7.setKey("toolbar.main.home");
    int _jspx_eval_fmt_message_7 = _jspx_th_fmt_message_7.doStartTag();
    if (_jspx_th_fmt_message_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_7);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_7);
    return false;
  }

  private boolean _jspx_meth_fmt_message_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_8 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_8.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_8.setParent(null);
    _jspx_th_fmt_message_8.setKey("toolbar.main.products");
    int _jspx_eval_fmt_message_8 = _jspx_th_fmt_message_8.doStartTag();
    if (_jspx_th_fmt_message_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_8);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_8);
    return false;
  }

  private boolean _jspx_meth_fmt_message_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_9 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_9.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_9.setParent(null);
    _jspx_th_fmt_message_9.setKey("toolbar.main.services");
    int _jspx_eval_fmt_message_9 = _jspx_th_fmt_message_9.doStartTag();
    if (_jspx_th_fmt_message_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_9);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_9);
    return false;
  }

  private boolean _jspx_meth_fmt_message_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_10 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_10.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_10.setParent(null);
    _jspx_th_fmt_message_10.setKey("toolbar.main.events");
    int _jspx_eval_fmt_message_10 = _jspx_th_fmt_message_10.doStartTag();
    if (_jspx_th_fmt_message_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_10);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_10);
    return false;
  }

  private boolean _jspx_meth_fmt_message_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_11 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_11.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_11.setParent(null);
    _jspx_th_fmt_message_11.setKey("toolbar.main.information");
    int _jspx_eval_fmt_message_11 = _jspx_th_fmt_message_11.doStartTag();
    if (_jspx_th_fmt_message_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_11);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_11);
    return false;
  }

  private boolean _jspx_meth_fmt_message_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_12 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_12.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_12.setParent(null);
    _jspx_th_fmt_message_12.setKey("toolbar.main.gallery");
    int _jspx_eval_fmt_message_12 = _jspx_th_fmt_message_12.doStartTag();
    if (_jspx_th_fmt_message_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_12);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_12);
    return false;
  }

  private boolean _jspx_meth_fmt_message_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_13 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_13.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_13.setParent(null);
    _jspx_th_fmt_message_13.setKey("toolbar.main.aboutus");
    int _jspx_eval_fmt_message_13 = _jspx_th_fmt_message_13.doStartTag();
    if (_jspx_th_fmt_message_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_13);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_13);
    return false;
  }

  private boolean _jspx_meth_fmt_message_14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_14 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_14.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_14.setParent(null);
    _jspx_th_fmt_message_14.setKey("toolbar.main.contactus");
    int _jspx_eval_fmt_message_14 = _jspx_th_fmt_message_14.doStartTag();
    if (_jspx_th_fmt_message_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_14);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_14);
    return false;
  }
}
