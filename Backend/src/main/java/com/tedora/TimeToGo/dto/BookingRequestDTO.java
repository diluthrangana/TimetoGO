package com.tedora.TimeToGo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDTO {

    private String userId;

    private String scheduleId;

    private String seatNumber;

    private String passengerName;

    private String contactNumber;
}
