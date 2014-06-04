package pair_pro.client;

import javax.jdo.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class addData extends HttpServlet {

  public void doGet(HttpServletRequest req,
      HttpServletResponse resp)
      throws IOException {
    resp.setContentType("text/plain");
    resp.getWriter().println("can not access!!");
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse resp)
      throws IOException {
    request.setCharacterEncoding("UTF-8");
    String topping = request.getParameter("topping");
    String number = request.getParameter("number");
    Date date = Calendar.getInstance().getTime();
	PizzaData data = new PizzaData(topping,number,date);
    PersistenceManagerFactory pmf = PMF.get();
    PersistenceManager pm = pmf.getPersistenceManager();
    try {
      pm.makePersistent(data);
    } finally {
      pm.close();
    }
    resp.sendRedirect("ThankYou.html");
  }
}