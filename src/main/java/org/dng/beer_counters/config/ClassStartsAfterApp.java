package org.dng.beer_counters.config;

import org.dng.beer_counters.repository.NomenclatureRepository;
import org.dng.beer_counters.repository.ProductionInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class ClassStartsAfterApp {
    private final NomenclatureRepository nomenclatureRepository;

    private final ProductionInfoRepository productionInfoRepository;

    @Autowired
    public ClassStartsAfterApp(NomenclatureRepository nomenclatureRepository, ProductionInfoRepository productionInfoRepository) {
        this.nomenclatureRepository = nomenclatureRepository;
        this.productionInfoRepository = productionInfoRepository;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("app has just started up");

//        Group gr1 = new Group("java-113");
//        Group gr2 = new Group("c#-121");
//        groupRepository.saveAll(List.of(gr1,
//                gr2,
//                new Group("mraketing")
//        ));
//
//
////        Student student = new Student("firstName", "seconfName", 12345678, "e-mail@gmail.com");
//        Student st1 = new Student(gr1,"Ivan", "Petrov", 12345678, "e-mail1@gmail.com");
//        Student st2 = new Student(gr1,"Vanja", "Pupkin", 87654321, "e-mail2@gmail.com");
//        studentRepository.saveAll(List.of(
//                st1,
//                st2
//                )
//        );


    }

}
