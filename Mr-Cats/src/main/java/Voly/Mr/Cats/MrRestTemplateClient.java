package Voly.Mr.Cats;

import Voly.Mr.Cats.dto.MrCatsLapkins;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MrRestTemplateClient {

    private RestTemplate restTemplate;

    public MrRestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SneakyThrows
    public MrCatsLapkins mrGetCat() {
        String pref = "<script type=\"application/json\" data-target=\"react-app.embeddedData\">";
        String suff = "</script>\n  <div data-target=\"react-app.reactRoot\"></div>";
        ResponseEntity<String> textJson = restTemplate.getForEntity("https://github.com/GurSergey/datathon_comanda_AA/tree/main/Cats_lapkins", String.class);
        String text = textJson.getBody();
        int inxPref = text.indexOf(pref);
        int inxSuff = text.indexOf(suff);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(text.substring(inxPref + pref.length(), inxSuff), MrCatsLapkins.class);
    }

    @SneakyThrows
    public MrCatsLapkins mrGetByName(String name) {
        String pref = "<script type=\"application/json\" data-target=\"react-app.embeddedData\">";
        String suff = "</script>\n  <div data-target=\"react-app.reactRoot\"></div>";
        ResponseEntity<String> textJson = restTemplate.getForEntity("https://github.com/GurSergey/datathon_comanda_AA/tree/main/Cats_lapkins/" + name, String.class);
        String text = textJson.getBody();
        int inxPref = text.indexOf(pref);
        int inxSuff = text.indexOf(suff);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(text.substring(inxPref + pref.length(), inxSuff), MrCatsLapkins.class);

    }

    @SneakyThrows
    public byte[] mrGetJpg(String name, String jpgName) {
        ResponseEntity<byte[]> textJson = restTemplate.getForEntity("https://github.com/GurSergey/datathon_comanda_AA/raw/main/Cats_lapkins/" + name + "/" + jpgName, byte[].class);
        byte[] jpg = textJson.getBody();
        return jpg;
    }

}
