package com.example.user_service.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String message;
	private int status;
	private LocalDateTime timestamp;
	
	public ErrorResponse(String message, int status, LocalDateTime timestamp) {
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}

	    public void rotate(int[] nums, int k) {
	        int n = nums.length;

	        int d = k % n;

	        List<Integer> list = new ArrayList<>();
	        for(int i = 0; i < d; i++){
	            list.add(nums[n-i-1]);
	        }


	        for(int i = n -  -1; i >= 0; i--){
	           nums[i + d] = nums[i] ;
	        }

	        int j = 0;
	        for(int i = d-1; i >= 0; i--){
	           nums[i] = list.get(j++);
	        }
	    }
	

}
