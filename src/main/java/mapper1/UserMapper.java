package mapper1;

import model.User;

import java.util.List;

/**
 * @Description:
 * @author:lidetian
 * @date: 2018/7/20
 * @system name:马达贷
 * @copyright:长安新生（深圳）金融投资有限公司
 */
public interface UserMapper {
    List<User> findAllUser();
}
