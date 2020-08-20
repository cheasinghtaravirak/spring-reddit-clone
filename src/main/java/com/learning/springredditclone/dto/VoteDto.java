package com.learning.springredditclone.dto;

import com.learning.springredditclone.model.VoteType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto {
	private VoteType voteType;
	private Long postId;
}