package ssm.test;

import org.junit.Test;
import ssm.domain.UserEntity;
import ssm.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

public class UserEntityTest extends SpringTestCase {
    @Resource
    private UserMapper userDaoMapper;

    @Test
    public void selectAllUser(){
        List<UserEntity> userEntities = userDaoMapper.getAllUser();
        System.out.println(userEntities);
    }
}
