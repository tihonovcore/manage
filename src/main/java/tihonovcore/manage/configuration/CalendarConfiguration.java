package tihonovcore.manage.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tihonovcore.manage.dao.CalendarDao;
import tihonovcore.manage.dao.InMemoryCalendarDao;
import tihonovcore.manage.dao.JDBCCalendarDao;

@Configuration
public class CalendarConfiguration {
    @Bean
    public CalendarDao getDao() {
        return new JDBCCalendarDao();
    }
}
