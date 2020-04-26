package org.tensquare_user.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.tensquare_user.form.SearchParam;
import org.tensquare_user.mapper.UserMapper;
import org.tensquare_user.pojo.User;
import org.tensquare_user.service.UserService;

import com.tensquare.utils.IdWorker;

@Service
public class UserServiceImp implements UserService{
	
	@SuppressWarnings("rawtypes")
	@Resource
	private RedisTemplate redisTemplate;
	
	@Resource
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Resource
	private RabbitTemplate rabbitTemplate;
	@Resource
	private UserMapper userMapper;
	@Resource
	private IdWorker idWorker;
	@Override
	public List<User> selectList(SearchParam searchParam) {
		return null;
	}
	@Override
	public int save(User user) {
		String encode = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encode);
		
		String object = (String) redisTemplate.opsForValue().get(user.getMobile());
		System.out.println("从redis数据库中获取的验证码"+object);
		System.out.println("用户数据的验证码是"+user.getEmail());
		
		if(user.getEmail().equals(object)) {
			System.out.println("一致 可以登录");
		}else {
			System.out.println("不一致  不可以登录");
		}
		user.setId(String.valueOf(idWorker.nextId()));
		return userMapper.insertSelective(user);
	}
	
	/**
	 * 使用mq发送验证码
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void sendMessage(String tel) {
		//生成验证码
		String random = UUID.randomUUID().toString();
		System.out.println("key"+tel+"value"+random);
		System.out.println(random+"--验证码是");
		HashMap<String,String> hashMap = new HashMap<>();
		hashMap.put("mobile",tel);
		hashMap.put("code",random);
		redisTemplate.opsForValue().set(tel,random);
		//同步到 mq 中
		rabbitTemplate.convertAndSend("queue_02",hashMap);
	}
	/**
	 * 登录逻辑验证
	 */
	@Override
	public User login(User user) {
		User model = userMapper.Login(user.getLoginname());
		if(model != null) {
			System.out.println(model+"------------");
			//有这个用户
			if(!(bCryptPasswordEncoder.matches(user.getPassword(),model.getPassword()))){
				System.out.println("密码不相等-----------");
			}else {
				System.out.println("密码相等");
				return model;
			}
		}
		return model;
	}
	@Override
	public void delte(String id) {
		userMapper.deleteByPrimaryKey(id);
	}
}



