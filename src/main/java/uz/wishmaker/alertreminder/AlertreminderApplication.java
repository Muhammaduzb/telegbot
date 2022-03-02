package uz.wishmaker.alertreminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import uz.wishmaker.alertreminder.controllers.TelegramController;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class AlertreminderApplication implements CommandLineRunner {

    TelegramController telegramController;

    AlertreminderApplication(TelegramController telegramController){
        this.telegramController = telegramController;
    }


    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//        springDBQueryObjectEx.main();
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(AlertreminderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
