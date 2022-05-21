package com.manisha.response;

import java.time.LocalDate;

import lombok.Data;
@Data
public class SearchResponse {

	private Long caseName;
	private String planName;
	private String planStatus;
	private Double benifitAmt;
	private LocalDate startDate;
	private LocalDate endDate;
	private String denailReason;
	private String holderName;
	private Long holderSsn;
}
