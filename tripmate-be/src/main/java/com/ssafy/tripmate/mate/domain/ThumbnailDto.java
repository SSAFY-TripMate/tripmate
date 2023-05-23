package com.ssafy.tripmate.mate.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ThumbnailDto {
    private int mateThumbnailNo;
    private int mateNo;
    private String imageFolder;
    private String imageOriginName;
    private String imageSaveName;
    private String imageType;
}
