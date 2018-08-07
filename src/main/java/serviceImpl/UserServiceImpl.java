package serviceImpl;

import mapper1.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

import java.util.List;

/**
 * @Description:
 * @author:lidetian
 * @date: 2018/7/20
 * @system name:马达贷
 * @copyright:长安新生（深圳）金融投资有限公司
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    public List<User> findAllUser() {
        List<User> findAllUser = userMapper.findAllUser();
        return findAllUser;
    }
}
