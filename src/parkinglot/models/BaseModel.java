package parkinglot.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BaseModel {

    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;

}
