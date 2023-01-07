package Control;

import Entity.Account;
import Entity.MailConfig;
import org.apache.commons.mail.Email;
import java.sql.SQLException;
import org.apache.commons.mail.EmailException;
import service.UserService;
import javax.mail.Authenticator;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "SendMail", value = { "SendMail" })
public class SendMail extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String emailTo = request.getParameter("email");
        final Email email = (Email)new SimpleEmail();
        email.setHostName(MailConfig.HOST_NAME);
        email.setSmtpPort(MailConfig.SSL_PORT);
        email.setAuthenticator((Authenticator)new DefaultAuthenticator(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD));
        email.setSSLOnConnect(true);
        try {
            final UserService user = new UserService();
            final Account account = user.findAccount(emailTo);
            if (account == null) {
                response.sendRedirect("Forgottenpassword.jsp");
                return;
            }
            final String password = account.getPassword();
            email.setFrom(MailConfig.APP_EMAIL);
            email.addTo(emailTo);
            email.setSubject("ShopCVT Gui lai mat khau cua ban");
            email.setMsg("Mat khau cua ban la: " +password);
            email.send();
            System.out.println("Message sent successfully");
            response.sendRedirect("Login.jsp");
        }
        catch (EmailException e) {
            System.out.println(e);
            response.sendRedirect("Forgottenpassword.jsp");
        }
        catch (SQLException e2) {
            throw new RuntimeException(e2);
        }
        catch (ClassNotFoundException e3) {
            throw new RuntimeException(e3);
        }
    }
}