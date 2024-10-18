package parkinglot.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BaseModel {

    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;

}
