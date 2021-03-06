/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC10
 * Generated at: 2014-01-31 14:39:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.FileReader;
import java.util.logging.Level;
import org.opensolaris.opengrok.OpenGrokLogger;
import org.apache.lucene.search.Query;
import org.opensolaris.opengrok.search.QueryBuilder;
import org.opensolaris.opengrok.search.context.Context;
import java.io.File;
import java.io.IOException;
import org.opensolaris.opengrok.configuration.Project;
import org.opensolaris.opengrok.history.HistoryGuru;
import org.opensolaris.opengrok.web.EftarFileReader;
import org.opensolaris.opengrok.web.PageConfig;
import org.opensolaris.opengrok.web.Prefix;
import org.opensolaris.opengrok.web.Util;
import org.opensolaris.opengrok.Info;
import org.opensolaris.opengrok.web.PageConfig;
import org.opensolaris.opengrok.web.PageConfig;
import java.util.EnumSet;
import org.opensolaris.opengrok.web.PageConfig;
import org.opensolaris.opengrok.web.Prefix;

public final class more_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    private PageConfig cfg;
    /** Just cleanup cached objects */

    public void jspDestroy() {
        if (cfg != null) {
            cfg.cleanup();
        }
    }


/* ---------------------- foot.jspf members start --------------------- */
    private static EnumSet<Prefix> needAddDiv = EnumSet.of(
        Prefix.HIST_L, Prefix.XREF_P, Prefix.DIFF_P, Prefix.MORE_P,
        // could NOT find any mapping/reference to those ones:
        Prefix.HIST_S, Prefix.XREF_S, Prefix.DIFF_S, Prefix.MORE_S);
/* ---------------------- foot.jspf members end --------------------- */

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/pageheader.jspf", Long.valueOf(1331040730000L));
    _jspx_dependants.put("/foot.jspf", Long.valueOf(1331040730000L));
    _jspx_dependants.put("/mast.jsp", Long.valueOf(1331040730000L));
    _jspx_dependants.put("/pageconfig.jspf", Long.valueOf(1331040730000L));
    _jspx_dependants.put("/httpheader.jspf", Long.valueOf(1331040730000L));
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


