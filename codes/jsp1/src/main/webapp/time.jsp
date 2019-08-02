<%@page pageEncoding="utf-8"
  contentType="text/html"
  import="java.text.*,java.util.Date"%> 
  
  <%
  	Date date = new Date();
  	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
  	String now =  sdf.format(date);
  %>
  <!-- 此jsp被其他网页引用，是其他网页的一部分，所以不必写出完整的结构 -->
  <p><%=now%></p>