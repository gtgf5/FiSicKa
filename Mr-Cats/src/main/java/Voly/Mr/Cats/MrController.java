package Voly.Mr.Cats;

import Voly.Mr.Cats.dto.MrCatsLapkins;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.MediaTray;
import java.awt.*;

@RestController
public class MrController {
    private MrService mrService;


    public MrController(MrService mrService) {
        this.mrService = mrService;
    }

    @GetMapping(value = "/getMrCat", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getMrCat() throws JsonProcessingException {
        return mrService.getMrCat();
    }
}
