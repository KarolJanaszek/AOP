package pl.bykowski.aop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

//Samego Shedulinga nie stosuje się często. Lepiej konkretną metodę przypisać do endopintu i wywołać ją przez ContinuesIntegration, np Jenkins.
@Component
public class Hello {

    @EventListener(ApplicationReadyEvent.class)
    @HelloAspectAnnotation
    public String sayHello() {
        System.out.println("Hello");
        return "Hello!";
    }

    //Co ilość mls od zakonczenia działania metody.
    //cron - co ile ma sie wykonywać (dni tygodnia i godziny)
    //fixedRate - metoda wykona się co ileś mls ale nie od momentu zakonczenia działania metody
    @Scheduled(fixedDelay = 2000L)
    public void scheduleHello() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Hello every 2 sec.");
    }

    //dokumentacja na stornie oracle
    @Schedules({
            @Scheduled(fixedDelay = 1000),
            @Scheduled(cron = "0 0 12 * * ?")
    })
    public void scheduleHelloCrone() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Hello every 2 sec.");
    }
}
