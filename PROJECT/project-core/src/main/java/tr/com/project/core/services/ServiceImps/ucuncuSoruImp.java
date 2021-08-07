package tr.com.project.core.services.ServiceImps;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.project.core.services.ucuncuSoru;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ucuncuSoruImp implements ucuncuSoru {

    @Override
    public Boolean recommedMovies(Integer flightLenght) {
        Vector<Integer> movieLenghts = dummyData();
        for (int i = 0; i < movieLenghts.size() - 1; i++) {
            for (int j = i + 1; j < movieLenghts.size(); j++) {
                if (movieLenghts.get(i) + movieLenghts.get(j).intValue() == flightLenght.intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    //java stream kütüphanesiyle yazdım ancak c ve c++'da kullanamayacağım için diğer metodu da yazdım.
    @Override
    public boolean recommedMoviesWithStream(Integer flightLenght) {

        Vector<Integer> movieLenghts = dummyData();

        for (Integer movieLenght : movieLenghts) {
            List<Integer> collect = movieLenghts.stream().filter(foo -> foo.intValue() == flightLenght - movieLenght.intValue()).collect(Collectors.toList());
            if (!collect.isEmpty() && !(collect.get(0).intValue() == movieLenght.intValue() && collect.size() == 1)) {
                return true;
            }
        }
        return false;
    }

    public Vector<Integer> dummyData() {
        Vector<Integer> movieLenghts = new Vector<>();
        movieLenghts.add(84);
        movieLenghts.add(90);
        movieLenghts.add(90);
        movieLenghts.add(25);
        movieLenghts.add(40);
        movieLenghts.add(60);
        movieLenghts.add(102);
        return movieLenghts;
    }


}
