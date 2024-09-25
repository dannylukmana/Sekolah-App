package com.schoolapp.schoolapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentSaveDTO {
    private String studentName;
    private String teacherName;
    private String address;
    private int  mobile;
    private boolean  active;
}
