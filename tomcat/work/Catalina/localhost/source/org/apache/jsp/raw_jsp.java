/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC10
 * Generated at: 2014-01-31 14:39:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import org.opensolaris.opengrok.configuration.RuntimeEnvironment;
import org.opensolaris.opengrok.history.HistoryGuru;
import org.opensolaris.opengrok.web.PageConfig;
import org.opensolaris.opengrok.web.PageConfig;

public final class raw_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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


/* ---------------------- raw.jsp start --------------------- */
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

    File f = cfg.getResourceFile();
    String revision = cfg.getRequestedRevision();
    if (revision.length() == 0) {
        revision = null;
    }
    InputStream in = null;
    try {
        if (revision != null) {
            in = HistoryGuru.getInstance().getRevision(f.getParent(),
                f.getName(), revision.substring(2));
        } else {
            long flast = cfg.getLastModified();
            if (request.getDateHeader("If-Modified-Since") >= flast) {
                response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                return;
            }
            in = new FileInputStream(f);
            response.setContentLength((int) f.length());
            response.setDateHeader("Last-Modified", f.lastModified());
        }
    } catch (Exception e) {
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
        return ;
    }
    String mimeType = getServletContext().getMimeType(f.getAbsolutePath());
    response.setContentType(mimeType);

    try {
        response.setHeader("content-disposition", "attachment; filename="
            + f.getName());
        OutputStream o = response.getOutputStream();
        byte[] buffer = new byte[8192];
        int nr;
        while ((nr = in.read(buffer)) > 0) {
            o.write(buffer, 0, nr);
        }
        o.flush();
        o.close();
    } finally {
        in.close();
    }
}
/* ---------------------- raw.jsp end-------------------- */

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
