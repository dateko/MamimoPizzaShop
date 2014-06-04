package pair_pro.server;

import java.io.*;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")

public class revPizzaData extends HttpServlet{

	 @SuppressWarnings("unchecked")
	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	      throws IOException {
	    resp.setContentType("text/html");
	    PersistenceManager pm = pair_pro.client.PMF.get().getPersistenceManager();
	    String query = "select from " + pair_pro.client.PizzaData.class.getName();
	    List<pair_pro.client.PizzaData> datas = (List<pair_pro.client.PizzaData>) pm.newQuery(query).execute();
	    Writer out = resp.getWriter();
	    out.write("<table border=\"1\">");
	    out.write("<tr><th>ID</th><th>枚数</th><th>トッピング</th><th>ご注文時刻</th>");
	    for(pair_pro.client.PizzaData data : datas){
	      out.write("<tr>");
	      out.write("<td>" + data.getId() + "</td>");
	      out.write("<td>" + data.getNumber() + "</td>");
	      out.write("<td>" + data.getTopping() + "</td>");
	      out.write("<td>" + data.getDate() + "</td>");
	      out.write("</tr>");
	    }
	    out.write("</table>");
	  }
}
