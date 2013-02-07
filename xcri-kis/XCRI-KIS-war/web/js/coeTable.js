/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
  oTable = $('#dataTable').dataTable({
    "oLanguage": {
      "sEmptyTable": "No courses found."
    },
    "sDom": '<"H"l<"search">r>t<"F"ip>',
    "bFilter": false,
    "bJQueryUI": true
  });
  $("div.search").html('<a href="search.jsp" class="search-link" >Search again</a>');
});

