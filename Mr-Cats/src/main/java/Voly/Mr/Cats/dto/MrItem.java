package Voly.Mr.Cats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MrItem {
    String name;
    String path;
    String contentType;
}