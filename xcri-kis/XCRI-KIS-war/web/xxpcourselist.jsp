<%-- 
    Document   : index
    Created on : 04-Nov-2012, 11:40:23
    Author     : Tony
--%>
<%@page contentType="text/html" 
        pageEncoding="UTF-8"
        import="java.util.List,
        uk.co.igsl.common.*,
        uk.co.igsl.model.XxpCoeCourse"%>
<%
  List<XxpCoeCourse> coeList = (List<XxpCoeCourse>) session.getAttribute(AppConstants.SEC_XXP_REC);
%>
<!DOCTYPE html>
<html>
  <head>
    <title>XCRI-CAP KIS Search Results</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="author" content="Anthony Au" />
    <meta name="MSSmartTagsPreventParsing" content="true" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <style type="text/css" media="all">
      @import "css/datatable_ui.css";
      @import "css/jquery-ui.css";
      @import "css/jquery.ui.theme.css";
      @import "css/kis.css";
    </style>

    <script type="text/javascript" charset="utf-8" language="javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" language="javascript" src="js/jquery.dataTables.min.js"></script>  
    <script type="text/javascript" charset="utf-8" language="javascript" src="js/coeTable.js"></script>    
  </head>
  <body>
    <p class="hidden">
      <a href="#content">Skip to content</a>
    </p>
    <div id="page">
      <div id="nonFooter">
        <header>
          <span class="title">Extending XCRI-CAP with KIS data</span>
        </header>
        <!-- END header -->
        <div id="content">
          <div id="contentMain">
            <h1 id="headingFeaturesPages">
              <span class="featureIcon"></span>The Open University<span class="hidden">&ndash;</span> <span class="subTitle">Course Search Results</span>
            </h1>
            <p>
              <strong>Includes official data on each university and college's satisfaction scores in the National Student Survey, jobs and salaries after study and other key information for prospective students.
              </strong>
            </p>

            <% if (null == coeList) {%>
            <h2>No Course found</h2>
            <% } else {%>
            <h2><%=coeList.size()%> courses found</h2>
            <table cellpadding="0" cellspacing="0" border="0" class="display" id="dataTable">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Title</th>
                  <th>JACS</th>
                </tr>
              </thead>
              <tbody>
                <% for (XxpCoeCourse coe : coeList) {%>
                <tr>
                  <td><a href="<%=AppConstants.PATH_VIEW_XXP_COE%>&<%=AppConstants.FORM_COE_ID%>=<%=coe.getId()%>" ><%=coe.getInternalId()%></td>
                  <td><%=coe.getTitle()%></td>
                  <td><%=coe.getJacs3()%></td>
                </tr>
                <% }%>
              </tbody>   
            </table>              
            <% }%>

            <!-- END featureNavigation -->
          </div>
          <!-- END contentMain -->

          <!-- END contentSub -->
          <div class="clearer">
          </div>
        </div>
        <!-- END content -->
      </div>
      <!-- END nonFooter -->
    </div>
    <!-- END page -->
    <div id="footer">
      <ul id="bottomLinks">
        <li class="first">
          <a href="http://www.jisc.ac.uk." target="_blank">JISC</a>
        </li>
        <li>
          <a href="http://www.xxp.org" target="_blank">XXP</a>
        </li>
        <li>
          <a href="http://www.ingenius-solutions.co.uk/" target="_blank">IGSL</a>
        </li>
        <li>
          <a href="http://www.alanpaull.co.uk" target="_blank">APS</a>
        </li>        
        <li>
          <a href="mailto:xcri-kis@igsl.co.uk?subject=XCRI-CAP KIS demonstrator enquiry" target="_blank">Contact Us</a>
        </li>
      </ul>
      <p>
        &copy; 2012 InGenius Solutions Limited (IGSL). All rights reserved.
      </p>
    </div>
    <!-- END footer -->
    <script type="text/javascript">
      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-5836281-21']);
      _gaq.push(['_trackPageview']);
      (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
      })();
    </script>
  </body>
</html>


