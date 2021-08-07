package tr.com.project.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tr.com.project.core.services.dorduncuSoru;
import tr.com.project.core.services.ikinciSoru;
import tr.com.project.core.services.ilkSoruService;
import tr.com.project.core.services.ucuncuSoru;

import java.util.Stack;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class test {

    private final ilkSoruService ilkSoru;
    private final ikinciSoru ikinciSoru;
    private final ucuncuSoru ucuncuSoru;
    private final dorduncuSoru dorduncuSoru;

    @GetMapping(value = "/nestedLoop")
    public String nestedLoop(@RequestParam("kenarUzunluk") int kenarUzunluk) {
        return ilkSoru.cizimGetir(kenarUzunluk);
    }

    @GetMapping(value = "/reverseWords")
    public String reverseWords(@RequestParam("message") String message) {
        return ikinciSoru.reverseMessage(message);
    }


    //c ve c++'da split işlemi olmadığı için ekstra olarak yazdım
    @GetMapping(value = "/reverseWordsBySplit")
    public String reverseWordsBySplit(@RequestParam("message") String message) {
        return ikinciSoru.reverseMessageBySplit(message);
    }

    //c ve c++'da java stream olmadığı için ekstra olarak yazdım
    @GetMapping(value = "/recommedMoviesWithStream")
    public Boolean recommedMoviesWithStream(@RequestParam("flightLenght") Integer flightLenght) {
        return ucuncuSoru.recommedMoviesWithStream(flightLenght);
    }

    @GetMapping(value = "/recommedMoviesWithFor")
    public Boolean recommedMoviesWithFor(@RequestParam("flightLenght") Integer flightLenght) {
        return ucuncuSoru.recommedMovies(flightLenght);
    }

    @PostMapping(value = "/deleteMid", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Stack<Integer> deleteMid(@RequestBody Stack<Integer> stack) {
        return dorduncuSoru.deleteMid(stack, stack.size(), 0);
    }

    //test verisi eklenmiş hali. çalıştırarak test edilebilir.
    @GetMapping(value = "/deleteMidWithValues")
    public Stack<Integer> deleteMidWithValues() {
        return dorduncuSoru.deleteMidWithValues();
    }

}