package co.develhope.APIInterceptorMiddleware02.interceptors;

import co.develhope.APIInterceptorMiddleware02.entities.Month;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Infine ho creato l'interceptor MonthInterceptor in cui ho inserito una lista di 6 months.
 * Nel preHandle ho preso il monthNumber dalla richiesta, se nulla o vuota mi ritorna errore 400 = BAD REQUEST
 * invece se e presente nella lista, lo ritorna sotto forma di json, se no, dovrebbe ritornare un month vuoto con le
 * stringhe a valore nope (ma a me no succede)
 * e ritornare alla fine un 200 = OK
 *
 * Nelle richieste di postman
 * - monthNumber absent = 400
 * - monthNumber empty = 400
 * - monthNumber values in list = 200 con ritorno di month sotto forma di json
 * - monthNumber value not in list = 200 ma non ritorna nessun json
 */
@Component
public class MonthInterceptor implements HandlerInterceptor {

    public static List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni")
    ));

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberString = request.getHeader("monthNumber");
        if(monthNumberString == null || monthNumberString.isEmpty()) {
            response.setStatus(400);
            return false;
        } else {
            long monthNumber = Long.parseLong(monthNumberString);
            Optional<Month> month = months.stream().filter(singleMonth -> {
                return singleMonth.getMonthNumber() == monthNumber;
            }).findFirst();
            if (month.isPresent()) {
                request.setAttribute("MonthInterceptor-Month", month.get());
            } else {
                request.setAttribute("month", new Month(0, "nope", "nope", "nope"));
            }
            response.setStatus(200);
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
