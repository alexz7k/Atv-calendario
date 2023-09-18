import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalendarioServlet")
public class CalendarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String yearParam = request.getParameter("ano");
        String monthParam = request.getParameter("mes");

        if (yearParam != null && monthParam != null) {
            int year = Integer.parseInt(yearParam);
            int month = Integer.parseInt(monthParam);

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month - 1);
            cal.set(Calendar.DAY_OF_MONTH, 1);

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
            String monthYear = sdf.format(cal.getTime());

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calendário</title>");
            out.println("<style>");
            out.println("table { border-collapse: collapse; }");
            out.println("table, th, td { border: 1px solid black; }");
            out.println("th, td { padding: 10px; text-align: center; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Calendário para " + monthYear + "</h2>");
            out.println("<table>");
            out.println("<tr><th>Domingo</th><th>Segunda-feira</th><th>Terça-feira</th><th>Quarta-feira</th><th>Quinta-feira</th><th>Sexta-feira</th><th>Sábado</th></tr>");

            int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            
            for (int i = Calendar.SUNDAY; i < firstDayOfWeek; i++) {
                out.println("<td></td>");
            }

            int dayOfMonth = 1;
            while (cal.get(Calendar.MONTH) == month - 1) {
                int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

                if (dayOfWeek == Calendar.SUNDAY) {
                    out.println("<tr>");
                }

                out.println("<td>" + dayOfMonth + "</td>");
                dayOfMonth++;

                if (dayOfWeek == Calendar.SATURDAY) {
                    out.println("</tr>");
                }

                cal.add(Calendar.DAY_OF_MONTH, 1);
            }

      
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("Por favor, informe o ano e o mês como parâmetros.");
        }
    }
}
