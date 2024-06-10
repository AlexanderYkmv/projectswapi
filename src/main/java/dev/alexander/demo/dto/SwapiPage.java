package dev.alexander.demo.dto;

import java.util.List;
import org.springframework.data.domain.Page;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"count", "nextPage","prevPage", "content"})
public class SwapiPage<T> {

    private List<T> content;
    private Long count;
    private String nextPage;
    private String prevPage;

    public SwapiPage(Page<T> springPage, String nextPage, String prevPage){
        this.count = springPage.getTotalElements();
        if(springPage.hasNext()){
            this.nextPage = nextPage;
        }else{
            this.nextPage = null;
        }
        if(springPage.hasPrevious()){
            
            this.prevPage = prevPage;
        }else{
            this.prevPage = null;
        }
        this.content = springPage.getContent();
    }
   
}
