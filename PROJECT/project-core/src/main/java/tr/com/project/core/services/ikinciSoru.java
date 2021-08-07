package tr.com.project.core.services;

import java.util.List;

public interface ikinciSoru {
    String reverseMessage(String message);

    String reverse(List<String> list);

    //C ve C++'da split olmadığı için diğer metodu da yazdım
    String reverseMessageBySplit(String message);
}
