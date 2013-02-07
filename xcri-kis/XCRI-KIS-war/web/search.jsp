<%-- 
    Document   : index
    Created on : 04-oct-2012, 15:40:49
    Author     : Tony
--%>
<%@page contentType="text/html" 
        pageEncoding="UTF-8"
        import="uk.co.igsl.common.*"%>
<!DOCTYPE html>
<html>
  <head>
    <title>XCRI-CAP KIS Search</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta name="author" content="Anthony Au" />
    <meta name="MSSmartTagsPreventParsing" content="true" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <style type="text/css" media="all">
      @import "css/kis.css";
      @import "css/form.css";
    </style>
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
              <span class="featureIcon"></span>The Open University<span class="hidden">&ndash;</span> <span class="subTitle">Course Search Demonstrator</span>
            </h1>
            <p>
              <strong>Includes official data on each university and college's satisfaction scores in the National Student Survey, jobs and salaries after study and other key information for prospective students.
              </strong>
            </p>
            <h2>
              Course Search Demonstrator
            </h2>

            <form action="<%=AppConstants.PATH_SEARCH%>" method="post" class="kis-form">
              <fieldset>
                <legend>Search Options</legend>
                <ul>
                  <li>
                    <label for="<%=AppConstants.FORM_COURSE_ID%>">Course Title contains this word or phrase: </label>
                    <input required type="text" id="<%=AppConstants.FORM_COURSE_ID%>" name="<%=AppConstants.FORM_COURSE_ID%>" />
                  </li>
                  <li> <label for="<%=AppConstants.FORM_COURSE_WORK_CONDITION%>">Assessment by coursework:</label>
                    <select id="<%=AppConstants.FORM_COURSE_WORK_CONDITION%>" name="<%=AppConstants.FORM_COURSE_WORK_CONDITION%>">
                      <option value = "0" selected="selected">-</option>       
                      <option value = "90">&gt;90%</option>
                      <option value = "80">&gt;80%</option>
                      <option value = "70">&gt;70%</option>
                      <option value = "60">&gt;60%</option>
                      <option value = "50">&gt;50%</option>
                      <option value = "40">&gt;40%</option>
                      <option value = "30">&gt;30%</option>
                      <option value = "20">&gt;20%</option>
                      <option value = "10">&gt;10%</option>
                    </select>
                  </li>
                  <li> <label for="<%=AppConstants.FORM_WORK_STUDY_CONDITION%>">Work/Study six months after finishing the course:</label>
                    <select id="<%=AppConstants.FORM_WORK_STUDY_CONDITION%>" name="<%=AppConstants.FORM_WORK_STUDY_CONDITION%>">
                      <option value = "0" selected="selected">-</option>       
                      <option value = "99">&gt;99%</option>
                      <option value = "89">&gt;89%</option>
                      <option value = "79">&gt;79%</option>
                      <option value = "69">&gt;69%</option>
                      <option value = "59">&gt;59%</option>
                      <option value = "49">&gt;49%</option>
                      <option value = "39">&gt;39%</option>
                      <option value = "29">&gt;29%</option>
                      <option value = "19">&gt;19%</option>
                      <option value = "9">&gt;9%</option>
                    </select>
                  </li>
                </ul>
                <ul class="nav">
                  <li class="left"> <input type="submit" value="Search"/></li>
                </ul>
                <input id="<%=AppConstants.JSP_PARAM_FUNCTION%>" name="<%=AppConstants.JSP_PARAM_FUNCTION%>" type="hidden" value="<%=AppConstants.SUBMIT_SEARCH_ADVANCE%>"/>
              </fieldset>
            </form>

      
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
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>
  </body>
</html>

