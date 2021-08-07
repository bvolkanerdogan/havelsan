package tr.com.project.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tr.com.project.core.services.dorduncuSoru;
import tr.com.project.core.services.ikinciSoru;

import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/unitTest")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class unitTest {

    private final ikinciSoru ikinciSoru;
    private final dorduncuSoru dorduncuSoru;

    @PostMapping(value = "/reverse", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String reverse(@RequestBody List<String> list) {
        return ikinciSoru.reverse(list);
    }

    @PostMapping(value = "/isValid", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean isValid(@RequestBody Stack<Integer> stack, @RequestParam("size") int size, @RequestParam("current") int current) {
        return dorduncuSoru.isValid(stack, size, current);
    }

    @GetMapping(value = "/isEven")
    public boolean isEven(@RequestParam("size") int size) {
        return dorduncuSoru.isEven(size);
    }


}
