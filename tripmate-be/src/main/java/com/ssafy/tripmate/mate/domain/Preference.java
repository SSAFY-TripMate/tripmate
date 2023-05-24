package com.ssafy.tripmate.mate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Preference {
    private int preferenceNo;
    private String title;
    private String description;
}
