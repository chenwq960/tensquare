package org.tensquare_user.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tensquare_user.mapper.AdminMapper;
import org.tensquare_user.service.AdminService;
@Service
public class AdminServiceImp implements AdminService{
	@Resource
	private AdminMapper adminMapper;
}
