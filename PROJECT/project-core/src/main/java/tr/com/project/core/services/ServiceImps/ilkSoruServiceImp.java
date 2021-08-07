package tr.com.project.core.services.ServiceImps;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.project.core.services.ilkSoruService;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ilkSoruServiceImp implements ilkSoruService {

    @Override
    public String cizimGetir(int kenarUzunluk) {

        String cizim = "";
        for (int i = 0; i < kenarUzunluk; i++) {
            for (int j = 0; j < kenarUzunluk; j++) {
                if (j < kenarUzunluk - i - 1) {
                    cizim += ".";
                } else {
                    cizim += "*";
                }
            }
            cizim += "\r\n";
        }
        return cizim;

    }

}
