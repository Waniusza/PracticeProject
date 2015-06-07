package com.gut.practice.entity.user;

import com.gut.practice.entity.enums.Speciality;
import com.gut.practice.entity.enums.TimePeriod;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author kongo
 */

@Getter
@Setter
@ToString

public class Coordinator extends PortalUser {
    private List<TimePeriod> availablity;
    private Speciality speciality;
    
    public Coordinator() {
        
    }
}
