package org.quiztoria.server;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebListener;
import java.util.EnumSet;

@WebListener
public class SessionTrackingModeSetter implements ServletContextListener {

    @Override
    public void contextInitialized (ServletContextEvent event) {
        event.getServletContext()
                .setSessionTrackingModes(EnumSet.of(SessionTrackingMode.URL));
    }

    @Override
    public void contextDestroyed (ServletContextEvent sce) {
    }
}