package com.bravuthon.skillmatrix.model;

import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserSkillDto implements Serializable {

    private UUID id;
    private String categoryId;
    private String skillId;
    private String productId;
    private String proficiencyLevel;
    private boolean certificateDone;
    private String upload;
    private boolean upSkill;
    private UUID userId;

    public static void main(String[] args) {
        int[] s = {1,2,3,4,5,6,7,8,9};

        Map<String, List<Integer>> collect = Arrays.stream(s).boxed().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
    }
}


