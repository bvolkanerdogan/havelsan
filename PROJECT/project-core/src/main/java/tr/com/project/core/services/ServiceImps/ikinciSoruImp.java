package tr.com.project.core.services.ServiceImps;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.project.core.services.ikinciSoru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ikinciSoruImp implements ikinciSoru {

    @Override
    public String reverseMessage(String message) {

        List<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < message.length(); i++) {

            if (i == message.length() - 1) {
                word += message.charAt(i);
                words.add(word);
            } else if (message.charAt(i) == ' ') {
                words.add(word);
                word = new String();
            } else if (!Character.isLetter(message.charAt(i))) {
                continue;
            } else {
                word += message.charAt(i);
            }
        }
        return reverse(words);
    }


    @Override
    //C ve C++'da split olmadığı için diğer metodu da yazdım
    public String reverseMessageBySplit(String message) {
        message = message.replaceAll("[^A-Za-z ]", "");
        String[] wordsList = message.split(" ");
        return reverse(Arrays.asList(wordsList));
    }

    @Override
    public String reverse(List<String> list) {
        String reversedWord = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedWord += list.get(i);
            if (i != 0) {
                reversedWord += " ";
            }
        }
        return reversedWord;
    }


}
