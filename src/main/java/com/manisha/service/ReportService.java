package com.manisha.service;

import java.util.List;

import com.manisha.request.SearchRequest;
import com.manisha.response.SearchResponse;

public interface ReportService {

	public List<String> getPlanName();

	public List<String> getPlanStatus();

	public List<SearchResponse> searchPlans(SearchRequest request);
}