/* ---------------------- mast.jsp start --------------------- */
{
    cfg = PageConfig.get(request);
    String redir = cfg.canProcess();
    if (redir == null || redir.length() > 0) {
        if (redir == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            response.sendRedirect(redir);
        }
        return;
    }
    // jel: hmmm - questionable for dynamic content
    long flast = cfg.getLastModified();
    if (request.getDateHeader("If-Modified-Since") >= flast) {
        response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
        return;
    }
    response.setDateHeader("Last-Modified", flast);

    // Use UTF-8 if no encoding is specified in the request
    if (request.getCharacterEncoding() == null) {
        request.setCharacterEncoding("UTF-8");
    }

    // set the default page title
    String path = cfg.getPath();
    cfg.setTitle("Cross Reference: " + path);

    String context = request.getContextPath();
    cfg.getEnv().setUrlPrefix(context + Prefix.SEARCH_R + "?");

    String uriEncodedPath = cfg.getUriEncodedPath();
    String rev = cfg.getRequestedRevision();


/* ---------------------- httpheader.jsp start --------------------- */
{
    cfg = PageConfig.get(request);
    String styleDir = cfg.getCssDir();
    String ctxPath = request.getContextPath();
    String dstyle = styleDir + '/' + "style.css";
    String pstyle = styleDir + '/' + "print.css";

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n");
      out.write("    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<meta name=\"robots\" content=\"noindex,nofollow\" />\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("<meta name=\"generator\" content=\"");
      out.print(Info.getVersion());
      out.write(' ');
      out.write('(');
      out.print(Info.getRevision());
      out.write(")\" />\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=8\" />\n");
      out.write("<link rel=\"icon\" href=\"");
      out.print(styleDir);
      out.write("/img/icon.png\" type=\"image/png\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\"\n");
      out.write("    title=\"Default\" href=\"");
      out.print( dstyle );
      out.write("\" />\n");
      out.write("<link rel=\"alternate stylesheet\" type=\"text/css\" media=\"all\"\n");
      out.write("    title=\"Paper White\" href=\"");
      out.print( pstyle );
      out.write("\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(styleDir);
      out.write("/print.css\" media=\"print\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(styleDir);
      out.write("/jquery.tooltip.css\" />\n");
      out.write("\n");
      out.write("<link rel=\"search\" href=\"");
      out.print(ctxPath);
      out.write("/opensearch\"\n");
      out.write("    type=\"application/opensearchdescription+xml\"\n");
      out.write("    title=\"OpenGrok Search for current project(s)\" />\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(ctxPath);
      out.write("/jquery-1.4.4.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(ctxPath);
      out.write("/jquery.tooltip-1.3.pack.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(ctxPath);
      out.write("/utils.js\"></script>\n");
      out.write("<title>");
      out.print(cfg.getTitle());
      out.write("</title>");

    out.write(cfg.getHeaderData());

      out.write("\n");
      out.write("</head>");

}
/* ---------------------- httpheader.jsp end --------------------- */

      out.write("<body>\n");
      out.write("<script type=\"text/javascript\">/* <![CDATA[ */\n");
      out.write("    document.hash = '");
      out.print( cfg.getDocumentHash()
    );
      out.write("';document.rev = '");
      out.print( rev
    );
      out.write("';document.link = '");
      out.print( context + Prefix.XREF_P + uriEncodedPath
    );
      out.write("';document.annotate = ");
      out.print( cfg.annotate() );
      out.write(";\n");
      out.write("    document.domReady.push(function() {domReadyMast();});\n");
      out.write("    document.pageReady.push(function() { pageReadyMast();});\n");
      out.write("/* ]]> */</script>\n");
      out.write("<div id=\"page\">\n");
      out.write("    <div id=\"whole_header\">\n");
      out.write("        <form action=\"");
      out.print( context + Prefix.SEARCH_P );
      out.write("\">\n");
      out.write("<div id=\"header\">");
 
/* ---------------------- pageheader.jspf start --------------------- */
{
    cfg = PageConfig.get(request);

      out.write("\n");
      out.write("<a href=\"");
      out.print( request.getContextPath() );
      out.write("/\"><span id=\"MastheadLogo\"></span></a>\n");
      out.print( cfg.getEnv().getConfiguration().getHeaderIncludeFileContent() );
      out.write('\n');
 
}
/* ---------------------- pageheader.jspf end --------------------- */

      out.write('\n');
      out.write("\n");
      out.write("    <div id=\"pagetitle\"><span id=\"filename\"\n");
      out.write("                    >Cross Reference: ");
      out.print( cfg.getCrossFilename() );
      out.write("</span>");

    String dtag = cfg.getDefineTagsIndex();
    if (dtag.length() > 0) {
                    
      out.write("<br/>");
      out.print( dtag );

    }
    
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<div id=\"Masthead\">\n");
      out.write("    <tt><a href=\"");
      out.print( context + Prefix.XREF_P );
      out.write("/\">xref</a>: ");
      out.print( Util
        .breadcrumbPath(context + Prefix.XREF_P, path,'/',"",true,cfg.isDir())
    );
      out.write("</tt>\n");
      out.write("</div>\n");
      out.write("<div id=\"bar\">\n");
      out.write("    <ul>\n");
      out.write("        <li><a href=\"");
      out.print( context );
      out.write("/\"><span id=\"home\"></span>Home</a></li>");

    if (!cfg.hasHistory()) {
        
      out.write("<li><span id=\"history\"></span><span class=\"c\">History</span></li>");

    } else {
        
      out.write("<li><a href=\"");
      out.print( context + Prefix.HIST_L + uriEncodedPath
            );
      out.write("\"><span id=\"history\"></span>History</a></li>");

    }
    if (!cfg.hasAnnotations() /* || cfg.getPrefix() == Prefix.HIST_S */ ) {
        
      out.write("<li><span class=\"c\"><span class=\"annotate\"></span>Annotate</span></li>");

    } else if (cfg.annotate()) {
        
      out.write("<li><span id=\"toggle-annotate-by-javascript\" style=\"display: none\"><a\n");
      out.write("            href=\"#\" onclick=\"javascript:toggle_annotations(); return false;\"\n");
      out.write("            title=\"Show or hide line annotation(commit revisions,authors).\"\n");
      out.write("            ><span class=\"annotate\"></span>Annotate</a></span><span\n");
      out.write("            id=\"toggle-annotate\"><a href=\"");
      out.print(
                context + Prefix.XREF_P + uriEncodedPath
                + (rev.length() == 0 ? "" : "?") + rev
            );
      out.write("\"><span class=\"annotate\"></span>Annotate</a></span></li>");

    } else {
        
      out.write("<li><a href=\"#\" onclick=\"javascript:get_annotations(); return false;\"\n");
      out.write("            ><span class=\"annotate\"></span>Annotate</a></li>");

    }
    if (!cfg.isDir()) {
        if (cfg.getPrefix() == Prefix.XREF_P) {
        
      out.write("<li><a href=\"#\" onclick=\"javascript:lntoggle();return false;\"\n");
      out.write("            title=\"");
      out.print( "Show or hide line numbers (might be slower if "
                + "file has more than 10 000 lines)."
            );
      out.write("\"><span id=\"line\"></span>Line#</a></li><li><a\n");
      out.write("            href=\"#\" onclick=\"javascript:lsttoggle();return false;\"\n");
      out.write("            title=\"Show or hide symbol list.\">");
      out.write("<span id=\"defbox\"></span>Navigate</a></li>");

        }
        
      out.write("<li><a href=\"");
      out.print( context + Prefix.RAW_P + uriEncodedPath
            + (rev.length() == 0 ? "" : "?") + rev
            );
      out.write("\"><span id=\"download\"></span>Download</a></li>");

    }
        
      out.write("<li><input type=\"text\" id=\"search\" name=\"q\" class=\"q\" />\n");
      out.write("            <input type=\"submit\" value=\"Search\" class=\"submit\" /></li>");

    Project proj = cfg.getProject();
    String[] vals = cfg.getSearchOnlyIn();
        
      out.write("<li><input type=\"checkbox\" name=\"path\" value=\"");
      out.print( vals[0]
            );
      out.write('"');
      out.write(' ');
      out.print( vals[2] );
      out.write("/> only in <b>");
      out.print( vals[1] );
      out.write("</b></li>\n");
      out.write("        ");
      out.write("\n");
      out.write("    </ul>");

    if (proj != null) {
    
      out.write("\n");
      out.write("    <input type=\"hidden\" name=\"project\" value=\"");
      out.print(proj.getDescription());
      out.write("\" />");

    }

      out.write("\n");
      out.write("</div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("<div id=\"content\">\n");

}
/* ---------------------- mast.jsp end --------------------- */


/* ---------------------- more.jsp start --------------------- */
{
    cfg = PageConfig.get(request);
    QueryBuilder qbuilder = cfg.getQueryBuilder();

    try {
        Query tquery = qbuilder.build();
        if (tquery != null) {
            Context sourceContext = new Context(tquery, qbuilder.getQueries());

      out.write("<p><span class=\"pagetitle\">Lines Matching <b>");
      out.print( tquery );
      out.write("</b></span></p>\n");
      out.write("<div id=\"more\" style=\"line-height:1.5em;\">\n");
      out.write("    <pre>");

            sourceContext.getContext(new FileReader(cfg.getResourceFile()), out,
                request.getContextPath() + Prefix.XREF_P, null, cfg.getPath(),
                null, false, null);
    
      out.write("</pre>\n");
      out.write("</div>");

        }
    } catch (Exception e) {
        OpenGrokLogger.getLogger().log(Level.WARNING, e.getMessage());
    }
}
/* ---------------------- more.jsp end --------------------- */


/* ---------------------- foot.jspf start --------------------- */
{
    cfg = PageConfig.get(request);

        
      out.write("\n");
      out.write("    <div id=\"footer\">\n");
      out.write("<p><a href=\"http://www.opensolaris.org/os/project/opengrok/\"\n");
      out.write(" title=\"Served by OpenGrok\"><span id=\"fti\"></span></a></p>\n");
      out.write("<p>Indexes created ");
      out.print( cfg.getEnv().getDateForLastIndexRun() );
      out.write("</p>\n");
      out.write("    ");
      out.print( cfg.getEnv().getConfiguration().getFooterIncludeFileContent() );
      out.write("\n");
      out.write("    ");

    if (needAddDiv.contains(cfg.getPrefix())) {
        
      out.write("</div>");
 // #content
    }
    // #footer, #page:
    
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");

}
/* ---------------------- foot.jspf end --------------------- */

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
