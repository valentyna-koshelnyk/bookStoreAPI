package org.startsteps.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Authors{

    int authorId;
    String authorName;
    String origin;
    Date birthDate;
}
