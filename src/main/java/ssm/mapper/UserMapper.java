package ssm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ssm.domain.UserEntity;

import java.util.List;

public interface UserMapper {
	@Insert("insert into user(name, age) values(#{name}, #{age})")
	public int insertUser(UserEntity userEntity);

	@Delete("delete from user where id=#{id}")
	public int deleteUserById(int id);

	@Update("update user set name=#{name},age=#{age} where id=#{id}")
	public int updateUser(UserEntity userEntity);

	@Select("select * from user where id=#{id}")
	public UserEntity getUserById(int id);

	@Select("select * from user")
	public List<UserEntity> getAllUser();
}
