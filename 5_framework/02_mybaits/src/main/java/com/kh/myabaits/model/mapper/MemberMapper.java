package com.kh.myabaits.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.myabaits.model.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	// 전체 회원 목록 조회
	List<MemberDTO> findAll();
	
	//회원 등록 
	int insert(MemberDTO member);
}
