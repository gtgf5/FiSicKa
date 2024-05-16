package Voly.Mr.Cats;

import Voly.Mr.Cats.dto.MrCatsLapkins;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MrService {
    private MrRestTemplateClient mrRestTemplateClient;

    public MrService(MrRestTemplateClient mrRestTemplateClient) {
        this.mrRestTemplateClient = mrRestTemplateClient;
    }

    public byte[] getMrCat() {
        MrCatsLapkins mrCatsLapkins = mrRestTemplateClient.mrGetCat();
        List<String> catNames = mrCatsLapkins.getPayload().getTree().getItems().stream().map((mrItem -> mrItem.getName())).toList();
        Random rd = new Random();
        String rdCatName = catNames.get(rd.nextInt(catNames.size()));
        MrCatsLapkins mrCatsLapkinsJpg = mrRestTemplateClient.mrGetByName(rdCatName);
        List<String> catJpg = mrCatsLapkinsJpg.getPayload().getTree().getItems().stream().map((mrItem -> mrItem.getName())).toList();
        String rdCatJpg = catJpg.get(rd.nextInt(catJpg.size()));
        return mrRestTemplateClient.mrGetJpg(rdCatName,rdCatJpg);
    }
}
