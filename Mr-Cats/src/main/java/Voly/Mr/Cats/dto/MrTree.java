package Voly.Mr.Cats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MrTree {
    List<MrItem> items;

}
