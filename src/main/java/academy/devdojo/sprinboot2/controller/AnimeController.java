package academy.devdojo.sprinboot2.controller;

import academy.devdojo.sprinboot2.domain.Anime;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  academy.devdojo.sprinboot2.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor // public AnimeController(){this.dateUtil = dateUtil;}
@RequestMapping("anime")
public class AnimeController {

    private DateUtil dateUtil;

    //http://localhost:8080/anime/list
    @GetMapping(path="list")
    public List<Anime>  List(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("DBZ"), new Anime("Naruto"));
    }

}
