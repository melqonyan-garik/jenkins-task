package com.example.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter

@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "list-array", typeClass = ListArrayType.class),
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class UserDetails {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private DrawDataJson drawDataJson;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DrawDataJson {

        private List<PrizePayoutsJson> prizePayouts;
    }

    @Data
    @NoArgsConstructor
    public static class PrizePayoutsJson {
        private String level;
        private String matches;
        private String amount;
        private String winners;


    }

}


