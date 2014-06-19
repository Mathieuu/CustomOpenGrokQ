/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC10
 * Generated at: 2014-01-31 14:39:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Set;
import org.opensolaris.opengrok.history.DirectoryHistoryReader;
import org.opensolaris.opengrok.history.History;
import org.opensolaris.opengrok.history.HistoryEntry;
import org.opensolaris.opengrok.history.HistoryGuru;
import org.opensolaris.opengrok.web.Util;
import org.opensolaris.opengrok.web.Prefix;
import org.opensolaris.opengrok.web.PageConfig;
import org.opensolaris.opengrok.web.PageConfig;

public final class rss_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    private PageConfig cfg;
    /** Just cleanup cached objects */

    public void jspDestroy() {
        if (cfg != null) {
            cfg.cleanup();
        }
    }

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/pageconfig.jspf", Long.valueOf(1331040730000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;


/* ---------------------- rss.jsp start --------------------- */
{
    cfg = PageConfig.get(request);
    String redir = cfg.canProcess();
    if (redir == null || redir.length() > 0) {
        if (redir != null) {
            response.sendRedirect(redir);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        return;
    }
    cfg.getEnv().setUrlPrefix(request.getContextPath() + Prefix.SEARCH_R + '?');
    String path = cfg.getPath();
    String dtag = cfg.getDefineTagsIndex();
    response.setContentType("text/xml");

      out.write("<?xml version=\"1.0\"?>\n");
      out.write("<?xml-stylesheet type=\"text/xsl\" href=\"");
      out.print( request.getContextPath()
    );
      out.write("/rss.xsl.xml\"?>\n");
      out.write("<rss version=\"2.0\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\">\n");
      out.write("<channel>\n");
      out.write("    <title>Changes in ");
      out.print( path.length() == 0
        ? "Cross Reference"
        : Util.htmlize(cfg.getResourceFile().getName()) );
      out.write("</title>\n");
      out.write("    <link>");
      out.print( Util.htmlize(request.getRequestURL()) );
      out.write("</link>\n");
      out.write("    <description>");
      out.print( Util.htmlize(dtag) );
      out.write("</description>\n");
      out.write("    <language>en</language>\n");
      out.write("    <copyright>Copyright 2005</copyright>\n");
      out.write("    <generator>Java</generator>");

    History hist = null;
    if(cfg.isDir()) {
        hist = new DirectoryHistoryReader(cfg.getHistoryDirs()).getHistory();
    } else {
        hist = HistoryGuru.getInstance().getHistory(cfg.getResourceFile());
    }
    if (hist != null) {
        int i = 20;
        for (HistoryEntry entry : hist.getHistoryEntries()) {
            if (i-- <= 0) {
                break;
            }
            if (entry.isActive()) {
    
      out.write("\n");
      out.write("    <item>\n");
      out.write("        <title>");
      out.print( Util.htmlize(entry.getMessage()) );
      out.write("</title>\n");
      out.write("        <description>");

                if (cfg.isDir()) {
                    Set<String> files = entry.getFiles();
                    if (files != null) {
                        for (String ifile : files) {
            
      out.print( Util.htmlize(ifile) );

                        }
                    }
                } else {
            
      out.print( Util.htmlize(path) );
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print(
                Util.htmlize(entry.getRevision()) );

                }
        
      out.write("</description>\n");
      out.write("        <pubDate>");

                SimpleDateFormat df =
                    new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
                Util.htmlize(df.format(entry.getDate()));
        
      out.write("</pubDate>\n");
      out.write("        <dc:creator>");
      out.print( Util.htmlize(entry.getAuthor()) );
      out.write("</dc:creator>\n");
      out.write("    </item>\n");

            }
        }
    }

      out.write("\n");
      out.write("</channel>\n");
      out.write("</rss>\n");

}
/* ---------------------- rss.jsp end --------------------- */

      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
